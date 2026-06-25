package net.epitap.degeneracycraft.world.feature.dimention.moon;

import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.world.feature.biome.DCSurfaceRules;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class MoonNoiseSettings {
    public static NoiseGeneratorSettings create(HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noises) {
        return new NoiseGeneratorSettings(
                NoiseSettings.create(
                        0,   // minY
                        384,   // height
                        1,     // sizeHorizontal
                        2      // sizeVertical
                )                        ,     // Noise
                DCBlocks.MOON_STONE.get().defaultBlockState(),     // default_block
                Blocks.AIR.defaultBlockState(),    // default_fluid
                MoonNoiseRouters.create(densityFunctions, noises),     // noise_router
                DCSurfaceRules.moon(),     // surface_rule
                List.of(),     // spawn_target
                0,                           // sea_level
                false,                       // disable_mob_generation
                false,                       // aquifers_enabled
                false,                       // ore_veins_enabled
                false                        // legacy_random_source
        );
    }
}