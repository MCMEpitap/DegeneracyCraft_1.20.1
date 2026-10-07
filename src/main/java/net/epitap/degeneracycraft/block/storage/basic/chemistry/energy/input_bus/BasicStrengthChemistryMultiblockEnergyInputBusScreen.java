package net.epitap.degeneracycraft.block.storage.basic.chemistry.energy.input_bus;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthChemistryMultiblockEnergyInputBusScreen
        extends DCMultiblockEnergyScreenBase<BasicStrengthChemistryMultiblockEnergyInputBusMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
            Degeneracycraft.MOD_ID,
            "textures/gui/multiblock/basic/chemistry/basic_strength_chemistry_multiblock_energy_input_bus/basic_strength_chemistry_multiblock_energy_input_bus_gui.png"
    );

    public BasicStrengthChemistryMultiblockEnergyInputBusScreen(BasicStrengthChemistryMultiblockEnergyInputBusMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected DCMultiblockEnergyScreenLayout createLayout() {
        return new DCMultiblockEnergyScreenLayout(
                176, 166,
                63, 10, 100, 64,
                35, 15,
                35, 25,
                35, 35,
                35, 45
        );
    }

    @Override
    protected ResourceLocation getTexture() {
        return TEXTURE;
    }
}