package net.epitap.degeneracycraft.world.feature.dimention.moon;

import net.epitap.degeneracycraft.world.feature.dimention.DCNoises;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class MoonNoiseRouters {

    public static NoiseRouter create(
            HolderGetter<DensityFunction> functions,
            HolderGetter<NormalNoise.NoiseParameters> noises) {

        //========================
        // 地形
        //========================

        DensityFunction baseTerrain =
                DensityFunctions.add(
                        DensityFunctions.constant(0.6),
                        DensityFunctions.yClampedGradient(
                                60,
                                96,
                                0.5,
                                -1.5
                        )
                );

        DensityFunction continents =
                DensityFunctions.mul(
                        DensityFunctions.constant(0.10),
                        DensityFunctions.noise(
                                noises.getOrThrow(
                                        DCNoises.MOON_CONTINENT
                                )
                        )
                );

        DensityFunction craters =
                DensityFunctions.mul(
                        DensityFunctions.constant(-0.8),
                        DensityFunctions.noise(
                                noises.getOrThrow(
                                        DCNoises.MOON_CRATER
                                )
                        )
                );

        DensityFunction detail =
                DensityFunctions.mul(
                        DensityFunctions.constant(0.01),
                        DensityFunctions.noise(
                                noises.getOrThrow(
                                        DCNoises.MOON_DETAIL
                                )
                        )
                );

        DensityFunction ground =
                DensityFunctions.add(
                        baseTerrain,
                        DensityFunctions.add(
                                continents,
                                DensityFunctions.add(
                                        craters,
                                        detail
                                )
                        )
                );
//========================
// Main Tube
//========================
//========================
// Main Cave Noise
//========================

        DensityFunction caveNoise =
                DensityFunctions.noise(
                        noises.getOrThrow(
                                DCNoises.MOON_CAVE
                        ),
                        0.9,
                        0.6
                );

        DensityFunction caveShape =
                caveNoise
                        .abs()
                        .square();



        DensityFunction cavernNoise =
                DensityFunctions.noise(
                        noises.getOrThrow(
                                DCNoises.MOON_CAVERN
                        ),
                        0.35,
                        0.35
                ).abs();

//========================
// 地下だけ生成
//========================

        DensityFunction caveMask =
                DensityFunctions.mul(

                        DensityFunctions.yClampedGradient(
                                75,
                                16,
                                0.0,
                                1.0
                        ),

                        DensityFunctions.yClampedGradient(
                                6,
                                15,
                                0.0,
                                1.0
                        )
                );

//========================
// 洞窟密度
//========================

        DensityFunction caves =
                DensityFunctions.mul(

                        caveMask,

                        DensityFunctions.add(

                                DensityFunctions.mul(
                                        DensityFunctions.constant(-5.5),
                                        caveShape
                                ),

                                DensityFunctions.mul(
                                        DensityFunctions.constant(-1.8),
                                        cavernNoise
                                )
                        )
                );

//========================
// 最終
//========================

        DensityFunction finalDensity =
                DensityFunctions.add(
                        ground,
                        caves
                );
        //========================
        // その他
        //========================

        DensityFunction erosion =
                DensityFunctions.mul(
                        DensityFunctions.constant(0.35),
                        DensityFunctions.noise(
                                noises.getOrThrow(
                                        DCNoises.MOON_DETAIL
                                )
                        )
                );

        DensityFunction ridges =
                DensityFunctions.mul(
                        DensityFunctions.constant(2.0),
                        DensityFunctions.noise(
                                noises.getOrThrow(
                                        DCNoises.MOON_CONTINENT
                                )
                        )
                );

        return new NoiseRouter(
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),

                DensityFunctions.zero(),
                DensityFunctions.zero(),

                DensityFunctions.zero(),
                erosion,
                DensityFunctions.zero(),
                ridges,

                ground,
                finalDensity,

                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero()
        );
    }
}