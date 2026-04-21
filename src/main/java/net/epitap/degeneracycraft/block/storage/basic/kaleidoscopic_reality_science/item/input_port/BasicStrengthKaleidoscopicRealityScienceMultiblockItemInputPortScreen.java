package net.epitap.degeneracycraft.block.storage.basic.kaleidoscopic_reality_science.item.input_port;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortScreen extends AbstractContainerScreen<BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/kaleidoscopic_reality_science/basic_strength_kaleidoscopic_reality_science_multiblock_item_input_port/basic_strength_kaleidoscopic_reality_science_multiblock_item_input_port_gui.png");


    public BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortScreen(BasicStrengthKaleidoscopicRealityScienceMultiblockItemInputPortMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {

    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, mouseX, mouseY, delta);
        renderTooltip(pGuiGraphics, mouseX, mouseY);
    }
}
