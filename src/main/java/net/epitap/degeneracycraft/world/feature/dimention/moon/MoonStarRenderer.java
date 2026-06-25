package net.epitap.degeneracycraft.world.feature.dimention.moon;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.epitap.degeneracycraft.world.feature.dimention.DCDimensionTimes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoonStarRenderer {
    private static final List<StarData> STARS = new ArrayList<>();

    static {
        Random random = new Random(10842L);

        for(int i = 0; i < 3000; i++) {

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
                size = 0.20F + random.nextFloat() * 0.20F;
            }

            int r;
            int g;
            int b;

            float colorRoll = random.nextFloat();

            if(colorRoll < 0.70F) {
                r = 255;
                g = 255;
                b = 255;
            }
            else if(colorRoll < 0.90F) {
                r = 220;
                g = 235;
                b = 255;
                size *= 1.05F;
            }
            else if(colorRoll < 0.96F) {
                r = 255;
                g = 245;
                b = 180;
                size *= 1.1F;
            }
            else if(colorRoll < 0.99F) {
                r = 255;
                g = 190;
                b = 120;

                size *= 1.2F;
            }
            else {
                r = 255;
                g = 120;
                b = 120;

                size *= 1.4F;
            }


            STARS.add(new StarData(vec, size, r, g, b));
        }
    }

    public static void render(PoseStack poseStack) {

        Minecraft mc = Minecraft.getInstance();
        Level level = mc.level;

        if (level == null) return;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);

        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        Matrix4f matrix = poseStack.last().pose();

        BufferBuilder buffer =
                Tesselator.getInstance().getBuilder();

        buffer.begin(
                VertexFormat.Mode.QUADS,
                DefaultVertexFormat.POSITION_COLOR
        );

        float distance = 100.0F;

        float angle = DCDimensionTimes.getCelestialAngle(level, mc.getFrameTime());

        float x = angle * 2.0F - 1.0F;

        float night = 1.0F - Math.abs(x);

        night = night * night * night;

        float starStrength =
                0.12F + 0.88F * night;

        int alpha = (int)(255.0F * starStrength);

        for (StarData star : STARS) {

            Vec3 dir = star.position().normalize();
            float size = star.size();

            Vec3 center = dir.scale(distance);

            Vec3 reference =
                    Math.abs(dir.y) > 0.95
                            ? new Vec3(1, 0, 0)
                            : new Vec3(0, 1, 0);

            Vec3 right = dir.cross(reference).normalize();
            Vec3 up = right.cross(dir).normalize();

            double seed =
                    dir.x * 12.9898 +
                            dir.y * 78.233 +
                            dir.z * 37.719;

            double cos = Math.cos(seed);
            double sin = Math.sin(seed);

            Vec3 r = right.scale(cos).add(up.scale(sin));
            Vec3 u = up.scale(cos).subtract(right.scale(sin));

            r = r.scale(size);
            u = u.scale(size);

            Vec3 p1 = center.subtract(r).subtract(u);
            Vec3 p2 = center.add(r).subtract(u);
            Vec3 p3 = center.add(r).add(u);
            Vec3 p4 = center.subtract(r).add(u);

            int rC = star.red();
            int gC = star.green();
            int bC = star.blue();

            buffer.vertex(matrix, (float)p1.x, (float)p1.y, (float)p1.z)
                    .color(rC, gC, bC, alpha).endVertex();

            buffer.vertex(matrix, (float)p2.x, (float)p2.y, (float)p2.z)
                    .color(rC, gC, bC, alpha).endVertex();

            buffer.vertex(matrix, (float)p3.x, (float)p3.y, (float)p3.z)
                    .color(rC, gC, bC, alpha).endVertex();

            buffer.vertex(matrix, (float)p4.x, (float)p4.y, (float)p4.z)
                    .color(rC, gC, bC, alpha).endVertex();
        }

        BufferUploader.drawWithShader(buffer.end());

        RenderSystem.depthMask(true);
    }

    public record StarData(Vec3 position, float size, int red, int green, int blue) {}

}

