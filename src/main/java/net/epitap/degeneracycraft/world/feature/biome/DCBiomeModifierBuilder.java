package net.epitap.degeneracycraft.world.feature.biome;

import com.google.gson.JsonObject;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;

public class DCBiomeModifierBuilder {

    private final JsonObject json = new JsonObject();

    public static DCBiomeModifierBuilder createAddFeatures() {
        DCBiomeModifierBuilder builder = new DCBiomeModifierBuilder();
        builder.json.addProperty("type", "forge:add_features");
        return builder;
    }

    public DCBiomeModifierBuilder biomes(TagKey<Biome> biomeTag) {
        json.addProperty("biomes", "#" + biomeTag.location());
        return this;
    }

    public DCBiomeModifierBuilder feature(String feature) {
        json.addProperty("features", feature);
        return this;
    }

    public DCBiomeModifierBuilder step(GenerationStep.Decoration step) {
        json.addProperty("step", step.getName());
        return this;
    }

    public JsonObject build() {
        return json;
    }
}
