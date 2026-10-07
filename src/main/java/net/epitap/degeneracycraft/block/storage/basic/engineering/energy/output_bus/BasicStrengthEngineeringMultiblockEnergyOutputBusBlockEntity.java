package net.epitap.degeneracycraft.block.storage.basic.engineering.energy.output_bus;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.machine.DCNearbyStorageManagerBase;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyBlockEntityBase;
import net.epitap.degeneracycraft.block.storage.basic.engineering.energy.energy_storage.BasicStrengthEngineeringMultiblockEnergyStorageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class BasicStrengthEngineeringMultiblockEnergyOutputBusBlockEntity extends DCMultiblockEnergyBlockEntityBase {
    public static final float STORAGE_CAPACITY = 100000F;
    public static final float STORAGE_TRANSFER = 32F;
    public static final int STORAGE_COUNT = 9;


    public BasicStrengthEngineeringMultiblockEnergyOutputBusBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK_ENTITY.get(), pos, state,
                STORAGE_CAPACITY, STORAGE_TRANSFER, STORAGE_COUNT);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BasicStrengthEngineeringMultiblockEnergyOutputBusMenu(containerId, inventory, this, data);
    }

    private void pushEnergyToNearbyStorages(Level level) {
        float stored = ENERGY_STORAGE.getEnergyStoredFloat();

        if (stored <= 0F) {
            return;
        }

        List<DCNearbyStorageManagerBase.ReceiveEnergyStorageCandidate> storages =
                DCNearbyStorageManagerBase.findReceiveEnergyStorages(level, getBlockPos(), BasicStrengthEngineeringMultiblockEnergyStorageBlockEntity.class);

        for (DCNearbyStorageManagerBase.ReceiveEnergyStorageCandidate candidate : storages) {
            if (stored <= 0F) {
                break;
            }

            float accepted =
                    candidate.storage().receiveEnergyFloat(stored, false);

            if (accepted <= 0F) {
                continue;
            }

            ENERGY_STORAGE.extractEnergyFloat(accepted, false);
            stored -= accepted;
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicStrengthEngineeringMultiblockEnergyOutputBusBlockEntity blockEntity) {
        blockEntity.pushEnergyToNearbyStorages(level);
    }
}