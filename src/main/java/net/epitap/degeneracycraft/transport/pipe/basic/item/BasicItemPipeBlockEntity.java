package net.epitap.degeneracycraft.transport.pipe.basic.item;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.transport.pipe.pipebase.PipeTypeBase;
import net.epitap.degeneracycraft.transport.pipe.pipebase.PipeWorkBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BasicItemPipeBlockEntity extends PipeWorkBlockEntity {
    public BasicItemPipeBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_ITEM_PIPE_BLOCK_ENTITY.get(), new PipeTypeBase[]{BasicItemPipeType.INSTANCE}, pos, state);
    }
}
