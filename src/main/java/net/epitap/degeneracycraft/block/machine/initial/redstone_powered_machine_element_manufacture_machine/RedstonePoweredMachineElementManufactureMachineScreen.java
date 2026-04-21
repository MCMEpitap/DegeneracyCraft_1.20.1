package net.epitap.degeneracycraft.block.machine.initial.redstone_powered_machine_element_manufacture_machine;

import com.mojang.blaze3d.systems.RenderSystem;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class RedstonePoweredMachineElementManufactureMachineScreen extends AbstractContainerScreen<RedstonePoweredMachineElementManufactureMachineMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Degeneracycraft.MOD_ID, 
                    "textures/gui/initial/redstone_powered_machine_element_manufacture_machine/redstone_powered_machine_element_manufacture_machine_gui.png");


    public RedstonePoweredMachineElementManufactureMachineScreen(RedstonePoweredMachineElementManufactureMachineMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void renderLabels(GuiGraphics guiGraphics,int pMouseX, int pMouseY) {
        guiGraphics.drawCenteredString(this.font, Component.translatable("screen." + "degeneracycraft" + ".phase0"),
                35, 67, 0xFFFFFF);
        if (menu.isWorking()) {
            guiGraphics.drawCenteredString(this.font, "Work!",
                    80, 30, 0x00FF00);
        } else {
            guiGraphics.drawCenteredString(this.font, "Stop!",
                    80, 30, 0xFF0000);
        }
        guiGraphics.drawCenteredString(this.font, (int) menu.getProgressPercent() + " %",
                80, 11, 0xFFFFFF);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
