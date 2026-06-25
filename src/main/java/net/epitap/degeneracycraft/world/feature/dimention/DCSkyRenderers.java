package net.epitap.degeneracycraft.world.feature.dimention;

import com.mojang.blaze3d.vertex.PoseStack;
import net.epitap.degeneracycraft.world.feature.dimention.moon.MoonSkyRenderer;
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
