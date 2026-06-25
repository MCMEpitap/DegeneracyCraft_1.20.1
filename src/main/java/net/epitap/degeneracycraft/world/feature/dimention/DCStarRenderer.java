package net.epitap.degeneracycraft.world.feature.dimention;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DCStarRenderer {

    private static final List<StarData> STARS = new ArrayList<>();

    static {

        Random random = new Random(10842L);

        for(int i = 0; i < 1500; i++) {

            double x = random.nextDouble() * 2.0D - 1.0D;
            double y = random.nextDouble() * 2.0D - 1.0D;
            double z = random.nextDouble() * 2.0D - 1.0D;

            Vec3 vec = new Vec3(x, y, z);

            if(vec.lengthSqr() < 0.01D) {
                continue;
            }

            vec = vec.normalize();

            float size;

            if(random.nextFloat() < 0.90F) {
                size = 0.08F + random.nextFloat() * 0.10F;
            }

            else {
                size = 0.30F + random.nextFloat() * 0.20F;
            }

            STARS.add(new StarData(vec, size));
        }
    }

    public static void render(PoseStack poseStack) {

        RenderSystem.setShader(
                GameRenderer::getPositionColorShader
        );

        Matrix4f matrix =
                poseStack.last().pose();

        BufferBuilder buffer =
                Tesselator.getInstance().getBuilder();

        buffer.begin(
                VertexFormat.Mode.QUADS,
                DefaultVertexFormat.POSITION_COLOR
        );

        float distance = 100.0F;

        for(StarData star : STARS) {

            Vec3 pos = star.position();

            float size = star.size();

            float x =
                    (float)(pos.x * distance);

            float y =
                    (float)(pos.y * distance);

            float z =
                    (float)(pos.z * distance);

            buffer.vertex(
                            matrix,
                            x - size,
                            y,
                            z - size
                    )
                    .color(255, 255, 255, 255)
                    .endVertex();

            buffer.vertex(
                            matrix,
                            x + size,
                            y,
                            z - size
                    )
                    .color(255, 255, 255, 255)
                    .endVertex();

            buffer.vertex(
                            matrix,
                            x + size,
                            y,
                            z + size
                    )
                    .color(255, 255, 255, 255)
                    .endVertex();

            buffer.vertex(
                            matrix,
                            x - size,
                            y,
                            z + size
                    )
                    .color(255, 255, 255, 255)
                    .endVertex();
        }

        BufferUploader.drawWithShader(
                buffer.end()
        );
    }

    public record StarData(Vec3 position, float size) {}
}