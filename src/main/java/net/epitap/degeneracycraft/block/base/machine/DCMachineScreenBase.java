package net.epitap.degeneracycraft.block.base.machine;

import com.mojang.blaze3d.systems.RenderSystem;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.render.EnergyInfoArea;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCMachineToggleC2SPacketTest;
import net.epitap.degeneracycraft.util.DCMouseUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Optional;

public abstract class DCMachineScreenBase<T extends DCMachineMenuBase> extends AbstractContainerScreen<T> {
    protected static final ResourceLocation HOLOGRAM_ON =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/button/hologram_on.png");

    protected static final ResourceLocation HOLOGRAM_LV1 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/button/hologram_lv1.png");

    protected static final ResourceLocation HOLOGRAM_OFF =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/button/hologram_off.png");

    protected static final ResourceLocation HALT_ON =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/button/halt_on.png");

    protected static final ResourceLocation HALT_OFF =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/button/halt_off.png");

    protected static final ResourceLocation LOCK_ON =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/button/lock_on.png");

    protected static final ResourceLocation LOCK_OFF =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/button/lock_off.png");
    protected final DCMachineScreenLayout layout;

    protected EnergyInfoArea energyInfoArea;


    protected DCMachineScreenBase(T menu, Inventory inventory, Component title) {
        super(menu, inventory, title);

        this.layout = createLayout();

        this.imageWidth = layout.imageWidth();
        this.imageHeight = layout.imageHeight();
    }


    /**
     * 各機械が自分のGUIレイアウトを返す。
     */
    protected abstract DCMachineScreenLayout createLayout();


    @Override
    protected void init() {
        super.init();
        assignEnergyInfoArea();
    }


    protected void assignEnergyInfoArea() {

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        energyInfoArea = new EnergyInfoArea(x + layout.energyX(), y + layout.energyY(), menu.getEnergy());
    }


    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;


        renderEnergyAreaTooltips(guiGraphics, mouseX, mouseY, x, y);

        if (menu.isWorking()) {
            guiGraphics.drawString(this.font, "Work!", layout.workingX(), layout.workingY(), 0x00FF00);

        } else {
            guiGraphics.drawString(this.font, "Stop!", layout.workingX(), layout.workingY(), 0xFF0000);
        }


        guiGraphics.drawCenteredString(this.font, menu.getProgressPercent() + " %", layout.progressX(), layout.progressY(), 0xFFFFFF);

        if (menu.isForceHalt()) {
            guiGraphics.drawCenteredString(this.font, Component.translatable("screen.degeneracycraft.halt"), layout.haltTextX(), layout.haltTextY(), 0xFFFFFF);
        }

        renderHologramStatus(guiGraphics);

        if (menu.isInputLocked()) {
            guiGraphics.drawCenteredString(this.font, Component.translatable("screen.degeneracycraft.lock"), layout.lockTextX(), layout.lockTextY(), 0xFFFFFF);
        }

        renderPowerModifierTooltips(guiGraphics, mouseX, mouseY, x, y);

        renderMultiblockInfoTooltips(guiGraphics, mouseX, mouseY, x, y);

        renderHaltTooltips(guiGraphics, mouseX, mouseY, x, y);

        renderLockTooltips(guiGraphics, mouseX, mouseY,x, y);
    }


    protected void renderHologramStatus(GuiGraphics guiGraphics) {

        switch (menu.getHologramLevel()) {

            case 1 -> guiGraphics.drawCenteredString(
                    this.font, "Lv.1", layout.hologramTextX(), layout.hologramTextY(), 0xFF0000);

            case 0 -> guiGraphics.drawCenteredString(
                    this.font, "ON", layout.hologramTextX(), layout.hologramTextY(), 0x00FF00);

            default -> guiGraphics.drawCenteredString(
                    this.font, "OFF", layout.hologramTextX(), layout.hologramTextY(), 0xFF0000);
        }
    }


    protected void renderMultiblockInfoTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {

        if (isMouseAboveArea(mouseX, mouseY, x, y,
                layout.multiblockTooltipX(), layout.multiblockTooltipY(), layout.multiblockTooltipWidth(), layout.multiblockTooltipHeight())) {

            guiGraphics.renderTooltip(this.font, getMultiblockInfoTooltips(), Optional.empty(), mouseX - x, mouseY - y);
        }
    }


    protected List<Component> getMultiblockInfoTooltips() {

        return switch (menu.getMultiblockLevel()) {

            case 1 -> List.of(
                    Component.translatable(
                            "tooltip.degeneracycraft.structure.lv1"
                    ),
                    Component.literal(
                            "Parallel Processing: ×" + menu.getParallelLimit()
                    ),
                    Component.literal(
                            "Energy Usage Modifier: ×"
                                    + menu.getParallelLimit()
                    )
            );

            case 0 -> List.of(
                    Component.translatable(
                            "tooltip.degeneracycraft.structure.on"
                    ),
                    Component.literal(
                            "Parallel Processing: ×" + menu.getParallelLimit()
                    ),
                    Component.literal(
                            "Energy Usage Modifier: ×"
                                    + menu.getParallelLimit()
                    )
            );

            default -> List.of(
                    Component.translatable(
                            "tooltip.degeneracycraft.structure.off"
                    ),
                    Component.literal(
                            "Process Modifier: ×"
                                    + menu.getParallelLimit()
                    ),
                    Component.literal(
                            "Energy Usage Modifier: ×"
                                    + menu.getParallelLimit()
                    )
            );
        };
    }


    protected void renderPowerModifierTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {

        if (isMouseAboveArea(mouseX, mouseY, x, y,
                layout.hologramTooltipX(), layout.hologramTooltipY(), layout.hologramTooltipWidth(), layout.hologramTooltipHeight())) {

            guiGraphics.renderTooltip(
                    this.font, getPowerModifierTooltips(), Optional.empty(), mouseX - x, mouseY - y);
        }
    }


    protected List<Component> getPowerModifierTooltips() {

        return switch (menu.getHologramLevel()) {

            case 1 -> List.of(
                    Component.translatable(
                            "screen.degeneracycraft_machine.process_modifier_3"
                    ),
                    Component.translatable(
                            "screen.degeneracycraft_machine.energy_usage_modifier_2"
                    )
            );

            case 0 -> List.of(
                    Component.translatable(
                            "screen.degeneracycraft_machine.process_modifier_2"
                    ),
                    Component.translatable(
                            "screen.degeneracycraft_machine.energy_usage_modifier_1.5"
                    )
            );

            default -> List.of(
                    Component.translatable(
                            "screen.degeneracycraft_machine.process_modifier_1"
                    ),
                    Component.translatable(
                            "screen.degeneracycraft_machine.energy_usage_modifier_1"
                    )
            );
        };
    }


    protected void renderHaltTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {

        if (menu.isForceHalt() && isMouseAboveArea(mouseX, mouseY, x, y,
                layout.haltTooltipX(), layout.haltTooltipY(), layout.haltTooltipWidth(), layout.haltTooltipHeight())) {

            guiGraphics.renderTooltip(
                    this.font, getHaltTooltips(), Optional.empty(), mouseX - x, mouseY - y);
        }
    }


    protected List<Component> getHaltTooltips() {

        return List.of(
                Component.translatable(
                        "tooltip.degeneracycraft.halt"
                )
        );
    }


    protected void renderLockTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {

        if (menu.isInputLocked() && isMouseAboveArea(mouseX, mouseY, x, y,
                layout.lockTooltipX(), layout.lockTooltipY(), layout.lockTooltipWidth(), layout.lockTooltipHeight())) {

            guiGraphics.renderTooltip(
                    this.font, getLockTooltips(), Optional.empty(), mouseX - x, mouseY - y);
        }
    }


    protected List<Component> getLockTooltips() {

        return List.of(
                Component.translatable(
                        "tooltip.degeneracycraft.lock"
                )
        );
    }


    protected void renderEnergyAreaTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y) {

        if (isMouseAboveArea(mouseX, mouseY, x, y,
                layout.energyX(), layout.energyY(), layout.energyWidth(), layout.energyHeight())) {

            guiGraphics.renderTooltip(
                    this.font, energyInfoArea.getTooltips(), Optional.empty(), mouseX - x, mouseY - y);
        }
    }


    protected boolean isMouseAboveArea(int mouseX, int mouseY, int x, int y, int offsetX, int offsetY, int width, int height) {

        return DCMouseUtil.isMouseOver(
                mouseX, mouseY, x + offsetX, y + offsetY, width, height);
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {

        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        RenderSystem.setShaderColor(
                1.0F,
                1.0F,
                1.0F,
                1.0F
        );

        ResourceLocation texture = getTexture();

        RenderSystem.setShaderTexture(0, texture);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(texture, x, y, 0, 0, imageWidth, imageHeight);

        energyInfoArea.draw(guiGraphics);

        renderButtons(guiGraphics, x, y);
    }

    protected abstract ResourceLocation getTexture();


    protected void renderButtons(GuiGraphics guiGraphics, int guiX, int guiY) {

        int buttonSize = layout.buttonSize();


        ResourceLocation hologramTexture = switch (menu.getHologramLevel()) {

            case 0 -> HOLOGRAM_ON;

            case 1 -> HOLOGRAM_LV1;

            default -> HOLOGRAM_OFF;
        };


        guiGraphics.blit(hologramTexture, guiX + layout.hologramX(), guiY + layout.hologramY(), 0, 0,
                buttonSize, buttonSize, buttonSize, buttonSize);


        guiGraphics.blit(menu.isForceHalt()
                        ? HALT_ON
                        : HALT_OFF,
                guiX + layout.haltX(), guiY + layout.haltY(), 0, 0,
                buttonSize, buttonSize, buttonSize, buttonSize);


        guiGraphics.blit(
                menu.isInputLocked()
                        ? LOCK_ON
                        : LOCK_OFF,
                guiX + layout.lockX(), guiY + layout.lockY(), 0, 0,
                buttonSize, buttonSize, buttonSize, buttonSize
        );
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        if (button != 0) {
            return super.mouseClicked(mouseX, mouseY, button);
        }

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;


        if (isMouseOver(mouseX, mouseY, x + layout.hologramX(), y + layout.hologramY())) {

            DCMessages.sendToServer(
                    new DCMachineToggleC2SPacketTest(
                            menu.getBlockEntity().getBlockPos(),
                            DCMachineToggleC2SPacketTest.TOGGLE_HOLOGRAM
                    )
            );

            return true;
        }


        if (isMouseOver(mouseX, mouseY, x + layout.haltX(), y + layout.haltY())) {

            DCMessages.sendToServer(new DCMachineToggleC2SPacketTest(menu.getBlockEntity().getBlockPos(), 1));

            return true;
        }


        if (isMouseOver(mouseX, mouseY, x + layout.lockX(), y + layout.lockY())) {

            DCMessages.sendToServer(new DCMachineToggleC2SPacketTest(menu.getBlockEntity().getBlockPos(), 2)
            );

            return true;
        }


        return super.mouseClicked(mouseX, mouseY, button);
    }


    protected boolean isMouseOver(double mouseX, double mouseY, int x, int y) {

        return mouseX >= x
                && mouseX < x + layout.buttonSize()
                && mouseY >= y
                && mouseY < y + layout.buttonSize();
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {

        renderBackground(guiGraphics);

        super.render(guiGraphics, mouseX, mouseY, delta);

        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    public record DCMachineScreenLayout(int imageWidth, int imageHeight, int hologramX, int hologramY, int haltX,
                                        int haltY, int lockX, int lockY, int buttonSize, int workingX, int workingY,
                                        int progressX, int progressY, int hologramTextX, int hologramTextY,
                                        int haltTextX, int haltTextY, int lockTextX, int lockTextY,
                                        int multiblockTooltipX, int multiblockTooltipY, int multiblockTooltipWidth,
                                        int multiblockTooltipHeight, int hologramTooltipX, int hologramTooltipY,
                                        int hologramTooltipWidth, int hologramTooltipHeight, int haltTooltipX,
                                        int haltTooltipY, int haltTooltipWidth, int haltTooltipHeight, int lockTooltipX,
                                        int lockTooltipY, int lockTooltipWidth, int lockTooltipHeight, int energyX,
                                        int energyY, int energyWidth, int energyHeight,
                                        float multiblockLv1ProcessModifier, float multiblockLv1EnergyModifier,
                                        float multiblockFormedProcessModifier, float multiblockFormedEnergyModifier,
                                        float multiblockOffProcessModifier, float multiblockOffEnergyModifier) {
    }
}