package net.epitap.degeneracycraft.block.storage.basic.biology.energy.output_bus;

import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyBlockEntityBase;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyMenuBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BasicStrengthBiologyMultiblockEnergyOutputBusMenu extends DCMultiblockEnergyMenuBase {

    public BasicStrengthBiologyMultiblockEnergyOutputBusMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(0));
    }

    public BasicStrengthBiologyMultiblockEnergyOutputBusMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(), id, inv, (DCMultiblockEnergyBlockEntityBase) entity, data);
    }

    @Override
    protected Block getValidBlock() {
        return DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get();
    }
}