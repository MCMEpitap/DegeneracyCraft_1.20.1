package net.epitap.degeneracycraft.block.storage.basic.imitation_magic_engineering.item.input_port;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthImitationMagicEngineeringMultiblockItemInputPortScreen
        extends DCMultiblockItemScreenBase<BasicStrengthImitationMagicEngineeringMultiblockItemInputPortMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/imitation_magic_engineering/basic_strength_imitation_magic_engineering_multiblock_item_input_port/basic_strength_imitation_magic_engineering_multiblock_item_input_port_gui.png"
            );

    public BasicStrengthImitationMagicEngineeringMultiblockItemInputPortScreen(BasicStrengthImitationMagicEngineeringMultiblockItemInputPortMenu menu, Inventory playerInventory, Component title) {
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