package net.epitap.degeneracycraft.block.storage.basic.biology.item.item_storage;

import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemBlockEntityBase;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemMenuBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BasicStrengthBiologyMultiblockItemStorageMenu extends DCMultiblockItemMenuBase {
    public BasicStrengthBiologyMultiblockItemStorageMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(0));
    }

    public BasicStrengthBiologyMultiblockItemStorageMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_STORAGE_MENU.get(), id, inv,
                (DCMultiblockItemBlockEntityBase) entity, data);
    }

    @Override
    protected void addItemSlots() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                addItemSlot(column + row * 3, 8 + column * 18, 7 + row * 18);
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                addItemSlot(9 + column + row * 3, 98 + column * 18, 7 + row * 18);
            }
        }
    }

    @Override
    protected Block getValidBlock() {
        return DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_STORAGE_BLOCK.get();
    }
}
