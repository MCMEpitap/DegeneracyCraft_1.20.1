package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import com.mojang.serialization.Codec;
import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinCapability;
import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinGeneratedCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VeinFeature extends Feature<NoneFeatureConfiguration> {



    public VeinFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        if (context.chunkGenerator() instanceof FlatLevelSource) {
            return false;
        }

        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();

        IVeinCapability veinCapability = level.getLevel()
                .getCapability(VeinCapability.CAPABILITY)
                .orElse(null);

        IVeinGeneratedCapability generatedCapability = level.getLevel()
                .getCapability(VeinGeneratedCapability.CAPABILITY)
                .orElse(null);

        boolean placedVein = false;
        boolean placedPending = placePendingBlocks(
                level,
                veinCapability,
                generatedCapability,
                origin
        );

        if (level.getRandom().nextDouble() > 0.9D) {

            for (int i = 0; i < 5; i++) {

                AbstractVein vein = VeinBlockPath.veinBlockPath.pick(level, origin);

                if (vein == null) {
                    continue;
                }

                boolean generated =
                        vein.generate(level, origin, veinCapability, generatedCapability) > 0;

                if (generated) {
                    placedVein = true;
                    vein.afterGen(level, origin, veinCapability, generatedCapability);
                }
            }
        }

        generatedCapability.setChunkGenerated(new ChunkPos(origin));

        return placedVein || placedPending;
    }

    private boolean placePendingBlocks(WorldGenLevel level, IVeinCapability veinCapability, IVeinGeneratedCapability generatedCapability, BlockPos origin) {

        ChunkPos chunkPos = new ChunkPos(origin);

        ConcurrentLinkedQueue<VeinCapability.PendingBlock> pendingBlocks =
                veinCapability.getPendingBlocks(chunkPos);

        pendingBlocks.forEach(block ->
                VeinFeatureUtils.enqueueBlockPlacement(level, chunkPos, block.pos(), block.state(), veinCapability, generatedCapability)
        );

        veinCapability.removePendingBlocksForChunk(chunkPos);

        return !pendingBlocks.isEmpty();
    }
}