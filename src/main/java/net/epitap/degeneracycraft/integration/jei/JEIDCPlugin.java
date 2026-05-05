package net.epitap.degeneracycraft.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope.BasicPerformanceAstronomicalTelescopeBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope.BasicPerformanceAstronomicalTelescopeMenu;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope.BasicPerformanceAstronomicalTelescopeScreen;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope.BasicPerformanceAstronomicalTelescopeTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_fine_particle_adsorber.BasicPerformanceFineParticleAdsorberBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_fine_particle_adsorber.BasicPerformanceFineParticleAdsorberMenu;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_fine_particle_adsorber.BasicPerformanceFineParticleAdsorberScreen;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_fine_particle_adsorber.BasicPerformanceFineParticleAdsorberTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_starlight_collector.BasicPerformanceStarlightCollectorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_starlight_collector.BasicPerformanceStarlightCollectorMenu;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_starlight_collector.BasicPerformanceStarlightCollectorScreen;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_starlight_collector.BasicPerformanceStarlightCollectorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor.BasicPerformanceBioReactorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor.BasicPerformanceBioReactorMenu;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor.BasicPerformanceBioReactorScreen;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor.BasicPerformanceBioReactorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_cell_incubator.BasicPerformanceCellIncubatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_cell_incubator.BasicPerformanceCellIncubatorMenu;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_cell_incubator.BasicPerformanceCellIncubatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_cell_incubator.BasicPerformanceCellIncubatorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_crop_cultivator.BasicPerformanceCropCultivatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_crop_cultivator.BasicPerformanceCropCultivatorMenu;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_crop_cultivator.BasicPerformanceCropCultivatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_crop_cultivator.BasicPerformanceCropCultivatorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_chemical_reactor.BasicPerformanceChemicalReactorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_chemical_reactor.BasicPerformanceChemicalReactorMenu;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_chemical_reactor.BasicPerformanceChemicalReactorScreen;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_chemical_reactor.BasicPerformanceChemicalReactorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_compound_purifier.BasicPerformanceCompoundPurifierBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_compound_purifier.BasicPerformanceCompoundPurifierMenu;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_compound_purifier.BasicPerformanceCompoundPurifierScreen;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_compound_purifier.BasicPerformanceCompoundPurifierTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser.BasicPerformanceElectrolyserBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser.BasicPerformanceElectrolyserMenu;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser.BasicPerformanceElectrolyserScreen;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser.BasicPerformanceElectrolyserTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_compression_condenser.BasicTechnologyCompressionCondenserBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_compression_condenser.BasicTechnologyCompressionCondenserMenu;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_compression_condenser.BasicTechnologyCompressionCondenserScreen;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_compression_condenser.BasicTechnologyCompressionCondenserTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor.BasicTechnologyElectromagneticInductorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor.BasicTechnologyElectromagneticInductorMenu;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor.BasicTechnologyElectromagneticInductorScreen;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor.BasicTechnologyElectromagneticInductorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorMenu;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_manufacturer.BasicTechnologyMachineManufacturerBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_manufacturer.BasicTechnologyMachineManufacturerMenu;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_manufacturer.BasicTechnologyMachineManufacturerScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_manufacturer.BasicTechnologyMachineManufacturerTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_part_processor.BasicTechnologyMachinePartProcessorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_part_processor.BasicTechnologyMachinePartProcessorMenu;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_part_processor.BasicTechnologyMachinePartProcessorScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_part_processor.BasicTechnologyMachinePartProcessorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_multiblock_equipment_fabricator.BasicTechnologyMultiblockEquipmentFabricatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_multiblock_equipment_fabricator.BasicTechnologyMultiblockEquipmentFabricatorMenu;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_multiblock_equipment_fabricator.BasicTechnologyMultiblockEquipmentFabricatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_multiblock_equipment_fabricator.BasicTechnologyMultiblockEquipmentFabricatorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_circuit_builder.BasicPerformanceCircuitBuilderBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_circuit_builder.BasicPerformanceCircuitBuilderMenu;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_circuit_builder.BasicPerformanceCircuitBuilderScreen;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_circuit_builder.BasicPerformanceCircuitBuilderTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_designated_data_injector.BasicPerformanceDesignatedDataInjectorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_designated_data_injector.BasicPerformanceDesignatedDataInjectorMenu;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_designated_data_injector.BasicPerformanceDesignatedDataInjectorScreen;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_designated_data_injector.BasicPerformanceDesignatedDataInjectorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerMenu;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerScreen;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_ore_sorter.BasicPerformanceOreSorterBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_ore_sorter.BasicPerformanceOreSorterMenu;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_ore_sorter.BasicPerformanceOreSorterScreen;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_ore_sorter.BasicPerformanceOreSorterTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherMenu;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherScreen;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_soil_purifier.BasicPerformanceSoilPurifierBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_soil_purifier.BasicPerformanceSoilPurifierMenu;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_soil_purifier.BasicPerformanceSoilPurifierScreen;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_soil_purifier.BasicPerformanceSoilPurifierTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_electric_arc_furnace.BasicPerformanceElectricArcFurnaceBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_electric_arc_furnace.BasicPerformanceElectricArcFurnaceMenu;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_electric_arc_furnace.BasicPerformanceElectricArcFurnaceScreen;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_electric_arc_furnace.BasicPerformanceElectricArcFurnaceTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_forming_machine.BasicPerformanceFormingMachineBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_forming_machine.BasicPerformanceFormingMachineMenu;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_forming_machine.BasicPerformanceFormingMachineScreen;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_forming_machine.BasicPerformanceFormingMachineTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_material_separator.BasicPerformanceMaterialSeparatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_material_separator.BasicPerformanceMaterialSeparatorMenu;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_material_separator.BasicPerformanceMaterialSeparatorScreen;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_material_separator.BasicPerformanceMaterialSeparatorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_imitation_magic_engraver.BasicTechnologyImitationMagicEngraverBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_imitation_magic_engraver.BasicTechnologyImitationMagicEngraverMenu;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_imitation_magic_engraver.BasicTechnologyImitationMagicEngraverScreen;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_imitation_magic_engraver.BasicTechnologyImitationMagicEngraverTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserMenu;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserScreen;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorMenu;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorScreen;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.jenith_void_science.basic_technology_void_world_coordinate_recording_machine.BasicTechnologyVoidWorldCoordinateRecordingMachineBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.jenith_void_science.basic_technology_void_world_coordinate_recording_machine.BasicTechnologyVoidWorldCoordinateRecordingMachineMenu;
import net.epitap.degeneracycraft.block.machine.basic.jenith_void_science.basic_technology_void_world_coordinate_recording_machine.BasicTechnologyVoidWorldCoordinateRecordingMachineScreen;
import net.epitap.degeneracycraft.block.machine.basic.jenith_void_science.basic_technology_void_world_coordinate_recording_machine.BasicTechnologyVoidWorldCoordinateRecordingMachineTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineMenu;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineScreen;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineTransferHandler;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine.RedstonePoweredMachineElementManufactureMachineBlockEntity;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine.RedstonePoweredMachineElementManufactureMachineMenu;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine.RedstonePoweredMachineElementManufactureMachineScreen;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine.RedstonePoweredMachineElementManufactureMachineTransferHandler;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_part_manufacture_machine.RedstonePoweredMachinePartManufactureMachineBlockEntity;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_part_manufacture_machine.RedstonePoweredMachinePartManufactureMachineMenu;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_part_manufacture_machine.RedstonePoweredMachinePartManufactureMachineScreen;
import net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_part_manufacture_machine.RedstonePoweredMachinePartManufactureMachineTransferHandler;
import net.epitap.degeneracycraft.block.test.TestMachineMenu;
import net.epitap.degeneracycraft.block.test.TestMachineScreen;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.astronomical_telescope.AstronomicalTelescopeRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.astronomical_telescope.AstronomicalTelescopeRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.fine_particle_adsorber.FineParticleAdsorberRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.fine_particle_adsorber.FineParticleAdsorberRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.starlight_collector.StarlightCollectorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.starlight_collector.StarlightCollectorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.biology.bio_reactor.BioReactorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.biology.bio_reactor.BioReactorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.biology.cell_incubator.CellIncubatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.biology.cell_incubator.CellIncubatorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.biology.crop_cultivator.CropCultivatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.biology.crop_cultivator.CropCultivatorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.chemical_reactor.ChemicalReactorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.chemical_reactor.ChemicalReactorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.compound_purifier.CompoundPurifierRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.compound_purifier.CompoundPurifierRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.electrolyser.ElectrolyserRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.electrolyser.ElectrolyserRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.compression_condenser.CompressionCondenserRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.compression_condenser.CompressionCondenserRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.electromagnetic_inductor.ElectromagneticInductorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.electromagnetic_inductor.ElectromagneticInductorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.steam_generator.SteamGeneratorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.steam_generator.SteamGeneratorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_element_processor.MachineElementProcessorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_element_processor.MachineElementProcessorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_manufacturer.MachineManufacturerRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_manufacturer.MachineManufacturerRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_part_processor.MachinePartProcessorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_part_processor.MachinePartProcessorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.multiblock_equipment_fabricator.MultiblockEquipmentFabricatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.multiblock_equipment_fabricator.MultiblockEquipmentFabricatorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.circuit_builder.CircuitBuilderRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.circuit_builder.CircuitBuilderRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.designated_data_injector.DesignatedDataInjectorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.designated_data_injector.DesignatedDataInjectorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.machine_data_installer.MachineDataInstallerRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.machine_data_installer.MachineDataInstallerRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.ore_sorter.OreSorterRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.ore_sorter.OreSorterRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.rock_crasher.RockCrasherRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.rock_crasher.RockCrasherRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.soil_purifier.SoilPurifierRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.soil_purifier.SoilPurifierRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.electric_arc_furnace.ElectricArcFurnaceRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.electric_arc_furnace.ElectricArcFurnaceRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.forming_machine.FormingMachineRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.forming_machine.FormingMachineRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.material_separator.MaterialSeparatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.material_separator.MaterialSeparatorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.imitation_magic_engraver.ImitationMagicEngraverRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.imitation_magic_engraver.ImitationMagicEngraverRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.suspected_magic_condenser.SuspectedMagicCondenserRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.suspected_magic_condenser.SuspectedMagicCondenserRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.virtual_sigil_processor.VirtualSigilProcessorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.virtual_sigil_processor.VirtualSigilProcessorRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.jenith_void_science.void_world_coordinate_recording_machine.VoidWorldCoordinateRecordingMachineRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.jenith_void_science.void_world_coordinate_recording_machine.VoidWorldCoordinateRecordingMachineRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.basic.kaleidoscopic_reality_science.reality_phase_adjustment_machine.RealityPhaseAdjustmentMachineRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.kaleidoscopic_reality_science.reality_phase_adjustment_machine.RealityPhaseAdjustmentMachineRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.test.TestMachineRecipe;
import net.epitap.degeneracycraft.integration.jei.test.TestMachineRecipeCategory;
import net.epitap.degeneracycraft.integration.jei.test.TestMachineRecipeTransferHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIDCPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Degeneracycraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                AstronomicalTelescopeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                FineParticleAdsorberRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                StarlightCollectorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));



        registration.addRecipeCategories(new
                BioReactorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                CellIncubatorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                CropCultivatorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));



        registration.addRecipeCategories(new
                ChemicalReactorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                CompoundPurifierRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                ElectrolyserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));




        registration.addRecipeCategories(new
                CompressionCondenserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                ElectromagneticInductorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                SteamGeneratorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));


        registration.addRecipeCategories(new
                MachineElementProcessorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                MachineManufacturerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                MachinePartProcessorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                MultiblockEquipmentFabricatorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));



        registration.addRecipeCategories(new
                CircuitBuilderRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                MachineDataInstallerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                DesignatedDataInjectorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));


        registration.addRecipeCategories(new
                OreSorterRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                RockCrasherRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                SoilPurifierRecipeCategory(registration.getJeiHelpers().getGuiHelper()));



        registration.addRecipeCategories(new
                ElectricArcFurnaceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                FormingMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                MaterialSeparatorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));




        registration.addRecipeCategories(new
                ImitationMagicEngraverRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                SuspectedMagicCondenserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                VirtualSigilProcessorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));



        registration.addRecipeCategories(new
                VoidWorldCoordinateRecordingMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));




        registration.addRecipeCategories(new
                RealityPhaseAdjustmentMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(
                new TestMachineRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();


        List<AstronomicalTelescopeRecipe> astronomicalTelescopeRecipe =
                rm.getAllRecipesFor(AstronomicalTelescopeRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(AstronomicalTelescopeRecipeCategory.UID, AstronomicalTelescopeRecipe.class), astronomicalTelescopeRecipe);
        List<FineParticleAdsorberRecipe> fineParticleAdsorberRecipe =
                rm.getAllRecipesFor(FineParticleAdsorberRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(FineParticleAdsorberRecipeCategory.UID, FineParticleAdsorberRecipe.class), fineParticleAdsorberRecipe);
        List<StarlightCollectorRecipe> starlightCollectorRecipe =
                rm.getAllRecipesFor(StarlightCollectorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(StarlightCollectorRecipeCategory.UID, StarlightCollectorRecipe.class), starlightCollectorRecipe);



        List<BioReactorRecipe> bioReactorRecipe =
                rm.getAllRecipesFor(BioReactorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(BioReactorRecipeCategory.UID, BioReactorRecipe.class), bioReactorRecipe);
        List<CellIncubatorRecipe> cellIncubatorRecipe =
                rm.getAllRecipesFor(CellIncubatorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(CellIncubatorRecipeCategory.UID, CellIncubatorRecipe.class), cellIncubatorRecipe);
        List<CropCultivatorRecipe> cropCultivatorRecipe =
                rm.getAllRecipesFor(CropCultivatorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(CropCultivatorRecipeCategory.UID, CropCultivatorRecipe.class), cropCultivatorRecipe);



        List<ChemicalReactorRecipe> chemicalReactorRecipe =
                rm.getAllRecipesFor(ChemicalReactorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(ChemicalReactorRecipeCategory.UID, ChemicalReactorRecipe.class), chemicalReactorRecipe);
        List<CompoundPurifierRecipe> compoundPurifierRecipe =
                rm.getAllRecipesFor(CompoundPurifierRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(CompoundPurifierRecipeCategory.UID, CompoundPurifierRecipe.class), compoundPurifierRecipe);
        List<ElectrolyserRecipe> electrolyserRecipe =
                rm.getAllRecipesFor(ElectrolyserRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(ElectrolyserRecipeCategory.UID, ElectrolyserRecipe.class), electrolyserRecipe);



        List<CompressionCondenserRecipe> compressionCondenserRecipe =
                rm.getAllRecipesFor(CompressionCondenserRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(CompressionCondenserRecipeCategory.UID, CompressionCondenserRecipe.class), compressionCondenserRecipe);
        List<ElectromagneticInductorRecipe> electromagneticInductorRecipe =
                rm.getAllRecipesFor(ElectromagneticInductorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(ElectromagneticInductorRecipeCategory.UID, ElectromagneticInductorRecipe.class), electromagneticInductorRecipe);
        List<SteamGeneratorRecipe> steamGeneratorRecipes =
                rm.getAllRecipesFor(SteamGeneratorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(SteamGeneratorRecipeCategory.UID, SteamGeneratorRecipe.class), steamGeneratorRecipes);




        List<MachineElementProcessorRecipe> machineElementProcessorRecipe =
                rm.getAllRecipesFor(MachineElementProcessorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MachineElementProcessorRecipeCategory.UID, MachineElementProcessorRecipe.class), machineElementProcessorRecipe);
        List<MachineManufacturerRecipe> machineManufacturerRecipe =
                rm.getAllRecipesFor(MachineManufacturerRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MachineManufacturerRecipeCategory.UID, MachineManufacturerRecipe.class), machineManufacturerRecipe);
        List<MachinePartProcessorRecipe> machinePartProcessorRecipe =
                rm.getAllRecipesFor(MachinePartProcessorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MachinePartProcessorRecipeCategory.UID, MachinePartProcessorRecipe.class), machinePartProcessorRecipe);
        List<MultiblockEquipmentFabricatorRecipe> multiblockEquipmentFabricatorRecipe =
                rm.getAllRecipesFor(MultiblockEquipmentFabricatorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MultiblockEquipmentFabricatorRecipeCategory.UID, MultiblockEquipmentFabricatorRecipe.class), multiblockEquipmentFabricatorRecipe);




        List<CircuitBuilderRecipe> circuitBuilderRecipe =
                rm.getAllRecipesFor(CircuitBuilderRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(CircuitBuilderRecipeCategory.UID, CircuitBuilderRecipe.class), circuitBuilderRecipe);
        List<MachineDataInstallerRecipe> machineDataInstallerRecipe =
                rm.getAllRecipesFor(MachineDataInstallerRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MachineDataInstallerRecipeCategory.UID, MachineDataInstallerRecipe.class), machineDataInstallerRecipe);
        List<DesignatedDataInjectorRecipe> designatedDataInjectorRecipe =
                rm.getAllRecipesFor(DesignatedDataInjectorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(DesignatedDataInjectorRecipeCategory.UID, DesignatedDataInjectorRecipe.class), designatedDataInjectorRecipe);



        List<OreSorterRecipe> oreSorterRecipe =
                rm.getAllRecipesFor(OreSorterRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(OreSorterRecipeCategory.UID, OreSorterRecipe.class), oreSorterRecipe);
        List<RockCrasherRecipe> rockCrasherRecipe =
                rm.getAllRecipesFor(RockCrasherRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(RockCrasherRecipeCategory.UID, RockCrasherRecipe.class), rockCrasherRecipe);
        List<SoilPurifierRecipe> soilPurifierRecipe =
                rm.getAllRecipesFor(SoilPurifierRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(SoilPurifierRecipeCategory.UID, SoilPurifierRecipe.class), soilPurifierRecipe);




        List<ElectricArcFurnaceRecipe> electricFurnaceRecipe =
                rm.getAllRecipesFor(ElectricArcFurnaceRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(ElectricArcFurnaceRecipeCategory.UID, ElectricArcFurnaceRecipe.class), electricFurnaceRecipe);
        List<FormingMachineRecipe> formingMachineRecipe =
                rm.getAllRecipesFor(FormingMachineRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(FormingMachineRecipeCategory.UID, FormingMachineRecipe.class), formingMachineRecipe);
        List<MaterialSeparatorRecipe> materialSeparatorRecipe =
                rm.getAllRecipesFor(MaterialSeparatorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MaterialSeparatorRecipeCategory.UID, MaterialSeparatorRecipe.class), materialSeparatorRecipe);



        List<ImitationMagicEngraverRecipe> imitationMagicEngraverRecipe =
                rm.getAllRecipesFor(ImitationMagicEngraverRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(ImitationMagicEngraverRecipeCategory.UID, ImitationMagicEngraverRecipe.class), imitationMagicEngraverRecipe);
        List<SuspectedMagicCondenserRecipe> suspectedMagicCondenserRecipe =
                rm.getAllRecipesFor(SuspectedMagicCondenserRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(SuspectedMagicCondenserRecipeCategory.UID, SuspectedMagicCondenserRecipe.class), suspectedMagicCondenserRecipe);
        List<VirtualSigilProcessorRecipe> virtualSigilProcessorRecipe =
                rm.getAllRecipesFor(VirtualSigilProcessorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(VirtualSigilProcessorRecipeCategory.UID, VirtualSigilProcessorRecipe.class), virtualSigilProcessorRecipe);



        List<VoidWorldCoordinateRecordingMachineRecipe> voidWorldCoordinateRecordingMachineRecipe =
                rm.getAllRecipesFor(VoidWorldCoordinateRecordingMachineRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(VoidWorldCoordinateRecordingMachineRecipeCategory.UID, VoidWorldCoordinateRecordingMachineRecipe.class), voidWorldCoordinateRecordingMachineRecipe);



        List<RealityPhaseAdjustmentMachineRecipe> realityPhaseAdjustmentMachineRecipe =
                rm.getAllRecipesFor(RealityPhaseAdjustmentMachineRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(RealityPhaseAdjustmentMachineRecipeCategory.UID, RealityPhaseAdjustmentMachineRecipe.class), realityPhaseAdjustmentMachineRecipe);

//        List<BasicPowerSteamGeneratorMultiblockStructure> basicPowerCompositeStructureTypeThermalGeneratorMultiblockStructures =
//                rm.getAllRecipesFor(BasicPowerSteamGeneratorMultiblockStructure.Type.INSTANCE);
//        registration.addRecipes(new RecipeType<>(BasicPowerSteamGeneratorMultiblockStructureCategory.UID, BasicPowerSteamGeneratorMultiblockStructure.class), basicPowerCompositeStructureTypeThermalGeneratorMultiblockStructures);


        List<TestMachineRecipe> testMachineRecipe =
                rm.getAllRecipesFor(TestMachineRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(TestMachineRecipeCategory.UID, TestMachineRecipe.class), testMachineRecipe);

    }

    @SuppressWarnings("removal")
    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(RedstonePoweredMachineElementManufactureMachineScreen.class, 64, 20, 29, 8, MachineElementProcessorRecipeCategory.TYPE);
        registration.addRecipeClickArea(RedstonePoweredMachinePartManufactureMachineScreen.class, 64, 20, 29, 8, MachinePartProcessorRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicPerformanceAstronomicalTelescopeScreen.class, 64, 20, 29, 8, AstronomicalTelescopeRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceFineParticleAdsorberScreen.class, 64, 20, 29, 8, FineParticleAdsorberRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceStarlightCollectorScreen.class, 64, 20, 29, 8, StarlightCollectorRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicPerformanceBioReactorScreen.class, 64, 20, 29, 8, BioReactorRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceCellIncubatorScreen.class, 64, 20, 29, 8, CellIncubatorRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceCropCultivatorScreen.class, 64, 20, 29, 8, CropCultivatorRecipeCategory.TYPE);




        registration.addRecipeClickArea(BasicPerformanceChemicalReactorScreen.class, 64, 20, 29, 8, ChemicalReactorRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceCompoundPurifierScreen.class, 64, 20, 29, 8, CompoundPurifierRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceElectrolyserScreen.class, 64, 20, 29, 8, ElectrolyserRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicTechnologyCompressionCondenserScreen.class, 64, 20, 29, 8, CompressionCondenserRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicTechnologyElectromagneticInductorScreen.class, 64, 20, 29, 8, ElectromagneticInductorRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicTechnologyMachineElementProcessorScreen.class, 64, 20, 29, 8, MachineElementProcessorRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicTechnologyMachineManufacturerScreen.class, 64, 20, 29, 8, MachineManufacturerRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicTechnologyMachinePartProcessorScreen.class, 64, 20, 29, 8, MachinePartProcessorRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicTechnologyMultiblockEquipmentFabricatorScreen.class, 64, 20, 29, 8, MultiblockEquipmentFabricatorRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicPerformanceCircuitBuilderScreen.class, 64, 20, 29, 8, CircuitBuilderRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceMachineDataInstallerScreen.class, 64, 20, 29, 8, MachineDataInstallerRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceDesignatedDataInjectorScreen.class, 64, 20, 29, 8, DesignatedDataInjectorRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicPerformanceOreSorterScreen.class, 64, 20, 29, 8, OreSorterRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceRockCrasherScreen.class, 64, 20, 29, 8, RockCrasherRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceSoilPurifierScreen.class, 64, 20, 29, 8, SoilPurifierRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicPerformanceElectricArcFurnaceScreen.class, 64, 20, 29, 8, ElectricArcFurnaceRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceFormingMachineScreen.class, 64, 20, 29, 8, FormingMachineRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicPerformanceMaterialSeparatorScreen.class, 64, 20, 29, 8, MaterialSeparatorRecipeCategory.TYPE);


        registration.addRecipeClickArea(BasicTechnologyImitationMagicEngraverScreen.class, 64, 20, 29, 8, ImitationMagicEngraverRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicTechnologySuspectedMagicCondenserScreen.class, 64, 20, 29, 8, SuspectedMagicCondenserRecipeCategory.TYPE);
        registration.addRecipeClickArea(BasicTechnologyVirtualSigilProcessorScreen.class, 64, 20, 29, 8, VirtualSigilProcessorRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicTechnologyVoidWorldCoordinateRecordingMachineScreen.class, 64, 20, 29, 8, VoidWorldCoordinateRecordingMachineRecipeCategory.TYPE);



        registration.addRecipeClickArea(BasicPerformanceRealityPhaseAdjustmentMachineScreen.class, 64, 20, 29, 8, RealityPhaseAdjustmentMachineRecipeCategory.TYPE);


        registration.addRecipeClickArea(TestMachineScreen.class, 64, 20, 29, 8,
                TestMachineRecipeCategory.TYPE);

    }

    @SuppressWarnings("removal")
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.REDSTONE_POWERED_MACHINE_ELEMENT_MANUFACTURE_MACHINE_BLOCK.get()), MachineElementProcessorRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.REDSTONE_POWERED_MACHINE_PART_MANUFACTURE_MACHINE_BLOCK.get()), MachineManufacturerRecipeCategory.TYPE);
        
        
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_ASTRONOMICAL_TELESCOPE_BLOCK.get()), AstronomicalTelescopeRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_FINE_PARTICLE_ADSORBER_BLOCK.get()), FineParticleAdsorberRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_STARLIGHT_COLLECTOR_BLOCK.get()), StarlightCollectorRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_BIO_REACTOR_BLOCK.get()), BioReactorRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_CELL_INCUBATOR_BLOCK.get()), CellIncubatorRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_CROP_CULTIVATOR_BLOCK.get()), CropCultivatorRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_CHEMICAL_REACTOR_BLOCK.get()), ChemicalReactorRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_COMPOUND_PURIFIER_BLOCK.get()), CompoundPurifierRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_ELECTROLYSER_BLOCK.get()), ElectrolyserRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_COMPRESSION_CONDENSER_BLOCK.get()), CompressionCondenserRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_ELECTROMAGNETIC_INDUCTOR_BLOCK.get()), ElectromagneticInductorRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_MACHINE_ELEMENT_PROCESSOR_BLOCK.get()), MachineElementProcessorRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_MACHINE_MANUFACTURER_BLOCK.get()), MachineManufacturerRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_MACHINE_PART_PROCESSOR_BLOCK.get()), MachinePartProcessorRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_MULTIBLOCK_EQUIPMENT_FABRICATOR_BLOCK.get()), MultiblockEquipmentFabricatorRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_CIRCUIT_BUILDER_BLOCK.get()), CircuitBuilderRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_MACHINE_DATA_INSTALLER_BLOCK.get()), MachineDataInstallerRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_DESIGNATED_DATA_INJECTOR_BLOCK.get()), DesignatedDataInjectorRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_ORE_SORTER_BLOCK.get()), OreSorterRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_ROCK_CRASHER_BLOCK.get()), RockCrasherRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_SOIL_PURIFIER_BLOCK.get()), SoilPurifierRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_ELECTRIC_ARC_FURNACE_BLOCK.get()), ElectricArcFurnaceRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_FORMING_MACHINE_BLOCK.get()), FormingMachineRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_MATERIAL_SEPARATOR_BLOCK.get()), MaterialSeparatorRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_IMITATION_MAGIC_ENGRAVER_BLOCK.get()), ImitationMagicEngraverRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_SUSPECTED_MAGIC_CONDENSER_BLOCK.get()), SuspectedMagicCondenserRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_VIRTUAL_SIGIL_PROCESSOR_BLOCK.get()), VirtualSigilProcessorRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_TECHNOLOGY_VOID_WORLD_COORDINATE_RECORDING_MACHINE_BLOCK.get()), VoidWorldCoordinateRecordingMachineRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.BASIC_PERFORMANCE_REALITY_PHASE_ADJUSTMENT_MACHINE_BLOCK.get()), RealityPhaseAdjustmentMachineRecipeCategory.TYPE);


        registration.addRecipeCatalyst(new ItemStack(DCBlocks.TEST_MACHINE_BLOCK.get()), TestMachineRecipeCategory.TYPE);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(
                new RedstonePoweredMachineElementManufactureMachineTransferHandler(
                        registration.getTransferHelper(),
                        RedstonePoweredMachineElementManufactureMachineMenu.class,
                        0, RedstonePoweredMachineElementManufactureMachineBlockEntity.RECIPE_COUNT,
                        RedstonePoweredMachineElementManufactureMachineBlockEntity.MACHINE_COUNT,
                        36
                ),
                MachineElementProcessorRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new RedstonePoweredMachinePartManufactureMachineTransferHandler(
                        registration.getTransferHelper(),
                        RedstonePoweredMachinePartManufactureMachineMenu.class,
                        0, RedstonePoweredMachinePartManufactureMachineBlockEntity.RECIPE_COUNT,
                        RedstonePoweredMachinePartManufactureMachineBlockEntity.MACHINE_COUNT,
                        36
                ),
                MachinePartProcessorRecipeCategory.TYPE
        );
        
        
        
        registration.addRecipeTransferHandler(
                new BasicPerformanceAstronomicalTelescopeTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceAstronomicalTelescopeMenu.class,
                        0, BasicPerformanceAstronomicalTelescopeBlockEntity.RECIPE_COUNT,
                        BasicPerformanceAstronomicalTelescopeBlockEntity.MACHINE_COUNT,
                        36
                ),
                AstronomicalTelescopeRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceFineParticleAdsorberTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceFineParticleAdsorberMenu.class,
                        0, BasicPerformanceFineParticleAdsorberBlockEntity.RECIPE_COUNT,
                        BasicPerformanceFineParticleAdsorberBlockEntity.MACHINE_COUNT,
                        36
                ),
                FineParticleAdsorberRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceStarlightCollectorTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceStarlightCollectorMenu.class,
                        0, BasicPerformanceStarlightCollectorBlockEntity.RECIPE_COUNT,
                        BasicPerformanceStarlightCollectorBlockEntity.MACHINE_COUNT,
                        36
                ),
                StarlightCollectorRecipeCategory.TYPE
        );





        registration.addRecipeTransferHandler(
                new BasicPerformanceBioReactorTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceBioReactorMenu.class,
                        0, BasicPerformanceBioReactorBlockEntity.RECIPE_COUNT,
                        BasicPerformanceBioReactorBlockEntity.MACHINE_COUNT,
                        36
                ),
                BioReactorRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceCellIncubatorTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceCellIncubatorMenu.class,
                        0, BasicPerformanceCellIncubatorBlockEntity.RECIPE_COUNT,
                        BasicPerformanceCellIncubatorBlockEntity.MACHINE_COUNT,
                        36
                ),
                CellIncubatorRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceCropCultivatorTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceCropCultivatorMenu.class,
                        0, BasicPerformanceCropCultivatorBlockEntity.RECIPE_COUNT,
                        BasicPerformanceCropCultivatorBlockEntity.MACHINE_COUNT,
                        36
                ),
                CropCultivatorRecipeCategory.TYPE
        );



        registration.addRecipeTransferHandler(
                new BasicPerformanceChemicalReactorTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceChemicalReactorMenu.class,
                        0, BasicPerformanceChemicalReactorBlockEntity.RECIPE_COUNT,
                        BasicPerformanceChemicalReactorBlockEntity.MACHINE_COUNT,
                        36
                ),
                ChemicalReactorRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceCompoundPurifierTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceCompoundPurifierMenu.class,
                        0, BasicPerformanceCompoundPurifierBlockEntity.RECIPE_COUNT,
                        BasicPerformanceCompoundPurifierBlockEntity.MACHINE_COUNT,
                        36
                ),
                CompoundPurifierRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceElectrolyserTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceElectrolyserMenu.class,
                        0, BasicPerformanceElectrolyserBlockEntity.RECIPE_COUNT,
                        BasicPerformanceElectrolyserBlockEntity.MACHINE_COUNT,
                        36
                ),
                ElectrolyserRecipeCategory.TYPE
        );




        registration.addRecipeTransferHandler(
                new BasicTechnologyCompressionCondenserTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyCompressionCondenserMenu.class,
                        0, BasicTechnologyCompressionCondenserBlockEntity.RECIPE_COUNT,
                        BasicTechnologyCompressionCondenserBlockEntity.MACHINE_COUNT,
                        36
                ),
                CompressionCondenserRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicTechnologyElectromagneticInductorTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyElectromagneticInductorMenu.class,
                        0, BasicTechnologyElectromagneticInductorBlockEntity.RECIPE_COUNT,
                        BasicTechnologyElectromagneticInductorBlockEntity.MACHINE_COUNT,
                        36
                ),
                ElectromagneticInductorRecipeCategory.TYPE
        );




        registration.addRecipeTransferHandler(
                new BasicTechnologyMachineElementProcessorTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyMachineElementProcessorMenu.class,
                        0, BasicTechnologyMachineElementProcessorBlockEntity.RECIPE_COUNT,
                        BasicTechnologyMachineElementProcessorBlockEntity.MACHINE_COUNT,
                        36
                ),
                MachineElementProcessorRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicTechnologyMachineManufacturerTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyMachineManufacturerMenu.class,
                        0, BasicTechnologyMachineManufacturerBlockEntity.RECIPE_COUNT,
                        BasicTechnologyMachineManufacturerBlockEntity.MACHINE_COUNT,
                        36
                ),
                MachineManufacturerRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicTechnologyMachinePartProcessorTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyMachinePartProcessorMenu.class,
                        0, BasicTechnologyMachinePartProcessorBlockEntity.RECIPE_COUNT,
                        BasicTechnologyMachinePartProcessorBlockEntity.MACHINE_COUNT,
                        36
                ),
                MachinePartProcessorRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicTechnologyMultiblockEquipmentFabricatorTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyMultiblockEquipmentFabricatorMenu.class,
                        0, BasicTechnologyMultiblockEquipmentFabricatorBlockEntity.RECIPE_COUNT,
                        BasicTechnologyMultiblockEquipmentFabricatorBlockEntity.MACHINE_COUNT,
                        36
                ),
                MultiblockEquipmentFabricatorRecipeCategory.TYPE
        );




        registration.addRecipeTransferHandler(
                new BasicPerformanceCircuitBuilderTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceCircuitBuilderMenu.class,
                        0, BasicPerformanceCircuitBuilderBlockEntity.RECIPE_COUNT,
                        BasicPerformanceCircuitBuilderBlockEntity.MACHINE_COUNT,
                        36
                ),
                CircuitBuilderRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceDesignatedDataInjectorTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceDesignatedDataInjectorMenu.class,
                        0, BasicPerformanceDesignatedDataInjectorBlockEntity.RECIPE_COUNT,
                        BasicPerformanceDesignatedDataInjectorBlockEntity.MACHINE_COUNT,
                        36
                ),
                DesignatedDataInjectorRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceMachineDataInstallerTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceMachineDataInstallerMenu.class,
                        0, BasicPerformanceMachineDataInstallerBlockEntity.RECIPE_COUNT,
                        BasicPerformanceMachineDataInstallerBlockEntity.MACHINE_COUNT,
                        36
                ),
                MachineDataInstallerRecipeCategory.TYPE
        );



        registration.addRecipeTransferHandler(
                new BasicPerformanceOreSorterTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceOreSorterMenu.class,
                        0, BasicPerformanceOreSorterBlockEntity.RECIPE_COUNT,
                        BasicPerformanceOreSorterBlockEntity.MACHINE_COUNT,
                        36
                ),
                OreSorterRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceRockCrasherTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceRockCrasherMenu.class,
                        0, BasicPerformanceRockCrasherBlockEntity.RECIPE_COUNT,
                        BasicPerformanceRockCrasherBlockEntity.MACHINE_COUNT,
                        36
                ),
                RockCrasherRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceSoilPurifierTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceSoilPurifierMenu.class,
                        0, BasicPerformanceSoilPurifierBlockEntity.RECIPE_COUNT,
                        BasicPerformanceSoilPurifierBlockEntity.MACHINE_COUNT,
                        36
                ),
                SoilPurifierRecipeCategory.TYPE
        );



        registration.addRecipeTransferHandler(
                new BasicPerformanceElectricArcFurnaceTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceElectricArcFurnaceMenu.class,
                        0, BasicPerformanceElectricArcFurnaceBlockEntity.RECIPE_COUNT,
                        BasicPerformanceElectricArcFurnaceBlockEntity.MACHINE_COUNT,
                        36
                ),
                ElectricArcFurnaceRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceFormingMachineTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceFormingMachineMenu.class,
                        0, BasicPerformanceFormingMachineBlockEntity.RECIPE_COUNT,
                        BasicPerformanceFormingMachineBlockEntity.MACHINE_COUNT,
                        36
                ),
                FormingMachineRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicPerformanceMaterialSeparatorTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceMaterialSeparatorMenu.class,
                        0, BasicPerformanceMaterialSeparatorBlockEntity.RECIPE_COUNT,
                        BasicPerformanceMaterialSeparatorBlockEntity.MACHINE_COUNT,
                        36
                ),
                MaterialSeparatorRecipeCategory.TYPE
        );



        registration.addRecipeTransferHandler(
                new BasicTechnologyImitationMagicEngraverTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyImitationMagicEngraverMenu.class,
                        0, BasicTechnologyImitationMagicEngraverBlockEntity.RECIPE_COUNT,
                        BasicTechnologyImitationMagicEngraverBlockEntity.MACHINE_COUNT,
                        36
                ),
                ImitationMagicEngraverRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicTechnologySuspectedMagicCondenserTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologySuspectedMagicCondenserMenu.class,
                        0, BasicTechnologySuspectedMagicCondenserBlockEntity.RECIPE_COUNT,
                        BasicTechnologySuspectedMagicCondenserBlockEntity.MACHINE_COUNT,
                        36
                ),
                SuspectedMagicCondenserRecipeCategory.TYPE
        );
        registration.addRecipeTransferHandler(
                new BasicTechnologyVirtualSigilProcessorTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyVirtualSigilProcessorMenu.class,
                        0, BasicTechnologyVirtualSigilProcessorBlockEntity.RECIPE_COUNT,
                        BasicTechnologyVirtualSigilProcessorBlockEntity.MACHINE_COUNT,
                        36
                ),
                VirtualSigilProcessorRecipeCategory.TYPE
        );




        registration.addRecipeTransferHandler(
                new BasicTechnologyVoidWorldCoordinateRecordingMachineTransferHandler(
                        registration.getTransferHelper(),
                        BasicTechnologyVoidWorldCoordinateRecordingMachineMenu.class,
                        0, BasicTechnologyVoidWorldCoordinateRecordingMachineBlockEntity.RECIPE_COUNT,
                        BasicTechnologyVoidWorldCoordinateRecordingMachineBlockEntity.MACHINE_COUNT,
                        36
                ),
                VoidWorldCoordinateRecordingMachineRecipeCategory.TYPE
        );


        registration.addRecipeTransferHandler(
                new BasicPerformanceRealityPhaseAdjustmentMachineTransferHandler(
                        registration.getTransferHelper(),
                        BasicPerformanceRealityPhaseAdjustmentMachineMenu.class,
                        0, BasicPerformanceRealityPhaseAdjustmentMachineBlockEntity.RECIPE_COUNT,
                        BasicPerformanceRealityPhaseAdjustmentMachineBlockEntity.MACHINE_COUNT,
                        36
                ),
                RealityPhaseAdjustmentMachineRecipeCategory.TYPE
        );





        registration.addRecipeTransferHandler(
                new TestMachineRecipeTransferHandler(
                        registration.getTransferHelper(),
                        TestMachineMenu.class,
                        0, 5,
                        8, 36
                ),
                TestMachineRecipeCategory.TYPE
        );


        }
    }


