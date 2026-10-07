package net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.energy_storage;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyBlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BasicStrengthFormalScienceMultiblockEnergyStorageBlockEntity extends DCMultiblockEnergyBlockEntityBase {
    public static final float STORAGE_CAPACITY = 100000F;
    public static final float STORAGE_TRANSFER = 32F;
    public static final int STORAGE_COUNT = 9;


    public BasicStrengthFormalScienceMultiblockEnergyStorageBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_BLOCK_ENTITY.get(), pos, state,
                STORAGE_CAPACITY, STORAGE_TRANSFER, STORAGE_COUNT);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BasicStrengthFormalScienceMultiblockEnergyStorageMenu(containerId, inventory, this, data);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicStrengthFormalScienceMultiblockEnergyStorageBlockEntity blockEntity) {
        blockEntity.ENERGY_STORAGE.receiveEnergyFloat(1e-20F, false);
        blockEntity.ENERGY_STORAGE.extractEnergyFloat(1e-20F, false);
    }

    @Override
    public float getEnergyCapacity() {
        return 0;
    }
}
