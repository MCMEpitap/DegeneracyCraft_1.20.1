package net.epitap.degeneracycraft.integration.emi;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class DCMultiblockPreviewRenderer {
    private final Minecraft minecraft;
    private final BlockRenderDispatcher blockRenderer;
    private final DCMultiblockCamera camera;

    public DCMultiblockPreviewRenderer() {
        this.minecraft = Minecraft.getInstance();
        this.blockRenderer = minecraft.getBlockRenderer();
        this.camera = new DCMultiblockCamera();
    }

    public void render(
            GuiGraphics graphics,
            DCMultiblockDisplayData data,
            int x,
            int y,
            int width,
            int height,
            int selectedLayer
    ) {
        PoseStack poseStack = graphics.pose();
        Map<BlockPos, BlockState> allBlocks = data.getBlocks();
        graphics.fill(0, 220, 160, 240, 0xFF000000);
        if (allBlocks.isEmpty()) {
            return;
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minZ = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxZ = Integer.MIN_VALUE;

        for (BlockPos pos : allBlocks.keySet()) {
            minX = Math.min(minX, pos.getX());
            minY = Math.min(minY, pos.getY());
            minZ = Math.min(minZ, pos.getZ());
            maxX = Math.max(maxX, pos.getX());
            maxY = Math.max(maxY, pos.getY());
            maxZ = Math.max(maxZ, pos.getZ());
        }

        float centerX = (minX + maxX + 1) / 2.0F;
        float centerY = (minY + maxY + 1) / 2.0F;
        float centerZ = (minZ + maxZ + 1) / 2.0F;

        float scale = 12.0F * camera.getZoom();

        poseStack.pushPose();

        // 指定されたプレビュー領域の中央を回転中心にする
        poseStack.translate(
                x + width / 2.0F,
                y + height / 2.0F,
                100.0F
        );

        poseStack.scale(scale, -scale, scale);
        poseStack.mulPose(
                Axis.XP.rotationDegrees(camera.getPitch())
        );
        poseStack.mulPose(
                Axis.YP.rotationDegrees(camera.getYaw())
        );
        poseStack.translate(-centerX, -centerY, -centerZ);

        Map<BlockPos, BlockState> blocksToRender;

        if (selectedLayer < 0) {
            blocksToRender = allBlocks;
        } else {
            final int targetY = minY + selectedLayer;
            blocksToRender = new HashMap<>();

            for (Map.Entry<BlockPos, BlockState> entry
                    : allBlocks.entrySet()) {
                BlockPos pos = entry.getKey();

                if (pos.getY() == targetY) {
                    blocksToRender.put(pos, entry.getValue());
                }
            }
        }

        for (Map.Entry<BlockPos, BlockState> entry
                : blocksToRender.entrySet()) {
            BlockPos pos = entry.getKey();

            renderSingleBlock(
                    graphics,
                    entry.getValue(),
                    pos.getX(),
                    pos.getY(),
                    pos.getZ()
            );
        }
        poseStack.popPose();
    }

    public void mousePressed(double mouseX, double mouseY) {
        camera.beginDrag(mouseX, mouseY);
    }

    public void mouseDragged(double mouseX, double mouseY) {
        camera.drag(mouseX, mouseY);
    }

    public void mouseReleased() {
        camera.endDrag();
    }

    public void mouseScrolled(double amount) {
        camera.scroll(amount);
    }

    public float getYaw() {
        return camera.getYaw();
    }

    public float getPitch() {
        return camera.getPitch();
    }

    public float getZoom() {
        return camera.getZoom();
    }

    public void resetCamera() {
        camera.reset();
    }

    public DCMultiblockCamera getCamera() {
        return camera;
    }
    private void renderSingleBlock(
            GuiGraphics graphics,
            BlockState state,
            int x,
            int y,
            int z
    ) {
        PoseStack poseStack = graphics.pose();

        MultiBufferSource.BufferSource buffer = graphics.bufferSource();

        poseStack.pushPose();
        poseStack.translate(x, y, z);

        blockRenderer.renderSingleBlock(
                state,
                poseStack,
                buffer,
                0xF000F0,
                OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();
    }
}