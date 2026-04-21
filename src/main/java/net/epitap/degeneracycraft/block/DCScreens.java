package net.epitap.degeneracycraft.block;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine.RedstonePoweredMachineElementManufactureMachineScreen;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_part_manufacture_machine.RedstonePoweredMachinePartManufactureMachineScreen;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope.BasicPerformanceAstronomicalTelescopeScreen;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_fine_particle_adsorber.BasicPerformanceFineParticleAdsorberScreen;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_starlight_collector.BasicPerformanceStarlightCollectorScreen;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor.BasicPerformanceBioReactorScreen;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_cell_incubator.BasicPerformanceCellIncubatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_crop_cultivator.BasicPerformanceCropCultivatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_chemical_reactor.BasicPerformanceChemicalReactorScreen;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_compound_purifier.BasicPerformanceCompoundPurifierScreen;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser.BasicPerformanceElectrolyserScreen;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_power_steam_generator.BasicPowerSteamGeneratorScreen;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_compression_condenser.BasicTechnologyCompressionCondenserScreen;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor.BasicTechnologyElectromagneticInductorScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_manufacturer.BasicTechnologyMachineManufacturerScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_part_processor.BasicTechnologyMachinePartProcessorScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_multiblock_equipment_fabricator.BasicTechnologyMultiblockEquipmentFabricatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_circuit_builder.BasicPerformanceCircuitBuilderScreen;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_designated_data_injector.BasicPerformanceDesignatedDataInjectorScreen;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerScreen;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_ore_sorter.BasicPerformanceOreSorterScreen;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherScreen;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_soil_purifier.BasicPerformanceSoilPurifierScreen;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_electric_arc_furnace.BasicPerformanceElectricArcFurnaceScreen;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_forming_machine.BasicPerformanceFormingMachineScreen;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_material_separator.BasicPerformanceMaterialSeparatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_imitation_magic_engraver.BasicTechnologyImitationMagicEngraverScreen;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserScreen;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorScreen;
import net.epitap.degeneracycraft.block.machine.basic.jenith_void_science.basic_technology_void_world_coordinate_recording_machine.BasicTechnologyVoidWorldCoordinateRecordingMachineScreen;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineScreen;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.energy.energy_storage.BasicStrengthAstronomyMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.energy.input_bus.BasicStrengthAstronomyMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.energy.output_bus.BasicStrengthAstronomyMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.item_storage.BasicStrengthAstronomyMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.input_port.BasicStrengthAstronomyMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.output_port.BasicStrengthAstronomyMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.biology.energy.energy_storage.BasicStrengthBiologyMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.biology.energy.input_bus.BasicStrengthBiologyMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.biology.energy.output_bus.BasicStrengthBiologyMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.item_storage.BasicStrengthBiologyMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.input_port.BasicStrengthBiologyMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.output_port.BasicStrengthBiologyMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.energy.energy_storage.BasicStrengthChemistryMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.energy.input_bus.BasicStrengthChemistryMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.energy.output_bus.BasicStrengthChemistryMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.item_storage.BasicStrengthChemistryMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.input_port.BasicStrengthChemistryMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.output_port.BasicStrengthChemistryMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.energy_storage.BasicStrengthDynamicEnergeticsMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.input_bus.BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.output_bus.BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.item_storage.BasicStrengthDynamicEnergeticsMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.input_port.BasicStrengthDynamicEnergeticsMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.output_port.BasicStrengthDynamicEnergeticsMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.engineering.energy.energy_storage.BasicStrengthEngineeringMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.engineering.energy.input_bus.BasicStrengthEngineeringMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.engineering.energy.output_bus.BasicStrengthEngineeringMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.item_storage.BasicStrengthEngineeringMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.input_port.BasicStrengthEngineeringMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.output_port.BasicStrengthEngineeringMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.energy_storage.BasicStrengthFormalScienceMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.input_bus.BasicStrengthFormalScienceMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.output_bus.BasicStrengthFormalScienceMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.item_storage.BasicStrengthFormalScienceMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.input_port.BasicStrengthFormalScienceMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.output_port.BasicStrengthFormalScienceMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.energy.energy_storage.BasicStrengthGeoScienceMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.energy.input_bus.BasicStrengthGeoScienceMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.energy.output_bus.BasicStrengthGeoScienceMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.item_storage.BasicStrengthGeoScienceMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.input_port.BasicStrengthGeoScienceMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.output_port.BasicStrengthGeoScienceMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.energy_storage.BasicStrengthHybridPhysicsMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.input_bus.BasicStrengthHybridPhysicsMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.energy.output_bus.BasicStrengthHybridPhysicsMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.item_storage.BasicStrengthHybridPhysicsMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.input_port.BasicStrengthHybridPhysicsMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.output_port.BasicStrengthHybridPhysicsMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.energy.energy_storage.BasicStrengthImitationMagicEngineeringMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.energy.input_bus.BasicStrengthImitationMagicEngineeringMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.energy.output_bus.BasicStrengthImitationMagicEngineeringMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.item_storage.BasicStrengthImitationMagicEngineeringMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.input_port.BasicStrengthImitationMagicEngineeringMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.output_port.BasicStrengthImitationMagicEngineeringMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.energy.energy_storage.BasicStrengthJenithVoidScienceMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.energy.input_bus.BasicStrengthJenithVoidScienceMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.energy.output_bus.BasicStrengthJenithVoidScienceMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.item_storage.BasicStrengthJenithVoidScienceMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.input_port.BasicStrengthJenithVoidScienceMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.output_port.BasicStrengthJenithVoidScienceMultiblockItemOutputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.energy.energy_storage.BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.energy.input_bus.BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyInputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.energy.output_bus.BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyOutputBusScreen;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.item_storage.BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageScreen;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.input_port.BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortScreen;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.output_port.BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Degeneracycraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DCScreens {

    @SubscribeEvent
    public static void registerScreens(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {

            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthAstronomyMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthAstronomyMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthAstronomyMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthAstronomyMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthAstronomyMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ASTRONOMY_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthAstronomyMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthBiologyMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthBiologyMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthBiologyMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthBiologyMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthBiologyMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_BIOLOGY_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthBiologyMultiblockItemOutputPortScreen::new);


            
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthChemistryMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthChemistryMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthChemistryMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthChemistryMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthChemistryMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_CHEMISTRY_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthChemistryMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthDynamicEnergeticsMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthDynamicEnergeticsMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthDynamicEnergeticsMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_DYNAMIC_ENERGETICS_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthDynamicEnergeticsMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthEngineeringMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthEngineeringMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthEngineeringMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthEngineeringMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthEngineeringMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthEngineeringMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthFormalScienceMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthFormalScienceMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthFormalScienceMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthFormalScienceMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthFormalScienceMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_FORMAL_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthFormalScienceMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthGeoScienceMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthGeoScienceMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthGeoScienceMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthGeoScienceMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthGeoScienceMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_GEO_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthGeoScienceMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthHybridPhysicsMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthHybridPhysicsMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthHybridPhysicsMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthHybridPhysicsMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthHybridPhysicsMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthHybridPhysicsMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthImitationMagicEngineeringMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthImitationMagicEngineeringMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthImitationMagicEngineeringMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthImitationMagicEngineeringMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthImitationMagicEngineeringMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_IMITATION_MAGIC_ENGINEERING_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthImitationMagicEngineeringMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthJenithVoidScienceMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthJenithVoidScienceMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthJenithVoidScienceMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthJenithVoidScienceMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthJenithVoidScienceMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_JENITH_VOID_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthJenithVoidScienceMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_STORAGE_MENU.get(),
                    BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_INPUT_BUS_MENU.get(),
                    BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyInputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ENERGY_OUTPUT_BUS_MENU.get(),
                    BasicStrengthKaleidoscopicRealityScienceMultiblockEnergyOutputBusScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_STORAGE_MENU.get(),
                    BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_INPUT_PORT_MENU.get(),
                    BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_STRENGTH_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCK_ITEM_OUTPUT_PORT_MENU.get(),
                    BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortScreen::new);



            MenuScreens.register(DCMenuTypes.REDSTONE_POWERED_MACHINE_ELEMENT_MANUFACTURE_MACHINE_MENU.get(),
                    RedstonePoweredMachineElementManufactureMachineScreen::new);
            MenuScreens.register(DCMenuTypes.REDSTONE_POWERED_MACHINE_PART_MANUFACTURE_MACHINE_MENU.get(),
                    RedstonePoweredMachinePartManufactureMachineScreen::new);

            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_ASTROMICAL_TELESCOPE_MENU.get(),
                    BasicPerformanceAstronomicalTelescopeScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_FINE_PARTICLE_ADSORBER_MENU.get(),
                    BasicPerformanceFineParticleAdsorberScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_STARLIGHT_COLLECTOR_MENU.get(),
                    BasicPerformanceStarlightCollectorScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_BIO_REACTOR_MENU.get(),
                    BasicPerformanceBioReactorScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_CELL_INCUBATOR_MENU.get(),
                    BasicPerformanceCellIncubatorScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_CROP_CULTIVATOR_MENU.get(),
                    BasicPerformanceCropCultivatorScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_CHEMICAL_REACTOR_MENU.get(),
                    BasicPerformanceChemicalReactorScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_COMPOUND_PURIFIER_MENU.get(),
                    BasicPerformanceCompoundPurifierScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_ELECTROLYSER_MENU.get(),
                    BasicPerformanceElectrolyserScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_POWER_STEAM_GENERATOR_MENU.get(),
                    BasicPowerSteamGeneratorScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_COMPRESSION_CONDENSER_MENU.get(),
                    BasicTechnologyCompressionCondenserScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_ELECTROMAGNETIC_INDUCTOR_MENU.get(),
                    BasicTechnologyElectromagneticInductorScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_MACHINE_MANUFACTURER_MENU.get(),
                    BasicTechnologyMachineManufacturerScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_MACHINE_ELEMENT_PROCESSOR_MENU.get(),
                    BasicTechnologyMachineElementProcessorScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_MACHINE_PART_PROCESSOR_MENU.get(),
                    BasicTechnologyMachinePartProcessorScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_MULTIBLOCK_EQUIPMENT_FABRICATOR_MENU.get(),
                    BasicTechnologyMultiblockEquipmentFabricatorScreen::new);




            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_CIRCUIT_BUILDER_MENU.get(),
                    BasicPerformanceCircuitBuilderScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_MACHINE_DARA_INSTALLER_MENU.get(),
                    BasicPerformanceMachineDataInstallerScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_DESIGNATED_DATA_INJECTOR_MENU.get(),
                    BasicPerformanceDesignatedDataInjectorScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_ORE_SORTER_MENU.get(),
                    BasicPerformanceOreSorterScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_ROCK_CRASHER_MENU.get(),
                    BasicPerformanceRockCrasherScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_SOIL_PURIFIER_MENU.get(),
                    BasicPerformanceSoilPurifierScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_ELECTRIC_ARC_FURNACE_MENU.get(),
                    BasicPerformanceElectricArcFurnaceScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_FORMING_MACHINE_MENU.get(),
                    BasicPerformanceFormingMachineScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_MATERIAL_SEPARATOR_MENU.get(),
                    BasicPerformanceMaterialSeparatorScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_IMITATION_MAGIC_ENGRAVER_MENU.get(),
                    BasicTechnologyImitationMagicEngraverScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_SUSPECTED_MAGIC_CONDENSER_MENU.get(),
                    BasicTechnologySuspectedMagicCondenserScreen::new);
            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_VIRTUAL_SIGIL_PROCESSOR_MENU.get(),
                    BasicTechnologyVirtualSigilProcessorScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_TECHNOLOGY_VOID_WORLD_COORDINATE_RECORDING_MACHINE_MENU.get(),
                    BasicTechnologyVoidWorldCoordinateRecordingMachineScreen::new);


            MenuScreens.register(DCMenuTypes.BASIC_PERFORMANCE_REALITY_PHASE_ADJUSTMENT_MACHINE_MENU.get(),
                    BasicPerformanceRealityPhaseAdjustmentMachineScreen::new);

        });
    }
}
