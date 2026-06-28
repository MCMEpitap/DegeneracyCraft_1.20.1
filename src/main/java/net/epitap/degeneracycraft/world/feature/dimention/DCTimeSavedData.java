package net.epitap.degeneracycraft.world.feature.dimention;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;

public class DCTimeSavedData extends SavedData {

    private static final String NAME = "dc_time";

    private final Map<ResourceLocation, Long> times =
            new HashMap<>();

    public DCTimeSavedData() {
    }

    public static DCTimeSavedData load(CompoundTag tag) {

        DCTimeSavedData data = new DCTimeSavedData();

        CompoundTag timesTag = tag.getCompound("Times");

        for (String key : timesTag.getAllKeys()) {

            data.times.put(
                    new ResourceLocation(key),
                    timesTag.getLong(key)
            );
        }

        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {

        CompoundTag timesTag = new CompoundTag();

        for (Map.Entry<ResourceLocation, Long> entry
                : times.entrySet()) {

            timesTag.putLong(
                    entry.getKey().toString(),
                    entry.getValue()
            );
        }

        tag.put("Times", timesTag);

        return tag;
    }

    public long getTime(ResourceKey<Level> dimension) {

        return times.getOrDefault(
                dimension.location(),
                0L
        );
    }

    public void addTime(
            ResourceKey<Level> dimension,
            long add) {

        times.put(
                dimension.location(),
                getTime(dimension) + add
        );

        setDirty();
    }

    public void setTime(
            ResourceKey<Level> dimension,
            long time) {

        times.put(
                dimension.location(),
                time
        );

        setDirty();
    }

    public static DCTimeSavedData get(ServerLevel level) {

        return level.getServer()
                .overworld()
                .getDataStorage()
                .computeIfAbsent(
                        DCTimeSavedData::load,
                        DCTimeSavedData::new,
                        NAME
                );
    }
}