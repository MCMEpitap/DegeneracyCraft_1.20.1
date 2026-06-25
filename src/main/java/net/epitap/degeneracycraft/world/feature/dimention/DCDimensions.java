package net.epitap.degeneracycraft.world.feature.dimention;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.dimention.moon.MoonDimension;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

public class DCDimensions {
    public static final ResourceKey<DimensionType> MOON_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(Degeneracycraft.MOD_ID, "moon"));
    public static final ResourceKey<LevelStem> MOON_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Degeneracycraft.MOD_ID, "moon"));
    public static final ResourceKey<Level> MOON_LEVEL = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(Degeneracycraft.MOD_ID, "moon"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        MoonDimension.bootstrapType(context);
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        MoonDimension.bootstrapStem(context);
    }
}
