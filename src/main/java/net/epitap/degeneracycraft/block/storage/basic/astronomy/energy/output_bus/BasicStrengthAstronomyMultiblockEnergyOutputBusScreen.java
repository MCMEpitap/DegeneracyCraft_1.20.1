package net.epitap.degeneracycraft.block.storage.basic.astronomy.energy.output_bus;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.render.MultiblockEnergyStorageInfoArea;
import net.epitap.degeneracycraft.util.DCMouseUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Optional;

public class BasicStrengthAstronomyMultiblockEnergyOutputBusScreen
        extends AbstractContainerScreen<BasicStrengthAstronomyMultiblockEnergyOutputBusMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Degeneracycraft.MOD_ID,
                    "textures/gui/multiblock/basic/astronomy/basic_strength_astronomy_multiblock_energy_output_bus/basic_strength_astronomy_multiblock_energy_output_bus_gui.png");

    private MultiblockEnergyStorageInfoArea energyInfoArea;

    public BasicStrengthAstronomyMultiblockEnergyOutputBusScreen(
            BasicStrengthAstronomyMultiblockEnergyOutputBusMenu menu,
            Inventory playerInventory,
            Component title
    ) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        assignEnergyInfoArea();
    }

    private void assignEnergyInfoArea() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        energyInfoArea = new MultiblockEnergyStorageInfoArea(x + 63, y + 10, menu.getEnergy());
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        energyInfoArea.draw(guiGraphics);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {

        guiGraphics.drawCenteredString(
                this.font,
                Component.translatable("screen.degeneracycraft.available"),
                35, 15, 0xffffff
        );

        guiGraphics.drawCenteredString(
                this.font,
                (int) (menu.getAvailableEnergy() / 1E3F) + " kFE",
                35, 25, 0xffffff
        );

        guiGraphics.drawCenteredString(
                this.font,
                Component.translatable("screen.degeneracycraft.available%"),
                35, 35, 0xffffff
        );

        guiGraphics.drawCenteredString(
                this.font,
                (int) menu.getAvailableEnergyPercent() + " %",
                35, 45, 0xffffff
        );

        renderEnergyAreaTooltips(guiGraphics, mouseX, mouseY);
    }

    private void renderEnergyAreaTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        if (isMouseAboveArea(mouseX, mouseY, x, y, 63, 10, 100, 64)) {
            guiGraphics.renderTooltip(
                    this.font,
                    energyInfoArea.getTooltips(),
                    Optional.empty(),
                    mouseX - x,
                    mouseY - y
            );
        }
    }

    private boolean isMouseAboveArea(int mouseX, int mouseY, int x, int y,
                                     int offsetX, int offsetY, int width, int height) {
        return DCMouseUtil.isMouseOver(mouseX, mouseY, x + offsetX, y + offsetY, width, height);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
