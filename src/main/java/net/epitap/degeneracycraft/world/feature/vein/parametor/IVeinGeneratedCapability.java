package net.epitap.degeneracycraft.world.feature.vein.parametor;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ChunkPos;

public interface IVeinGeneratedCapability {
    boolean hasChunkGenerated(ChunkPos pos);

    void setChunkGenerated(ChunkPos pos);

    CompoundTag serializeNBT();

    void deserializeNBT(CompoundTag compound);
}
