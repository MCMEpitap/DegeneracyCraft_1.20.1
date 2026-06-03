package net.epitap.degeneracycraft.world.feature.placed;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DCPlacedFeatureBuilder {
    private final String feature;

    private final JsonArray placement = new JsonArray();

    private DCPlacedFeatureBuilder(String feature) {
        this.feature = feature;
    }

    public static DCPlacedFeatureBuilder create(String feature) {
        return new DCPlacedFeatureBuilder(feature);
    }

    public DCPlacedFeatureBuilder biome() {

        JsonObject obj = new JsonObject();
        obj.addProperty("type", "minecraft:biome");

        placement.add(obj);

        return this;
    }

    public DCPlacedFeatureBuilder inSquare() {

        JsonObject obj = new JsonObject();
        obj.addProperty("type", "minecraft:in_square");

        placement.add(obj);

        return this;
    }

    public DCPlacedFeatureBuilder count(int count) {

        JsonObject obj = new JsonObject();

        obj.addProperty("type", "minecraft:count");
        obj.addProperty("count", count);

        placement.add(obj);

        return this;
    }

    public DCPlacedFeatureBuilder rarity(int chance) {

        JsonObject obj = new JsonObject();

        obj.addProperty("type", "minecraft:rarity_filter");
        obj.addProperty("chance", chance);

        placement.add(obj);

        return this;
    }


    public DCPlacedFeatureBuilder heightRange(String distribution, int min, int max) {

        JsonObject height = new JsonObject();

        height.addProperty("type", distribution);

        JsonObject minObj = new JsonObject();
        minObj.addProperty("absolute", min);

        JsonObject maxObj = new JsonObject();
        maxObj.addProperty("absolute", max);

        height.add("min_inclusive", minObj);
        height.add("max_inclusive", maxObj);

        JsonObject obj = new JsonObject();

        obj.addProperty("type", "minecraft:height_range");
        obj.add("height", height);

        placement.add(obj);

        return this;
    }

    public JsonObject build() {

        JsonObject root = new JsonObject();

        root.addProperty("feature", feature);
        root.add("placement", placement);

        return root;
    }
}
