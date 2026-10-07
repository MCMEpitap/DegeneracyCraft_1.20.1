package net.epitap.degeneracycraft.block.storage.basic.chemistry.item.output_port;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthChemistryMultiblockItemOutputPortScreen
        extends DCMultiblockItemScreenBase<BasicStrengthChemistryMultiblockItemOutputPortMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/chemistry/basic_strength_chemistry_multiblock_item_output_port/basic_strength_chemistry_multiblock_item_output_port_gui.png"
            );

    public BasicStrengthChemistryMultiblockItemOutputPortScreen(BasicStrengthChemistryMultiblockItemOutputPortMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected DCMultiblockItemScreenLayout createLayout() {
        return new DCMultiblockItemScreenLayout(176, 166);
    }

    @Override
    protected ResourceLocation getTexture() {
        return TEXTURE;
    }
}
