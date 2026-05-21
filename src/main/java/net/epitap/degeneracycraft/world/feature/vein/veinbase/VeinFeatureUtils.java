package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinCapability;
import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinGeneratedCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkAccess;

import javax.annotation.Nullable;

public class VeinFeatureUtils {
    private static boolean ensureCanWriteNoThrow(WorldGenLevel level, BlockPos pos) {
        if (level instanceof WorldGenRegion region) {
            ChunkPos center = region.getCenter();
            int i = SectionPos.blockToSectionCoord(pos.getX());
            int j = SectionPos.blockToSectionCoord(pos.getZ());
            int k = Math.abs(center.x - i);
            int l = Math.abs(center.z - j);
            return k <= 1 && l <= 1;
        } else {
            return false;
        }
    }

    public static boolean enqueueBlockPlacement(WorldGenLevel level, ChunkPos chunk, BlockPos pos, BlockState state,
                                                IVeinCapability depCap, @Nullable IVeinGeneratedCapability cgCap) {
        if (cgCap != null && cgCap.hasChunkGenerated(new ChunkPos(pos))) {
            if (!level.hasChunk(chunk.x, chunk.z)) return false;
            if (!ensureCanWriteNoThrow(level, pos)) return false;

            ChunkAccess chunkaccess = level.getChunk(pos);
            BlockState blockstate = chunkaccess.setBlockState(pos, state, false);
            if (blockstate != null) {
                level.getLevel().onBlockStateChange(pos, blockstate, state);
            }
            return true;
        }

        if (!ensureCanWriteNoThrow(level, pos)) {
            depCap.putPendingBlock(pos, state);
            return false;
        }

        if (!level.setBlock(pos, state, 2 | 16)) {
            depCap.putPendingBlock(pos, state);
            return false;
        }

        return true;
    }

    public static void fixSnowyBlock(WorldGenLevel level, BlockPos posPlaced) {
        BlockState below = level.getBlockState(posPlaced.below());
        if (below.hasProperty(BlockStateProperties.SNOWY)) {
            level.setBlock(posPlaced.below(), below.setValue(BlockStateProperties.SNOWY, Boolean.valueOf(false)),
                    2 | 16);
        }
    }
}
