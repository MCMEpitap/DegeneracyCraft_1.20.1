package net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.input_bus;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.machine.DCNearbyStorageManagerBase;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyBlockEntityBase;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.energy_storage.BasicStrengthHybridPhysicsMultiblockEnergyStorageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BasicStrengthHybridPhysicsMultiblockEnergyInputBusBlockEntity extends DCMultiblockEnergyBlockEntityBase {
    public static final float STORAGE_CAPACITY = 100000F;
    public static final float STORAGE_TRANSFER = 32F;
    public static final int STORAGE_COUNT = 9;


    public BasicStrengthHybridPhysicsMultiblockEnergyInputBusBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK_ENTITY.get(), pos, state,
                STORAGE_CAPACITY, STORAGE_TRANSFER, STORAGE_COUNT);
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BasicStrengthHybridPhysicsMultiblockEnergyInputBusMenu(containerId, inventory, this, data);
    }

    private void pullEnergyFromNearbyStorage(Level level) {
        float needed = STORAGE_CAPACITY - ENERGY_STORAGE.getEnergyStoredFloat();

        if (needed <= 0F) {
            return;
        }

        List<DCNearbyStorageManagerBase.ExtractEnergyStorageCandidate> storages =
                DCNearbyStorageManagerBase.findExtractEnergyStorages(level, getBlockPos(), BasicStrengthHybridPhysicsMultiblockEnergyStorageBlockEntity.class);

        for (DCNearbyStorageManagerBase.ExtractEnergyStorageCandidate candidate : storages) {
            if (needed <= 0F) {
                break;
            }

            float extracted = candidate.storage().extractEnergyFloat(needed, false);

            if (extracted <= 0F) {
                continue;
            }

            ENERGY_STORAGE.receiveEnergyFloat(extracted, false);
            needed -= extracted;
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicStrengthHybridPhysicsMultiblockEnergyInputBusBlockEntity blockEntity) {
        blockEntity.pullEnergyFromNearbyStorage(level);
    }
}