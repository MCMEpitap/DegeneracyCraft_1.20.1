package net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_element_processor.MachineElementProcessorRecipe;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RedstonePoweredMachineElementManufactureMachineBlockEntity extends BlockEntity implements MenuProvider {
    public final ContainerData data;
    public int counter = 0;
    public int getProgressPercent;
    
    public static final int RECIPE_COUNT      = 9;
    public static final int OUTPUT_COUNT      = 1;
    public static final int MACHINE_COUNT     = RECIPE_COUNT + OUTPUT_COUNT;
    
    public static final int DATA_COUNTER      = 0;
    public static final int DATA_PROGRESS     = 1;

    public final int IN_0 = 0, IN_1 = 1, IN_2 = 2, IN_3 = 3, IN_4 = 4, IN_5 = 5, IN_6 = 6, IN_7 = 7, IN_8 = 8;
    public final int OUT_0 = 9;
    
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
                case OUT_0 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    private final Map<Direction, LazyOptional<DCWrappedHandler>> directionDCWrappedHandlerMap =
            Map.of(
                    Direction.NORTH, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (in) -> in == IN_0, (in, stack) -> itemHandler.isItemValid(IN_0, stack))),
                    Direction.SOUTH, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (in) -> in == IN_0, (in, stack) -> itemHandler.isItemValid(IN_0, stack))),
                    Direction.EAST, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (out) -> out == OUT_0, (out, stack) -> false)),
                    Direction.WEST, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, (in) -> in == IN_0, (in, stack) -> itemHandler.isItemValid(IN_0, stack)))
            );

    public RedstonePoweredMachineElementManufactureMachineBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(DCBlockEntities.REDSTONE_POWERED_MACHINE_ELEMENT_MANUFACTURE_MACHINE_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);

        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case DATA_COUNTER    -> counter;
                    case DATA_PROGRESS   -> getProgressPercent;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case DATA_COUNTER -> counter = value;
                    case DATA_PROGRESS -> getProgressPercent = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

    }
    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new RedstonePoweredMachineElementManufactureMachineMenu(pContainerId, pInventory, this, this.data);
    }

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }
            if (directionDCWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(RedstonePoweredMachineElementManufactureMachineBlock.FACING);

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

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("counter", counter);
        nbt.putInt("getProgressPercent", getProgressPercent);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        counter = nbt.getInt("counter");
        getProgressPercent = nbt.getInt("getProgressPercent");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pPos, BlockState pState, RedstonePoweredMachineElementManufactureMachineBlockEntity blockEntity) {
        if (hasRecipe(blockEntity) && hasAmountRecipe(blockEntity) && canOutput(blockEntity)) {
                blockEntity.counter++;
                setChanged(level, pPos, pState);
                if (craftCheck(blockEntity)) {
                    craftItem(blockEntity);
                }
            } else {
            blockEntity.resetProgress();
            setChanged(level, pPos, pState);
        }
    }

    public static boolean craftCheck(RedstonePoweredMachineElementManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<MachineElementProcessorRecipe> match = level.getRecipeManager()
                .getRecipeFor(MachineElementProcessorRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            return blockEntity.data.get(0) >= match.get().getRequiredTime() * 20;
        }
        return false;
    }

    private static boolean hasRecipe(RedstonePoweredMachineElementManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<MachineElementProcessorRecipe> match = level.getRecipeManager()
                .getRecipeFor(MachineElementProcessorRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent();
    }

    private static boolean hasAmountRecipe(RedstonePoweredMachineElementManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        if (level == null) return false;

        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<MachineElementProcessorRecipe> match = level.getRecipeManager()
                .getRecipeFor(MachineElementProcessorRecipe.Type.INSTANCE, inventory, level);

        if (match.isEmpty()) return false;

        MachineElementProcessorRecipe recipe = match.get();
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

    private static void craftItem(RedstonePoweredMachineElementManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        if (level == null) return;

        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<MachineElementProcessorRecipe> match = level.getRecipeManager()
                .getRecipeFor(MachineElementProcessorRecipe.Type.INSTANCE, inventory, level);

        if (match.isEmpty()) return;

        MachineElementProcessorRecipe recipe = match.get();

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

    private static boolean canOutput(RedstonePoweredMachineElementManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        if (level == null) return false;

        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<MachineElementProcessorRecipe> match = level.getRecipeManager()
                .getRecipeFor(MachineElementProcessorRecipe.Type.INSTANCE, inventory, level);

        if (match.isEmpty()) return false;

        MachineElementProcessorRecipe recipe = match.get();
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
        if (!(recipe instanceof MachineElementProcessorRecipe recipeData)) return;

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
