package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinGeneratedCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

import java.util.concurrent.ConcurrentHashMap;

public class VeinGeneratedCapability implements IVeinGeneratedCapability {
    private final ConcurrentHashMap.KeySetView<ChunkPos, Boolean> generatedChunks;

    public static final Capability<IVeinGeneratedCapability> CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    public VeinGeneratedCapability() {
        this.generatedChunks = ConcurrentHashMap.newKeySet();
    }

    @Override
    public boolean hasChunkGenerated(ChunkPos pos) {
        return this.generatedChunks.contains(pos);
    }

    @Override
    public void setChunkGenerated(ChunkPos pos) {
        this.generatedChunks.add(pos);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compound = new CompoundTag();
        ListTag chunks = new ListTag();
        this.generatedChunks.forEach(chunkPos -> {
            CompoundTag tag = new CompoundTag();
            tag.putInt("x", chunkPos.x);
            tag.putInt("z", chunkPos.z);
            chunks.add(tag);
        });
        compound.put("chunks", chunks);
        return compound;
    }

    @Override
    public void deserializeNBT(CompoundTag compound) {
        ListTag chunks = compound.getList("chunks", 10);
        chunks.forEach(x -> {
            CompoundTag comp = (CompoundTag) x;
            ChunkPos chunkPos = new ChunkPos(comp.getInt("x"), comp.getInt("z"));
            this.generatedChunks.add(chunkPos);
        });
    }
}
