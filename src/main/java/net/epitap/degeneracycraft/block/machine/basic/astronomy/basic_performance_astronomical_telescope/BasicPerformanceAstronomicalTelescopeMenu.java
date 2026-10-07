package net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope;

import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.block.base.machine.DCMachineMenuBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BasicPerformanceAstronomicalTelescopeMenu extends DCMachineMenuBase {

    public static final int IN_X_0 = 26;
    public static final int IN_Y_0 = 25;

    public static final int IN_X_1 = 26;
    public static final int IN_Y_1 = 43;

    public static final int OUT_X_0 = 116;
    public static final int OUT_Y_0 = 25;

    public BasicPerformanceAstronomicalTelescopeMenu(int containerId, Inventory inventory, FriendlyByteBuf extraData) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(7));
    }

    public BasicPerformanceAstronomicalTelescopeMenu(int containerId, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(DCMenuTypes.BASIC_PERFORMANCE_ASTROMICAL_TELESCOPE_MENU.get(), containerId, inventory, (BasicPerformanceAstronomicalTelescopeBlockEntity) entity, data);
    }

    @Override
    protected MenuType<?> getMenuType() {
        return DCMenuTypes.BASIC_PERFORMANCE_ASTROMICAL_TELESCOPE_MENU.get();
    }

    @Override
    protected void addMachineSlots() {
        addMachineSlot(BasicPerformanceAstronomicalTelescopeBlockEntity.IN_0, IN_X_0, IN_Y_0);
        addMachineSlot(BasicPerformanceAstronomicalTelescopeBlockEntity.IN_1, IN_X_1, IN_Y_1);
        addMachineSlot(BasicPerformanceAstronomicalTelescopeBlockEntity.OUT_0, OUT_X_0, OUT_Y_0);
    }

    @Override
    protected int getMachineSlotCount() {
        return BasicPerformanceAstronomicalTelescopeBlockEntity.MACHINE_COUNT;
    }

    @Override
    protected Block getMachineBlock() {
        return DCBlocks.BASIC_PERFORMANCE_ASTRONOMICAL_TELESCOPE_BLOCK.get();
    }

}
