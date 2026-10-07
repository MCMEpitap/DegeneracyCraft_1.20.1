package net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockEntityBase;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.astronomical_telescope.AstronomicalTelescopeRecipe;
import net.epitap.degeneracycraft.multiblock.DCMultiblockFile;
import net.epitap.degeneracycraft.multiblock.DCMultiblockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BasicPerformanceAstronomicalTelescopeBlockEntity extends DCMachineBlockEntityBase {

    public static final float MACHINE_CAPACITY = 50000F;
    public static final float MACHINE_TRANSFER = 16F;

    public static final float MACHINE_ENERGY_USAGE_MODIFIER_0 = 1.5F;
    public static final float MACHINE_ENERGY_USAGE_MODIFIER_1 = 2.0F;

    public static final int MACHINE_PARALLEL_COUNT_0 = 4;
    public static final int MACHINE_PARALLEL_COUNT_1 = 8;

    public static final int RECIPE_COUNT = 2;
    public static final int OUTPUT_COUNT = 1;
    public static final int MACHINE_COUNT = RECIPE_COUNT + OUTPUT_COUNT;

    public static final int IN_0 = 0;
    public static final int IN_1 = 1;
    public static final int OUT_0 = 2;

    public static final int DATA_COUNTER = 0;
    public static final int DATA_PROGRESS = 1;
    public static final int DATA_HOLOGRAM = 2;
    public static final int DATA_FORCE_STOP = 3;
    public static final int DATA_MULTIBLOCK = 4;
    public static final int DATA_RECIPE_LOCK = 5;
    public static final int DATA_WORKING = 6;

    public int getProgressPercent;
    public long getTime;

    public int phase = 1;
    public int minX;
    public int maxY;
    public int minZ;

    protected final ContainerData data;

    public BasicPerformanceAstronomicalTelescopeBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_PERFORMANCE_ASTRONOMICAL_TELESCOPE_BLOCK_ENTITY.get(), pos, state,
                MACHINE_CAPACITY, MACHINE_TRANSFER, MACHINE_COUNT);

        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case DATA_COUNTER -> counter;
                    case DATA_PROGRESS -> getProgressPercent;
                    case DATA_HOLOGRAM -> hologramLevel;
                    case DATA_FORCE_STOP -> forceHalt ? 1 : 0;
                    case DATA_MULTIBLOCK -> multiblockLevel;
                    case DATA_RECIPE_LOCK -> inputLocked ? 1 : 0;
                    case DATA_WORKING -> working ? 1 : 0;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case DATA_COUNTER -> counter = value;
                    case DATA_PROGRESS -> getProgressPercent = value;
                    case DATA_HOLOGRAM -> hologramLevel = value;
                    case DATA_FORCE_STOP -> forceHalt = value != 0;
                    case DATA_MULTIBLOCK -> multiblockLevel = value;
                    case DATA_RECIPE_LOCK -> inputLocked = value != 0;
                    case DATA_WORKING -> working = value != 0;
                }
            }

            @Override
            public int getCount() {
                return 7;
            }
        };

        for (int i = 0; i < RECIPE_COUNT; i++) {
            inputLockedRecipe[i] = ItemStack.EMPTY;
        }
    }

    @Override
    protected ResourceLocation getMultiblockId() {
        return BasicPerformanceAstronomicalTelescopeMultiblockRenderer.LEVEL_0;
    }

    @Override
    public List<ResourceLocation> getMultiblockIds() {
        return List.of(
                BasicPerformanceAstronomicalTelescopeMultiblockRenderer.LEVEL_0,
                BasicPerformanceAstronomicalTelescopeMultiblockRenderer.LEVEL_1
        );
    }

    @Override
    protected int getParallelLimit() {
        return switch (multiblockLevel) {
            case 0 -> MACHINE_PARALLEL_COUNT_0;
            case 1 -> MACHINE_PARALLEL_COUNT_1;
            default -> 1;
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BasicPerformanceAstronomicalTelescopeMenu(containerId, inventory, this, data);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity) {
        if (level.isClientSide()) {
            return;
        }

        blockEntity.updateMultiblock();
        blockEntity.updateMachine(level, pos, state);
    }

    private void updateMultiblock() {
        boolean formed = checkMultiblock();

        if (!formed) {
            multiblockLevel = -1;
            return;
        }

        if (multiblockLevel < 0) {
            multiblockLevel = 0;
        }
    }

    private void updateMachine(Level level, BlockPos pos, BlockState state) {
        getProgressPercent = 0;

        scanMultiblockStorages(level);

        pullEnergyFromInputs();
        pullItemsFromInputs();

        if (!forceHalt) {
            pushEnergyToOutputs();
            pushItemsToOutputs();
        }

        energyStorage.receiveEnergyFloat(1e-20F, false);
        energyStorage.extractEnergyFloat(1e-20F, false);

        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Optional<AstronomicalTelescopeRecipe> match = level.getRecipeManager().getRecipeFor(
                AstronomicalTelescopeRecipe.Type.INSTANCE,
                inventory,
                level
        );

        if (forceHalt) {
            resetProgress();
            working = false;
            setChanged(level, pos, state);
            return;
        }

        if (match.isEmpty()) {
            working = false;
            resetProgress();
            return;
        }

        AstronomicalTelescopeRecipe recipe = match.get();

        int parallelCount = getParallelCount(recipe.getInputs(), recipe.getOutputs());

        working = parallelCount > 0
                && hasEnergyRecipe(this, recipe, parallelCount)
                && hasPhaseRecipe(this, recipe)
                && isTime(this)
                && isAboveAirBlock(this);

        if (working) {
            switch (multiblockLevel) {
                case 1 :
                    counter++;
                    energyStorage.extractEnergyFloat(
                            MACHINE_ENERGY_USAGE_MODIFIER_1 * recipe.getRequiredEnergy() * parallelCount
                                    / recipe.getRequiredTime() / 20F,
                            false
                    );

                case 0 :
                    counter++;
                    energyStorage.extractEnergyFloat(
                            MACHINE_ENERGY_USAGE_MODIFIER_0 * recipe.getRequiredEnergy() * parallelCount
                                    / recipe.getRequiredTime() / 20F,
                            false
                    );

                case -1 :
                    counter++;
                    energyStorage.extractEnergyFloat(
                            recipe.getRequiredEnergy() * parallelCount
                                    / recipe.getRequiredTime() / 20F,
                            false
                    );
            }

            getProgressPercent =
                    (int) (counter / (recipe.getRequiredTime() * 20F) * 100F);

            if (craftCheck(this, recipe)) {
                craftItem(this, recipe, parallelCount);
            }

        } else {
            resetProgress();
        }

        setChanged(level, pos, state);
    }

    @Override
    protected boolean canReceiveItem(int machineSlot, ItemStack stack) {
        return machineSlot == IN_0 || machineSlot == IN_1;
    }

    @Override
    protected boolean isOutputSlot(int machineSlot) {
        return machineSlot == OUT_0;
    }

    @Override
    protected int getInputSlot() {
        return IN_0;
    }

    @Override
    protected int getOutputSlot() {
        return OUT_0;
    }

    private static boolean isTime(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity) {
        Level level = blockEntity.getLevel();

        if (level != null) {
            blockEntity.getTime = level.getDayTime();
        }

        return blockEntity.getTime % 24000L >= 12000L;
    }

    private static boolean isAboveAirBlock(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity) {
        Level level = blockEntity.getLevel();

        if (level == null) {
            return false;
        }

        if (!blockEntity.isMultiblockFormed()) {
            BlockPos basePos = blockEntity.getBlockPos();
            int maxY = level.getMaxBuildHeight() - 1;

            for (int y = basePos.getY() + 1; y <= maxY; y++) {
                if (!level.getBlockState(new BlockPos(basePos.getX(), y, basePos.getZ())).isAir()) {
                    return false;
                }
            }

            return true;
        }

        DCMultiblockFile file =
                DCMultiblockRegistry.get(blockEntity.getMultiblockId());

        if (file == null) {
            return false;
        }

        BlockPos controllerOffset = file.getControllerOffset();

        if (controllerOffset == null) {
            return false;
        }

        BlockPos controllerPos = blockEntity.getBlockPos();

        Set<BlockPos> multiblockPositions = new HashSet<>();

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {
                    DCMultiblockFile.DCPlaceholder placeholder =
                            file.getPlaceholder(x, y, z);

                    boolean isAir = placeholder.getPredicates()
                            .stream()
                            .anyMatch(DCMultiblockFile.DCPredicate::isAir);

                    if (isAir) {
                        continue;
                    }

                    BlockPos worldPos = controllerPos.offset(
                            x - controllerOffset.getX(),
                            y - controllerOffset.getY(),
                            z - controllerOffset.getZ()
                    );

                    multiblockPositions.add(worldPos);
                }
            }
        }

        BlockPos basePos = blockEntity.getBlockPos();
        int maxY = level.getMaxBuildHeight() - 1;

        for (int y = basePos.getY() + 1; y <= maxY; y++) {
            BlockPos checkPos =
                    new BlockPos(basePos.getX(), y, basePos.getZ());

            BlockState state = level.getBlockState(checkPos);

            if (multiblockPositions.contains(checkPos)) {
                continue;
            }

            if (!state.isAir()) {
                return false;
            }
        }

        return true;
    }

    public static boolean craftCheck(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, AstronomicalTelescopeRecipe recipe) {
        return blockEntity.data.get(DATA_COUNTER)
                >= recipe.getRequiredTime() * 20;
    }

    private static int getInputParallelCount(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, AstronomicalTelescopeRecipe recipe) {
        int parallelCount = Integer.MAX_VALUE;

        List<ItemStack> inputs = recipe.getInputs();

        for (int i = 0; i < inputs.size(); i++) {
            ItemStack required = inputs.get(i);

            if (required.isEmpty() || required.getItem() == Items.AIR) {
                continue;
            }

            ItemStack actual = blockEntity.itemHandler.getStackInSlot(i);

            if (!ItemStack.isSameItemSameTags(required, actual)) {
                return 0;
            }

            if (required.getCount() <= 0) {
                continue;
            }

            int possible = actual.getCount() / required.getCount();

            parallelCount = Math.min(parallelCount, possible);
        }

        if (parallelCount == Integer.MAX_VALUE) {
            return 1;
        }

        return parallelCount;
    }

    private static int getOutputParallelCount(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, AstronomicalTelescopeRecipe recipe) {
        List<ItemStack> inputs = recipe.getInputs();
        List<ItemStack> outputs = recipe.getOutputs();

        int outputStart = inputs.size();

        int parallelCount = Integer.MAX_VALUE;

        for (int i = 0; i < outputs.size(); i++) {
            ItemStack out = outputs.get(i);

            if (out.isEmpty() || out.getItem() == Items.AIR) {
                continue;
            }

            if (out.getCount() <= 0) {
                continue;
            }

            int slot = outputStart + i;

            ItemStack existing =
                    blockEntity.itemHandler.getStackInSlot(slot);

            int slotLimit =
                    blockEntity.itemHandler.getSlotLimit(slot);

            if (existing.isEmpty()) {parallelCount = Math.min(parallelCount, slotLimit / out.getCount());
                continue;
            }

            if (!ItemStack.isSameItemSameTags(existing, out)) {
                return 0;
            }

            int remaining =
                    slotLimit - existing.getCount();

            parallelCount = Math.min(parallelCount, remaining / out.getCount());
        }

        if (parallelCount == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return parallelCount;
    }

    private static int getParallelCount(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, AstronomicalTelescopeRecipe recipe) {
        int limit = blockEntity.getParallelLimit();

        int inputParallel = getInputParallelCount(blockEntity, recipe);

        int outputParallel = getOutputParallelCount(blockEntity, recipe);

        return Math.min(limit, Math.min(inputParallel, outputParallel));
    }

    private static boolean hasEnergyRecipe(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, AstronomicalTelescopeRecipe recipe, int parallelCount) {
        float energyPerTick = recipe.getRequiredEnergy() * parallelCount / recipe.getRequiredTime() / 20F;

        return blockEntity.energyStorage.getEnergyStoredFloat()
                >= energyPerTick;
    }

    private static boolean hasPhaseRecipe(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, AstronomicalTelescopeRecipe recipe) {
        return blockEntity.phase >= recipe.getRequiredPhase();
    }

    private static void craftItem(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, AstronomicalTelescopeRecipe recipe, int parallelCount) {
        List<ItemStack> inputs = recipe.getInputs();
        List<ItemStack> outputs = recipe.getOutputs();

        for (int i = 0; i < inputs.size(); i++) {
            ItemStack required = inputs.get(i);

            if (required.isEmpty() || required.getItem() == Items.AIR) {
                continue;
            }

            int amount = required.getCount() * parallelCount;

            blockEntity.itemHandler.extractItem(i, amount, false);
        }

        int outputStart = inputs.size();

        for (int i = 0; i < outputs.size(); i++) {
            ItemStack out = outputs.get(i);

            if (out.isEmpty() || out.getItem() == Items.AIR) {
                continue;
            }

            int slot = outputStart + i;

            int amount = out.getCount() * parallelCount;

            ItemStack existing = blockEntity.itemHandler.getStackInSlot(slot);

            if (existing.isEmpty()) {
                ItemStack result = out.copy();
                result.setCount(amount);

                blockEntity.itemHandler.setStackInSlot(slot, result);

            } else if (ItemStack.isSameItemSameTags(existing, out)) {
                existing.grow(amount);

                blockEntity.itemHandler.setStackInSlot(slot, existing);
            }
        }

        blockEntity.resetProgress();
    }

    public void resetProgress() {
        counter = 0;
        getProgressPercent = 0;
    }

    public void setHandler(ItemStackHandler handler) {
        for (int i = 0; i < handler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, handler.getStackInSlot(i));
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);

        nbt.putInt("counter", counter);
        nbt.putInt("getProgressPercent", getProgressPercent);
        nbt.putInt("hologramLevel", hologramLevel);
        nbt.putBoolean("forceHalt", forceHalt);
        nbt.putInt("multiblockLevel", multiblockLevel);
        nbt.putBoolean("inputLocked", inputLocked);
        nbt.putBoolean("working", working);

        for (int i = 0; i < inputLockedRecipe.length; i++) {
            ItemStack stack = inputLockedRecipe[i];

            if (stack == null) {
                stack = ItemStack.EMPTY;
            }

            CompoundTag itemTag = new CompoundTag();
            stack.save(itemTag);
            nbt.put("inputLockedRecipe" + i, itemTag);
        }
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        counter = nbt.getInt("counter");
        getProgressPercent = nbt.getInt("getProgressPercent");
        hologramLevel = nbt.getInt("hologramLevel");
        forceHalt = nbt.getBoolean("forceHalt");
        multiblockLevel = nbt.getInt("multiblockLevel");
        inputLocked = nbt.getBoolean("inputLocked");
        working = nbt.getBoolean("working");

        for (int i = 0; i < inputLockedRecipe.length; i++) {
            if (nbt.contains("inputLockedRecipe" + i)) {
                inputLockedRecipe[i] =
                        ItemStack.of(
                                nbt.getCompound("inputLockedRecipe" + i)
                        );
            } else {
                inputLockedRecipe[i] = ItemStack.EMPTY;
            }

            if (inputLockedRecipe[i] == null) {
                inputLockedRecipe[i] = ItemStack.EMPTY;
            }
        }
    }

    @Override
    protected int getInputSlotCount() {
        return RECIPE_COUNT;
    }

    @Override
    protected List<ItemStack> getRecipeInputs(Recipe<?> recipe) {
        if (!(recipe instanceof AstronomicalTelescopeRecipe recipeData)) {
            return List.of();
        }

        return recipeData.getInputs();
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}