package net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_technology_electromagnetic_inductor;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.render.EnergyInfoArea;import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCMachineToggleC2SPacket;
import net.epitap.degeneracycraft.util.DCMouseUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Optional;

import static net.epitap.degeneracycraft.block.base.render.DCButtonComponent.*;

public class BasicTechnologyElectromagneticInductorScreen extends AbstractContainerScreen<BasicTechnologyElectromagneticInductorMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/basic/dynamic_energetics/basic_technology_electromagnetic_inductor/basic_technology_electromagnetic_inductor_gui.png");
    private EnergyInfoArea energyInfoArea;

    private static final int HOLOGRAM_X = 71;
    private static final int HOLOGRAM_Y = 59;
    private static final int HALT_X = 98;
    private static final int HALT_Y = 62;
    private static final int LOCK_X = 8;
    private static final int LOCK_Y = 62;
    private static final int BUTTON_SIZE = 16;

    public BasicTechnologyElectromagneticInductorScreen(BasicTechnologyElectromagneticInductorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
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
        energyInfoArea = new EnergyInfoArea(x + 157, y + 10, menu.getEnergy());
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderEnergyAreaTooltips(guiGraphics, pMouseX, pMouseY, x, y);

        if (menu.isWorking()) {
            guiGraphics.drawString(this.font, 
"Work!",
                    67, 30, 0x00FF00);
        } else {
            guiGraphics.drawString(this.font, 
"Stop!",
                    67, 30, 0xFF0000);
        }
        guiGraphics.drawCenteredString(this.font, menu.getProgressPercent() + " %",
                80, 11, 0xFFFFFF);


        if (menu.isForceHalt()) {
            guiGraphics.drawCenteredString(this.font, Component.translatable("screen." + "degeneracycraft" + ".halt"),
                    133, 66, 0xFFFFFF);
        }
        if (menu.getHologramLevel() == 1) {
            guiGraphics.drawCenteredString(this.font, "Lv.1",
                    80, 47, 0xFF0000);
        } else if (menu.getHologramLevel() == 0) {
            guiGraphics.drawCenteredString(this.font, "ON",
                    80, 47, 0x00FF00);
        } else {
            guiGraphics.drawCenteredString(this.font, "OFF",
                    80, 47, 0xFF0000);
        }

        if (menu.isInputLocked()) {
            guiGraphics.drawCenteredString(this.font, Component.translatable("screen." + "degeneracycraft" + ".lock"),
                    43, 66, 0xFFFFFF);
        }

        renderPowerModifierTooltips(guiGraphics, pMouseX, pMouseY, x, y);
        renderMultiblockInfoTooltips(guiGraphics, pMouseX, pMouseY, x, y);
        renderHaltTooltips(guiGraphics, pMouseX, pMouseY, x, y);
        renderLockTooltips(guiGraphics, pMouseX, pMouseY, x, y);
    }

    private void renderMultiblockInfoTooltips(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y) {
        if (isMouseAboveArea(pMouseX, pMouseY, x, y, 66, 28, 26, 10))
            guiGraphics.renderTooltip(this.font, this.MultiblockInfoTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
    }

     public List<Component> MultiblockInfoTooltips() {
        return switch (menu.getMultiblockLevel()) {
            case 1 -> List.of(
                    Component.translatable("tooltip.degeneracycraft.structure.lv1"),
                    Component.translatable("screen.degeneracycraft_machine.process_modifier_3"),
                    Component.translatable("screen.degeneracycraft_machine.energy_usage_modifier_2")
            );
            case 0 -> List.of(
                    Component.translatable("tooltip.degeneracycraft.structure.on"),
                    Component.translatable("screen.degeneracycraft_machine.process_modifier_2"),
                    Component.translatable("screen.degeneracycraft_machine.energy_usage_modifier_1.5")
            );
            default -> List.of(
                    Component.translatable("tooltip.degeneracycraft.structure.off"),
                    Component.translatable("screen.degeneracycraft_machine.process_modifier_1"),
                    Component.translatable("screen.degeneracycraft_machine.energy_usage_modifier_1")
            );
        };
    }
    private void renderPowerModifierTooltips(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y) {
        if (isMouseAboveArea(pMouseX, pMouseY, x, y, 66, 45, 26, 10))
            guiGraphics.renderTooltip(this.font, this.PowerModifierTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
    }

    public List<Component> PowerModifierTooltips() {
        return switch (menu.getHologramLevel()) {
            case 1 -> List.of(
                    Component.translatable("screen.degeneracycraft_machine.process_modifier_3"),
                    Component.translatable("screen.degeneracycraft_machine.energy_usage_modifier_2")
            );
            case 0 -> List.of(
                    Component.translatable("screen.degeneracycraft_machine.process_modifier_2"),
                    Component.translatable("screen.degeneracycraft_machine.energy_usage_modifier_1.5")
            );
            default -> List.of(
                    Component.translatable("screen.degeneracycraft_machine.process_modifier_1"),
                    Component.translatable("screen.degeneracycraft_machine.energy_usage_modifier_1")
            );
        };
    }

    private void renderHaltTooltips(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y) {
        if (menu.isForceHalt()
                && isMouseAboveArea(pMouseX, pMouseY, x, y, 117, 64, 30, 12))
            guiGraphics.renderTooltip(this.font, this.haltTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
    }

    public List<Component> haltTooltips() {
        return List.of(Component.translatable("tooltip." + "degeneracycraft" + ".halt"));
    }

    private void renderLockTooltips(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y) {
        if (menu.isInputLocked()
                && isMouseAboveArea(pMouseX, pMouseY, x, y, 27, 64, 30, 12))
            guiGraphics.renderTooltip(this.font, this.lockTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
    }

    public List<Component> lockTooltips() {
        return List.of(Component.translatable("tooltip." + "degeneracycraft" + ".lock"));
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        energyInfoArea.draw(guiGraphics);
        renderButtons(guiGraphics, x, y);
    }


     private void renderButtons(GuiGraphics guiGraphics, int guiX, int guiY) {
        int holoLevel = menu.getHologramLevel();

        ResourceLocation hologramTexture = switch (holoLevel) {
            case 0 -> HOLOGRAM_ON;
            case 1 -> HOLOGRAM_LV1;
            default -> HOLOGRAM_OFF;
        };

        guiGraphics.blit(hologramTexture,
                guiX + HOLOGRAM_X, guiY + HOLOGRAM_Y,
                0, 0, BUTTON_SIZE, BUTTON_SIZE,
                BUTTON_SIZE, BUTTON_SIZE);

        guiGraphics.blit(
                menu.isForceHalt() ? HALT_ON : HALT_OFF,
                guiX + HALT_X, guiY + HALT_Y,
                0, 0, BUTTON_SIZE, BUTTON_SIZE,
                BUTTON_SIZE, BUTTON_SIZE
        );

        guiGraphics.blit(
                menu.isInputLocked() ? LOCK_ON : LOCK_OFF,
                guiX + LOCK_X, guiY + LOCK_Y,
                0, 0, BUTTON_SIZE, BUTTON_SIZE,
                BUTTON_SIZE, BUTTON_SIZE
        );
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return super.mouseClicked(mouseX, mouseY, button);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        if (isMouseOver(mouseX, mouseY, x + HOLOGRAM_X, y + HOLOGRAM_Y)) {
            DCMessages.sendToServer(
                    new DCMachineToggleC2SPacket(menu.getBlockEntity().getBlockPos(), DCMachineToggleC2SPacket.TOGGLE_HOLOGRAM)
            );
            return true;
        }

        if (isMouseOver(mouseX, mouseY, x + HALT_X, y + HALT_Y)) {
            DCMessages.sendToServer(
                    new DCMachineToggleC2SPacket(menu.getBlockEntity().getBlockPos(), 1)
            );
            return true;
        }
        if (isMouseOver(mouseX, mouseY, x + LOCK_X, y + LOCK_Y)) {
            DCMessages.sendToServer(
                    new DCMachineToggleC2SPacket(menu.getBlockEntity().getBlockPos(), 2)
            );
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    private boolean isMouseOver(double mx, double my, int x, int y) {
        return mx >= x && mx < x + BUTTON_SIZE
                && my >= y && my < y + BUTTON_SIZE;
    }

    private void renderEnergyAreaTooltips(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y) {
        if (isMouseAboveArea(pMouseX, pMouseY, x, y, 155, 10, 9, 64)) {
            guiGraphics.renderTooltip(this.font, energyInfoArea.getTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return DCMouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
    }
}
