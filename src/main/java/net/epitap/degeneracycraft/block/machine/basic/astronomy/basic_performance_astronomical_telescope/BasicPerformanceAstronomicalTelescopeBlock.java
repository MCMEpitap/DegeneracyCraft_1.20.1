package net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BasicPerformanceAstronomicalTelescopeBlock extends DCMachineBlockBase {

    public BasicPerformanceAstronomicalTelescopeBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BasicPerformanceAstronomicalTelescopeBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, DCBlockEntities.BASIC_PERFORMANCE_ASTRONOMICAL_TELESCOPE_BLOCK_ENTITY.get(), BasicPerformanceAstronomicalTelescopeBlockEntity::tick);
    }
}