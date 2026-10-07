package net.epitap.degeneracycraft.block.storage.basic.biology.energy.input_bus;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockStorageBlockBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BasicStrengthBiologyMultiblockEnergyInputBusBlock extends DCMultiblockStorageBlockBase {
    public BasicStrengthBiologyMultiblockEnergyInputBusBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BasicStrengthBiologyMultiblockEnergyInputBusBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        return createTickerHelper(type, DCBlockEntities.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK_ENTITY.get(),
                BasicStrengthBiologyMultiblockEnergyInputBusBlockEntity::tick);
    }
}