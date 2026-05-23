//package net.epitap.degeneracycraft.datagen;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import net.epitap.degeneracycraft.Degeneracycraft;
//import net.epitap.degeneracycraft.world.feature.placed.PlacedFeatureBuilder;
//import net.minecraft.data.CachedOutput;
//import net.minecraft.data.DataProvider;
//import net.minecraft.data.PackOutput;
//
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//public class DCPlacedFeatureGenerator implements DataProvider {
//
//    private static final Gson GSON = new GsonBuilder()
//            .setPrettyPrinting()
//            .create();
//
//    private final PackOutput output;
//    private final List<CompletableFuture<?>> futures = new ArrayList<>();
//
//    public DCPlacedFeatureGenerator(PackOutput output) {
//        this.output = output;
//    }
//
//    @Override
//    public CompletableFuture<?> run(CachedOutput cache) {
//        registerPlacedFeatures(cache);
//
//        return CompletableFuture.allOf(
//                futures.toArray(new CompletableFuture[0])
//        );
//    }
//
//    private void registerPlacedFeatures(CachedOutput cache) {
//
//        JsonObject goldVein = PlacedFeatureBuilder.create(
//                        "gold_vein",
//                        "degeneracycraft:gold_vein"
//                )
//                .inSquare()
//                .biome()
//                .build();
//
//        placedFeature(cache, "gold_vein", goldVein);
//    }
//
//    private void placedFeature(CachedOutput cache, String name, JsonObject json) {
//
//        try {
//            Path path = output.getOutputFolder()
//                    .resolve("data/" + Degeneracycraft.MOD_ID + "/worldgen/placed_feature/" + name + ".json");
//
//            CompletableFuture<?> future =
//                    DataProvider.saveStable(cache, GSON.toJsonTree(json), path);
//
//            futures.add(future);
//
//        } catch (Exception exception) {
//            Degeneracycraft.LOGGER.error(
//                    "Failed to generate placed feature: {}",
//                    name,
//                    exception
//            );
//        }
//    }
//
//    @Override
//    public String getName() {
//        return "DegeneracyCraft Placed Feature Generator";
//    }
//}