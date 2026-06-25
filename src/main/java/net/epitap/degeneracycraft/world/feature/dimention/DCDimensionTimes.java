package net.epitap.degeneracycraft.world.feature.dimention;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.ServerLifecycleHooks;

public class DCDimensionTimes {

    public static final float BASIC_DAY_LENGTH = 24000f;
    private static double moonBuffer = 0.0;

    public static void tick(ServerLevel level, double speed) {

        moonBuffer += speed;

        long add = (long) moonBuffer;

        moonBuffer -= add;

        if (add > 0) {

            DCTimeSavedData.get(level)
                    .addMoonTime(add);
        }

        System.out.println(
                "Buffer=" + moonBuffer +
                        " Add=" + add
        );
    }
    public static float getCelestialAngle(Level level, float partialTick) {

        long time;

        if (level.dimension().equals(DCDimensions.MOON_LEVEL)) {
            MinecraftServer server =
                    ServerLifecycleHooks.getCurrentServer();

            if (server != null) {

                ServerLevel moon =
                        server.getLevel(DCDimensions.MOON_LEVEL);

                if (moon != null) {

                    time = DCTimeSavedData
                            .get(moon)
                            .getMoonTime();

                } else {
                    time = level.getDayTime();
                }

            } else {
                time = level.getDayTime();
            }

        } else {
            time = level.getDayTime();
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