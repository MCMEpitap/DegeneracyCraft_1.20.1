package net.epitap.degeneracycraft.world.feature.vein.dense;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinCapability;
import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinGeneratedCapability;
import net.epitap.degeneracycraft.world.feature.vein.veinbase.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DenseVein extends AbstractVein {
    public static final String JSON_TYPE = "degeneracycraft:vein_dense";

    private String name;
    private final int yMin;
    private final int yMax;
    private final int size;

    public DenseVein(
            HashMap<String, HashMap<BlockState, Float>> matcherToOreWeightPair,
            HashMap<BlockState, Float> outcropWeightPair,
            int yMin,
            int yMax,
            int size,
            int generationWeight,
            TagKey<Biome> biomeKey,
            HashSet<BlockState> matchers,
            Set<ResourceLocation> dimensions
    ) {
        super(matcherToOreWeightPair, outcropWeightPair, biomeKey, matchers, generationWeight, dimensions);

        this.yMin = yMin;
        this.yMax = yMax;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public int generate(WorldGenLevel level, BlockPos pos, IVeinCapability veins, IVeinGeneratedCapability chunksGenerated) {
        if (!this.canPlaceInBiome(level.getBiome(pos))) {
            return 0;
        }

        int totlPlaced = 0;
        int randY = this.yMin + level.getRandom().nextInt(this.yMax - this.yMin);
        int max = VeinBlockUtils.getTopSolidBlock(level, pos).getY();
        if (randY > max) {
            randY = Math.max(yMin, max);
        }

        float ranFlt = level.getRandom().nextFloat() * (float) Math.PI;
        double x1 = (float) (pos.getX() + 8) + Mth.sin(ranFlt) * (float) this.size / 8.0F;
        double x2 = (float) (pos.getX() + 8) - Mth.sin(ranFlt) * (float) this.size / 8.0F;
        double z1 = (float) (pos.getZ() + 8) + Mth.cos(ranFlt) * (float) this.size / 8.0F;
        double z2 = (float) (pos.getZ() + 8) - Mth.cos(ranFlt) * (float) this.size / 8.0F;
        double y1 = randY + level.getRandom().nextInt(3) - 2;
        double y2 = randY + level.getRandom().nextInt(3) - 2;

        for (int i = 0; i < this.size; ++i) {
            float radScl = (float) i / (float) this.size;
            double xn = x1 + (x2 - x1) * (double) radScl;
            double yn = y1 + (y2 - y1) * (double) radScl;
            double zn = z1 + (z2 - z1) * (double) radScl;
            double noise = level.getRandom().nextDouble() * (double) this.size / 16.0D;
            double radius = (double) (Mth.sin((float) Math.PI * radScl) + 1.0F) * noise + 1.0D;
            int xmin = Mth.floor(xn - radius / 2.0D);
            int ymin = Mth.floor(yn - radius / 2.0D);
            int zmin = Mth.floor(zn - radius / 2.0D);
            int xmax = Mth.floor(xn + radius / 2.0D);
            int ymax = Mth.floor(yn + radius / 2.0D);
            int zmax = Mth.floor(zn + radius / 2.0D);

            for (int x = xmin; x <= xmax; ++x) {
                double layerRadX = ((double) x + 0.5D - xn) / (radius / 2.0D);

                if (layerRadX * layerRadX < 1.0D) {
                    for (int y = ymin; y <= ymax; ++y) {
                        double layerRadY = ((double) y + 0.5D - yn) / (radius / 2.0D);

                        if (layerRadX * layerRadX + layerRadY * layerRadY < 1.0D) {
                            for (int z = zmin; z <= zmax; ++z) {
                                double layerRadZ = ((double) z + 0.5D - zn) / (radius / 2.0D);

                                if (layerRadX * layerRadX + layerRadY * layerRadY + layerRadZ * layerRadZ < 1.0D) {
                                    BlockPos placePos = new BlockPos(x, y, z);
                                    BlockState current = level.getBlockState(placePos);
                                    BlockState tmp = this.getOre(current, level.getRandom());
                                    if (tmp == null) {
                                        continue;
                                    }

                                    if (!(this.getMatchers().contains(current) || this.matcherToOreWeightPair.containsKey(VeinBlockUtils.getRegistryName(current)))) {
                                        continue;
                                    }

                                    if (VeinFeatureUtils.enqueueBlockPlacement(level, new ChunkPos(pos), placePos, tmp, veins, chunksGenerated)) {
                                        totlPlaced++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return totlPlaced;
    }

    @Override
    public void afterGen(WorldGenLevel level, BlockPos pos, IVeinCapability veins, IVeinGeneratedCapability chunksGenerated) {
        ChunkPos thisChunk = new ChunkPos(pos);
        int maxOutcropCnt = Math.min(10, (this.size / 10) + (this.size % 10));
        for (int i = 0; i < maxOutcropCnt; i++) {
            BlockState tmp = this.getOutcrop(level.getRandom());
            if (tmp == null) {
                continue;
            }

            BlockPos outcropPos = VeinOutcropUtils.getOutcropPosition(level, new ChunkPos(pos));
            if (outcropPos == null || VeinOutcropUtils.inNonWaterFluid(level, outcropPos)) {
                continue;
            }

            if (VeinOutcropUtils.isInWater(level, outcropPos) && tmp.hasProperty(BlockStateProperties.WATERLOGGED)) {
                tmp = tmp.setValue(BlockStateProperties.WATERLOGGED, Boolean.TRUE);
            }

            VeinFeatureUtils.enqueueBlockPlacement(level, thisChunk, outcropPos, tmp, veins, chunksGenerated);
            VeinFeatureUtils.fixSnowyBlock(level, outcropPos);
        }
    }

    public static DenseVein deserialize(JsonObject json) {
        if (json == null) {
            return null;
        }

        try {
            HashMap<String, HashMap<BlockState, Float>> oreBlocks = VeinSerializerUtils.buildMultiBlockMatcherMap(json.get("blocks").getAsJsonObject());
            HashMap<BlockState, Float> outcropBlocks = VeinSerializerUtils.buildMultiBlockMap(json, "outcrops");
            int yMin = json.get("yMin").getAsInt();
            int yMax = json.get("yMax").getAsInt();
            int size = json.get("size").getAsInt();
            int genWt = json.get("generationWeight").getAsInt();
            TagKey<Biome> biomeTag = TagKey.create(Registries.BIOME, new ResourceLocation(json.get("biomeTag").getAsString().replace("#", "")));

            HashSet<BlockState> blockStateMatchers = VeinUtils.getDefaultMatchers();
            if (json.has("blockStateMatchers")) {
                blockStateMatchers = VeinSerializerUtils.toBlockStateList(json.get("blockStateMatchers").getAsJsonArray());
            }

            Set<ResourceLocation> dimensions = new HashSet<>();
            if (json.has("dimensions")) {
                JsonArray dimArray = json.getAsJsonArray("dimensions");

                for (JsonElement element : dimArray) {
                    dimensions.add(new ResourceLocation(element.getAsString()));
                }
            }
            return new DenseVein(oreBlocks, outcropBlocks, yMin, yMax, size, genWt, biomeTag, blockStateMatchers, dimensions);
        } catch (Exception e) {
            return null;
        }
    }

    public JsonElement serialize() {
        JsonObject json = new JsonObject();
        JsonObject config = new JsonObject();

        config.add("blocks", VeinSerializerUtils.deconstructMultiBlockMatcherMap(this.matcherToOreWeightPair));
        config.add("outcrops", VeinSerializerUtils.deconstructMultiBlockMap(this.outcropWeightPair));
        config.add("blockStateMatchers",
                VeinSerializerUtils.deconstructBlockStateList(this.getMatchers()));
        config.addProperty("yMin", this.yMin);
        config.addProperty("yMax", this.yMax);
        config.addProperty("size", this.size);
        config.addProperty("generationWeight", this.generationWeight);
        config.addProperty("biomeTag", "#" + this.biomeKey.location());
        json.addProperty("type", JSON_TYPE);
        json.add("config", config);
        JsonArray dimArray = new JsonArray();

        for (ResourceLocation dim : this.dimensions) {
            dimArray.add(dim.toString());
        }

        config.add("dimensions", dimArray);
        return json;
    }
}
