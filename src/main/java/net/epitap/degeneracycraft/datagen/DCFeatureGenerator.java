package net.epitap.degeneracycraft.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.biome.DCBiomeModifierBuilder;
import net.epitap.degeneracycraft.world.feature.configured.DCConfiguredFeatureBuilder;
import net.epitap.degeneracycraft.world.feature.placed.DCPlacedFeatureBuilder;
import net.epitap.degeneracycraft.world.feature.vein.dense.DenseVein;
import net.epitap.degeneracycraft.world.feature.vein.dense.DenseVeinBuilder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DCFeatureGenerator implements DataProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final PackOutput output;
    private final List<CompletableFuture<?>> futures = new ArrayList<>();

    public DCFeatureGenerator(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        registerVeins(cache);
        registerBiomes(cache);

        return CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );
    }

    private void registerVeins(CachedOutput cache) {
        JsonObject vein = DCConfiguredFeatureBuilder
                .create("degeneracycraft:veins")
                .build();
        configured(cache, "veins_type", vein);

        JsonObject overworldVein = DCPlacedFeatureBuilder
                .create("degeneracycraft:veins_type")
                .heightRange("minecraft:trapezoid", -64, 320)
                .biome()
                .rarity(10)
                .build();
        placed(cache, "veins", overworldVein);

        DenseVein gold_Vein = DenseVeinBuilder.create()
                .yRange(32, 64)
                .size(50)
                .weight(0.05F)
                .dimension(Level.OVERWORLD)
                .biome(BiomeTags.IS_OVERWORLD)
                .matcher(Blocks.STONE)
                .matcher(Blocks.DEEPSLATE)
                .matcher(Blocks.SANDSTONE)
                .matcher(Blocks.RED_SANDSTONE)
                .matcher(Blocks.ANDESITE)
                .matcher(Blocks.DIORITE)
                .matcher(Blocks.GRANITE)
                .matcher(Blocks.GRAVEL)
                .defaultOre(Blocks.GOLD_ORE, 0.85f)
                .defaultOre(Blocks.STONE, 0.15f)
                .deepslateOre(Blocks.DEEPSLATE_GOLD_ORE, 0.85f)
                .deepslateOre(Blocks.DEEPSLATE,0.15f)
                .outcrop(Blocks.GOLD_ORE, 1.0f)
                .build();
        vein(cache, "gold_vein", gold_Vein);

        DenseVein nether_Gold_Vein = DenseVeinBuilder.create()
                .yRange(0, 64)
                .size(50)
                .weight(4)
                .dimension(Level.NETHER)
                .biome(BiomeTags.IS_NETHER)
                .matcher(Blocks.NETHERRACK)
                .defaultOre(Blocks.GOLD_ORE, 0.85f)
                .defaultOre(Blocks.NETHERRACK, 0.15f)
                .outcrop(Blocks.GOLD_ORE, 1.0f)
                .build();

        vein(cache, "nether_gold_vein", nether_Gold_Vein);
    }

    private void registerBiomes(CachedOutput cache) {
        JsonObject overworld_Biome_Vein = DCBiomeModifierBuilder.createAddFeatures()
                .biomes(BiomeTags.IS_OVERWORLD)
                .feature("degeneracycraft:veins")
                .step(GenerationStep.Decoration.UNDERGROUND_ORES)
                .build();

        biomeModifier(cache, "overworld_biome_vein", overworld_Biome_Vein);

        JsonObject nether_Biome_Vein = DCBiomeModifierBuilder.createAddFeatures()
                .biomes(BiomeTags.IS_NETHER)
                .feature("degeneracycraft:veins")
                .step(GenerationStep.Decoration.UNDERGROUND_ORES)
                .build();

        biomeModifier(cache, "nether_biome_vein", nether_Biome_Vein);
    }

    private void vein(CachedOutput cache, String name, DenseVein vein) {
        JsonElement json = vein.serialize();
        Path path = output.getOutputFolder()
                .resolve("data/degeneracycraft/veins/" + name + ".json");
        CompletableFuture<?> future = DataProvider.saveStable(cache, GSON.toJsonTree(json), path);
        futures.add(future);
    }

    private void configured(CachedOutput cache, String name, JsonObject json) {
        Path path = output.getOutputFolder().resolve("data/" + Degeneracycraft.MOD_ID + "/worldgen/configured_feature/" + name + ".json");
        futures.add(DataProvider.saveStable(cache, json, path));
    }

    private void placed(CachedOutput cache, String name, JsonObject json) {
        Path path = output.getOutputFolder()
                .resolve("data/" + Degeneracycraft.MOD_ID + "/worldgen/placed_feature/" + name + ".json");
        CompletableFuture<?> future = DataProvider.saveStable(cache, GSON.toJsonTree(json), path);
        futures.add(future);
    }

    private void biomeModifier(CachedOutput cache, String name, JsonObject json) {
        Path path = output.getOutputFolder()
                .resolve("data/" + Degeneracycraft.MOD_ID + "/forge/biome_modifier/" + name + ".json");

        CompletableFuture<?> future =
                DataProvider.saveStable(cache, GSON.toJsonTree(json), path);

        futures.add(future);
    }

    @Override
    public String getName() {
        return "DegeneracyCraft Feature Generator";
    }
}
