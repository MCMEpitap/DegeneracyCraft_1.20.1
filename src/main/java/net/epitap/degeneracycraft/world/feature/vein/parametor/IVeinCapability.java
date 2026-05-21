package net.epitap.degeneracycraft.world.feature.vein.parametor;

import net.epitap.degeneracycraft.world.feature.vein.veinbase.VeinCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.concurrent.ConcurrentLinkedQueue;

public interface IVeinCapability {
    void putPendingBlock(BlockPos pos, BlockState state);

    void removePendingBlocksForChunk(ChunkPos p);

    int getPendingBlockCount();

    ConcurrentLinkedQueue<VeinCapability.PendingBlock> getPendingBlocks(ChunkPos chunkPos);

    CompoundTag serializeNBT();

    void deserializeNBT(CompoundTag nbt);
}
