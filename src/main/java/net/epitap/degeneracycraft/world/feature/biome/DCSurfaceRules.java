package net.epitap.degeneracycraft.world.feature.biome;

import net.epitap.degeneracycraft.block.DCBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class DCSurfaceRules {

    private static SurfaceRules.RuleSource state(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
    private static final SurfaceRules.RuleSource BEDROCK = state(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource MOON_SURFACE = state(DCBlocks.MOON_REGOLITH.get());
    private static final SurfaceRules.RuleSource MOON_UNDERGROUND = state(DCBlocks.MOON_STONE.get());

    public static SurfaceRules.RuleSource moon() {
        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(
                        SurfaceRules.verticalGradient(
                                "moon_bedrock",
                                VerticalAnchor.bottom(),
                                VerticalAnchor.aboveBottom(5)
                        ),
                        BEDROCK
                ),

                SurfaceRules.ifTrue(
                        SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.ifTrue(
                                SurfaceRules.stoneDepthCheck(
                                        3,
                                        false,
                                        CaveSurface.FLOOR
                                ),
                                MOON_SURFACE
                        )
                ),

                SurfaceRules.ifTrue(
                        SurfaceRules.UNDER_FLOOR,
                        MOON_UNDERGROUND
                )
        );
    }
}