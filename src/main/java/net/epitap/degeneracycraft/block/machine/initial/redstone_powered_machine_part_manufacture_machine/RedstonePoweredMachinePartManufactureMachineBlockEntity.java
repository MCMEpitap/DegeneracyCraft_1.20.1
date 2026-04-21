package net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_part_manufacture_machine;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.integration.jei.initial.redstone_powered_machine_part_manufacture_machine.RedstonePoweredMachinePartManufactureMachineRecipe;
import net.epitap.degeneracycraft.util.DCWrappedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RedstonePoweredMachinePartManufactureMachineBlockEntity extends BlockEntity implements MenuProvider {
    public final ContainerData data;
    public int counter = 0;
    public int getProgressPercent;
    public static final int DATA_COUNTER      = 0;
    public static final int DATA_PROGRESS     = 1;

    public static final int IN_0   = 0;
    public static final int IN_1   = 1;
    public static final int IN_2   = 2;
    public static final int IN_3   = 3;
    public static final int IN_4   = 4;
    public static final int IN_5   = 5;
    public static final int IN_6   = 6;
    public static final int IN_7   = 7;
    public static final int IN_8   = 8;
    public static final int OUT_0   = 9;

    public final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
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

    public RedstonePoweredMachinePartManufactureMachineBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(DCBlockEntities.REDSTONE_POWERED_MACHINE_PART_MANUFACTURE_MACHINE_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);

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
        return new RedstonePoweredMachinePartManufactureMachineMenu(pContainerId, pInventory, this, this.data);
    }

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }
            if (directionDCWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(RedstonePoweredMachinePartManufactureMachineBlock.FACING);

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

    public static void tick(Level level, BlockPos pPos, BlockState pState, RedstonePoweredMachinePartManufactureMachineBlockEntity blockEntity) {
        if (hasRecipe(blockEntity) && hasAmountRecipe(blockEntity)) {
            if (hasNotReachedStackLimit(blockEntity)) {
                blockEntity.counter++;
                setChanged(level, pPos, pState);
                if (craftCheck(blockEntity)) {
                    craftItem(blockEntity);
                }
            } else {
                blockEntity.resetProgress();
                setChanged(level, pPos, pState);
            }
        } else {
            blockEntity.resetProgress();
            setChanged(level, pPos, pState);
        }
    }

    public static boolean craftCheck(RedstonePoweredMachinePartManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<RedstonePoweredMachinePartManufactureMachineRecipe> match = level.getRecipeManager()
                .getRecipeFor(RedstonePoweredMachinePartManufactureMachineRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            return blockEntity.data.get(0) > match.get().getRequiredTime() * 20;
        }
        return false;
    }

    private static boolean hasRecipe(RedstonePoweredMachinePartManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<RedstonePoweredMachinePartManufactureMachineRecipe> match = level.getRecipeManager()
                .getRecipeFor(RedstonePoweredMachinePartManufactureMachineRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent();
    }

    public static boolean hasAmountRecipe(RedstonePoweredMachinePartManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<RedstonePoweredMachinePartManufactureMachineRecipe> match = level.getRecipeManager()
                .getRecipeFor(RedstonePoweredMachinePartManufactureMachineRecipe.Type.INSTANCE, inventory, level);

        return blockEntity.itemHandler.getStackInSlot(IN_0).getCount() >= match.get().getInput0Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_1).getCount() >= match.get().getInput1Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_2).getCount() >= match.get().getInput2Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_3).getCount() >= match.get().getInput3Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_4).getCount() >= match.get().getInput4Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_5).getCount() >= match.get().getInput5Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_6).getCount() >= match.get().getInput6Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_7).getCount() >= match.get().getInput7Item().getCount()
                && blockEntity.itemHandler.getStackInSlot(IN_8).getCount() >= match.get().getInput8Item().getCount();
    }

    private static void craftItem(RedstonePoweredMachinePartManufactureMachineBlockEntity blockEntity) {
        Level level = blockEntity.level;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        Optional<RedstonePoweredMachinePartManufactureMachineRecipe> match = level.getRecipeManager()
                .getRecipeFor(RedstonePoweredMachinePartManufactureMachineRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            blockEntity.itemHandler.extractItem(IN_0, match.get().getInput0Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_1, match.get().getInput1Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_2, match.get().getInput2Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_3, match.get().getInput3Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_4, match.get().getInput4Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_5, match.get().getInput5Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_6, match.get().getInput6Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_7, match.get().getInput7Item().getCount(), false);
            blockEntity.itemHandler.extractItem(IN_8, match.get().getInput8Item().getCount(), false);
            blockEntity.itemHandler.setStackInSlot(OUT_0, new ItemStack(match.get().getOutput0Item().getItem(),
                    blockEntity.itemHandler.getStackInSlot(OUT_0).getCount() + match.get().getOutput0Item().getCount()));

            blockEntity.resetProgress();
        }
    }

    public float getProgressPercent() {
        Level level = this.level;
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<RedstonePoweredMachinePartManufactureMachineRecipe> match = level.getRecipeManager()
                .getRecipeFor(RedstonePoweredMachinePartManufactureMachineRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            return (this.data.get(0) / (match.get().getRequiredTime() * 20)) * 100;
        }
        return 0;
    }

    public void resetProgress() {
        this.counter = 0;
    }


    private static boolean hasNotReachedStackLimit(RedstonePoweredMachinePartManufactureMachineBlockEntity blockEntity) {
        return blockEntity.itemHandler.getStackInSlot(OUT_0).getCount() < blockEntity.itemHandler.getStackInSlot(OUT_0).getMaxStackSize();
    }

    public void insertRecipeInputsFromPlayer(Player player, Recipe<?> recipe, boolean shift) {
        if (!(recipe instanceof RedstonePoweredMachinePartManufactureMachineRecipe recipeData)) return;

        player.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(playerInv -> {
            this.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(machineInv -> {

                ItemStack[] recipeInputs = new ItemStack[]{
                        recipeData.getInput0Item(), recipeData.getInput1Item(), recipeData.getInput2Item(),
                        recipeData.getInput3Item(), recipeData.getInput4Item(), recipeData.getInput5Item(),
                        recipeData.getInput6Item(), recipeData.getInput7Item(), recipeData.getInput8Item()
                };

                Map<Item, Integer> totalCounts = new HashMap<>();
                if (shift) {
                    for (ItemStack input : recipeInputs) {
                        if (!input.isEmpty()) {
                            int count = countItemInInventory(playerInv, input.getItem());
                            totalCounts.put(input.getItem(), count);
                        }
                    }
                }

                for (int slot = 0; slot < recipeInputs.length; slot++) {
                    ItemStack required = recipeInputs[slot];
                    if (required.isEmpty()) continue;

                    if (shift) {
                        long sameCount = Arrays.stream(recipeInputs)
                                .filter(itemStack -> !itemStack.isEmpty() && itemStack.getItem() == required.getItem())
                                .count();

                        int total = totalCounts.getOrDefault(required.getItem(), 0);
                        int perSlot = sameCount > 0 ? total / (int) sameCount : total;
                        perSlot = Math.max(1, perSlot);

                        insertItemFromPlayer(playerInv, machineInv, new ItemStack(required.getItem(), perSlot), slot);
                    } else {
                        insertItemFromPlayer(playerInv, machineInv, required.copy(), slot);
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
            if (!fromSlot.equals(required)) continue;

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
}
