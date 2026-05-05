package net.epitap.degeneracycraft.integration.jei;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.astronomical_telescope.AstronomicalTelescopeRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.fine_particle_adsorber.FineParticleAdsorberRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.starlight_collector.StarlightCollectorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.biology.bio_reactor.BioReactorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.biology.cell_incubator.CellIncubatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.biology.crop_cultivator.CropCultivatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.chemical_reactor.ChemicalReactorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.compound_purifier.CompoundPurifierRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.electrolyser.ElectrolyserRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.compression_condenser.CompressionCondenserRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.electromagnetic_inductor.ElectromagneticInductorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.steam_generator.SteamGeneratorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_element_processor.MachineElementProcessorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_manufacturer.MachineManufacturerRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.machine_part_processor.MachinePartProcessorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.engineering.multiblock_equipment_fabricator.MultiblockEquipmentFabricatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.circuit_builder.CircuitBuilderRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.designated_data_injector.DesignatedDataInjectorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.formal_science.machine_data_installer.MachineDataInstallerRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.ore_sorter.OreSorterRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.rock_crasher.RockCrasherRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.geo_science.soil_purifier.SoilPurifierRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.electric_arc_furnace.ElectricArcFurnaceRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.forming_machine.FormingMachineRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.hybrid_physics.material_separator.MaterialSeparatorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.imitation_magic_engraver.ImitationMagicEngraverRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.suspected_magic_condenser.SuspectedMagicCondenserRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.virtual_sigil_processor.VirtualSigilProcessorRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.jenith_void_science.void_world_coordinate_recording_machine.VoidWorldCoordinateRecordingMachineRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.kaleidoscopic_reality_science.reality_phase_adjustment_machine.RealityPhaseAdjustmentMachineRecipe;
import net.epitap.degeneracycraft.integration.jei.test.TestMachineRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DCRecipeTypes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Degeneracycraft.MOD_ID);


    public static final RegistryObject<RecipeSerializer<AstronomicalTelescopeRecipe>> ASTRONOMICAL_TELESCOPE_SERIALIZER =
            SERIALIZERS.register("astronomical_telescope_recipe", () -> AstronomicalTelescopeRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<FineParticleAdsorberRecipe>> FINE_PARTICLE_ADSORBER_SERIALIZER =
            SERIALIZERS.register("fine_particle_adsorber_recipe", () -> FineParticleAdsorberRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<StarlightCollectorRecipe>> BASIC_PERFORMANCE_STARLIGHT_COLLECTOR_SERIALIZER =
            SERIALIZERS.register("starlight_collector_recipe", () -> StarlightCollectorRecipe.Serializer.INSTANCE);



    public static final RegistryObject<RecipeSerializer<BioReactorRecipe>> BASIC_PERFORMANCE_BIO_REACTOR_SERIALIZER =
            SERIALIZERS.register("bio_reactor_recipe", () -> BioReactorRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CellIncubatorRecipe>> BASIC_PERFORMANCE_CELL_INCUBATOR_SERIALIZER =
            SERIALIZERS.register("cell_incubator_recipe", () -> CellIncubatorRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CropCultivatorRecipe>> BASIC_PERFORMANCE_CROP_CULTIVATOR_SERIALIZER =
            SERIALIZERS.register("crop_cultivator_recipe", () -> CropCultivatorRecipe.Serializer.INSTANCE);



    public static final RegistryObject<RecipeSerializer<ChemicalReactorRecipe>> BASIC_PERFORMANCE_CHEMICAL_REACTOR_SERIALIZER =
            SERIALIZERS.register("chemical_reactor_recipe", () -> ChemicalReactorRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CompoundPurifierRecipe>> BASIC_PERFORMANCE_COMPOUND_PURIFIER_SERIALIZER =
            SERIALIZERS.register("compound_purifier_recipe", () -> CompoundPurifierRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<ElectrolyserRecipe>> BASIC_PERFORMANCE_ELECTROLYSER_SERIALIZER =
            SERIALIZERS.register("electrolyser_recipe", () -> ElectrolyserRecipe.Serializer.INSTANCE);



    public static final RegistryObject<RecipeSerializer<CompressionCondenserRecipe>> BASIC_TECHNOLOGY_COMPRESSION_CONDENSER_SERIALIZER =
            SERIALIZERS.register("compression_condenser_recipe", () -> CompressionCondenserRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<ElectromagneticInductorRecipe>> BASIC_TECHNOLOGY_ELECTROMAGNETIC_INDUCTOR_SERIALIZER =
            SERIALIZERS.register("electromagnetic_inductor_recipe", () -> ElectromagneticInductorRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<SteamGeneratorRecipe>> BASIC_POWER_STEAM_GENERATOR_SERIALIZER =
            SERIALIZERS.register("steam_generator_recipe", () -> SteamGeneratorRecipe.Serializer.INSTANCE);


    public static final RegistryObject<RecipeSerializer<MachineElementProcessorRecipe>> BASIC_MACHINE_ELEMENT_PROCESSOR_SERIALIZER =
            SERIALIZERS.register("machine_element_processor_recipe", () -> MachineElementProcessorRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<MachineManufacturerRecipe>> BASIC_TECHNOLOGY_MACHINE_MANUFACTURER_SERIALIZER =
            SERIALIZERS.register("machine_manufacturer_recipe", () -> MachineManufacturerRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<MachinePartProcessorRecipe>> BASIC_MACHINE_PART_PROCESSOR_SERIALIZER =
            SERIALIZERS.register("machine_part_processor_recipe", () -> MachinePartProcessorRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<MultiblockEquipmentFabricatorRecipe>> BASIC_MULTIBLOCK_EQUIPMENT_FABRICATOR_SERIALIZER =
            SERIALIZERS.register("multiblock_equipment_fabricator_recipe", () -> MultiblockEquipmentFabricatorRecipe.Serializer.INSTANCE);




    public static final RegistryObject<RecipeSerializer<CircuitBuilderRecipe>> BASIC_PERFORMANCE_CIRCUIT_BUILDER_SERIALIZER =
            SERIALIZERS.register("circuit_builder_recipe", () -> CircuitBuilderRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<MachineDataInstallerRecipe>> BASIC_PERFORMANCE_MACHINE_DATA_INSTALLER_SERIALIZER =
            SERIALIZERS.register("machine_data_installer_recipe", () -> MachineDataInstallerRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<DesignatedDataInjectorRecipe>> BASIC_PERFORMANCE_DESIGNATED_DATA_INJECTOR_SERIALIZER =
            SERIALIZERS.register("designated_data_injector_recipe", () -> DesignatedDataInjectorRecipe.Serializer.INSTANCE);




    public static final RegistryObject<RecipeSerializer<OreSorterRecipe>> BASIC_PERFORMANCE_BASIC_PERFORMANCE_ORE_SORTER_SERIALIZER =
            SERIALIZERS.register("ore_sorter_recipe", () -> OreSorterRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<RockCrasherRecipe>> BASIC_PERFORMANCE_BASIC_PERFORMANCE_ROCK_CRASHER_SERIALIZER =
            SERIALIZERS.register("rock_crasher_recipe", () -> RockCrasherRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<SoilPurifierRecipe>> BASIC_PERFORMANCE_BASIC_PERFORMANCE_SOIL_PURIFIER_SERIALIZER =
            SERIALIZERS.register("soil_purifier_recipe", () -> SoilPurifierRecipe.Serializer.INSTANCE);





    public static final RegistryObject<RecipeSerializer<ElectricArcFurnaceRecipe>> BASIC_PERFORMANCE_ELECTRIC_ARC_FURNACE_SERIALIZER =
            SERIALIZERS.register("electric_arc_furnace_recipe", () -> ElectricArcFurnaceRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<FormingMachineRecipe>> BASIC_PERFORMANCE_FORMING_MACHINE_SERIALIZER =
            SERIALIZERS.register("forming_machine_recipe", () -> FormingMachineRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<MaterialSeparatorRecipe>> BASIC_PERFORMANCE_MATERIAL_SEPARATOR_SERIALIZER =
            SERIALIZERS.register("material_separator_recipe", () -> MaterialSeparatorRecipe.Serializer.INSTANCE);





    public static final RegistryObject<RecipeSerializer<ImitationMagicEngraverRecipe>> BASIC_TECHNOLOGY_IMITATION_MAGIC_ENGRAVER_SERIALISER =
            SERIALIZERS.register("imitation_magic_engraver_recipe", () -> ImitationMagicEngraverRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<SuspectedMagicCondenserRecipe>> BASIC_TECHNOLOGY_SUSPECTRD_MAGIC_CONDENSER_SERIALISER =
            SERIALIZERS.register("suspected_magic_condenser_recipe", () -> SuspectedMagicCondenserRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<VirtualSigilProcessorRecipe>> BASIC_TECHNOLOGY_VIRTUAL_SIGIL_PRPCESSOR_SERIALISER =
            SERIALIZERS.register("virtual_sigil_processor_recipe", () -> VirtualSigilProcessorRecipe.Serializer.INSTANCE);



    public static final RegistryObject<RecipeSerializer<VoidWorldCoordinateRecordingMachineRecipe>> BASIC_TECHNOLOGY_VOID_WORLD_COORDINATE_RECORDING_MACHINE_SERIALISER =
            SERIALIZERS.register("void_world_coordinate_recording_machine_recipe", () -> VoidWorldCoordinateRecordingMachineRecipe.Serializer.INSTANCE);



    public static final RegistryObject<RecipeSerializer<RealityPhaseAdjustmentMachineRecipe>> BASIC_PERFORMANCE_REALITY_PHASE_ADJUSTMENT_MACHINE_SERIALISER =
            SERIALIZERS.register("reality_phase_adjustment_machine_recipe", () -> RealityPhaseAdjustmentMachineRecipe.Serializer.INSTANCE);



//    public static final RegistryObject<RecipeSerializer<BasicPowerSteamGeneratorMultiblockStructure>> BASIC_POWER_COMPOSITE_STRUCTURE_TYPE_THERMAL_GENERATOR_MULTIBLOCK_STRUCTURE_SERIALIZER =
//            SERIALIZERS.register("basic_power_thermal_generator_multiblock_structure", () -> BasicPowerSteamGeneratorMultiblockStructure.Serializer.INSTANCE);


    public static final RegistryObject<RecipeSerializer<?>> MACHINE_RECIPE =
            SERIALIZERS.register("test_machine_recipe", () -> TestMachineRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
