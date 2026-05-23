package net.epitap.degeneracycraft.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.configured.ConfiguredFeatureBuilder;
import net.epitap.degeneracycraft.world.feature.placed.PlacedFeatureBuilder;
import net.epitap.degeneracycraft.world.feature.vein.dense.DenseVein;
import net.epitap.degeneracycraft.world.feature.vein.dense.DenseVeinBuilder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DCVeinGenerator implements DataProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final PackOutput output;
    private final List<CompletableFuture<?>> futures = new ArrayList<>();

    public DCVeinGenerator(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        registerVeins(cache);

        return CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );
    }

    private void registerVeins(CachedOutput cache) {
        JsonObject vein = ConfiguredFeatureBuilder
                .create("degeneracycraft:veins")
                .build();
        configured(cache, "veins_type", vein);

        JsonObject overworldVein = PlacedFeatureBuilder
                .create("degeneracycraft:veins_type")
                .heightRange("minecraft:trapezoid", -64, 320)
                .biome()
                .build();
        placed(cache, "veins", overworldVein);

        DenseVein goldVein = DenseVeinBuilder.create()
                .yRange(32, 64)
                .size(50)
                .weight(4)
                .dimension(Level.OVERWORLD)
                .biome(BiomeTags.IS_OVERWORLD)
                .matcher(Blocks.STONE)
                .matcher(Blocks.DEEPSLATE)
                .defaultOre(Blocks.GOLD_ORE, 0.85f)
                .defaultOre(Blocks.STONE, 0.15f)
                .deepslateOre(Blocks.DEEPSLATE_GOLD_ORE, 0.85f)
                .deepslateOre(Blocks.DEEPSLATE,0.15f)
                .outcrop(Blocks.GOLD_ORE, 1.0f)
                .build();
        vein(cache, "gold_vein", goldVein);
    }

    private void vein(CachedOutput cache, String name, DenseVein vein) {
        try {

            JsonElement json = vein.serialize();

            Path path = output.getOutputFolder()
                    .resolve("data/degeneracycraft/veins/" + name + ".json");

            CompletableFuture<?> future =
                    DataProvider.saveStable(cache, GSON.toJsonTree(json), path);

            futures.add(future);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void configured(CachedOutput cache, String name, JsonObject json) {
        Path path = output.getOutputFolder()
                .resolve("data/" + Degeneracycraft.MOD_ID + "/worldgen/configured_feature/" + name + ".json");
        futures.add(DataProvider.saveStable(cache, json, path));
    }

    private void placed(CachedOutput cache, String name, JsonObject json) {
        Path path = output.getOutputFolder()
                .resolve("data/" + Degeneracycraft.MOD_ID + "/worldgen/placed_feature/" + name + ".json");
        CompletableFuture<?> future =
                DataProvider.saveStable(cache, GSON.toJsonTree(json), path);
        futures.add(future);
    }



    @Override
    public String getName() {
        return "DegeneracyCraft Vein Generator";
    }
}
