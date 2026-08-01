package net.epitap.degeneracycraft.datagen;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.client.world.feature.biome.DCBiomes;
import net.epitap.degeneracycraft.client.world.feature.configured.DCConfiguredFeatures;
import net.epitap.degeneracycraft.client.world.feature.dimension.DCDimensions;
import net.epitap.degeneracycraft.client.world.feature.dimension.DCNoiseSettings;
import net.epitap.degeneracycraft.client.world.feature.dimension.DCNoises;
import net.epitap.degeneracycraft.client.world.feature.placed.DCPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DCWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, DCConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DCPlacedFeatures::bootstrap)
            .add(Registries.BIOME, DCBiomes::boostrap)
            .add(Registries.LEVEL_STEM, DCDimensions::bootstrapStem)
            .add(Registries.DIMENSION_TYPE, DCDimensions::bootstrapType)
            .add(Registries.NOISE_SETTINGS, DCNoiseSettings::bootstrap)
            .add(Registries.NOISE, DCNoises::bootstrap);
//            .add(Registries.CONFIGURED_CARVER, DCConfiguredWorldCarvers::bootstrap);

//            .add(Registries.DENSITY_FUNCTION, DCDensityFunctions::bootstrap);
//    .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);
//            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public DCWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Degeneracycraft.MOD_ID));
    }
}
