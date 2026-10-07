package net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.output_port;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortScreen
        extends DCMultiblockItemScreenBase<BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/kaleidoscopic_reality_science/basic_strength_kaleidoscopic_reality_science_multiblock_item_output_port/basic_strength_kaleidoscopic_reality_science_multiblock_item_output_port_gui.png"
            );

    public BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortScreen(BasicStrengthKaleidoscopicRealityScienceMultiblockItemOutputPortMenu menu, Inventory playerInventory, Component title) {
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