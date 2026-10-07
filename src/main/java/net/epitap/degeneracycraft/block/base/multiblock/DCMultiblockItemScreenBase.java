package net.epitap.degeneracycraft.block.base.multiblock;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class DCMultiblockItemScreenBase<M extends DCMultiblockItemMenuBase>
        extends AbstractContainerScreen<M> {

    protected final DCMultiblockItemScreenLayout layout;

    protected DCMultiblockItemScreenBase(M menu, Inventory inventory, Component title) {
        super(menu, inventory, title);

        this.layout = createLayout();
        this.imageWidth = layout.imageWidth();
        this.imageHeight = layout.imageHeight();
    }

    protected abstract DCMultiblockItemScreenLayout createLayout();

    protected abstract ResourceLocation getTexture();

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        ResourceLocation texture = getTexture();
        RenderSystem.setShaderTexture(0, texture);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(texture, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    public record DCMultiblockItemScreenLayout(int imageWidth, int imageHeight) {
    }
}