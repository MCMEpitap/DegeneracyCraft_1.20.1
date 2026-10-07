package net.epitap.degeneracycraft.block.storage.basic.jenith_void_science.item.item_storage;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthJenithVoidScienceMultiblockItemStorageScreen
        extends DCMultiblockItemScreenBase<BasicStrengthJenithVoidScienceMultiblockItemStorageMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/jenith_void_science/basic_strength_jenith_void_science_multiblock_item_storage/basic_strength_jenith_void_science_multiblock_item_storage_gui.png"
            );

    public BasicStrengthJenithVoidScienceMultiblockItemStorageScreen(BasicStrengthJenithVoidScienceMultiblockItemStorageMenu menu, Inventory playerInventory, Component title) {
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
