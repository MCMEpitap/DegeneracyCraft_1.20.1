package net.epitap.degeneracycraft.world.feature.dimention;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.HashMap;
import java.util.Map;

public class DCDimensionTimes {

    public static final float BASIC_DAY_LENGTH = 24000f;
    private static final Map<ResourceKey<Level>, Double> BUFFER = new HashMap<>();
    public static final float MOON_DAY_MODIFIER = 1 / 0.05f;

    public static void tick(
            ServerLevel level,
            double speed) {

        ResourceKey<Level> dim =
                level.dimension();

        double buffer =
                BUFFER.getOrDefault(dim, 0.0);

        buffer += speed;

        long add = (long) buffer;

        buffer -= add;

        BUFFER.put(dim, buffer);

        if (add > 0) {

            DCTimeSavedData.get(level)
                    .addTime(dim, add);
        }
    }

    public static boolean usesCustomTime(ResourceKey<Level> dim) {
        return dim.equals(DCDimensions.MOON_LEVEL);
    }

    public static float getCelestialAngle(Level level, float partialTick) {

        long time = level.getDayTime();

        if (usesCustomTime(level.dimension())) {

            MinecraftServer server =
                    ServerLifecycleHooks.getCurrentServer();

            if (server != null) {

                ServerLevel serverLevel =
                        server.getLevel(level.dimension());

                if (serverLevel != null) {

                    time = DCTimeSavedData
                            .get(serverLevel)
                            .getTime(level.dimension());
                }
            }
        }

        double d0 =
                (time % BASIC_DAY_LENGTH + partialTick)
                        / BASIC_DAY_LENGTH;

        d0 -= 0.25D;
        d0 -= Math.floor(d0);

        double d1 =
                0.5D - Math.cos(d0 * Math.PI) / 2.0D;

        return (float)((d0 * 2.0D + d1) / 3.0D);
    }
}