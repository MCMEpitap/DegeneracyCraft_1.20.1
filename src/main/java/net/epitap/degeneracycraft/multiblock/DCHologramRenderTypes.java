package net.epitap.degeneracycraft.multiblock;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import org.lwjgl.opengl.GL11;

public final class DCHologramRenderTypes {
    private DCHologramRenderTypes() {}

    private static final RenderStateShard.TransparencyStateShard HOLOGRAM_TRANSPARENCY =
            new RenderStateShard.TransparencyStateShard(
                    "dc_hologram_transparency",
                    () -> {
                        RenderSystem.enableBlend();
                        RenderSystem.blendFunc(
                                GlStateManager.SourceFactor.SRC_ALPHA,
                                GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA
                        );
                    },
                    RenderSystem::disableBlend
            );

    private static final RenderStateShard.DepthTestStateShard HOLOGRAM_DEPTH_TEST =
            new RenderStateShard.DepthTestStateShard(
                    "dc_hologram_depth_test",
                    GL11.GL_LEQUAL
            );

    private static final RenderStateShard.CullStateShard HOLOGRAM_NO_CULL =
            new RenderStateShard.CullStateShard(false);

    private static final RenderStateShard.TextureStateShard HOLOGRAM_TEXTURE =
            new RenderStateShard.TextureStateShard(
                    TextureAtlas.LOCATION_BLOCKS,
                    false,
                    false
            );

    public static final RenderType HOLOGRAM = RenderType.create(
            "dc_hologram",
            DefaultVertexFormat.BLOCK,
            VertexFormat.Mode.QUADS,
            2097152,
            true,
            true,
            RenderType.CompositeState.builder()
                    .setShaderState(
                            new RenderStateShard.ShaderStateShard(
                                    GameRenderer::getRendertypeTranslucentShader
                            )
                    )
                    .setTextureState(HOLOGRAM_TEXTURE)
                    .setTransparencyState(HOLOGRAM_TRANSPARENCY)
                    .setDepthTestState(HOLOGRAM_DEPTH_TEST)
                    .setCullState(HOLOGRAM_NO_CULL)
                    .setLightmapState(
                            new RenderStateShard.LightmapStateShard(true)
                    )
                    .setOverlayState(
                            new RenderStateShard.OverlayStateShard(true)
                    )
                    .setWriteMaskState(
                            new RenderStateShard.WriteMaskStateShard(
                                    true,
                                    false
                            )
                    )
                    .createCompositeState(false)
    );
}