package net.epitap.degeneracycraft.client.transport.pipe.basic.energy.floa;


import net.epitap.degeneracycraft.client.transport.pipe.parametor.PipeModelRegistry.DCPipeModel;
import net.epitap.degeneracycraft.client.transport.pipe.pipebase.PipeRendererBase;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class FloatEnergyPipeRenderer extends PipeRendererBase {
    public FloatEnergyPipeRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public DCPipeModel getModel() {
        return DCPipeModel.FLOAT_ENERGY_PIPE_BLOCK_EXTRACT;
    }
}
