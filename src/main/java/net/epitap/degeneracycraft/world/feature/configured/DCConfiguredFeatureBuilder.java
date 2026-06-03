package net.epitap.degeneracycraft.world.feature.configured;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DCConfiguredFeatureBuilder {
    private final String type;

    private final JsonObject config = new JsonObject();

    private DCConfiguredFeatureBuilder(String type) {
        this.type = type;
    }

    public static DCConfiguredFeatureBuilder create(String type) {
        return new DCConfiguredFeatureBuilder(type);
    }

    public DCConfiguredFeatureBuilder property(String key, String value) {
        config.addProperty(key, value);
        return this;
    }

    public DCConfiguredFeatureBuilder property(String key, Number value) {
        config.addProperty(key, value);
        return this;
    }

    public DCConfiguredFeatureBuilder property(String key, Boolean value) {
        config.addProperty(key, value);
        return this;
    }

    public DCConfiguredFeatureBuilder json(String key, JsonElement element) {
        config.add(key, element);
        return this;
    }

    public DCConfiguredFeatureBuilder array(String key, String... values) {

        JsonArray array = new JsonArray();

        for (String value : values) {
            array.add(value);
        }

        config.add(key, array);

        return this;
    }

    public JsonObject build() {

        JsonObject root = new JsonObject();

        root.addProperty("type", type);
        root.add("config", config);

        return root;
    }
}