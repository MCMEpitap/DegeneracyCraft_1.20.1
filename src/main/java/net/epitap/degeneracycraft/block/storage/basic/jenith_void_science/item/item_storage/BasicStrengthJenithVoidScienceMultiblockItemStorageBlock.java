package net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.item_storage;

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

public class BasicStrengthJenithVoidScienceMultiblockItemStorageBlock extends DCMultiblockStorageBlockBase {
    public BasicStrengthJenithVoidScienceMultiblockItemStorageBlock(Properties properties) {
        super(properties);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BasicStrengthJenithVoidScienceMultiblockItemStorageBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        return createTickerHelper(type, DCBlockEntities.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_STORAGE_BLOCK_ENTITY.get(),
                BasicStrengthJenithVoidScienceMultiblockItemStorageBlockEntity::tick);
    }
}