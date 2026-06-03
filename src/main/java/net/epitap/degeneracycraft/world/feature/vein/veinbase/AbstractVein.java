package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinCapability;
import net.epitap.degeneracycraft.world.feature.vein.parametor.IVeinGeneratedCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractVein {
    protected final HashMap<String, HashMap<BlockState, Float>> matcherToOreWeightPair;
    protected final HashMap<BlockState, Float> outcropWeightPair;
    protected final TagKey<Biome> biomeKey;
    protected final HashSet<BlockState> matchers;
    protected final float generationWeight;
    protected final Set<ResourceLocation> dimensions;

    public AbstractVein(
            HashMap<String, HashMap<BlockState, Float>> matcherToOreWeightPair,
            HashMap<BlockState, Float> outcropWeightPair,
            TagKey<Biome> biomeKey,
            HashSet<BlockState> matchers,
            float generationWeight,
            Set<ResourceLocation> dimensions
    ) {
        this.matcherToOreWeightPair = matcherToOreWeightPair;
        this.outcropWeightPair = outcropWeightPair;
        this.biomeKey = biomeKey;
        this.matchers = matchers;
        this.generationWeight = generationWeight;
        this.dimensions = dimensions;
    }

    @Nullable
    public BlockState getOre(BlockState currentState, RandomSource rand) {
        String res = VeinBlockUtils.getRegistryName(currentState);
        if (this.matcherToOreWeightPair.containsKey(res)) {
            HashMap<BlockState, Float> mp = this.matcherToOreWeightPair.get(res);
            return VeinUtils.pick(mp, rand);
        }
        return VeinUtils.pick(this.matcherToOreWeightPair.get("default"), rand);
    }
    @Nullable
    public HashSet<BlockState> getAllOres() {
        HashSet<BlockState> ret = new HashSet<>();
        this.matcherToOreWeightPair.values().forEach(x -> ret.addAll(x.keySet()));
        ret.remove(Blocks.AIR.defaultBlockState());
        return ret.isEmpty() ? null : ret;
    }

    @Nullable
    public BlockState getOutcrop(RandomSource rand) {
        return VeinUtils.pick(this.outcropWeightPair, rand);
    }

    public float getGenerationWeight() {
        return this.generationWeight;
    }

    public boolean canPlaceInBiome(Holder<Biome> b) {
        return b.is(this.biomeKey);
    }

    public HashSet<BlockState> getMatchers() {
        return this.matchers == null ? VeinUtils.getDefaultMatchers() : this.matchers;
    }

    public boolean canPlaceInDimension(ResourceLocation dimension) {
        return dimensions.isEmpty() || dimensions.contains(dimension);
    }

    public abstract int generate(WorldGenLevel level, BlockPos pos, IVeinCapability Veins, IVeinGeneratedCapability chunksGenerated);

    public abstract void afterGen(WorldGenLevel level, BlockPos pos, IVeinCapability Veins, IVeinGeneratedCapability chunksGenerated);
}