package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;

public class VeinOutcropUtils {
    @Nullable
    public static BlockPos getOutcropPosition(WorldGenLevel level, ChunkPos chunkPos) {
        return getOutcropPosition(level, chunkPos, -1);
    }

    @Nullable
    public static BlockPos getOutcropPosition(WorldGenLevel level, ChunkPos chunkPos, int spread) {

        if (!(level instanceof WorldGenRegion region)) {
            return null;
        }

        var usedSpread = Math.max(8, spread);
        var xCenter = (chunkPos.getMinBlockX() + chunkPos.getMaxBlockX()) / 2;
        var zCenter = (chunkPos.getMinBlockZ() + chunkPos.getMaxBlockZ()) / 2;

        var blockPosX = xCenter
                + (level.getRandom().nextInt(usedSpread) * ((level.getRandom().nextBoolean()) ? 1 : -1));
        var blockPosZ = zCenter
                + (level.getRandom().nextInt(usedSpread) * ((level.getRandom().nextBoolean()) ? 1 : -1));

        if (!region.hasChunk(chunkPos.x, chunkPos.z)) {
            return null;
        }

        var searchPos = new BlockPos(blockPosX, region.getHeight(), blockPosZ);

        while (searchPos.getY() > region.getMinBuildHeight()) {
            var blockToPlaceOn = region.getBlockState(searchPos);
            if (Block.isFaceFull(blockToPlaceOn.getShape(region, searchPos), Direction.UP)) {
                if (!blockToPlaceOn.is(Blocks.GRASS_BLOCK)) {
                    searchPos = searchPos.below();
                    continue;
                }
                var actualPlacePos = searchPos.above();
                if (canReplace(region, actualPlacePos)) {
                    return actualPlacePos;
                }
            }
            searchPos = searchPos.below();
        }

        return null;
    }

    public static boolean canReplace(WorldGenLevel level, BlockPos pos) {
        var state = level.getBlockState(pos);
        return state.canBeReplaced() || state.isAir();
    }

    public static boolean isInWater(WorldGenLevel level, BlockPos pos) {
        return level.getBlockState(pos).getBlock() == Blocks.WATER;
    }

    public static boolean inNonWaterFluid(WorldGenLevel level, BlockPos pos) {
        return (!level.getBlockState(pos).getFluidState().isEmpty()) && !isInWater(level, pos);
    }

    public static boolean isWithinRange(int posA, int posB, int range) {
        return (Math.abs(posA - posB) <= range);
    }
}
