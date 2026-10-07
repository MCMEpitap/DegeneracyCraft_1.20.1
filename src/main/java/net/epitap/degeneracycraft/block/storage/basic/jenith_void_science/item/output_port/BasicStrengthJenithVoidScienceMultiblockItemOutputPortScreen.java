package net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.output_port;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthJenithVoidScienceMultiblockItemOutputPortScreen
        extends DCMultiblockItemScreenBase<BasicStrengthJenithVoidScienceMultiblockItemOutputPortMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/jenith_void_science/basic_strength_jenith_void_science_multiblock_item_output_port/basic_strength_jenith_void_science_multiblock_item_output_port_gui.png"
            );

    public BasicStrengthJenithVoidScienceMultiblockItemOutputPortScreen(BasicStrengthJenithVoidScienceMultiblockItemOutputPortMenu menu, Inventory playerInventory, Component title) {
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
