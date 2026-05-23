package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.Map.Entry;

public class VeinSerializerUtils {
    public static @NotNull BlockState fromString(@Nullable String string) {
        if (string == null) {
            return Blocks.AIR.defaultBlockState();
        }
        ResourceLocation resourceLocation = new ResourceLocation(string);
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(resourceLocation)).defaultBlockState();
    }

    public static String[] toStringArray(JsonArray arr) {
        String[] ret = new String[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            ret[i] = arr.get(i).getAsString();
        }

        return ret;
    }

    public static HashSet<BlockState> toBlockStateList(JsonArray arr) {
        HashSet<BlockState> ret = new HashSet<BlockState>();

        for (String s : toStringArray(arr)) {
            ret.add(fromString(s));
        }

        return ret;
    }

    public static HashMap<BlockState, Float> buildMultiBlockMap(JsonObject obj, String key) {
        HashMap<BlockState, Float> ret = new HashMap<BlockState, Float>();

        if (!obj.has(key)) return ret;
        if (!obj.get(key).isJsonArray()) return ret;

        for (JsonElement j : obj.getAsJsonArray(key)) {
            JsonObject pair = j.getAsJsonObject();
            if (pair.get("block").isJsonNull()) {
                ret.put(null, pair.get("chance").getAsFloat());
            } else {
                ret.put(fromString(pair.get("block").getAsString()), pair.get("chance").getAsFloat());
            }
        }

        return ret;
    }

    public static JsonArray deconstructMultiBlockMap(HashMap<BlockState, Float> map) {
        JsonArray array = new JsonArray();

        for (Map.Entry<BlockState, Float> entry : map.entrySet()) {
            JsonObject obj = new JsonObject();
            BlockState state = entry.getKey();

            if (state == null) {
                obj.add("block", JsonNull.INSTANCE);
            } else {
                ResourceLocation id = ForgeRegistries.BLOCKS.getKey(state.getBlock());
                obj.addProperty("block", id.toString());
            }
            obj.addProperty("chance", entry.getValue());
            array.add(obj);
        }

        return array;
    }

    public static HashMap<String, HashMap<BlockState, Float>> buildMultiBlockMatcherMap(JsonObject obj) {
        HashMap<String, HashMap<BlockState, Float>> ret = new HashMap<>();

        obj.keySet().forEach((key) -> {
            HashMap<BlockState, Float> value = buildMultiBlockMap(obj, key);
            ret.put(key, value);
        });

        return ret;
    }

    public static JsonObject deconstructMultiBlockMatcherMap(HashMap<String, HashMap<BlockState, Float>> in) {
        JsonObject ret = new JsonObject();

        for (Entry<String, HashMap<BlockState, Float>> i : in.entrySet()) {
            String key = i.getKey();
            JsonArray value = deconstructMultiBlockMap(i.getValue());
            ret.add(key, value);
        }

        return ret;
    }

    public static JsonArray deconstructBlockStateList(Set<BlockState> states) {
        JsonArray array = new JsonArray();

        for (BlockState state : states) {
            if (state == null) {
                continue;
            }

            ResourceLocation id = ForgeRegistries.BLOCKS.getKey(state.getBlock());

            if (id != null) {
                array.add(id.toString());
            }
        }

        return array;
    }
}