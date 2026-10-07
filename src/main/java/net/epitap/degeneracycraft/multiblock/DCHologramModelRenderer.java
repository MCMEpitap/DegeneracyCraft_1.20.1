package net.epitap.degeneracycraft.multiblock;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;

import java.util.List;

public final class DCHologramModelRenderer {

    private DCHologramModelRenderer() {}

    public static void render(PoseStack.Pose pose, VertexConsumer consumer, BlockState state,
                              BakedModel model, int packedLight, int packedOverlay) {
        RandomSource random = RandomSource.create(42L);

        renderQuads(
                pose,
                consumer,
                model.getQuads(
                        state,
                        null,
                        random,
                        ModelData.EMPTY,
                        DCHologramRenderTypes.HOLOGRAM
                ),
                packedLight,
                packedOverlay
        );

        for (Direction direction : Direction.values()) {

            random.setSeed(42L);

            List<BakedQuad> quads = model.getQuads(
                    state,
                    direction,
                    random,
                    ModelData.EMPTY,
                    DCHologramRenderTypes.HOLOGRAM
            );

            renderQuads(
                    pose,
                    consumer,
                    quads,
                    packedLight,
                    packedOverlay
            );
        }
    }

    private static void renderQuads(PoseStack.Pose pose, VertexConsumer consumer, List<BakedQuad> quads,
                                    int packedLight, int packedOverlay) {
        for (BakedQuad quad : quads) {

            consumer.putBulkData(
                    pose,
                    quad,
                    1.0F,
                    1.0F,
                    1.0F,
                    packedLight,
                    packedOverlay
            );
        }
    }
}