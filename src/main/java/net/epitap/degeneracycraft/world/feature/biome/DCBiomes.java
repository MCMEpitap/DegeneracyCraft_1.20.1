package net.epitap.degeneracycraft.world.feature.biome;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;

public class DCBiomes {
    public static final ResourceKey<Biome> MOON_BIOME = register("moon_biome");

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(MOON_BIOME, moon(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome moon(BootstapContext<Biome> context)
    {
        MobSpawnSettings.Builder spawns =
                new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder generation =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER)
                );

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(-0.5F)
                .downfall(0.0F)
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(0x3F76E4)
                                .waterFogColor(0x050533)
                                .fogColor(0x000000)
                                .skyColor(0x000000)
                                .ambientMoodSound(
                                        AmbientMoodSettings.LEGACY_CAVE_SETTINGS
                                )
                                .build()
                )
                .build();
    }


    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Degeneracycraft.MOD_ID, name));
    }
}