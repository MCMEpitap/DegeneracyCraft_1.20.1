package net.epitap.degeneracycraft.world.feature.dimention;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class DCTimeSavedData extends SavedData {

    private static final String NAME = "dc_time";

    private long moonTime;

    public DCTimeSavedData() {
    }

    public static DCTimeSavedData load(CompoundTag tag) {

        DCTimeSavedData data = new DCTimeSavedData();

        data.moonTime = tag.getLong("MoonTime");

        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {

        tag.putLong("MoonTime", moonTime);

        return tag;
    }

    public long getMoonTime() {
        return moonTime;
    }

    public void addMoonTime(long add) {

        moonTime += add;

        setDirty();
    }

    public void setMoonTime(long time) {

        moonTime = time;

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