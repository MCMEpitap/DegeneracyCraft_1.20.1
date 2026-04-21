package net.epitap.degeneracycraft.block.storage.basic.astronomy.item.output_port;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicStrengthAstronomyMultiblockItemOutputPortScreen extends AbstractContainerScreen<BasicStrengthAstronomyMultiblockItemOutputPortMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/astronomy/basic_strength_astronomy_multiblock_item_output_port/basic_strength_astronomy_multiblock_item_output_port_gui.png");


    public BasicStrengthAstronomyMultiblockItemOutputPortScreen(BasicStrengthAstronomyMultiblockItemOutputPortMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
