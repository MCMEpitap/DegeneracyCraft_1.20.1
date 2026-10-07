package net.epitap.degeneracycraft.block.storage.basic.geo_science.item.item_storage;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthGeoScienceMultiblockItemStorageScreen
        extends DCMultiblockItemScreenBase<BasicStrengthGeoScienceMultiblockItemStorageMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/geo_science/basic_strength_geo_sciencee_multiblock_item_storage/basic_strength_geo_science_multiblock_item_storage_gui.png"
            );

    public BasicStrengthGeoScienceMultiblockItemStorageScreen(BasicStrengthGeoScienceMultiblockItemStorageMenu menu, Inventory playerInventory, Component title) {
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
