package net.epitap.degeneracycraft.world.feature.configured;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ConfiguredFeatureBuilder {
    private final String type;

    private final JsonObject config = new JsonObject();

    private ConfiguredFeatureBuilder(String type) {
        this.type = type;
    }

    public static ConfiguredFeatureBuilder create(String type) {
        return new ConfiguredFeatureBuilder(type);
    }

    public ConfiguredFeatureBuilder property(String key, String value) {
        config.addProperty(key, value);
        return this;
    }

    public ConfiguredFeatureBuilder property(String key, Number value) {
        config.addProperty(key, value);
        return this;
    }

    public ConfiguredFeatureBuilder property(String key, Boolean value) {
        config.addProperty(key, value);
        return this;
    }

    public ConfiguredFeatureBuilder json(String key, JsonElement element) {
        config.add(key, element);
        return this;
    }

    public ConfiguredFeatureBuilder array(String key, String... values) {

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