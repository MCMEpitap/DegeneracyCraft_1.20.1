package net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.energy.energy_storage;

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

public class BasicStrengthImitationMagicEngineeringMultiblockEnergyStorageMenu extends DCMultiblockEnergyMenuBase {

    public BasicStrengthImitationMagicEngineeringMultiblockEnergyStorageMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(0));
    }

    public BasicStrengthImitationMagicEngineeringMultiblockEnergyStorageMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(DCMenuTypes.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_MENU.get(), id, inv,
                (DCMultiblockEnergyBlockEntityBase) entity, data);
    }

    @Override
    protected Block getValidBlock() {
        return DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_BLOCK.get();
    }
}