package net.epitap.degeneracycraft.block.storage.basic.formal_science.energy.energy_storage;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockEnergyScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthFormalScienceMultiblockEnergyStorageScreen
        extends DCMultiblockEnergyScreenBase<BasicStrengthFormalScienceMultiblockEnergyStorageMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
            Degeneracycraft.MOD_ID,
            "textures/gui/multiblock/basic/formal_science/basic_strength_formal_science_multiblock_energy_storage/basic_strength_formal_science_multiblock_energy_storage_gui.png"
    );

    public BasicStrengthFormalScienceMultiblockEnergyStorageScreen(BasicStrengthFormalScienceMultiblockEnergyStorageMenu menu, Inventory playerInventory, Component title) {
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