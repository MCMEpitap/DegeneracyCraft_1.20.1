package net.epitap.degeneracycraft.block;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.DCBlockBase;
import net.epitap.degeneracycraft.block.base.DCGlassBlockBase;
import net.epitap.degeneracycraft.block.base.DCHoloBlockBase;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope.BasicPerformanceAstronomicalTelescopeBlock;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_fine_particle_adsorber.BasicPerformanceFineParticleAdsorberBlock;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_starlight_collector.BasicPerformanceStarlightCollectorBlock;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor.BasicPerformanceBioReactorBlock;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_cell_incubator.BasicPerformanceCellIncubatorBlock;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_crop_cultivator.BasicPerformanceCropCultivatorBlock;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_chemical_reactor.BasicPerformanceChemicalReactorBlock;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_compound_purifier.BasicPerformanceCompoundPurifierBlock;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser.BasicPerformanceElectrolyserBlock;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_power_steam_generator.BasicPowerSteamGeneratorBlock;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_compression_condenser.BasicTechnologyCompressionCondenserBlock;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor.BasicTechnologyElectromagneticInductorBlock;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorBlock;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_manufacturer.BasicTechnologyMachineManufacturerBlock;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_part_processor.BasicTechnologyMachinePartProcessorBlock;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_multiblock_equipment_fabricator.BasicTechnologyMultiblockEquipmentFabricatorBlock;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_circuit_builder.BasicPerformanceCircuitBuilderBlock;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_designated_data_injector.BasicPerformanceDesignatedDataInjectorBlock;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerBlock;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_ore_sorter.BasicPerformanceOreSorterBlock;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherBlock;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_soil_purifier.BasicPerformanceSoilPurifierBlock;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_electric_arc_furnace.BasicPerformanceElectricArcFurnaceBlock;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_forming_machine.BasicPerformanceFormingMachineBlock;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_material_separator.BasicPerformanceMaterialSeparatorBlock;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_imitation_magic_engraver.BasicTechnologyImitationMagicEngraverBlock;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserBlock;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorBlock;
import net.epitap.degeneracycraft.block.machine.basic.jenith_void_science.basic_technology_void_world_coordinate_recording_machine.BasicTechnologyVoidWorldCoordinateRecordingMachineBlock;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineBlock;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine.RedstonePoweredMachineElementManufactureMachineBlock;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_part_manufacture_machine.RedstonePoweredMachinePartManufactureMachineBlock;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.energy.energy_storage.BasicStrengthAstronomyMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.energy.input_bus.BasicStrengthAstronomyMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.energy.output_bus.BasicStrengthAstronomyMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.input_port.BasicStrengthAstronomyMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.item_storage.BasicStrengthAstronomyMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.output_port.BasicStrengthAstronomyMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.biology.energy.energy_storage.BasicStrengthBiologyMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.biology.energy.input_bus.BasicStrengthBiologyMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.biology.energy.output_bus.BasicStrengthBiologyMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.input_port.BasicStrengthBiologyMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.item_storage.BasicStrengthBiologyMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.output_port.BasicStrengthBiologyMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.energy.energy_storage.BasicStrengthChemistryMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.energy.input_bus.BasicStrengthChemistryMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.input_port.BasicStrengthChemistryMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.item_storage.BasicStrengthChemistryMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.output_port.BasicStrengthChemistryMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.energy_storage.BasicStrengthDynamicEnergeticsMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.input_bus.BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.output_bus.BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.input_port.BasicStrengthDynamicEnergeticsMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.item_storage.BasicStrengthDynamicEnergeticsMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.output_port.BasicStrengthDynamicEnergeticsMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.engineering.energy.energy_storage.BasicStrengthEngineeringMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.engineering.energy.input_bus.BasicStrengthEngineeringMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.engineering.energy.output_bus.BasicStrengthEngineeringMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.input_port.BasicStrengthEngineeringMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.item_storage.BasicStrengthEngineeringMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.output_port.BasicStrengthEngineeringMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.energy_storage.BasicStrengthFormalScienceMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.input_bus.BasicStrengthFormalScienceMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.output_bus.BasicStrengthFormalScienceMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.input_port.BasicStrengthFormalScienceMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.item_storage.BasicStrengthFormalScienceMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.output_port.BasicStrengthFormalScienceMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.energy.energy_storage.BasicStrengthGeoScienceMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.energy.input_bus.BasicStrengthGeoScienceMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.energy.output_bus.BasicStrengthGeoScienceMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.input_port.BasicStrengthGeoScienceMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.item_storage.BasicStrengthGeoScienceMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.output_port.BasicStrengthGeoScienceMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.energy_storage.BasicStrengthHybridPhysicsMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.input_bus.BasicStrengthHybridPhysicsMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.output_bus.BasicStrengthHybridPhysicsMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.input_port.BasicStrengthHybridPhysicsMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.item_storage.BasicStrengthHybridPhysicsMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.output_port.BasicStrengthHybridPhysicsMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.energy.energy_storage.BasicStrengthImitationMagicEngineeringMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.energy.input_bus.BasicStrengthImitationMagicEngineeringMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.energy.output_bus.BasicStrengthImitationMagicEngineeringMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.input_port.BasicStrengthImitationMagicEngineeringMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.item_storage.BasicStrengthImitationMagicEngineeringMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.output_port.BasicStrengthImitationMagicEngineeringMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.energy.energy_storage.BasicStrengthJenithVoidScienceMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.energy.input_bus.BasicStrengthJenithVoidScienceMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.energy.output_bus.BasicStrengthJenithVoidScienceMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.input_port.BasicStrengthJenithVoidScienceMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.item_storage.BasicStrengthJenithVoidScienceMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.output_port.BasicStrengthJenithVoidScienceMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.energy.energy_storage.BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.energy.input_bus.BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyInputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.energy.output_bus.BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyOutputBusBlock;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.input_port.BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortBlock;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.item_storage.BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageBlock;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.output_port.BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortBlock;
import net.epitap.degeneracycraft.block.test.TestMachineBlock;
import net.epitap.degeneracycraft.items.DCItems;
import net.epitap.degeneracycraft.transport.pipe.basic.energy.BasicEnergyPipeBlock;
import net.epitap.degeneracycraft.transport.pipe.basic.energy.floa.FloatEnergyPipeBlock;
import net.epitap.degeneracycraft.transport.pipe.basic.item.BasicItemPipeBlock;
import net.epitap.degeneracycraft.transport.pipe.low.energy.LowEnergyPipeBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class DCBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Degeneracycraft.MOD_ID);


    public static final RegistryObject<Block> OVERWORLD_CASSITERITE_ORE = registerBlock("overworld_cassiterite_ore", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(4.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_CASSITERITE_ORE = registerBlock("deepslate_cassiterite_ore", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(4.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_CASSITERITE_ORE = registerBlock("nether_cassiterite_ore", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(4.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> END_CASSITERITE_ORE = registerBlock("end_cassiterite_ore", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(4.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SILICON_BLOCK = registerTooltipMeterialElementBlock("silicon_block", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f, 10.0f)),"silicon", "basic");
    public static final RegistryObject<Block> TIN_BLOCK = registerTooltipMeterialElementBlock("tin_block", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f, 10.0f)),"tin", "basic");


    public static final RegistryObject<Block> OVERWORLD_GRAVITATION_ORE = registerBlock("overworld_gravitation_ore_block", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> REINFORCED_PLANKS = registerBlock("reinforced_planks", () -> new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(4.0f, 10.0f)));



    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_astronomy_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_astronomy_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_astronomy_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_astronomy_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_astronomy_multiblock_energy_storage_block", () ->
            new BasicStrengthAstronomyMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_astronomy_multiblock_item_storage_block", () ->
            new BasicStrengthAstronomyMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_astronomy_multiblock_energy_input_bus_block", () ->
            new BasicStrengthAstronomyMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_astronomy_multiblock_energy_output_bus_block", () ->
            new BasicStrengthAstronomyMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_astronomy_multiblock_item_input_port_block", () ->
            new BasicStrengthAstronomyMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_astronomy_multiblock_item_output_port_block", () ->
            new BasicStrengthAstronomyMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_astronomy_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_biology_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_biology_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_biology_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_biology_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_biology_multiblock_energy_storage_block", () ->
            new BasicStrengthBiologyMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_biology_multiblock_item_storage_block", () ->
            new BasicStrengthBiologyMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_biology_multiblock_energy_input_bus_block", () ->
            new BasicStrengthBiologyMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_biology_multiblock_energy_output_bus_block", () ->
            new BasicStrengthBiologyMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_biology_multiblock_item_input_port_block", () ->
            new BasicStrengthBiologyMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_biology_multiblock_item_output_port_block", () ->
            new BasicStrengthBiologyMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_biology_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_chemistry_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_chemistry_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_chemistry_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_chemistry_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_chemistry_multiblock_energy_storage_block", () ->
            new BasicStrengthChemistryMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_chemistry_multiblock_item_storage_block", () ->
            new BasicStrengthChemistryMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_chemistry_multiblock_energy_input_bus_block", () ->
            new BasicStrengthChemistryMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_chemistry_multiblock_energy_output_bus_block", () ->
            new BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_chemistry_multiblock_item_input_port_block", () ->
            new BasicStrengthChemistryMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_chemistry_multiblock_item_output_port_block", () ->
            new BasicStrengthChemistryMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_chemistry_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));



    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_energy_storage_block", () ->
            new BasicStrengthDynamicEnergeticsMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_item_storage_block", () ->
            new BasicStrengthDynamicEnergeticsMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_energy_input_bus_block", () ->
            new BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_energy_output_bus_block", () ->
            new BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_item_input_port_block", () ->
            new BasicStrengthDynamicEnergeticsMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_dynamic_energetics_multiblock_item_output_port_block", () ->
            new BasicStrengthDynamicEnergeticsMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_dynamic_energetics_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));



    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_engineering_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_engineering_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_engineering_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_engineering_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_engineering_multiblock_energy_storage_block", () ->
            new BasicStrengthEngineeringMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_engineering_multiblock_item_storage_block", () ->
            new BasicStrengthEngineeringMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_engineering_multiblock_energy_input_bus_block", () ->
            new BasicStrengthEngineeringMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_engineering_multiblock_energy_output_bus_block", () ->
            new BasicStrengthEngineeringMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_engineering_multiblock_item_input_port_block", () ->
            new BasicStrengthEngineeringMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_engineering_multiblock_item_output_port_block", () ->
            new BasicStrengthEngineeringMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_engineering_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_formal_science_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_formal_science_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_formal_science_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_formal_science_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_formal_science_multiblock_energy_storage_block", () ->
            new BasicStrengthFormalScienceMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_formal_science_multiblock_item_storage_block", () ->
            new BasicStrengthFormalScienceMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_formal_science_multiblock_energy_input_bus_block", () ->
            new BasicStrengthFormalScienceMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_formal_science_multiblock_energy_output_bus_block", () ->
            new BasicStrengthFormalScienceMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_formal_science_multiblock_item_input_port_block", () ->
            new BasicStrengthFormalScienceMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_formal_science_multiblock_item_output_port_block", () ->
            new BasicStrengthFormalScienceMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_formal_science_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_geo_science_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_geo_science_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_geo_science_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_geo_science_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_geo_science_multiblock_energy_storage_block", () ->
            new BasicStrengthGeoScienceMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_geo_science_multiblock_item_storage_block", () ->
            new BasicStrengthGeoScienceMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_geo_science_multiblock_energy_input_bus_block", () ->
            new BasicStrengthGeoScienceMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_geo_science_multiblock_energy_output_bus_block", () ->
            new BasicStrengthGeoScienceMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_geo_science_multiblock_item_input_port_block", () ->
            new BasicStrengthGeoScienceMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_geo_science_multiblock_item_output_port_block", () ->
            new BasicStrengthGeoScienceMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_geo_science_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_energy_storage_block", () ->
            new BasicStrengthHybridPhysicsMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_item_storage_block", () ->
            new BasicStrengthHybridPhysicsMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_energy_input_bus_block", () ->
            new BasicStrengthHybridPhysicsMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_energy_output_bus_block", () ->
            new BasicStrengthHybridPhysicsMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_item_input_port_block", () ->
            new BasicStrengthHybridPhysicsMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_hybrid_physics_multiblock_item_output_port_block", () ->
            new BasicStrengthHybridPhysicsMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_hybrid_physics_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_energy_storage_block", () ->
            new BasicStrengthImitationMagicEngineeringMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_item_storage_block", () ->
            new BasicStrengthImitationMagicEngineeringMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_energy_input_bus_block", () ->
            new BasicStrengthImitationMagicEngineeringMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_energy_output_bus_block", () ->
            new BasicStrengthImitationMagicEngineeringMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_item_input_port_block", () ->
            new BasicStrengthImitationMagicEngineeringMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_imitation_magic_engineering_multiblock_item_output_port_block", () ->
            new BasicStrengthImitationMagicEngineeringMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_imitation_magic_engineering_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_energy_storage_block", () ->
            new BasicStrengthJenithVoidScienceMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_item_storage_block", () ->
            new BasicStrengthJenithVoidScienceMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_energy_input_bus_block", () ->
            new BasicStrengthJenithVoidScienceMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_energy_output_bus_block", () ->
            new BasicStrengthJenithVoidScienceMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_item_input_port_block", () ->
            new BasicStrengthJenithVoidScienceMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_jenith_void_science_multiblock_item_output_port_block", () ->
            new BasicStrengthJenithVoidScienceMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_jenith_void_science_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));



    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_BASE_FRAME_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_base_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_BASE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_base_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_MACHINE_FRAME_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_machine_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_MACHINE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_machine_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_structure_frame_block", () ->
            new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_STRUCTURE_FRAME_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_structure_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_structure_glass_block", () ->
            new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_STRUCTURE_GLASS_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_structure_glass_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_energy_storage_block", () ->
            new BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_energy_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_STORAGE_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_item_storage_block", () ->
            new BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_STORAGE_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_item_storage_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_energy_input_bus_block", () ->
            new BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyInputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_energy_input_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_energy_output_bus_block", () ->
            new BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyOutputBusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_energy_output_bus_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_item_input_port_block", () ->
            new BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_item_input_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_BLOCK = registerBlock("basic_strength_kaleidoscopic_reality_science_multiblock_item_output_port_block", () ->
            new BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_HOLO_BLOCK = registerHoloBlock("basic_strength_kaleidoscopic_reality_science_multiblock_item_output_port_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));





    public static final RegistryObject<Block> REDSTONE_POWERED_MACHINE_ELEMENT_MANUFACTURE_MACHINE_BLOCK = registerBlock("redstone_powered_machine_element_manufacture_machine_block", () ->
            new RedstonePoweredMachineElementManufactureMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> REDSTONE_POWERED_MACHINE_PART_MANUFACTURE_MACHINE_BLOCK = registerBlock("redstone_powered_machine_part_manufacture_machine_block", () ->
            new RedstonePoweredMachinePartManufactureMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    // BasicAstronomy
    public static final RegistryObject<Block> BASIC_PERFORMANCE_ASTRONOMICAL_TELESCOPE_BLOCK = registerTooltipBasicMachineBlock("basic_performance_astronomical_telescope_block", () ->
                    new BasicPerformanceAstronomicalTelescopeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_astronomical_telescope_block", "astronomy", "basic");
    public static final RegistryObject<Block> BASIC_PRECISION_OBJECTIVE_LENS_BLOCK = registerTooltipMultiblockAbilityBlock("basic_precision_objective_lens_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_astronomical_telescope_block",
            "astronomy",
            "basic");
    public static final RegistryObject<Block> BASIC_PRECISION_OBJECTIVE_LENS_HOLO_BLOCK = registerHoloBlock("basic_precision_objective_lens_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_FINE_PARTICLE_ADSORBER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_fine_particle_adsorber_block", () ->
                    new BasicPerformanceFineParticleAdsorberBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×4×3",
            "Lv1:3×4×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_fine_particle_adsorber_block", "astronomy", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_FINE_PARTICLE_STORAGE_TANK_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_particle_storage_tank_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_fine_particle_adsorber_block",
            "astronomy",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_FINE_PARTICLE_STORAGE_TANK_HOLO_BLOCK = registerHoloBlock("basic_efficiency_particle_storage_tank_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_STARLIGHT_COLLECTOR_BLOCK = registerTooltipBasicMachineBlock("basic_performance_starlight_collector_block", () ->
                    new BasicPerformanceStarlightCollectorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_starlight_collector_block", "astronomy", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_FAINT_LIGHT_RESERVER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_faint_light_receiver_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_starlight_collector_block",
            "astronomy",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_FAINT_LIGHT_RESERVER_HOLO_BLOCK = registerHoloBlock("basic_efficiency_faint_light_receiver_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));



    // BasicBiology
    public static final RegistryObject<Block> BASIC_PERFORMANCE_BIO_REACTOR_BLOCK = registerTooltipBasicMachineBlock("basic_performance_bio_reactor_block", () ->
                    new BasicPerformanceBioReactorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:5×3×3",
            "Lv1:5×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_bio_reactor_block", "biology", "basic");
    public static final RegistryObject<Block> BASIC_SPEED_CULTIVATION_GREENHOUSE_BLOCK = registerTooltipMultiblockAbilityBlock("basic_speed_cultivation_greenhouse_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_bio_reactor_block",
            "biology",
            "basic");
    public static final RegistryObject<Block> BASIC_SPEED_CULTIVATION_GREENHOUSE_HOLO_BLOCK = registerHoloBlock("basic_speed_cultivation_greenhouse_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_CELL_INCUBATOR_BLOCK = registerTooltipBasicMachineBlock("basic_performance_cell_incubator_block", () ->
                    new BasicPerformanceCellIncubatorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_cell_incubator_block", "biology", "basic");
    public static final RegistryObject<Block> BASIC_DURABILITY_INCUBATION_CONTAINER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_durability_incubation_container_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_cell_incubator_block",
            "biology",
            "basic");
    public static final RegistryObject<Block> BASIC_DURABILITY_INCUBATION_CONTAINER_HOLO_BLOCK = registerHoloBlock("basic_durability_incubation_container_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_CROP_CULTIVATOR_BLOCK = registerTooltipBasicMachineBlock("basic_performance_crop_cultivator_block", () ->
                    new BasicPerformanceCropCultivatorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_crop_cultivator_block", "biology", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_GROWTH_STABILIZER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_growth_stabilizer_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_crop_cultivator_block",
            "biology",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_GROWTH_STABILIZER_HOLO_BLOCK = registerHoloBlock("basic_efficiency_growth_stabilizer_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    // BasicChemistry
    public static final RegistryObject<Block> BASIC_PERFORMANCE_CHEMICAL_REACTOR_BLOCK = registerTooltipBasicMachineBlock("basic_performance_chemical_reactor_block", () ->
                    new BasicPerformanceChemicalReactorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:5×3×3",
            "Lv1:5×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_chemical_reactor_block", "chemistry", "basic");
    public static final RegistryObject<Block> BASIC_RATE_COMPOUND_AGITATION_SYSTEM_BLOCK = registerTooltipMultiblockAbilityBlock("basic_rate_compound_agitation_system_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_chemical_reactor_block",
            "chemistry",
            "basic");
    public static final RegistryObject<Block> BASIC_RATE_COMPOUND_AGITATION_SYSTEM_HOLO_BLOCK = registerHoloBlock("basic_rate_compound_agitation_system_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_COMPOUND_PURIFIER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_compound_purifier_block", () ->
                    new BasicPerformanceCompoundPurifierBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_compound_purifier_block", "chemistry", "basic");
    public static final RegistryObject<Block> BASIC_DURABLE_HIGH_SPPED_CHEMICAL_REACTOR_BLOCK = registerTooltipMultiblockAbilityBlock("basic_durable_high_speed_chemical_reactor_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_compound_purifier_block",
            "chemistry",
            "basic");
    public static final RegistryObject<Block> BASIC_DURABLE_HIGH_SPPED_CHEMICAL_REACTOR_HOLO_BLOCK = registerHoloBlock("basic_durable_high_speed_chemical_reactor_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_ELECTROLYSER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_electrolyser_block", () ->
                    new BasicPerformanceElectrolyserBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:5×3×3",
            "Lv1:5×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_electrolyser_block", "chemistry", "basic");
    public static final RegistryObject<Block> BASIC_DURABLE_EXPANDED_ELECTROLYTIC_CELL_BLOCK = registerTooltipMultiblockAbilityBlock("basic_durable_expanded_electrolytic_cell_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_electrolyser_block",
            "chemistry",
            "basic");
    public static final RegistryObject<Block> BASIC_DURABLE_EXPANDED_ELECTROLYTIC_CELL_HOLO_BLOCK = registerHoloBlock("basic_durable_expanded_electrolytic_cell_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    // BasicDynamicEnergetics
    public static final RegistryObject<Block> BASIC_POWER_STEAM_GENERATOR_BLOCK = registerTooltipBasicMachineBlock("basic_power_steam_generator_block", () ->
                    new BasicPowerSteamGeneratorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Power 16 FE/t",
            "Lv0:Power 32 FE/t",
            "Lv1:Power 48 FE/t",
            "basic_power_steam_generator_block", "dynamic_energetics", "basic");
    public static final RegistryObject<Block> BASIC_ENDURANCE_HIGH_TEMPERATURE_COMBUSTION_CHAMBER_BLOCK = registerTooltipMultiblockAbilityBlock(
            "basic_endurance_high_temperature_combustion_chamber_block", () ->
                    new DCGlassBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(4.0f)),
            "basic_power_steam_generator_block",
            "dynamic_energetics",
            "basic");
    public static final RegistryObject<Block> BASIC_ENDURANCE_HIGH_TEMPERATURE_COMBUSTION_CHAMBER_HOLO_BLOCK = registerHoloBlock("basic_endurance_high_temperature_combustion_chamber_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_COMPRESSION_CONDENSER_BLOCK = registerTooltipBasicMachineBlock("basic_technology_compression_condenser_block", () ->
                    new BasicTechnologyCompressionCondenserBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_compression_condenser_block", "dynamic_energetics", "basic");
    public static final RegistryObject<Block> BASIC_PRESSURE_COMPRESSION_ASSIST_SYSTEM_BLOCK = registerTooltipMultiblockAbilityBlock(
            "basic_pressure_compression_assist_system_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f)),
            "basic_technology_compression_condenser_block",
            "dynamic_energetics",
            "basic");
    public static final RegistryObject<Block> BASIC_PRESSURE_COMPRESSION_ASSIST_SYSTEM_HOLO_BLOCK = registerHoloBlock("basic_pressure_compression_assist_system_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_ELECTROMAGNETIC_INDUCTOR_BLOCK = registerTooltipBasicMachineBlock("basic_technology_electromagnetic_inductor_block", () ->
                    new BasicTechnologyElectromagneticInductorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_electromagnetic_inductor_block", "dynamic_energetics", "basic");
    public static final RegistryObject<Block> BASIC_DURABLE_INSULATED_CHAMBER_BLOCK = registerTooltipMultiblockAbilityBlock(
            "basic_durable_insulated_chamber_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4.0f)),
            "basic_technology_electromagnetic_inductor_block",
            "dynamic_energetics",
            "basic");
    public static final RegistryObject<Block> BASIC_DURABLE_INSULATED_CHAMBER_HOLO_BLOCK = registerHoloBlock("basic_durable_insulated_chamber_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));



    // BasicEngineering
    public static final RegistryObject<Block> BASIC_TECHNOLOGY_MACHINE_MANUFACTURER_BLOCK = registerTooltipBasicMachineBlock("basic_technology_machine_manufacturer_block", () ->
                    new BasicTechnologyMachineManufacturerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_machine_manufacturer_block", "engineering", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_MACHINE_PROCESSING_CHAMBER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_machine_processing_chamber_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_machine_manufacturer_block",
            "engineering",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_MACHINE_PROCESSING_CHAMBER_HOLO_BLOCK = registerHoloBlock("basic_efficiency_machine_processing_chamber_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_MACHINE_ELEMENT_PROCESSOR_BLOCK = registerTooltipBasicMachineBlock("basic_technology_machine_element_processor_block", () ->
                    new BasicTechnologyMachineElementProcessorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_machine_element_processor_block", "engineering", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_MACHINE_ELEMENT_PROCESSING_CHAMBER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_machine_element_processing_chamber_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_machine_element_processor_block",
            "engineering",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_MACHINE_ELEMENT_PROCESSING_CHAMBER_HOLO_BLOCK = registerHoloBlock("basic_efficiency_machine_element_processing_chamber_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_MACHINE_PART_PROCESSOR_BLOCK = registerTooltipBasicMachineBlock("basic_technology_machine_part_processor_block", () ->
                    new BasicTechnologyMachinePartProcessorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_machine_part_processor_block", "engineering", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_MACHINE_PART_PROCESSING_CHAMBER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_machine_part_processing_chamber_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_machine_part_processor_block",
            "engineering",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_MACHINE_PART_PROCESSING_CHAMBER_HOLO_BLOCK = registerHoloBlock("basic_efficiency_machine_part_processing_chamber_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_MULTIBLOCK_EQUIPMENT_FABRICATOR_BLOCK = registerTooltipBasicMachineBlock("basic_technology_multiblock_equipment_fabricator_block", () ->
                    new BasicTechnologyMultiblockEquipmentFabricatorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_multiblock_equipment_fabricator_block", "engineering", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_EQUIPMENT_PRODUCTION_AUXILIARY_SYSTEM_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_equipment_production_auxiliary_system_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_multiblock_equipment_fabricator_block",
            "engineering",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_EQUIPMENT_PRODUCTION_AUXILIARY_SYSTEM_HOLO_BLOCK = registerHoloBlock("basic_efficiency_equipment_production_auxiliary_system_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    // BasicFormalScience
    public static final RegistryObject<Block> BASIC_PERFORMANCE_CIRCUIT_BUILDER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_circuit_builder_block", () ->
                    new BasicPerformanceCircuitBuilderBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_circuit_builder_block", "formal_science", "basic");
    public static final RegistryObject<Block> BASIC_PURITY_CIRCUIT_CLEAN_ROOM_BLOCK = registerTooltipMultiblockAbilityBlock("basic_purity_circuit_clean_room_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_circuit_builder_block",
            "formal_science",
            "basic");
    public static final RegistryObject<Block> BASIC_PURITY_CIRCUIT_CLEAN_ROOM_HOLO_BLOCK = registerHoloBlock("basic_purity_circuit_clean_room_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_MACHINE_DATA_INSTALLER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_machine_data_installer_block", () ->
                    new BasicPerformanceMachineDataInstallerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_machine_data_installer_block", "formal_science", "basic");
    public static final RegistryObject<Block> BASIC_SPEED_DATA_READER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_speed_data_reader_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_machine_data_installer_block",
            "formal_science",
            "basic");
    public static final RegistryObject<Block> BASIC_SPEED_DATA_READER_HOLO_BLOCK = registerHoloBlock("basic_speed_data_reader_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_DESIGNATED_DATA_INJECTOR_BLOCK = registerTooltipBasicMachineBlock("basic_performance_designated_data_injector_block", () ->
                    new BasicPerformanceDesignatedDataInjectorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_designated_data_injector_block", "formal_science", "basic");
    public static final RegistryObject<Block> BASIC_SPEED_CALCULATION_AUXILIARY_WRITE_DEVICE_BLOCK = registerTooltipMultiblockAbilityBlock("basic_speed_calculation_auxiliary_write_device_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_designated_data_injector_block",
            "formal_science",
            "basic");
    public static final RegistryObject<Block> BASIC_SPEED_CALCULATION_AUXILIARY_WRITE_DEVICE_HOLO_BLOCK = registerHoloBlock("basic_speed_calculation_auxiliary_coder_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    // BasicGeoScience
    public static final RegistryObject<Block> BASIC_PERFORMANCE_ORE_SORTER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_ore_sorter_block", () ->
                    new BasicPerformanceOreSorterBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_ore_sorter_block", "geo_science", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_ORE_SORTING_FILTER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_ore_sorting_filter_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_ore_sorter_block",
            "geo_science",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_ORE_SORTING_FILTER_HOLO_BLOCK = registerHoloBlock("basic_efficiency_ore_sorting_filter_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_ROCK_CRASHER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_rock_crasher_block", () ->
                    new BasicPerformanceRockCrasherBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×4×3",
            "Lv1:3×4×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_rock_crasher_block", "geo_science", "basic");
    public static final RegistryObject<Block> BASIC_CRASHING_BASE_BLOCK = registerTooltipMultiblockAbilityBlock("basic_crashing_base_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_rock_crasher_block",
            "geo_science",
            "basic");
    public static final RegistryObject<Block> BASIC_CRASHING_BASE_HOLO_BLOCK = registerHoloBlock("basic_crashing_base_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_SOIL_PURIFIER_BLOCK = registerTooltipBasicMachineBlock("basic_performance_soil_purifier_block", () ->
                    new BasicPerformanceSoilPurifierBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_soil_purifier_block", "geo_science", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_PARTICLE_MIXING_CHAMBER_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_particle_mixing_chamber_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_soil_purifier_block",
            "geo_science",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_PARTICLE_MIXING_CHAMBER_HOLO_BLOCK = registerHoloBlock("basic_efficiency_particle_mixing_chamber_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));




    // BasicHybridPhysics
    public static final RegistryObject<Block> BASIC_PERFORMANCE_ELECTRIC_ARC_FURNACE_BLOCK = registerTooltipBasicMachineBlock("basic_performance_electric_arc_furnace_block", () ->
                    new BasicPerformanceElectricArcFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×4×3",
            "Lv1:3×4×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_electric_arc_furnace_block", "hybrid_physics", "basic");
    public static final RegistryObject<Block> BASIC_FLOW_COOLING_SYSTEM_BLOCK = registerTooltipMultiblockAbilityBlock("basic_flow_cooling_system_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_electric_arc_furnace_block",
            "hybrid_physics",
            "basic");
    public static final RegistryObject<Block> BASIC_FLOW_COOLING_SYSTEM_HOLO_BLOCK = registerHoloBlock("basic_flow_cooling_system_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_FORMING_MACHINE_BLOCK = registerTooltipBasicMachineBlock("basic_performance_forming_machine_block", () ->
                    new BasicPerformanceFormingMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:5×3×3",
            "Lv1:5×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_forming_machine_block", "hybrid_physics", "basic");
    public static final RegistryObject<Block> BASIC_PRECISION_EXTRUSION_ASSIST_SYSTEM_BLOCK = registerTooltipMultiblockAbilityBlock("basic_precision_extrusion_assist_system_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_forming_machine_block",
            "hybrid_physics",
            "basic");
    public static final RegistryObject<Block> BASIC_PRECISION_EXTRUSION_ASSIST_SYSTEM_HOLO_BLOCK = registerHoloBlock("basic_precision_extrusion_assist_system_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_MATERIAL_SEPARATOR_BLOCK = registerTooltipBasicMachineBlock("basic_performance_material_separator_block", () ->
                    new BasicPerformanceMaterialSeparatorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_material_separator_block", "hybrid_physics", "basic");
    public static final RegistryObject<Block> BASIC_DURABILITY_VIBRATION_CONTROL_BASE_BLOCK = registerTooltipMultiblockAbilityBlock("basic_durability_vibration_control_base_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_material_separator_block",
            "hybrid_physics",
            "basic");
    public static final RegistryObject<Block> BASIC_DURABILITY_VIBRATION_CONTROL_BASE_HOLO_BLOCK = registerHoloBlock("basic_durability_vibration_control_base_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    // Basic Imitation Magic Engineering
    public static final RegistryObject<Block> BASIC_TECHNOLOGY_IMITATION_MAGIC_ENGRAVER_BLOCK = registerTooltipBasicMachineBlock("basic_technology_imitation_magic_engraver_block", () ->
                    new BasicTechnologyImitationMagicEngraverBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_imitation_magic_engraver_block", "imitation_magic_engineering", "basic");
    public static final RegistryObject<Block> BASIC_OUTPUT_MYSTIC_OPTICAL_PROJECTION_DEVICE_BLOCK = registerTooltipMultiblockAbilityBlock("basic_output_mystic_optical_projection_device_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_imitation_magic_engraver_block",
            "imitation_magic_engineering",
            "basic");
    public static final RegistryObject<Block> BASIC_OUTPUT_MYSTIC_OPTICAL_PROJECTION_DEVICE_HOLO_BLOCK = registerHoloBlock("basic_output_mystic_optical_projection_device_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_SUSPECTED_MAGIC_CONDENSER_BLOCK = registerTooltipBasicMachineBlock("basic_technology_suspected_magic_condenser_block", () ->
                    new BasicTechnologySuspectedMagicCondenserBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_suspected_magic_condenser_block", "imitation_magic_engineering", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_SEALED_EXTRACTION_CASE_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_sealed_extraction_case_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_suspected_magic_condenser_block",
            "imitation_magic_engineering",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_SEALED_EXTRACTION_CASE_HOLO_BLOCK = registerHoloBlock("basic_efficiency_sealed_extraction_case_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_VIRTUAL_SIGIL_PROCESSOR_BLOCK = registerTooltipBasicMachineBlock("basic_technology_virtual_sigil_processor_block", () ->
                    new BasicTechnologyVirtualSigilProcessorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:3×3×3",
            "Lv1:3×3×3",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_virtual_sigil_processor_block", "imitation_magic_engineering", "basic");
    public static final RegistryObject<Block> BASIC_SPEED_PATTERN_TRANSFER_SYSTEM_BLOCK = registerTooltipMultiblockAbilityBlock("basic_speed_pattern_transfer_system_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_virtual_sigil_processor_block",
            "imitation_magic_engineering",
            "basic");
    public static final RegistryObject<Block> BASIC_SPEED_PATTERN_TRANSFER_SYSTEM_HOLO_BLOCK = registerHoloBlock("basic_speed_pattern_transfer_system_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_TECHNOLOGY_VOID_WORLD_COORDINATE_RECORDING_MACHINE_BLOCK = registerTooltipBasicMachineBlock("basic_technology_void_world_coordinate_recording_machine_block", () ->
                    new BasicTechnologyVoidWorldCoordinateRecordingMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:5×5×5",
            "Lv1:5×5×5",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_technology_void_world_coordinate_recording_machine_block", "jenith_void_science", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_VOID_INTERFERENCE_FLAME_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_void_interference_frame_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_technology_void_world_coordinate_recording_machine_block",
            "jenith_void_science",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_VOID_INTERFERENCE_FLAME_HOLO_BLOCK = registerHoloBlock("basic_efficiency_void_interference_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));

    public static final RegistryObject<Block> BASIC_PERFORMANCE_REALITY_PHASE_ADJUSTMENT_MACHINE_BLOCK = registerTooltipBasicMachineBlock("basic_performance_reality_phase_adjustment_machine_block", () ->
                    new BasicPerformanceRealityPhaseAdjustmentMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "Lv0:5×5×5",
            "Lv1:5×5×5",
            "Base:Speed ×1.00,Energy Usage ×1.00",
            "Lv0:Speed ×2.00,Energy Usage ×1.50",
            "Lv1:Speed ×3.00,Energy Usage ×2.00",
            "basic_performance_reality_phase_adjustment_machine_block", "kaleidoscopic_reality_science", "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_PHASE_STABLE_FLAME_BLOCK = registerTooltipMultiblockAbilityBlock("basic_efficiency_phase_stable_frame_block", () ->
                    new DCBlockBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            "basic_performance_reality_phase_adjustment_machine_block",
            "kaleidoscopic_reality_science",
            "basic");
    public static final RegistryObject<Block> BASIC_EFFICIENCY_PHASE_STABLE_FLAME_HOLO_BLOCK = registerHoloBlock("basic_efficiency_phase_stable_frame_holo_block", () ->
            new DCHoloBlockBase(BlockBehaviour.Properties.copy(Blocks.GLASS).destroyTime(0.0F).strength(0.0F)));







    public static final RegistryObject<Block> BASIC_ITEM_PIPE_BLOCK = registerBlock("basic_item_pipe_block", BasicItemPipeBlock::new);
    public static final RegistryObject<Block> BASIC_ENERGY_PIPE_BLOCK = registerBlock("basic_energy_pipe_block", BasicEnergyPipeBlock::new);
    public static final RegistryObject<Block> LOW_ENERGY_PIPE_BLOCK = registerBlock("low_energy_pipe_block", LowEnergyPipeBlock::new);
    public static final RegistryObject<Block> FLOAT_ENERGY_PIPE_BLOCK = registerBlock("float_energy_pipe_block", FloatEnergyPipeBlock::new);



    public static final RegistryObject<Block> TEST_MACHINE_BLOCK = registerBlock("test_machine_block", () ->
            new TestMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return DCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerTooltipMeterialElementBlock(String name, Supplier<T> block, String atomicName, String phase) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerTooltipMeterialElementBlockItem(name, toReturn, atomicName, phase);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerTooltipMeterialElementBlockItem(
            String name,
            Supplier<T> block,
            String atomicName,
            String phase
    ) {
        return DCItems.ITEMS.register(name, () ->
                new BlockItem(block.get(), new Item.Properties()) {

                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {

                        if (Screen.hasShiftDown()) {

                            switch (phase) {
                                case "initial" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0xFFFFFF)));
                                case "basic" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0xFF0000)));
                                case "low" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0xFF8000)));
                                case "medium" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0xFFFF00)));
                                case "high" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0x80FF00)));
                                case "super" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0x00FF00)));
                                case "over" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0x00FFFF)));
                                case "ultra" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0x0080FF)));
                                case "anti" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0x0000FF)));
                                case "imaginary" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0xFF00FF)));
                                case "infinity" ->
                                        pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp." + phase).withStyle(style -> style.withColor(0x808080)));
                                default -> throw new IllegalStateException("Unexpected value: " + phase);
                            }

                            pTooltip.add(Component.translatable("tooltip.degeneracycraft." + atomicName + ".name").withStyle(style -> style.withColor(0xFFFFFF)));
                            pTooltip.add(Component.translatable("tooltip.degeneracycraft." + atomicName + ".number").withStyle(style -> style.withColor(0xFF8000)));
                            pTooltip.add(Component.translatable("tooltip.degeneracycraft." + atomicName + ".weight").withStyle(style -> style.withColor(0xFF00FF)));
                            pTooltip.add(Component.translatable("tooltip.degeneracycraft." + atomicName + ".melting").withStyle(style -> style.withColor(0x0080FF)));
                            pTooltip.add(Component.translatable("tooltip.degeneracycraft." + atomicName + ".boiling").withStyle(style -> style.withColor(0xFF0000)));
                            pTooltip.add(Component.translatable("tooltip.degeneracycraft." + atomicName + ".formula").withStyle(style -> style.withColor(0x00FFFF)));

                        } else {
                            pTooltip.add(Component.translatable("tooltip.degeneracycraft.tooltipitem").withStyle(style -> style.withColor(0xFFFF00)));
                        }
                    }
                }
                
                
        );
    }

    private static <T extends Block> RegistryObject<T> registerTooltipBasicMachineBlock(String name, Supplier<T> block, String lv0MachineSize, String lv1MachineSize,
                                                                                        String basePara, String lv0Para, String lv1Para, String machineName, String scienceName, String phase) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerTooltipBasicMachineBlockItem(name, toReturn, lv0MachineSize, lv1MachineSize, basePara, lv0Para, lv1Para, machineName, scienceName, phase);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerTooltipBasicMachineBlockItem(String name, RegistryObject<T> block, String lv0MachineSize, String lv1MachineSize,
                                                                                               String basePara, String lv0Para, String lv1Para, String machineName, String scienceName, String phase) {
        return DCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {
                if (Screen.hasShiftDown()) {
                    pTooltip.add(Component.translatable("tooltip.degeneracycraft." + machineName).withStyle(style -> style.withColor(0xFFFFFF)));
                    switch (scienceName) {
                        case "astronomy" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF00FF)).withStyle(ChatFormatting.BOLD)));
                        case "biology" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x80FF00)).withStyle(ChatFormatting.BOLD)));
                        case "chemistry" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x0080FF)).withStyle(ChatFormatting.BOLD)));
                        case "dynamic_energetics" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x808080)).withStyle(ChatFormatting.BOLD)));
                        case "engineering" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x404040)).withStyle(ChatFormatting.BOLD)));
                        case "formal_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x00FFFF)).withStyle(ChatFormatting.BOLD)));
                        case "geo_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFFFF00)).withStyle(ChatFormatting.BOLD)));
                        case "hybrid_physics" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF0000)).withStyle(ChatFormatting.BOLD)));
                        case "imitation_magic_engineering" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFFFFFF)).withStyle(ChatFormatting.BOLD)));
                        case "jenith_void_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF8000)).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.UNDERLINE)));
                        case "kaleidoscopic_reality_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF8000)).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.UNDERLINE)));
                    }
                    switch (phase) {
                        case "initial" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFFFFFF))));
                        case "basic" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFF0000))));
                        case "low" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFF8000))));
                        case "medium" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFFFF00))));
                        case "high" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x80FF00))));
                        case "super" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x00FF00))));
                        case "over" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x00FFFF))));
                        case "ultra" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x0080FF))));
                        case "anti" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x0000FF))));
                        case "imaginary" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFF00FF))));
                        case "infinity" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x808080))));

                        default -> throw new IllegalStateException("Unexpected value: " + phase);
                    }
                } else {
                    pTooltip.add(Component.translatable("tooltip.degeneracycraft.tooltipitem").withStyle(style -> style.withColor(0xFFFF00)));
                }
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerTooltipMultiblockAbilityBlock(String name, Supplier<T> block, String machineName, String scienceName, String phase) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerTooltipMultiblockAbilityBlockItem(name, toReturn, machineName, scienceName, phase);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerTooltipMultiblockAbilityBlockItem(String name, RegistryObject<T> block,
                                                                                                    String machineName, String scienceName, String phase) {
        return DCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {
                if (Screen.hasShiftDown()) {
                    pTooltip.add(Component.translatable("tooltip.degeneracycraft.ability" + machineName).withStyle(style -> style.withColor(0xFFFFFF)));
                    switch (scienceName) {
                        case "astronomy" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF00FF))));
                        case "biology" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x80FF00))));
                        case "chemistry" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x0080FF))));
                        case "dynamic_energetics" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x404040))));
                        case "engineering" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x808080))));
                        case "formal_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0x00FFFF))));
                        case "geo_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFFFF00))));
                        case "hybrid_physics" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF0000))));
                        case "imitation_magic_engineering" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFFFFFF))));
                        case "jenith_void_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF8000)).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.UNDERLINE)));
                        case "kaleidoscopic_reality_science" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.science").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(scienceName).withStyle(style -> style.withColor(0xFF8000)).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.UNDERLINE)));
                    }
                    switch (phase) {
                        case "initial" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFFFFFF))));
                        case "basic" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFF0000))));
                        case "low" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFF8000))));
                        case "medium" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFFFF00))));
                        case "high" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x80FF00))));
                        case "super" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x00FF00))));
                        case "over" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x00FFFF))));
                        case "ultra" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x0080FF))));
                        case "anti" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x0000FF))));
                        case "imaginary" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0xFF00FF))));
                        case "infinity" ->
                                pTooltip.add(Component.translatable("tooltip.degeneracycraft.ipp").withStyle(style -> style.withColor(0x808080)).append(Component.translatable(phase).withStyle(style -> style.withColor(0x808080))));

                        default -> throw new IllegalStateException("Unexpected value: " + phase);
                    }
                } else {
                    pTooltip.add(Component.translatable("tooltip.degeneracycraft.tooltipitem").withStyle(style -> style.withColor(0xFFFF00)));
                }
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerHoloBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerHoloBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerHoloBlockItem(String name, RegistryObject<T> block) {
        DCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(0)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
