package net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.input_port;

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

public class BasicStrengthJenithVoidScienceMultiblockItemInputPortBlock extends DCMultiblockStorageBlockBase {
    public BasicStrengthJenithVoidScienceMultiblockItemInputPortBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BasicStrengthJenithVoidScienceMultiblockItemInputPortBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        return createTickerHelper(type, DCBlockEntities.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK_ENTITY.get(),
                BasicStrengthJenithVoidScienceMultiblockItemInputPortBlockEntity::tick);
    }
}