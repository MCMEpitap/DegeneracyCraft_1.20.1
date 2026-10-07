package net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.item_storage;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageScreen
        extends DCMultiblockItemScreenBase<BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/kaleidoscopic_reality_science/basic_strength_kaleidoscopic_reality_science_multiblock_item_storage/basic_strength_kaleidoscopic_reality_science_multiblock_item_storage_gui.png"
            );

    public BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageScreen(BasicStrengthKaleidoscopicRealityScienceMultiblockItemStorageMenu menu, Inventory playerInventory, Component title) {
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