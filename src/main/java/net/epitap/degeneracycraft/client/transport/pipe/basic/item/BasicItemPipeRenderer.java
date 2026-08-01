package net.epitap.degeneracycraft.client.transport.pipe.basic.item;


import net.epitap.degeneracycraft.client.transport.pipe.parametor.PipeModelRegistry.DCPipeModel;
import net.epitap.degeneracycraft.client.transport.pipe.pipebase.PipeRendererBase;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class BasicItemPipeRenderer extends PipeRendererBase {
    public BasicItemPipeRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public DCPipeModel getModel() {
        return DCPipeModel.BASIC_ITEM_PIPE_BLOCK_EXTRACT;
    }
}
