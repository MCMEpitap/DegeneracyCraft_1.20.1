package net.epitap.degeneracycraft.world.feature.vein.dense;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DenseVeinSerializer {
    public DenseVein deserialize(JsonObject json) {
        return DenseVein.deserialize(json);
    }

    public JsonElement serialize(DenseVein dep) {
        return dep.serialize();
    }
}
