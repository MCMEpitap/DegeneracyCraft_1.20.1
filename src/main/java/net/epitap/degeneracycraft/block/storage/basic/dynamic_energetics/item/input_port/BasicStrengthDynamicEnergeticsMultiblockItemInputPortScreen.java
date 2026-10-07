package net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.input_port;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthDynamicEnergeticsMultiblockItemInputPortScreen
        extends DCMultiblockItemScreenBase<BasicStrengthDynamicEnergeticsMultiblockItemInputPortMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/dynamic_energetics/basic_strength_dynamic_energetics_multiblock_item_input_port/basic_strength_dynamic_energetics_multiblock_item_input_port_gui.png"
            );

    public BasicStrengthDynamicEnergeticsMultiblockItemInputPortScreen(BasicStrengthDynamicEnergeticsMultiblockItemInputPortMenu menu, Inventory playerInventory, Component title) {
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

