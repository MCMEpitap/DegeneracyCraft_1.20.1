package net.epitap.degeneracycraft.block.base.machine;

import net.epitap.degeneracycraft.energy.DCIEnergyStorageFloat;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public abstract class DCMachineMenuBase extends AbstractContainerMenu {

    protected static final int HOTBAR_SLOT_COUNT = 9;
    protected static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    protected static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    protected static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    protected static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    protected static final int VANILLA_FIRST_SLOT_INDEX = 0;
    protected static final int MACHINE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    protected static final int DATA_COUNTER = 0;
    protected static final int DATA_PROGRESS = 1;
    protected static final int DATA_HOLOGRAM = 2;
    protected static final int DATA_FORCE_STOP = 3;
    protected static final int DATA_MULTIBLOCK = 4;
    protected static final int DATA_RECIPE_LOCK = 5;
    protected static final int DATA_WORKING = 6;

    protected final DCMachineBlockEntityBase blockEntity;
    protected final Level level;
    protected final ContainerData data;

    protected DCMachineMenuBase(MenuType<?> menuType, int containerId, Inventory inventory, DCMachineBlockEntityBase blockEntity, ContainerData data) {
        super(menuType, containerId);

        this.blockEntity = blockEntity;
        this.level = inventory.player.level();
        this.data = data;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        addMachineSlots();

        addDataSlots(data);
    }

    protected abstract net.minecraft.world.inventory.MenuType<?> getMenuType();

    protected abstract void addMachineSlots();

    protected abstract int getMachineSlotCount();

    protected abstract net.minecraft.world.level.block.Block getMachineBlock();

    public boolean isWorking() {
        return data.get(DATA_WORKING) != 0;
    }

    public int getProgressPercent() {
        return data.get(DATA_PROGRESS);
    }

    public int getHologramLevel() {
        return data.get(DATA_HOLOGRAM);
    }

    public boolean isForceHalt() {
        return data.get(DATA_FORCE_STOP) != 0;
    }

    public int getMultiblockLevel() {
        return data.get(DATA_MULTIBLOCK);
    }

    public boolean isInputLocked() {
        return data.get(DATA_RECIPE_LOCK) != 0;
    }

    public DCIEnergyStorageFloat getEnergy() {
        return blockEntity.getEnergyStorage();
    }

    public DCMachineBlockEntityBase getBlockEntity() {
        return blockEntity;
    }

    public int getParallelLimit() {
        return blockEntity.getParallelLimit();
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);

        if (sourceSlot == null || !sourceSlot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        int machineFirstSlot = MACHINE_INVENTORY_FIRST_SLOT_INDEX;
        int machineLastSlot = machineFirstSlot + getMachineSlotCount();

        if (index < VANILLA_SLOT_COUNT) {

            if (!moveItemStackTo(sourceStack, machineFirstSlot, machineLastSlot, false)) {
                return ItemStack.EMPTY;
            }

        } else if (index < machineLastSlot) {

            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }

        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(player, sourceStack);

        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, getMachineBlock());
    }

    protected void addMachineSlot(int slot, int x, int y) {
        blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> addSlot(new SlotItemHandler(handler, slot, x, y)));
    }

    protected void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < PLAYER_INVENTORY_ROW_COUNT; row++) {
            for (int column = 0; column < PLAYER_INVENTORY_COLUMN_COUNT; column++) {
                addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }
    }

    protected void addPlayerHotbar(Inventory playerInventory) {
        for (int slot = 0; slot < HOTBAR_SLOT_COUNT; slot++) {
            addSlot(new Slot(playerInventory, slot, 8 + slot * 18, 142));
        }
    }
}