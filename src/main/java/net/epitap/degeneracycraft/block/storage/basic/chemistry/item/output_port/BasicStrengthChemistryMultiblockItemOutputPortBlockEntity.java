package net.epitap.degeneracycraft.block.storage.basic.chemistry.item.output_port;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.machine.DCNearbyStorageManagerBase;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemBlockEntityBase;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.item_storage.BasicStrengthChemistryMultiblockItemStorageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BasicStrengthChemistryMultiblockItemOutputPortBlockEntity extends DCMultiblockItemBlockEntityBase {
    public static final int STORAGE_COUNT = 18;

    public BasicStrengthChemistryMultiblockItemOutputPortBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK_ENTITY.get(), pos, state, STORAGE_COUNT);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BasicStrengthChemistryMultiblockItemOutputPortMenu(containerId, inventory, this, data);
    }

    private void pushItemsToNearbyStorage(Level level) {
        List<DCNearbyStorageManagerBase.ReceiveItemStorageCandidate> storages =
                DCNearbyStorageManagerBase.findReceiveItemStorages(level, getBlockPos(), BasicStrengthChemistryMultiblockItemStorageBlockEntity.class);

        if (storages.isEmpty()) return;

        for (int portSlot = 0; portSlot < itemHandler.getSlots(); portSlot++) {
            ItemStack sourceStack = itemHandler.getStackInSlot(portSlot);
            if (sourceStack.isEmpty()) continue;

            for (DCNearbyStorageManagerBase.ReceiveItemStorageCandidate candidate : storages) {
                IItemHandler storage = candidate.handler();

                for (int storageSlot = 0; storageSlot < storage.getSlots(); storageSlot++) {
                    ItemStack simulated = storage.insertItem(storageSlot, sourceStack.copy(), true);
                    int insertable = sourceStack.getCount() - simulated.getCount();
                    if (insertable <= 0) continue;

                    ItemStack toInsert = sourceStack.copy();
                    toInsert.setCount(insertable);

                    ItemStack remainder = storage.insertItem(storageSlot, toInsert, false);
                    int inserted = insertable - remainder.getCount();
                    if (inserted <= 0) continue;

                    sourceStack.shrink(inserted);
                    itemHandler.setStackInSlot(portSlot, sourceStack);

                    if (sourceStack.isEmpty()) break;
                }

                if (sourceStack.isEmpty()) break;
            }
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicStrengthChemistryMultiblockItemOutputPortBlockEntity blockEntity) {
        blockEntity.pushItemsToNearbyStorage(level);
    }
}