package net.epitap.degeneracycraft.world.feature.dimention.moon;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.dimention.DCDimensionTimes;
import net.epitap.degeneracycraft.world.feature.dimention.DCDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

public class MoonSkyRenderer {

    public static void render(PoseStack poseStack, float partialTick) {

        Minecraft minecraft = Minecraft.getInstance();

        if(minecraft.level == null) {
            return;
        }

        if(minecraft.level.dimension() != DCDimensions.MOON_LEVEL) {
            return;
        }

        float celestialAngle = DCDimensionTimes
                .getCelestialAngle(minecraft.level, partialTick);

        MoonStarRenderer.render(poseStack);
        SunRenderer.render(poseStack, celestialAngle);
        EarthRenderer.render(poseStack);
    }

    public static class SunRenderer {

        public static final ResourceLocation SUN =
                new ResourceLocation(Degeneracycraft.MOD_ID, "textures/block/world/sun/sun.png");

        public static void render(PoseStack poseStack, float celestialAngle) {
            float distance = 100.0F;
            float size = 15.0F;

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, SUN);

            poseStack.pushPose();

            poseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));
            poseStack.mulPose(Axis.XP.rotationDegrees(celestialAngle * 360.0F));

            Matrix4f matrix = poseStack.last().pose();

            BufferBuilder buffer = Tesselator.getInstance().getBuilder();

            buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

            buffer.vertex(matrix, -size, distance, -size).uv(0, 0).endVertex();
            buffer.vertex(matrix, size, distance, -size).uv(1, 0).endVertex();
            buffer.vertex(matrix, size, distance, size).uv(1, 1).endVertex();
            buffer.vertex(matrix, -size, distance, size).uv(0, 1).endVertex();

            BufferUploader.drawWithShader(buffer.end());
            poseStack.popPose();
        }
    }


    public static class EarthRenderer {

        public static final ResourceLocation EARTH =
                new ResourceLocation(Degeneracycraft.MOD_ID, "textures/block/world/earth/earth.png");

        public static void render(PoseStack poseStack) {
            float distance = 100.0F;
            float size = 20.0F;

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, EARTH);

            poseStack.pushPose();

            poseStack.mulPose(Axis.YP.rotationDegrees(135F));
            poseStack.mulPose(Axis.XP.rotationDegrees(70F));

            Matrix4f matrix = poseStack.last().pose();

            BufferBuilder buffer = Tesselator.getInstance().getBuilder();

            buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

            buffer.vertex(matrix, -size, distance, -size).uv(0, 0).endVertex();
            buffer.vertex(matrix, size, distance, -size).uv(1, 0).endVertex();
            buffer.vertex(matrix, size, distance, size).uv(1, 1).endVertex();
            buffer.vertex(matrix, -size, distance, size).uv(0, 1).endVertex();

            BufferUploader.drawWithShader(buffer.end());
            poseStack.popPose();
        }
    }
}