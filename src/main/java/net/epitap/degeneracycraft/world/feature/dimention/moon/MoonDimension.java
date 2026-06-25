package net.epitap.degeneracycraft.world.feature.dimention.moon;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.biome.DCBiomes;
import net.epitap.degeneracycraft.world.feature.dimention.DCDimensions;
import net.epitap.degeneracycraft.world.feature.dimention.DCNoiseSettings;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.OptionalLong;

public class MoonDimension {

    public static void bootstrapType(
            BootstapContext<DimensionType> context
    ) {

        context.register(
                DCDimensions.MOON_TYPE,

                new DimensionType(
                        OptionalLong.empty(), // fixedTime
                        true,                 // hasSkylight
                        false,                // hasCeiling
                        false,                // ultraWarm
                        false,                // natural
                        1.0D,                 // coordinateScale
                        true,                // bedWorks
                        false,                // respawnAnchorWorks
                        0,                    // minY
                        384,                  // height
                        384,                  // logicalHeight
                        BlockTags.INFINIBURN_OVERWORLD,
                        new ResourceLocation(
                                Degeneracycraft.MOD_ID,
                                "moon"
                        ),
                        0.0F,

                        new DimensionType.MonsterSettings(
                                false,
                                false,
                                ConstantInt.of(0),
                                0
                        )
                )
        );
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator generator =
                new NoiseBasedChunkGenerator(
                        new FixedBiomeSource(
                                biomes.getOrThrow(
                                        DCBiomes.MOON_BIOME
                                )
                        ),
                        noiseSettings.getOrThrow(
                                DCNoiseSettings.MOON
                        )
                );

        context.register(DCDimensions.MOON_STEM,
                new LevelStem(
                        dimensionTypes.getOrThrow(
                                DCDimensions.MOON_TYPE
                        ),
                        generator
                )
        );
    }
}