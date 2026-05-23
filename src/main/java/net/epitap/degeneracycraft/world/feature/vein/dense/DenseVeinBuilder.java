package net.epitap.degeneracycraft.world.feature.vein.dense;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DenseVeinBuilder {
    private int yMin;
    private int yMax;
    private int size;
    private int generationWeight;

    private TagKey<Biome> biomeTag;

    private final Set<ResourceLocation> dimensions = new HashSet<>();
    private final HashSet<BlockState> matchers = new HashSet<>();

    private final HashMap<String, HashMap<BlockState, Float>> oreBlocks = new HashMap<>();
    private final HashMap<BlockState, Float> outcrops = new HashMap<>();

    private DenseVeinBuilder() {}

    public static DenseVeinBuilder create() {
        return new DenseVeinBuilder();
    }


    public DenseVeinBuilder yRange(int yMin, int yMax) {
        this.yMin = yMin;
        this.yMax = yMax;
        return this;
    }

    public DenseVeinBuilder size(int size) {
        this.size = size;
        return this;
    }

    public DenseVeinBuilder weight(int generationWeight) {
        this.generationWeight = generationWeight;
        return this;
    }

    public DenseVeinBuilder biome(TagKey<Biome> biomeTag) {
        this.biomeTag = biomeTag;
        return this;
    }

    public DenseVeinBuilder dimension(ResourceKey<Level> dimension) {
        this.dimensions.add(dimension.location());
        return this;
    }

    public DenseVeinBuilder matcher(Block block) {
        this.matchers.add(block.defaultBlockState());
        return this;
    }

    public DenseVeinBuilder defaultOre(Block block, float chance) {
        oreBlocks.computeIfAbsent("default", k -> new HashMap<>())
                .put(block.defaultBlockState(), chance);

        return this;
    }

    public DenseVeinBuilder defaultEmpty(float chance) {
        oreBlocks.computeIfAbsent("default", k -> new HashMap<>())
                .put(null, chance);

        return this;
    }

    public DenseVeinBuilder deepslateOre(Block block, float chance) {
        oreBlocks.computeIfAbsent("minecraft:deepslate", k -> new HashMap<>())
                .put(block.defaultBlockState(), chance);

        return this;
    }

    public DenseVeinBuilder deepslateEmpty(float chance) {
        oreBlocks.computeIfAbsent("minecraft:deepslate", k -> new HashMap<>())
                .put(null, chance);

        return this;
    }

    public DenseVeinBuilder outcrop(Block block, float chance) {
        outcrops.put(block.defaultBlockState(), chance);
        return this;
    }

    public DenseVein build() {
        return new DenseVein(
                oreBlocks,
                outcrops,
                yMin,
                yMax,
                size,
                generationWeight,
                biomeTag,
                matchers,
                dimensions
        );
    }
}