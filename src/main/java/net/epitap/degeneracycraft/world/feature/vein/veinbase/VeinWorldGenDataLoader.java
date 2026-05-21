package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.vein.dense.DenseVein;
import net.epitap.degeneracycraft.world.feature.vein.dense.DenseVeinSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Map;

public class VeinWorldGenDataLoader extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private final DenseVeinSerializer DenseSerializer = new DenseVeinSerializer();
//    private final LayerDepositSerializer LayerSerializer = new LayerDepositSerializer();
//    private final TopLayerDepositSerializer TopLayerSerializer = new TopLayerDepositSerializer();
//    private final DikeDepositSerializer DikeSerializer = new DikeDepositSerializer();
//    private final SparseDepositSerializer SparseSerializer = new SparseDepositSerializer();

    public VeinWorldGenDataLoader() {
        super(GSON, "veins");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> datamap, @Nonnull ResourceManager manager, @NotNull ProfilerFiller profiler) {
        VeinBlockPath.veinBlockPath.clear();
        datamap.forEach((rl, json) -> {
            try {
                JsonObject jsonobject = json.getAsJsonObject();
                JsonObject config = jsonobject.get("config").getAsJsonObject();
                Degeneracycraft.LOGGER.info("Preparing to load vein datafile {}", rl.toString());

                switch (jsonobject.get("type").getAsString()) {
                    case "degeneracycraft:vein_dense" -> {
                        DenseVein denseDeposit = DenseSerializer.deserialize(config);
                        if (denseDeposit != null) {
                            Degeneracycraft.LOGGER.info(denseDeposit.toString());
                            VeinBlockPath.veinBlockPath.addVein(denseDeposit);
                        }
                    }
//                    case "geolosys:vein_layer" -> {
//                        LayerDeposit layerDeposit = LayerSerializer.deserialize(config);
//                        if (layerDeposit != null) {
//                            Geolosys.getInstance().LOGGER.info(layerDeposit.toString());
//                            GeolosysAPI.veinBlockRegistry.addDeposit(layerDeposit);
//                        }
//                    }
//                    case "geolosys:vein_top_layer" -> {
//                        TopLayerDeposit topLayerDeposit = TopLayerSerializer.deserialize(config);
//                        if (topLayerDeposit != null) {
//                            Geolosys.getInstance().LOGGER.info(topLayerDeposit.toString());
//                            GeolosysAPI.veinBlockRegistry.addDeposit(topLayerDeposit);
//                        }
//                    }
//                    case "geolosys:vein_dike" -> {
//                        DikeDeposit dikeDeposit = DikeSerializer.deserialize(config);
//                        if (dikeDeposit != null) {
//                            Geolosys.getInstance().LOGGER.info(dikeDeposit.toString());
//                            GeolosysAPI.veinBlockRegistry.addDeposit(dikeDeposit);
//                        }
//                    }
//                    case "geolosys:vein_sparse" -> {
//                        SparseDeposit sparseDeposit = SparseSerializer.deserialize(config);
//                        if (sparseDeposit != null) {
//                            Geolosys.getInstance().LOGGER.info(sparseDeposit.toString());
//                            GeolosysAPI.veinBlockRegistry.addDeposit(sparseDeposit);
//                        }
//                    }
                    default ->
                            Degeneracycraft.LOGGER.warn("Unknown JSON type. Received JSON {}", json.toString());
                }
            } catch (NullPointerException ex) {
                Degeneracycraft.LOGGER.info("Skipping registration of ore {}", rl);
            }
        });
    }
}
