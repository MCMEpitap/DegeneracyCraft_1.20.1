package net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.energy.input_bus;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusScreen
        extends DCMultiblockEnergyScreenBase<BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
            Degeneracycraft.MOD_ID,
            "textures/gui/multiblock/basic/dynamic_energetics/basic_strength_dynamic_energetics_multiblock_energy_input_bus/basic_strength_dynamic_energetics_multiblock_energy_input_bus_gui.png"
    );

    public BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusScreen(BasicStrengthDynamicEnergeticsMultiblockEnergyInputBusMenu menu, Inventory playerInventory, Component title) {
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