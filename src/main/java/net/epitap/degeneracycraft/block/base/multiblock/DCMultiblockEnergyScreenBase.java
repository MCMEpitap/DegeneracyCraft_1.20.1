package net.epitap.degeneracycraft.block.base.multiblock;

import com.mojang.blaze3d.systems.RenderSystem;
import net.epitap.degeneracycraft.block.base.render.MultiblockEnergyStorageInfoArea;
import net.epitap.degeneracycraft.util.DCMouseUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Optional;

public abstract class DCMultiblockEnergyScreenBase<M extends DCMultiblockEnergyMenuBase> extends AbstractContainerScreen<M> {

    protected final DCMultiblockEnergyScreenLayout layout;
    protected MultiblockEnergyStorageInfoArea energyInfoArea;

    protected DCMultiblockEnergyScreenBase(M menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.layout = createLayout();
        this.imageWidth = layout.imageWidth();
        this.imageHeight = layout.imageHeight();
    }

    protected abstract DCMultiblockEnergyScreenLayout createLayout();
    protected abstract ResourceLocation getTexture();

    @Override
    protected void init() {
        super.init();
        assignEnergyInfoArea();
    }

    protected void assignEnergyInfoArea() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        energyInfoArea = new MultiblockEnergyStorageInfoArea(
                x + layout.energyX(),
                y + layout.energyY(),
                menu.getEnergy()
        );
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        ResourceLocation texture = getTexture();
        RenderSystem.setShaderTexture(0, texture);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(texture, x, y, 0, 0, imageWidth, imageHeight);
        renderEnergyArea(guiGraphics);
    }

    protected void renderEnergyArea(GuiGraphics guiGraphics) {
        energyInfoArea.draw(guiGraphics);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderEnergyLabels(guiGraphics);
        renderEnergyAreaTooltips(guiGraphics, mouseX, mouseY, x, y);
    }

    protected void renderEnergyLabels(GuiGraphics guiGraphics) {
        guiGraphics.drawCenteredString(this.font, Component.translatable("screen.degeneracycraft.available"),
                layout.availableX(), layout.availableY(), 0xFFFFFF);

        guiGraphics.drawCenteredString(this.font, (int) (menu.getAvailableEnergy() / 1E3F) + " kFE",
                layout.availableEnergyX(), layout.availableEnergyY(), 0xFFFFFF);

        guiGraphics.drawCenteredString(this.font, Component.translatable("screen.degeneracycraft.available%"),
                layout.availablePercentX(), layout.availablePercentY(), 0xFFFFFF);
        guiGraphics.drawCenteredString(this.font, (int) menu.getAvailableEnergyPercent() + " %",
                layout.availablePercentValueX(), layout.availablePercentValueY(), 0xFFFFFF);
    }

    protected void renderEnergyAreaTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {
        if (isMouseAboveArea(mouseX, mouseY, x, y,
                layout.energyX(), layout.energyY(), layout.energyWidth(), layout.energyHeight())) {
            guiGraphics.renderTooltip(this.font, energyInfoArea.getTooltips(),
                    Optional.empty(),
                    mouseX - x,
                    mouseY - y
            );
        }
    }

    protected boolean isMouseAboveArea(int mouseX, int mouseY, int x, int y,
            int offsetX, int offsetY, int width, int height) {
        return DCMouseUtil.isMouseOver(mouseX, mouseY,
                x + offsetX, y + offsetY,
                width, height
        );
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    public record DCMultiblockEnergyScreenLayout(int imageWidth, int imageHeight, int energyX, int energyY, int energyWidth, int energyHeight,
            int availableX, int availableY, int availableEnergyX, int availableEnergyY,
            int availablePercentX, int availablePercentY, int availablePercentValueX, int availablePercentValueY
    ) {}
}