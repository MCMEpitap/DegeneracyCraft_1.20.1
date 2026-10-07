package net.epitap.degeneracycraft.block.storage.basic.engineering.item.input_port;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.machine.DCNearbyStorageManagerBase;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemBlockEntityBase;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.item_storage.BasicStrengthEngineeringMultiblockItemStorageBlockEntity;
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

public class BasicStrengthEngineeringMultiblockItemInputPortBlockEntity extends DCMultiblockItemBlockEntityBase {
    public static final int STORAGE_COUNT = 18;

    public BasicStrengthEngineeringMultiblockItemInputPortBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK_ENTITY.get(), pos, state, STORAGE_COUNT);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BasicStrengthEngineeringMultiblockItemInputPortMenu(containerId, inventory, this, data);
    }

    private void pullItemsFromNearbyStorage(Level level) {
        boolean hasSpace = false;
        for (int machineSlot = 0; machineSlot < itemHandler.getSlots(); machineSlot++) {
            ItemStack current = itemHandler.getStackInSlot(machineSlot);
            if (current.isEmpty() || current.getCount() < current.getMaxStackSize()) {
                hasSpace = true;
                break;
            }
        }

        if (!hasSpace) return;

        List<DCNearbyStorageManagerBase.ExtractItemStorageCandidate> storages =
                DCNearbyStorageManagerBase.findExtractItemStorages(level, getBlockPos(), BasicStrengthEngineeringMultiblockItemStorageBlockEntity.class);

        for (DCNearbyStorageManagerBase.ExtractItemStorageCandidate candidate : storages) {
            IItemHandler storage = candidate.handler();

            for (int storageSlot = 0; storageSlot < storage.getSlots(); storageSlot++) {
                ItemStack sourceStack = storage.getStackInSlot(storageSlot);
                if (sourceStack.isEmpty()) continue;

                for (int machineSlot = 0; machineSlot < itemHandler.getSlots(); machineSlot++) {
                    if (!itemHandler.isItemValid(machineSlot, sourceStack)) continue;

                    ItemStack simulated = itemHandler.insertItem(machineSlot, sourceStack.copy(), true);
                    int insertable = sourceStack.getCount() - simulated.getCount();
                    if (insertable <= 0) continue;

                    ItemStack extracted = storage.extractItem(storageSlot, insertable, false);
                    if (extracted.isEmpty()) continue;

                    ItemStack remainder = itemHandler.insertItem(machineSlot, extracted, false);
                    if (!remainder.isEmpty()) {
                        storage.insertItem(storageSlot, remainder, false);
                    }
                    return;
                }
            }
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicStrengthEngineeringMultiblockItemInputPortBlockEntity blockEntity) {
        blockEntity.pullItemsFromNearbyStorage(level);
    }
}
