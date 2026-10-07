package net.epitap.degeneracycraft.integration.emi;

import net.epitap.degeneracycraft.multiblock.DCMultiblockFile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public final class DCMultiblockDisplayDataFactory {
    private DCMultiblockDisplayDataFactory() {
    }

    public static DCMultiblockDisplayData create(
            ResourceLocation id,
            DCMultiblockFile file
    ) {
        Map<BlockPos, BlockState> blocks = new HashMap<>();
        Map<Integer, Map<BlockPos, BlockState>> layers = new HashMap<>();
        Map<Block, Integer> blockCounts = new HashMap<>();

        BlockPos controllerOffset = file.getControllerOffset();

        if (controllerOffset == null) {
            throw new IllegalArgumentException(
                    "Multiblock '" + id + "' has no controller"
            );
        }

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {
                    DCMultiblockFile.DCPlaceholder placeholder =
                            file.getPlaceholder(x, y, z);

                    if (placeholder == null) {
                        continue;
                    }

                    DCMultiblockFile.DCPredicate predicate = null;

                    for (DCMultiblockFile.DCPredicate p : placeholder.getPredicates()) {
                        if (p != null && p.isBlock()) {
                            predicate = p;
                            break;
                        }
                    }

                    if (predicate == null) {
                        continue;
                    }

                    ResourceLocation blockId = predicate.getBlockId();

                    if (blockId == null) {
                        continue;
                    }

                    Block block = BuiltInRegistries.BLOCK.get(blockId);

                    if (block == Blocks.AIR) {
                        continue;
                    }

                    BlockState state = block.defaultBlockState();

                    BlockPos relativePos = file.toRelativePos(x, y, z);

                    blocks.put(relativePos, state);

                    layers.computeIfAbsent(
                            relativePos.getY(),
                            ignored -> new HashMap<>()
                    ).put(relativePos, state);

                    blockCounts.merge(block, 1, Integer::sum);
                }
            }
        }

        return new DCMultiblockDisplayData(
                id,
                file.getX(),
                file.getY(),
                file.getZ(),
                controllerOffset,
                blocks,
                layers,
                blockCounts
        );
    }
}