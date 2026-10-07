package net.epitap.degeneracycraft.integration.emi;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class DCMultiblockDisplayData {
    private final ResourceLocation id;
    private final int sizeX;
    private final int sizeY;
    private final int sizeZ;
    private final BlockPos controllerOffset;
    private final Map<BlockPos, BlockState> blocks;
    private final Map<Integer, Map<BlockPos, BlockState>> layers;
    private final Map<Block, Integer> blockCounts;

    public DCMultiblockDisplayData(ResourceLocation id, int sizeX, int sizeY, int sizeZ, BlockPos controllerOffset,
                                   Map<BlockPos, BlockState> blocks, Map<Integer, Map<BlockPos, BlockState>> layers, Map<Block, Integer> blockCounts) {
        this.id = id;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.controllerOffset = controllerOffset;
        this.blocks = blocks;
        this.layers = layers;
        this.blockCounts = blockCounts;
    }

    public ResourceLocation getId() {
        return id;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeZ() {
        return sizeZ;
    }

    public BlockPos getControllerOffset() {
        return controllerOffset;
    }

    public Map<BlockPos, BlockState> getBlocks() {
        return blocks;
    }

    public Map<BlockPos, BlockState> getLayer(int y) {
        return layers.getOrDefault(y, Map.of());
    }

    public Map<Block, Integer> getBlockCounts() {
        return blockCounts;
    }

    public int getLayerCount() {
        return sizeY;
    }

    public boolean hasLayer(int y) {
        return y >= 0 && y < sizeY;
    }
}