//package net.epitap.degeneracycraft.datagen;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import net.epitap.degeneracycraft.Degeneracycraft;
//import net.epitap.degeneracycraft.world.feature.configured.ConfiguredFeatureBuilder;
//import net.minecraft.data.CachedOutput;
//import net.minecraft.data.DataProvider;
//import net.minecraft.data.PackOutput;
//
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//
//
//public class DCConfiguredFeatureGenerator implements DataProvider {
//
//    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
//
//    private final PackOutput output;
//    private final List<CompletableFuture<?>> futures = new ArrayList<>();
//
//    public DCConfiguredFeatureGenerator(PackOutput output) {
//        this.output = output;
//    }
//
//    @Override
//    public CompletableFuture<?> run(CachedOutput cache) {
//        register(cache);
//
//        return CompletableFuture.allOf(
//                futures.toArray(new CompletableFuture[0])
//        );
//    }
//
//    private void register(CachedOutput cache) {
//
//        JsonObject vein = ConfiguredFeatureBuilder
//                .create("veins", "degeneracycraft:veins")
//                .build();
//
//        save(cache, "veins", vein);
//    }
//
//    private void save(CachedOutput cache, String name, JsonObject json) {
//
//        Path path = output.getOutputFolder()
//                .resolve("data/" + Degeneracycraft.MOD_ID + "/worldgen/configured_feature/" + name + ".json");
//
//        futures.add(DataProvider.saveStable(cache, json, path));
//    }
//
//    @Override
//    public String getName() {
//        return "DegeneracyCraft Configured Features";
//    }
//}
