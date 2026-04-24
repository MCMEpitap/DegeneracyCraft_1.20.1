package net.epitap.degeneracycraft.datagen;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.DCBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class DCBlockTagGenerator extends BlockTagsProvider {

    public static final TagKey<Block> CASSITERITE_ORE = TagKey.create(Registries.BLOCK, new ResourceLocation(Degeneracycraft.MOD_ID, "cassiterite_ore"));

    public static final TagKey<Block> DEGENERACYCRAFT_MULTIBLOCKS = TagKey.create(Registries.BLOCK, new ResourceLocation(Degeneracycraft.MOD_ID, "degeneracycraft_multiblocks"));
    public static final TagKey<Block> DEGENERACYCRAFT_MACHINES = TagKey.create(Registries.BLOCK, new ResourceLocation(Degeneracycraft.MOD_ID, "degeneracycraft_machines"));
    public static final TagKey<Block> DEGENERACYCRAFT_ABILITY_BLOCKS = TagKey.create(Registries.BLOCK, new ResourceLocation(Degeneracycraft.MOD_ID, "degeneracycraft_ability_blocks"));
    public static final TagKey<Block> DEGENERACYCRAFT_PIPES = TagKey.create(Registries.BLOCK, new ResourceLocation(Degeneracycraft.MOD_ID, "degeneracycraft_pipes"));

    public DCBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Degeneracycraft.MOD_ID, existingFileHelper);
    }



    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(DCBlocks.OVERWORLD_GRAVITATION_ORE.get())
                .add(DCBlocks.OVERWORLD_CASSITERITE_ORE.get())
                .add(DCBlocks.DEEPSLATE_CASSITERITE_ORE.get())
                .add(DCBlocks.NETHER_CASSITERITE_ORE.get())
                .add(DCBlocks.END_CASSITERITE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(DCBlocks.OVERWORLD_CASSITERITE_ORE.get())
                .add(DCBlocks.DEEPSLATE_CASSITERITE_ORE.get())
                .add(DCBlocks.NETHER_CASSITERITE_ORE.get())
                .add(DCBlocks.END_CASSITERITE_ORE.get());

//        tag(DCTags.Blocks.NEEDS_CAMMDA_TIER1)
//                .add(DCBlocks.OVERWORLD_GRAVITATION_ORE.get());
//
//
//        tag(DCBlocks.GRAVITATION_ORE)
//                .add(DCBlocks.OVERWORLD_GRAVITATION_ORE.get());

        tag(CASSITERITE_ORE)
                .add(DCBlocks.OVERWORLD_CASSITERITE_ORE.get())
                .add(DCBlocks.DEEPSLATE_CASSITERITE_ORE.get())
                .add(DCBlocks.NETHER_CASSITERITE_ORE.get())
                .add(DCBlocks.END_CASSITERITE_ORE.get());

        tag(DEGENERACYCRAFT_MULTIBLOCKS)
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK.get())
                .add(DCBlocks.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK.get());

        tag(DEGENERACYCRAFT_MACHINES)
                .add(DCBlocks.REDSTONE_POWERED_MACHINE_ELEMENT_MANUFACTURE_MACHINE_BLOCK.get())
                .add(DCBlocks.REDSTONE_POWERED_MACHINE_PART_MANUFACTURE_MACHINE_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_ASTRONOMICAL_TELESCOPE_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_FINE_PARTICLE_ADSORBER_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_STARLIGHT_COLLECTOR_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_BIO_REACTOR_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_CELL_INCUBATOR_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_CROP_CULTIVATOR_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_CHEMICAL_REACTOR_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_COMPOUND_PURIFIER_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_ELECTROLYSER_BLOCK.get())
                .add(DCBlocks.BASIC_POWER_STEAM_GENERATOR_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_COMPRESSION_CONDENSER_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_ELECTROMAGNETIC_INDUCTOR_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_MACHINE_MANUFACTURER_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_MACHINE_ELEMENT_PROCESSOR_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_MACHINE_PART_PROCESSOR_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_MULTIBLOCK_EQUIPMENT_FABRICATOR_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_CIRCUIT_BUILDER_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_MACHINE_DATA_INSTALLER_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_DESIGNATED_DATA_INJECTOR_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_ORE_SORTER_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_ROCK_CRASHER_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_SOIL_PURIFIER_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_ELECTRIC_ARC_FURNACE_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_FORMING_MACHINE_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_MATERIAL_SEPARATOR_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_IMITATION_MAGIC_ENGRAVER_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_SUSPECTED_MAGIC_CONDENSER_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_VIRTUAL_SIGIL_PROCESSOR_BLOCK.get())
                .add(DCBlocks.BASIC_TECHNOLOGY_VOID_WORLD_COORDINATE_RECORDING_MACHINE_BLOCK.get())
                .add(DCBlocks.BASIC_PERFORMANCE_REALITY_PHASE_ADJUSTMENT_MACHINE_BLOCK.get())

        ;

        tag(DEGENERACYCRAFT_ABILITY_BLOCKS)
                .add(DCBlocks.BASIC_PRECISION_OBJECTIVE_LENS_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_FINE_PARTICLE_STORAGE_TANK_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_FAINT_LIGHT_RESERVER_BLOCK.get())
                .add(DCBlocks.BASIC_SPEED_CULTIVATION_GREENHOUSE_BLOCK.get())
                .add(DCBlocks.BASIC_DURABILITY_INCUBATION_CONTAINER_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_GROWTH_STABILIZER_BLOCK.get())
                .add(DCBlocks.BASIC_RATE_COMPOUND_AGITATION_SYSTEM_BLOCK.get())
                .add(DCBlocks.BASIC_DURABLE_HIGH_SPPED_CHEMICAL_REACTOR_BLOCK.get())
                .add(DCBlocks.BASIC_DURABLE_EXPANDED_ELECTROLYTIC_CELL_BLOCK.get())
                .add(DCBlocks.BASIC_ENDURANCE_HIGH_TEMPERATURE_COMBUSTION_CHAMBER_BLOCK.get())
                .add(DCBlocks.BASIC_PRESSURE_COMPRESSION_ASSIST_SYSTEM_BLOCK.get())
                .add(DCBlocks.BASIC_DURABLE_INSULATED_CHAMBER_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_MACHINE_PROCESSING_CHAMBER_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_MACHINE_ELEMENT_PROCESSING_CHAMBER_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_MACHINE_PART_PROCESSING_CHAMBER_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_EQUIPMENT_PRODUCTION_AUXILIARY_SYSTEM_BLOCK.get())
                .add(DCBlocks.BASIC_PURITY_CIRCUIT_CLEAN_ROOM_BLOCK.get())
                .add(DCBlocks.BASIC_SPEED_DATA_READER_BLOCK.get())
                .add(DCBlocks.BASIC_SPEED_CALCULATION_AUXILIARY_WRITE_DEVICE_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_ORE_SORTING_FILTER_BLOCK.get())
                .add(DCBlocks.BASIC_CRASHING_BASE_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_PARTICLE_MIXING_CHAMBER_BLOCK.get())
                .add(DCBlocks.BASIC_FLOW_COOLING_SYSTEM_BLOCK.get())
                .add(DCBlocks.BASIC_PRECISION_EXTRUSION_ASSIST_SYSTEM_BLOCK.get())
                .add(DCBlocks.BASIC_DURABILITY_VIBRATION_CONTROL_BASE_BLOCK.get())
                .add(DCBlocks.BASIC_OUTPUT_MYSTIC_OPTICAL_PROJECTION_DEVICE_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_SEALED_EXTRACTION_CASE_BLOCK.get())
                .add(DCBlocks.BASIC_SPEED_PATTERN_TRANSFER_SYSTEM_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_VOID_INTERFERENCE_FLAME_BLOCK.get())
                .add(DCBlocks.BASIC_EFFICIENCY_PHASE_STABLE_FLAME_BLOCK.get())
        ;

        tag(DEGENERACYCRAFT_PIPES)
                .add(DCBlocks.BASIC_ITEM_PIPE_BLOCK.get())
                .add(DCBlocks.BASIC_ENERGY_PIPE_BLOCK.get())
                .add(DCBlocks.LOW_ENERGY_PIPE_BLOCK.get())
                .add(DCBlocks.FLOAT_ENERGY_PIPE_BLOCK.get())
                ;
    }




    @Override
    public String getName() {
        return "Block Tags";
    }
}

