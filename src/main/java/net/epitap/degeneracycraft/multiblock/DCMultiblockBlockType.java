package net.epitap.degeneracycraft.multiblock;

import net.epitap.degeneracycraft.block.DCBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public enum DCMultiblockBlockType {

    ENERGY_INPUT(
            DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get()
    ),

    ENERGY_OUTPUT(
            DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get()
    ),

    ITEM_INPUT(
            DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get()
    ),

    ITEM_OUTPUT(
            DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get(),
            DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get()
    );

    private final Set<Block> blocks;

    DCMultiblockBlockType(Block... blocks) {
        this.blocks = Set.of(blocks);
    }

    /**
     * 実際のBlockから種類を取得
     */
    public static DCMultiblockBlockType getType(Block block) {
        for (DCMultiblockBlockType type : values()) {
            if (type.blocks.contains(block)) {
                return type;
            }
        }

        return null;
    }

    /**
     * Placeholderのpredicate keyから種類を取得
     */
    public static DCMultiblockBlockType getType(String key) {

        for (DCMultiblockBlockType type : values()) {

            for (Block block : type.blocks) {

                ResourceLocation id =
                        BuiltInRegistries.BLOCK.getKey(block);

                if (id != null && id.toString().equals(key)) {
                    return type;
                }
            }
        }

        return null;
    }

    /**
     * Placeholderから種類を取得
     */
    public static DCMultiblockBlockType getType(
            DCMultiblockFile.DCPlaceholder placeholder
    ) {

        for (DCMultiblockFile.DCPredicate predicate :
                placeholder.getPredicates()) {

            if (!predicate.isBuiltin()) {
                continue;
            }

            DCMultiblockBlockType type =
                    getType(predicate.getKey());

            if (type != null) {
                return type;
            }
        }

        return null;
    }

    public boolean matches(Block block) {
        return blocks.contains(block);
    }

    public Set<Block> getBlocks() {
        return blocks;
    }
}