package net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.output_bus;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusScreen
        extends DCMultiblockEnergyScreenBase<BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
            Degeneracycraft.MOD_ID,
            "textures/gui/multiblock/basic/dynamic_energetics/basic_strength_dynamic_energetics_multiblock_energy_output_bus/basic_strength_dynamic_energetics_multiblock_energy_output_bus_gui.png"
    );

    public BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusScreen(BasicStrengthDynamicEnergeticsMultiblockEnergyOutputBusMenu menu, Inventory playerInventory, Component title) {
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
