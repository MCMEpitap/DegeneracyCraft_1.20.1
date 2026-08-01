package net.epitap.degeneracycraft.client.world.feature.dimension;

import com.mojang.blaze3d.vertex.PoseStack;
import net.epitap.degeneracycraft.client.world.feature.dimension.moon.MoonSkyRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

public class DCSkyRenderers {

    public static void renderSky(PoseStack poseStack, float partialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;

        if(level == null) return;

        if(level.dimension() == DCDimensions.MOON_LEVEL) {
            MoonSkyRenderer.render(poseStack, partialTick);
        }

    }
}
