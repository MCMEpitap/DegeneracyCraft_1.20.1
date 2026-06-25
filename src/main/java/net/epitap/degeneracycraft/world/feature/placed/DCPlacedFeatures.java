package net.epitap.degeneracycraft.world.feature.placed;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.configured.DCConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class DCPlacedFeatures {

    public static final ResourceKey<PlacedFeature> VEINS_KEY = registerKey("veins");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);

        register(
                context,
                VEINS_KEY,
                configuredFeatures.getOrThrow(DCConfiguredFeatures.VEINS_TYPE),
                List.of(
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        ),
                        BiomeFilter.biome(),
                        RarityFilter.onAverageOnceEvery(10)
                )
        );
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Degeneracycraft.MOD_ID, name));
    }

    private static void register(
            BootstapContext<PlacedFeature> context,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> configuredFeature,
            List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuredFeature, modifiers));
    }
}
