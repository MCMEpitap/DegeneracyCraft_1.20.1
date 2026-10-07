package net.epitap.degeneracycraft.block.storage.basic.dynamic_energetics.item.item_storage;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthDynamicEnergeticsMultiblockItemStorageScreen
        extends DCMultiblockItemScreenBase<BasicStrengthDynamicEnergeticsMultiblockItemStorageMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/dynamic_energetics/basic_strength_dynamic_energetics_multiblock_item_storage/basic_strength_dynamic_energetics_multiblock_item_storage_gui.png"
            );

    public BasicStrengthDynamicEnergeticsMultiblockItemStorageScreen(BasicStrengthDynamicEnergeticsMultiblockItemStorageMenu menu, Inventory playerInventory, Component title) {
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
