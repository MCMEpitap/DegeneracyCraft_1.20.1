package net.epitap.degeneracycraft.multiblock;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockEntityBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public abstract class DCMultiblockHologramRenderer<T extends DCMachineBlockEntityBase>
        implements BlockEntityRenderer<T> {

    private static final float HOLOGRAM_ALPHA = 1.0F;
    private static final float HOLOGRAM_SCALE = 0.8F;

    protected DCMultiblockHologramRenderer(
            BlockEntityRendererProvider.Context context
    ) {}

    @Override
    public boolean shouldRender(T blockEntity, Vec3 cameraPos) {
        return true;
    }

    @Nullable
    protected abstract ResourceLocation getHologramMultiblockId(
            T blockEntity,
            int hologramLevel
    );

    @Nullable
    protected DCMultiblockFile getHologramMultiblock(
            T blockEntity,
            int hologramLevel
    ) {
        ResourceLocation multiblockId =
                getHologramMultiblockId(blockEntity, hologramLevel);

        if (multiblockId == null) {
            return null;
        }

        return DCMultiblockRegistry.get(multiblockId);
    }

    @Override
    public void render(
            T blockEntity,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            int packedOverlay
    ) {
        int hologramLevel = blockEntity.getHologramLevel();

        if (hologramLevel < 0) {
            return;
        }

        DCMultiblockFile file =
                getHologramMultiblock(
                        blockEntity,
                        hologramLevel
                );

        if (file == null || file.getControllerOffset() == null) {
            return;
        }

        BlockRenderDispatcher blockRenderer =
                Minecraft.getInstance().getBlockRenderer();

        VertexConsumer baseConsumer =
                buffer.getBuffer(DCHologramRenderTypes.HOLOGRAM);

        VertexConsumer hologramConsumer =
                new DCAlphaVertexConsumer(
                        baseConsumer,
                        HOLOGRAM_ALPHA
                );

        Direction facing =
                blockEntity.getMachineFacing();

        poseStack.pushPose();

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {

                    DCMultiblockFile.DCPlaceholder placeholder =
                            file.getPlaceholder(x, y, z);

                    if (placeholder == null) {
                        continue;
                    }

                    DCMultiblockFile.DCPredicate predicate =
                            getRenderPredicate(placeholder);

                    if (predicate == null) {
                        continue;
                    }

                    ResourceLocation blockId =
                            predicate.getBlockId();

                    if (blockId == null) {
                        continue;
                    }

                    Block block =
                            BuiltInRegistries.BLOCK.get(blockId);

                    if (block == Blocks.AIR) {
                        continue;
                    }

                    BlockState state =
                            block.defaultBlockState();

                    BakedModel model =
                            blockRenderer.getBlockModel(state);

                    if (model == null) {
                        continue;
                    }

                    BlockPos relativePos =
                            file.toRelativePos(x, y, z);

                    BlockPos rotatedPos =
                            rotateRelativePos(
                                    relativePos,
                                    facing
                            );

                    poseStack.pushPose();

                    poseStack.translate(
                            rotatedPos.getX(),
                            rotatedPos.getY(),
                            rotatedPos.getZ()
                    );

                    poseStack.translate(
                            0.5F,
                            0.5F,
                            0.5F
                    );

                    poseStack.scale(
                            HOLOGRAM_SCALE,
                            HOLOGRAM_SCALE,
                            HOLOGRAM_SCALE
                    );

                    poseStack.translate(
                            -0.5F,
                            -0.5F,
                            -0.5F
                    );

                    DCHologramModelRenderer.render(
                            poseStack.last(),
                            hologramConsumer,
                            state,
                            model,
                            LightTexture.FULL_BRIGHT,
                            OverlayTexture.NO_OVERLAY
                    );

                    poseStack.popPose();
                }
            }
        }

        poseStack.popPose();
    }

    @Nullable
    private DCMultiblockFile.DCPredicate getRenderPredicate(
            DCMultiblockFile.DCPlaceholder placeholder
    ) {
        if (placeholder.getPredicates() == null) {
            return null;
        }

        for (DCMultiblockFile.DCPredicate predicate :
                placeholder.getPredicates()) {

            if (predicate != null && predicate.isBlock()) {
                return predicate;
            }
        }

        return null;
    }

    private BlockPos rotateRelativePos(
            BlockPos relative,
            Direction facing
    ) {
        return switch (facing) {
            case EAST -> new BlockPos(
                    -relative.getZ(),
                    relative.getY(),
                    relative.getX()
            );

            case SOUTH -> new BlockPos(
                    -relative.getX(),
                    relative.getY(),
                    -relative.getZ()
            );

            case WEST -> new BlockPos(
                    relative.getZ(),
                    relative.getY(),
                    -relative.getX()
            );

            default -> new BlockPos(
                    relative.getX(),
                    relative.getY(),
                    relative.getZ()
            );
        };
    }
}