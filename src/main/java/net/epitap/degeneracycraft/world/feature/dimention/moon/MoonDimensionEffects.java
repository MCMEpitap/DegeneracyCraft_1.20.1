package net.epitap.degeneracycraft.world.feature.dimention.moon;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;

public class MoonDimensionEffects extends DimensionSpecialEffects {
    public MoonDimensionEffects() {
        super(
                192.0F,
                true,
                SkyType.NONE,
                false,
                false
        );
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
        return color;
    }

    @Override
    public boolean isFoggyAt(int x, int z) {
        return false;
    }

    @Override
    public float getCloudHeight() {
        return Float.NaN;
    }

}