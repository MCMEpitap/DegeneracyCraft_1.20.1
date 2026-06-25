package net.epitap.degeneracycraft.world.feature.dimention;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.dimention.moon.MoonNoises;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class DCNoises {

    public static final ResourceKey<NormalNoise.NoiseParameters> MOON_CONTINENT = ResourceKey.create(Registries.NOISE,
            new ResourceLocation(Degeneracycraft.MOD_ID, "moon_continent"));

    public static final ResourceKey<NormalNoise.NoiseParameters> MOON_CRATER = ResourceKey.create(Registries.NOISE,
            new ResourceLocation(Degeneracycraft.MOD_ID, "moon_crater"));

    public static final ResourceKey<NormalNoise.NoiseParameters> MOON_DETAIL = ResourceKey.create(Registries.NOISE,
            new ResourceLocation(Degeneracycraft.MOD_ID, "moon_detail"));

    public static final ResourceKey<NormalNoise.NoiseParameters> MOON_CAVE = ResourceKey.create(Registries.NOISE,
            new ResourceLocation(Degeneracycraft.MOD_ID, "moon_cave"));

    public static final ResourceKey<NormalNoise.NoiseParameters> MOON_CAVERN = ResourceKey.create(Registries.NOISE,
            new ResourceLocation(Degeneracycraft.MOD_ID, "moon_cavern"));

    public static final ResourceKey<NormalNoise.NoiseParameters> MOON_ENTRANCE = ResourceKey.create(Registries.NOISE,
            new ResourceLocation(Degeneracycraft.MOD_ID, "moon_entrance"));



    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> context) {
        MoonNoises.bootstrap(context);
    }
}