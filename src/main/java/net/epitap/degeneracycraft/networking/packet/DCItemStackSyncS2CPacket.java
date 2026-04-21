package net.epitap.degeneracycraft.networking.packet;

import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope.BasicPerformanceAstronomicalTelescopeBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_fine_particle_adsorber.BasicPerformanceFineParticleAdsorberBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_starlight_collector.BasicPerformanceStarlightCollectorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_bio_reactor.BasicPerformanceBioReactorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_cell_incubator.BasicPerformanceCellIncubatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.biology.basic_performance_crop_cultivator.BasicPerformanceCropCultivatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_chemical_reactor.BasicPerformanceChemicalReactorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_compound_purifier.BasicPerformanceCompoundPurifierBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser.BasicPerformanceElectrolyserBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_power_steam_generator.BasicPowerSteamGeneratorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_compression_condenser.BasicTechnologyCompressionCondenserBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor.BasicTechnologyElectromagneticInductorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_manufacturer.BasicTechnologyMachineManufacturerBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_part_processor.BasicTechnologyMachinePartProcessorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_multiblock_equipment_fabricator.BasicTechnologyMultiblockEquipmentFabricatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_circuit_builder.BasicPerformanceCircuitBuilderBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_designated_data_injector.BasicPerformanceDesignatedDataInjectorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_ore_sorter.BasicPerformanceOreSorterBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_soil_purifier.BasicPerformanceSoilPurifierBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_electric_arc_furnace.BasicPerformanceElectricArcFurnaceBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_forming_machine.BasicPerformanceFormingMachineBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.hybrid_physics.basic_performance_material_separator.BasicPerformanceMaterialSeparatorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_imitation_magic_engraver.BasicTechnologyImitationMagicEngraverBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.jenith_void_science.basic_technology_void_world_coordinate_recording_machine.BasicTechnologyVoidWorldCoordinateRecordingMachineBlockEntity;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.input_port.BasicStrengthAstronomyMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.item_storage.BasicStrengthAstronomyMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.astronomy.item.output_port.BasicStrengthAstronomyMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.input_port.BasicStrengthBiologyMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.item_storage.BasicStrengthBiologyMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.biology.item.output_port.BasicStrengthBiologyMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.input_port.BasicStrengthChemistryMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.item_storage.BasicStrengthChemistryMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.chemistry.item.output_port.BasicStrengthChemistryMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.input_port.BasicStrengthDynamicEnergeticsMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.item_storage.BasicStrengthDynamicEnergeticsMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.output_port.BasicStrengthDynamicEnergeticsMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.input_port.BasicStrengthEngineeringMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.item_storage.BasicStrengthEngineeringMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.engineering.item.output_port.BasicStrengthEngineeringMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.input_port.BasicStrengthFormalScienceMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.item_storage.BasicStrengthFormalScienceMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.formal_science.item.output_port.BasicStrengthFormalScienceMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.input_port.BasicStrengthGeoScienceMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.item_storage.BasicStrengthGeoScienceMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.geo_science.item.output_port.BasicStrengthGeoScienceMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.input_port.BasicStrengthHybridPhysicsMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.item_storage.BasicStrengthHybridPhysicsMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.output_port.BasicStrengthHybridPhysicsMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.input_port.BasicStrengthImitationMagicEngineeringMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.item_storage.BasicStrengthImitationMagicEngineeringMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.output_port.BasicStrengthImitationMagicEngineeringMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.input_port.BasicStrengthJenithVoidScienceMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.item_storage.BasicStrengthJenithVoidScienceMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.output_port.BasicStrengthJenithVoidScienceMultiblockItemOutputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.input_port.BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.item_storage.BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageBlockEntity;
import net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.output_port.BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class DCItemStackSyncS2CPacket {
    private final ItemStackHandler itemStackHandler;
    private final BlockPos pos;

    public DCItemStackSyncS2CPacket(ItemStackHandler itemStackHandler, BlockPos pos) {
        this.itemStackHandler = itemStackHandler;
        this.pos = pos;
    }

    public DCItemStackSyncS2CPacket(FriendlyByteBuf buf) {
        List<ItemStack> collection = buf.readCollection(ArrayList::new, FriendlyByteBuf::readItem);
        itemStackHandler = new ItemStackHandler(collection.size());
        for (int i = 0; i < collection.size(); i++) {
            itemStackHandler.insertItem(i, collection.get(i), false);
        }

        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        Collection<ItemStack> list = new ArrayList<>();
        for(int i = 0; i < itemStackHandler.getSlots(); i++) {
            list.add(itemStackHandler.getStackInSlot(i));
        }

        buf.writeCollection(list, FriendlyByteBuf::writeItem);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthAstronomyMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthAstronomyMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthAstronomyMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthBiologyMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthBiologyMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthBiologyMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthChemistryMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthChemistryMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthChemistryMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthDynamicEnergeticsMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthDynamicEnergeticsMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthDynamicEnergeticsMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }




            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthEngineeringMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthEngineeringMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthEngineeringMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthFormalScienceMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthFormalScienceMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthFormalScienceMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthGeoScienceMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthGeoScienceMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthGeoScienceMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthHybridPhysicsMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthHybridPhysicsMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthHybridPhysicsMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthImitationMagicEngineeringMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthImitationMagicEngineeringMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthImitationMagicEngineeringMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthJenithVoidScienceMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthJenithVoidScienceMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthJenithVoidScienceMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }

            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }




            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceFineParticleAdsorberBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceStarlightCollectorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceBioReactorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceCellIncubatorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceCropCultivatorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }




            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceChemicalReactorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceCompoundPurifierBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceElectrolyserBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPowerSteamGeneratorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyCompressionCondenserBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyElectromagneticInductorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyMachineManufacturerBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyMachineElementProcessorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyMachinePartProcessorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyMultiblockEquipmentFabricatorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceCircuitBuilderBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceMachineDataInstallerBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceDesignatedDataInjectorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }





            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceOreSorterBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceRockCrasherBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceSoilPurifierBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }




            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceElectricArcFurnaceBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceFormingMachineBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceMaterialSeparatorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyImitationMagicEngraverBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologySuspectedMagicCondenserBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyVirtualSigilProcessorBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicTechnologyVoidWorldCoordinateRecordingMachineBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }



            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof BasicPerformanceRealityPhaseAdjustmentMachineBlockEntity blockEntity) {
                blockEntity.setHandler(this.itemStackHandler);
            }
        });
        return true;
    }
}