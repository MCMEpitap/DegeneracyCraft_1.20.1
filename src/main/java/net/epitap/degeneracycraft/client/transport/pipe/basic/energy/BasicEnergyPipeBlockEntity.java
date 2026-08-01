package net.epitap.degeneracycraft.client.transport.pipe.basic.energy;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.client.transport.pipe.pipebase.PipeTypeBase;
import net.epitap.degeneracycraft.client.transport.pipe.pipebase.PipeWorkBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BasicEnergyPipeBlockEntity extends PipeWorkBlockEntity {
    public BasicEnergyPipeBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_ENERGY_PIPE_BLOCK_ENTITY.get(), new PipeTypeBase[]{BasicEnergyPipeType.INSTANCE}, pos, state);
    }
}
