package net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.energy.DCEnergyStorageFloatBase;
import net.epitap.degeneracycraft.energy.DCIEnergyStorageFloat;
import net.epitap.degeneracycraft.integration.jei.basic.biology.bio_reactor.BioReactorRecipe;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCEnergySyncS2CPacket;
import net.epitap.degeneracycraft.util.DCWrappedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.*;

public class BasicPerformanceBioReactorBlockEntity extends BlockEntity implements MenuProvider {
    public float MACHINE_CAPACITY = 30000F;
    public float MACHINE_TRANSFER = 32F;
    public float MACHINE_MANUFACTURING_SPEED_MODIFIER_FORMED = 2F;
    public float MACHINE_MANUFACTURING_SPEED_MODIFIER_POWERED_1 = 3F;
    public float MACHINE_MANUFACTURING_ENERGY_USAGE_MODIFIER_FORMED = 1.5F;
    public float MACHINE_MANUFACTURING_ENERGY_USAGE_MODIFIER_POWERED_1 = 2.0F;
    public final ContainerData data;
    public int counter;
    public int getProgressPercent;

    public int hologramLevel = -1;
    public int multiblockLevel = -1;

    public int minX;
    public int maxY;
    public int minZ;

    public boolean forceHalt = false;
    public static final int RECIPE_COUNT      = 4;
    public static final int OUTPUT_COUNT      = 3;
    public static final int MACHINE_COUNT     = RECIPE_COUNT + OUTPUT_COUNT;

    private final ItemStack[] inputLockedRecipe = new ItemStack[RECIPE_COUNT];
    public boolean inputLocked = false;

    public static final int DATA_COUNTER      = 0;
    public static final int DATA_PROGRESS     = 1;
    public static final int DATA_HOLOGRAM     = 2;
    public static final int DATA_FORCE_STOP   = 3;
    public static final int DATA_MULTIBLOCK   = 4;
    public static final int DATA_RECIPE_LOCK   = 5;

    public final int IN_0 = 0, IN_1 = 1, IN_2 = 2, IN_3 = 3;
    public final int OUT_0 = 4, OUT_1 = 5, OUT_2 = 6;

    private final List<DCIEnergyStorageFloat> energyInputs = new ArrayList<>();
    private final List<DCIEnergyStorageFloat> energyOutputs = new ArrayList<>();
    private final List<IItemHandler> itemInputs = new ArrayList<>();
    private final List<IItemHandler> itemOutputs = new ArrayList<>();

    public final ItemStackHandler itemHandler = new ItemStackHandler(MACHINE_COUNT) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case OUT_0,OUT_1,OUT_2 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private final DCEnergyStorageFloatBase ENERGY_STORAGE = new DCEnergyStorageFloatBase(MACHINE_CAPACITY, MACHINE_TRANSFER) {
        @Override
        public void onEnergyChanged() {
            setChanged();
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            DCMessages.sendToClients(new DCEnergySyncS2CPacket(this.energy, getBlockPos()));
        }
    };

    public DCIEnergyStorageFloat getEnergyStorage() {
        return ENERGY_STORAGE;
    }

    public void setEnergyLevel(float energy) {
        this.ENERGY_STORAGE.setEnergyFloat(energy);
    }

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<DCIEnergyStorageFloat> lazyEnergyHandler = LazyOptional.empty();
    private final Map<Direction, LazyOptional<DCWrappedHandler>> directionDCWrappedHandlerMap =
            Map.of(
                    Direction.NORTH, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (in) -> in == IN_0, (in, stack) -> itemHandler.isItemValid(IN_0, stack))),
                    Direction.SOUTH, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (in) -> in == IN_0, (in, stack) -> itemHandler.isItemValid(IN_0, stack))),
                    Direction.EAST, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (out) -> out == OUT_0,(out, stack) -> false)),
                    Direction.WEST, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (in) -> in == IN_0,(in, stack) -> itemHandler.isItemValid(IN_0, stack)))
            );

    public BasicPerformanceBioReactorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(DCBlockEntities.BASIC_PERFORMANCE_BIO_REACTOR_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case DATA_COUNTER    -> counter;
                    case DATA_PROGRESS   -> getProgressPercent;
                    case DATA_HOLOGRAM   -> hologramLevel;
                    case DATA_FORCE_STOP -> forceHalt ? 1 : 0;
                    case DATA_MULTIBLOCK   -> multiblockLevel;
                    case DATA_RECIPE_LOCK   -> inputLocked ? 1 : 0;
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
                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };

        for (int i = 0; i < RECIPE_COUNT; i++) {
            inputLockedRecipe[i] = ItemStack.EMPTY;
        }
    }


    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new BasicPerformanceBioReactorMenu(pContainerId, pInventory, this, this.data);
    }

    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY && (side == Direction.UP || side == Direction.DOWN)) {
            return lazyEnergyHandler.cast();
        } else if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }
            if (directionDCWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(BasicPerformanceBioReactorBlock.FACING);

                if (side == Direction.UP || side == Direction.DOWN) {
                    return directionDCWrappedHandlerMap.get(side).cast();
                }
                return switch (localDir) {
                    default -> directionDCWrappedHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionDCWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionDCWrappedHandlerMap.get(side).cast();
                    case WEST -> directionDCWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }
        return super.getCapability(cap, side);
    }

    public void setHandler(ItemStackHandler itemStackHandler) {
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, itemStackHandler.getStackInSlot(i));
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putFloat("energy", ENERGY_STORAGE.getEnergyStoredFloat());
        nbt.putInt("counter", counter);
        nbt.putInt("getProgressPercent", getProgressPercent);
        nbt.putInt("hologramLevel", hologramLevel);
        nbt.putBoolean("forceHalt", forceHalt);
        nbt.putInt("multiblockLevel", multiblockLevel);
        nbt.putBoolean("inputLocked", inputLocked);
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
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        ENERGY_STORAGE.setEnergyFloat(nbt.getFloat("energy"));
        counter = nbt.getInt("counter");
        getProgressPercent = nbt.getInt("getProgressPercent");
        hologramLevel = nbt.getInt("hologramLevel");
        forceHalt = nbt.getBoolean("forceHalt");
        multiblockLevel = nbt.getInt("multiblockLevel");
        inputLocked = nbt.getBoolean("inputLocked");
        for (int i = 0; i < inputLockedRecipe.length; i++) {
            if (nbt.contains("inputLockedRecipe" + i)) {
                inputLockedRecipe[i] = ItemStack.of(nbt.getCompound("inputLockedRecipe" + i));
            } else {
                inputLockedRecipe[i] = ItemStack.EMPTY;
            }

            if (inputLockedRecipe[i] == null) {
                inputLockedRecipe[i] = ItemStack.EMPTY;
            }
        }
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicPerformanceBioReactorBlockEntity blockEntity) {
        if(BasicPerformanceBioReactorStructure.isPowered1(level, pos, state, blockEntity)){
            blockEntity.multiblockLevel = 1;
        } else if(BasicPerformanceBioReactorStructure.isFormed(level, pos, state, blockEntity)){
            blockEntity.multiblockLevel = 0;
        } else {
            blockEntity.multiblockLevel = -1;
        }
        BasicPerformanceBioReactorStructure.hologram(level, pos, state, blockEntity);
        blockEntity.getProgressPercent = 0;

        blockEntity.scanMultiblockStorages(level);

        blockEntity.pullEnergyFromInputs();
        blockEntity.pullItemsFromInputs();

        if (!blockEntity.forceHalt) {
            blockEntity.pushEnergyToOutputs();
            blockEntity.pushItemsToOutputs();
        }

        blockEntity.ENERGY_STORAGE.receiveEnergyFloat(1e-20F, false);
        blockEntity.ENERGY_STORAGE.extractEnergyFloat(1e-20F, false);

        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());

        if (level.isClientSide()) {
            setChanged(level, pos, state);
            return;
        }
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }
        Optional<BioReactorRecipe> match = level.getRecipeManager()
                .getRecipeFor(BioReactorRecipe.Type.INSTANCE, inventory, level);

        if (blockEntity.forceHalt) {
            blockEntity.resetProgress();
            setChanged(level, pos, state);
            return;
        }

        if (hasRecipe(blockEntity) && hasAmountRecipe(blockEntity) && hasEnergyRecipe(blockEntity) && canOutput(blockEntity)) {
            if (blockEntity.hologramLevel == 1) {
                blockEntity.counter += blockEntity.MACHINE_MANUFACTURING_SPEED_MODIFIER_POWERED_1;
                blockEntity.ENERGY_STORAGE.extractEnergyFloat(blockEntity.MACHINE_MANUFACTURING_ENERGY_USAGE_MODIFIER_POWERED_1
                        * match.get().getRequiredEnergy() / match.get().getRequiredTime() / 20F, false);
            } else if (blockEntity.hologramLevel == 0) {
                blockEntity.counter += blockEntity.MACHINE_MANUFACTURING_SPEED_MODIFIER_FORMED;
                blockEntity.ENERGY_STORAGE.extractEnergyFloat(blockEntity.MACHINE_MANUFACTURING_ENERGY_USAGE_MODIFIER_FORMED
                        * match.get().getRequiredEnergy() / match.get().getRequiredTime() / 20F, false);
            } else {
                blockEntity.counter++;
                blockEntity.ENERGY_STORAGE.extractEnergyFloat(match.get().getRequiredEnergy() / match.get().getRequiredTime() / 20, false);
            }
            blockEntity.getProgressPercent = (int) (blockEntity.counter / (match.get().getRequiredTime() * 20F) * 100F);
            if (craftCheck(blockEntity)) {
                craftItem(blockEntity);
            }
            setChanged(level, pos, state);
        } else {
            blockEntity.resetProgress();
            setChanged(level, pos, state);
        }
        setChanged(level, pos, state);
    }

    private void scanMultiblockStorages(Level level) {
        if (level.isClientSide) return;
        if (multiblockLevel < 0) return;

        Direction facing = getBlockState().getValue(BasicPerformanceBioReactorBlock.FACING);
        BlockPos basePos = this.getBlockPos();
        energyInputs.clear();
        energyOutputs.clear();
        itemInputs.clear();
        itemOutputs.clear();


        String[][][] structure = switch (multiblockLevel) {
            case 0 -> BasicPerformanceBioReactorStructure.structure0;
            case 1 -> BasicPerformanceBioReactorStructure.structure1;
            default -> new String[0][][];
        };

        this.minX = switch (multiblockLevel){
            case 0 -> BasicPerformanceBioReactorStructure.minX0;
            case 1 -> BasicPerformanceBioReactorStructure.minX1;
            default -> 0;
        };

        this.maxY = switch (multiblockLevel){
            case 0 -> BasicPerformanceBioReactorStructure.maxY0;
            case 1 -> BasicPerformanceBioReactorStructure.maxY1;
            default -> 0;
        };

        this.minZ = switch (multiblockLevel){
            case 0 -> BasicPerformanceBioReactorStructure.minZ0;
            case 1 -> BasicPerformanceBioReactorStructure.minZ1;
            default -> 0;
        };

        for (int y = 0; y < structure.length; y++) {
            for (int z = 0; z < structure[y].length; z++) {
                for (int x = 0; x < structure[y][z].length; x++) {
                    String key = structure[y][z][x];

                    BlockPos targetPos = BasicPerformanceBioReactorStructure.getRelativePos(basePos,
                            x + this.minX,
                            this.maxY - y,
                            z + this.minZ, facing);

                    BlockEntity be = level.getBlockEntity(targetPos);
                    if (be == null || be == this) continue;

                    if (!key.equals("1") && !key.equals("2") && !key.equals("3") && !key.equals("4")) continue;

                    switch (key) {
                        case "1":
                            be.getCapability(ForgeCapabilities.ENERGY)
                                    .ifPresent(storage ->
                                            energyInputs.add((DCIEnergyStorageFloat) storage));
                            break;

                        case "2":
                            be.getCapability(ForgeCapabilities.ENERGY)
                                    .ifPresent(storage ->
                                            energyOutputs.add((DCIEnergyStorageFloat) storage));
                            break;

                        case "3":
                            be.getCapability(ForgeCapabilities.ITEM_HANDLER)
                                    .ifPresent(itemInputs::add);
                            break;

                        case "4":
                            be.getCapability(ForgeCapabilities.ITEM_HANDLER)
                                    .ifPresent(itemOutputs::add);
                            break;
                    }
                }
            }
        }
    }

    private void pullEnergyFromInputs() {
        float needed = MACHINE_CAPACITY - ENERGY_STORAGE.getEnergyStoredFloat();
        if (needed <= 0) return;

        for (DCIEnergyStorageFloat input : energyInputs) {

            if (needed <= 0) break;

            float extracted = input.extractEnergyFloat(needed, false);
            if (extracted > 0) {
                ENERGY_STORAGE.receiveEnergyFloat(extracted, false);
                needed -= extracted;
            }
        }
    }

    private void pushEnergyToOutputs() {
        float stored = ENERGY_STORAGE.getEnergyStoredFloat();
        float reserve = this.MACHINE_CAPACITY - this.MACHINE_TRANSFER;

        float transferable = stored - reserve;
        if (transferable <= 0) return;

        for (DCIEnergyStorageFloat output : energyOutputs) {

            if (transferable <= 0) break;

            float accepted = output.receiveEnergyFloat(transferable, false);

            if (accepted > 0) {
                ENERGY_STORAGE.extractEnergyFloat(accepted, false);
                transferable -= accepted;
            }
        }
    }

    public void toggleInputLock() {
        inputLocked = !inputLocked;
        if (inputLocked) {
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                ItemStack stack = itemHandler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    inputLockedRecipe[i] = stack.copy();
                } else {
                    inputLockedRecipe[i] = ItemStack.EMPTY;
                }
            }
        } else {
            Arrays.fill(inputLockedRecipe, ItemStack.EMPTY);
        }

        setChanged();
    }

    private void pullItemsFromInputs() {
        for (IItemHandler input : itemInputs) {
            for (int inputSlot = 0; inputSlot < input.getSlots(); inputSlot++) {
                ItemStack stack = input.getStackInSlot(inputSlot);
                if (stack.isEmpty()) continue;

                for (int machineSlot = IN_0; machineSlot <= RECIPE_COUNT - 1; machineSlot++) {
                    if (inputLocked) {

                        ItemStack lock = inputLockedRecipe[machineSlot];

                        if (lock.isEmpty()) continue;

                        if (!ItemStack.isSameItemSameTags(stack, lock)) continue;

                        if(lock == null) lock = ItemStack.EMPTY;

                        int current = itemHandler.getStackInSlot(machineSlot).getCount();
                        int limit = lock.getCount();

                        if (current >= limit) continue;
                    }

                    ItemStack simulated = itemHandler.insertItem(machineSlot, stack.copy(), true);
                    int insertable = stack.getCount() - simulated.getCount();

                    if (insertable > 0) {
                        if (inputLocked) {

                            int current = itemHandler.getStackInSlot(machineSlot).getCount();
                            int limit = inputLockedRecipe[machineSlot].getCount();
                            int remain = limit - current;

                            insertable = Math.min(insertable, remain);
                        }

                        ItemStack extracted = input.extractItem(inputSlot, insertable, false);
                        itemHandler.insertItem(machineSlot, extracted, false);

                        return;
                    }
                }
            }
        }
    }

    private void pushItemsToOutputs() {
        for (int machineSlot = OUT_0; machineSlot <= OUT_0 + OUTPUT_COUNT - 1; machineSlot++) {
            ItemStack stack = itemHandler.getStackInSlot(machineSlot);
            if (stack.isEmpty()) continue;

            for (IItemHandler output : itemOutputs) {

                for (int outputSlot = 0; outputSlot < output.getSlots(); outputSlot++) {

                    ItemStack leftover = output.insertItem(outputSlot, stack.copy(), false);

                    if (leftover.isEmpty()) {
                        itemHandler.setStackInSlot(machineSlot, ItemStack.EMPTY);
                        return;
                    }
                    else if (leftover.getCount() < stack.getCount()) {
                        itemHandler.setStackInSlot(machineSlot, leftover);
                        return;
                    }
                }
            }
        }
    }

    public static boolean craftCheck(BasicPerformanceBioReactorBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<BioReactorRecipe> match = level.getRecipeManager()
                .getRecipeFor(BioReactorRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            return blockEntity.data.get(0) >= match.get().getRequiredTime() * 20;
        }
        return false;
    }

    private static boolean hasRecipe(BasicPerformanceBioReactorBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<BioReactorRecipe> match = level.getRecipeManager()
                .getRecipeFor(BioReactorRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent();
    }

    private static boolean hasAmountRecipe(BasicPerformanceBioReactorBlockEntity blockEntity) {
        Level level = blockEntity.level;
        if (level == null) return false;

        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<BioReactorRecipe> match = level.getRecipeManager()
                .getRecipeFor(BioReactorRecipe.Type.INSTANCE, inventory, level);

        if (match.isEmpty()) return false;

        BioReactorRecipe recipe = match.get();
        List<ItemStack> inputs = recipe.getInputs();

        for (int i = 0; i < inputs.size(); i++) {
            ItemStack required = inputs.get(i);
            ItemStack actual = blockEntity.itemHandler.getStackInSlot(i);

            if (required.isEmpty() || required.getItem() == Items.AIR) {
                if (!actual.isEmpty()) {
                    return false;
                }
                continue;
            }

            if (!ItemStack.isSameItemSameTags(required, actual)
                    || actual.getCount() < required.getCount()) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasEnergyRecipe(BasicPerformanceBioReactorBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<BioReactorRecipe> match = level.getRecipeManager()
                .getRecipeFor(BioReactorRecipe.Type.INSTANCE, inventory, level);

        return blockEntity.ENERGY_STORAGE.getEnergyStoredFloat() >= match.get().getRequiredEnergy() / match.get().getRequiredTime() / 20F;
    }

    private static void craftItem(BasicPerformanceBioReactorBlockEntity blockEntity) {
        Level level = blockEntity.level;
        if (level == null) return;

        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<BioReactorRecipe> match = level.getRecipeManager()
                .getRecipeFor(BioReactorRecipe.Type.INSTANCE, inventory, level);

        if (match.isEmpty()) return;

        BioReactorRecipe recipe = match.get();

        List<ItemStack> inputs = recipe.getInputs();
        List<ItemStack> outputs = recipe.getOutputs();

        for (int i = 0; i < inputs.size(); i++) {
            ItemStack required = inputs.get(i);
            if (required.isEmpty() || required.getItem() == Items.AIR) continue;

            blockEntity.itemHandler.extractItem(i, required.getCount(), false);
        }

        int OUTPUT_START = inputs.size();

        for (int i = 0; i < outputs.size(); i++) {
            ItemStack out = outputs.get(i);

            if (out.isEmpty() || out.getItem() == Items.AIR) continue;

            int slot = OUTPUT_START + i;
            ItemStack existing = blockEntity.itemHandler.getStackInSlot(slot);

            if (existing.isEmpty()) {
                blockEntity.itemHandler.setStackInSlot(slot, out.copy());
            } else if (ItemStack.isSameItemSameTags(existing, out)) {
                existing.grow(out.getCount());
                blockEntity.itemHandler.setStackInSlot(slot, existing);
            }
        }

        blockEntity.resetProgress();
    }

    public void resetProgress() {
        this.counter = 0;
    }

    private static boolean canOutput(BasicPerformanceBioReactorBlockEntity blockEntity) {
        Level level = blockEntity.level;
        if (level == null) return false;

        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<BioReactorRecipe> match = level.getRecipeManager()
                .getRecipeFor(BioReactorRecipe.Type.INSTANCE, inventory, level);

        if (match.isEmpty()) return false;

        BioReactorRecipe recipe = match.get();
        List<ItemStack> inputs = recipe.getInputs();
        List<ItemStack> outputs = recipe.getOutputs();

        int OUTPUT_START = inputs.size();

        for (int i = 0; i < outputs.size(); i++) {
            ItemStack out = outputs.get(i);

            if (out.isEmpty() || out.getItem() == Items.AIR) continue;

            int slot = OUTPUT_START + i;
            ItemStack existing = blockEntity.itemHandler.getStackInSlot(slot);

            if (existing.isEmpty()) continue;

            if (!ItemStack.isSameItemSameTags(existing, out)) {
                return false;
            }

            if (existing.getCount() + out.getCount() > existing.getMaxStackSize()) {
                return false;
            }
        }

        return true;
    }

    public void insertRecipeInputsFromPlayer(Player player, Recipe<?> recipe, boolean shift) {
        if (!(recipe instanceof BioReactorRecipe recipeData)) return;

        player.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(playerInv -> {
            this.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(machineInv -> {

                List<ItemStack> inputs = recipeData.getInputs();

                Map<Item, Integer> totalCounts = new HashMap<>();
                if (shift) {
                    for (ItemStack input : inputs) {
                        if (!input.isEmpty() && input.getItem() != Items.AIR) {
                            int count = countItemInInventory(playerInv, input.getItem());
                            totalCounts.put(input.getItem(), count);
                        }
                    }
                }

                for (int slot = 0; slot < inputs.size(); slot++) {
                    ItemStack required = inputs.get(slot);

                    if (required.isEmpty() || required.getItem() == Items.AIR) continue;

                    if (shift) {
                        long sameCount = inputs.stream()
                                .filter(s -> !s.isEmpty()
                                        && s.getItem() != Items.AIR
                                        && s.getItem() == required.getItem())
                                .count();

                        int total = totalCounts.getOrDefault(required.getItem(), 0);

                        int perSlot = sameCount > 0 ? total / (int) sameCount : total;
                        perSlot = Math.max(1, perSlot);

                        insertItemFromPlayer(playerInv, machineInv,
                                new ItemStack(required.getItem(), perSlot),
                                slot);

                    } else {
                        insertItemFromPlayer(playerInv, machineInv,
                                required.copy(),
                                slot);
                    }
                }
            });
        });
    }

    private static int countItemInInventory(IItemHandler inventory, Item target) {
        int count = 0;
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (!stack.isEmpty() && stack.getItem() == target) {
                count += stack.getCount();
            }
        }
        return count;
    }

    private void insertItemFromPlayer(IItemHandler playerInv, IItemHandler machineInv, ItemStack required, int slotIndex) {
        if (required.isEmpty()) return;

        int needed = required.getCount();

        for (int i = 0; i < playerInv.getSlots() && needed > 0; i++) {
            ItemStack fromSlot = playerInv.getStackInSlot(i);
            if (!ItemStack.isSameItemSameTags(fromSlot, required)) continue;

            int toExtract = Math.min(needed, fromSlot.getCount());
            ItemStack extracted = playerInv.extractItem(i, toExtract, false);
            ItemStack leftover = machineInv.insertItem(slotIndex, extracted, false);

            if (!leftover.isEmpty()) {
                needed -= (toExtract - leftover.getCount());
                playerInv.insertItem(i, leftover, false);
            } else {
                needed -= toExtract;
            }
        }
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
