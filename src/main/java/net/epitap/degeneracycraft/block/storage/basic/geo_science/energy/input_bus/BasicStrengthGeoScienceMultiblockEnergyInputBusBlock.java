package net.epitap.degeneracycraft.block.storage.basic.geo_science.energy.input_bus;

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

public class BasicStrengthGeoScienceMultiblockEnergyInputBusBlock extends DCMultiblockStorageBlockBase {
    public BasicStrengthGeoScienceMultiblockEnergyInputBusBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BasicStrengthGeoScienceMultiblockEnergyInputBusBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        return createTickerHelper(type, DCBlockEntities.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK_ENTITY.get(),
                BasicStrengthGeoScienceMultiblockEnergyInputBusBlockEntity::tick);
    }
}