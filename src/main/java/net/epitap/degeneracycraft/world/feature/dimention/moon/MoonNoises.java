package net.epitap.degeneracycraft.world.feature.dimention.moon;

import net.epitap.degeneracycraft.world.feature.dimention.DCNoises;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class MoonNoises {

    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> context) {

        context.register(
                DCNoises.MOON_CONTINENT,
                new NormalNoise.NoiseParameters(
                        -12,
                        1.0,
                        1.0,
                        0.5,
                        0.25
                )
        );

        context.register(
                DCNoises.MOON_CRATER,
                new NormalNoise.NoiseParameters(
                        -8,
                        1.0,
                        0.5
                )
        );

        context.register(
                DCNoises.MOON_DETAIL,
                new NormalNoise.NoiseParameters(
                        0,
                        1.0
                )
        );

        context.register(
                DCNoises.MOON_CAVE,
                new NormalNoise.NoiseParameters(
                        -6,
                        1.0,
                        1.0,
                        0.5,
                        0.25
                )
        );

        context.register(
                DCNoises.MOON_CAVERN,
                new NormalNoise.NoiseParameters(
                        -7,
                        1.0
                )
        );

        context.register(
                DCNoises.MOON_ENTRANCE,
                new NormalNoise.NoiseParameters(
                        -5,
                        1.0
                )
        );
    }
}