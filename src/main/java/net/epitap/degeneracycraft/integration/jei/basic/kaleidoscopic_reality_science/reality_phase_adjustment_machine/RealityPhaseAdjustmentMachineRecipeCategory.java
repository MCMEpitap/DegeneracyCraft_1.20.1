package net.epitap.degeneracycraft.integration.jei.basic.kaleidoscopic_reality_science.reality_phase_adjustment_machine;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.block.machine.basic.kaleidoscopic_reality_science.basic_performance_reality_phase_adjustment_machine.BasicPerformanceRealityPhaseAdjustmentMachineMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class RealityPhaseAdjustmentMachineRecipeCategory implements IRecipeCategory<RealityPhaseAdjustmentMachineRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Degeneracycraft.MOD_ID, "reality_phase_adjustment_machine_recipe");
    public final static ResourceLocation TEXTURE1 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/basic/kaleidoscopic_reality_science/basic_performance_reality_phase_adjustment_machine/basic_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE2 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/low/kaleidoscopic_reality_science/low_performance_reality_phase_adjustment_machine/low_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE3 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/medium/kaleidoscopic_reality_science/medium_performance_reality_phase_adjustment_machine/medium_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE4 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/high/kaleidoscopic_reality_science/high_performance_reality_phase_adjustment_machine/high_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE5 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/super/kaleidoscopic_reality_science/super_performance_reality_phase_adjustment_machine/super_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE6 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/over/kaleidoscopic_reality_science/over_performance_reality_phase_adjustment_machine/over_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE7 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/ultra/kaleidoscopic_reality_science/ultra_performance_reality_phase_adjustment_machine/ultra_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE8 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/anti/kaleidoscopic_reality_science/anti_performance_reality_phase_adjustment_machine/anti_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE9 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/imaginary/kaleidoscopic_reality_science/imaginary_performance_reality_phase_adjustment_machine/imaginary_performance_reality_phase_adjustment_machine_uid.png");
    public final static ResourceLocation TEXTURE10 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/infinity/kaleidoscopic_reality_science/infinity_performance_reality_phase_adjustment_machine/infinity_performance_reality_phase_adjustment_machine_uid.png");

    private final IDrawable background1;
    private final IDrawable background2;
    private final IDrawable background3;
    private final IDrawable background4;
    private final IDrawable background5;
    private final IDrawable background6;
    private final IDrawable background7;
    private final IDrawable background8;
    private final IDrawable background9;
    private final IDrawable background10;

    private final IDrawable icon;

    public BasicPerformanceRealityPhaseAdjustmentMachineMenu menu;

    public RealityPhaseAdjustmentMachineRecipeCategory(IGuiHelper helper) {
        this.background1 = helper.createDrawable(TEXTURE1, 0, 0, 176, 154);
        this.background2 = helper.createDrawable(TEXTURE2, 0, 0, 176, 154);
        this.background3 = helper.createDrawable(TEXTURE3, 0, 0, 176, 154);
        this.background4 = helper.createDrawable(TEXTURE4, 0, 0, 176, 154);
        this.background5 = helper.createDrawable(TEXTURE5, 0, 0, 176, 154);
        this.background6 = helper.createDrawable(TEXTURE6, 0, 0, 176, 154);
        this.background7 = helper.createDrawable(TEXTURE7, 0, 0, 176, 154);
        this.background8 = helper.createDrawable(TEXTURE8, 0, 0, 176, 154);
        this.background9 = helper.createDrawable(TEXTURE9, 0, 0, 176, 154);
        this.background10 = helper.createDrawable(TEXTURE10, 0, 0, 176, 154);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DCBlocks.BASIC_PERFORMANCE_REALITY_PHASE_ADJUSTMENT_MACHINE_BLOCK.get()));
    }

    @Override
    public RecipeType<RealityPhaseAdjustmentMachineRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.degeneracycraft_reality_phase_adjustment_machine");
    }

    @Override
    public IDrawable getBackground() {
        return this.background1;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    public static final RecipeType<RealityPhaseAdjustmentMachineRecipe> TYPE =
            new RecipeType<>(UID, RealityPhaseAdjustmentMachineRecipe.class);


    @Override
    public void draw(RealityPhaseAdjustmentMachineRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics stack, double mouseX, double mouseY) {
        int phase = recipe.getRequiredPhase();
        switch (phase) {
            case 1 -> background1.draw(stack);
            case 2 -> background2.draw(stack);
            case 3 -> background3.draw(stack);
            case 4 -> background4.draw(stack);
            case 5 -> background5.draw(stack);
            case 6 -> background6.draw(stack);
            case 7 -> background7.draw(stack);
            case 8 -> background8.draw(stack);
            case 9 -> background9.draw(stack);
            case 10 -> background10.draw(stack);
        }

        drawPhase(recipe, stack);
        drawRequiredEnergy(recipe, stack);
        drawRequiredEnergyUsage(recipe, stack);
        drawRequiredTime(recipe, stack);
        drawRequiredCondition(recipe, stack);
    }

    protected void drawPhase(RealityPhaseAdjustmentMachineRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        int phase = recipe.getRequiredPhase();

        switch (phase) {
            case 0 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0xFFFFFF);
            case 1 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0xFF0000);
            case 2 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0xFFFF00);
            case 3 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0x00FF00);
            case 4 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0x00FFFF);
            case 5 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0x0000FF);
            case 6 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0xFF00FF);
            case 7 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0x808080);
            case 8 ->
                    guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0x404040);
            case 9 ->
                    guiGraphics.drawString(fontRenderer, grayText(Component.translatable("screen.degeneracycraft.phase" + phase).getString()), 115, 87, 0xFFFFFF);
            case 10 ->
                    guiGraphics.drawString(fontRenderer, rainbowText(Component.translatable("screen.degeneracycraft.phase" + phase).getString()), 115, 87, 0xFFFFFF);
            default -> throw new IllegalStateException("Unexpected value: " + phase);
        }
    }

    protected void drawRequiredEnergy(RealityPhaseAdjustmentMachineRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredenergy."), 17, 87, 0xFFFFFF);
        float energyRequired = recipe.getRequiredEnergy();
        if (energyRequired >= 1E3F) {
            guiGraphics.drawString(fontRenderer, (energyRequired / 1E3F + " kFE"), 17, 97, 0xFFFFFF);
        } else if (energyRequired >= 0F) {
            guiGraphics.drawString(fontRenderer, (energyRequired + " FE"), 17, 97, 0xFFFFFF);
        }
    }

    protected void drawRequiredEnergyUsage(RealityPhaseAdjustmentMachineRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredenergyusage."), 17, 107, 0xFFFFFF);

        float energyUsage = (recipe.getRequiredEnergy() / (recipe.getRequiredTime() * 20F));
        if (energyUsage >= 1E3F) {
            guiGraphics.drawString(fontRenderer, (energyUsage / 1E3F + " kFE/t"), 17, 117, 0xFFFFFF);
        } else if (energyUsage >= 0F) {
            guiGraphics.drawString(fontRenderer, (energyUsage + " FE/t"), 17, 117, 0xFFFFFF);
        }

    }

    protected void drawRequiredTime(RealityPhaseAdjustmentMachineRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredtime."), 17, 127, 0xFFFFFF);
        guiGraphics.drawString(fontRenderer, recipe.getRequiredTime() * 20 + " tick" + " " + "(" + recipe.getRequiredTime() + " Sec" + ")", 17, 137, 0xFFFFFF);
    }

    protected void drawRequiredCondition(RealityPhaseAdjustmentMachineRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.night."), 80, 127, 0xFFFFFF);
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder,
                          @Nonnull RealityPhaseAdjustmentMachineRecipe recipe,
                          @Nonnull IFocusGroup focusGroup) {

        List<ItemStack> inputs = recipe.getInputs();
        List<ItemStack> outputs = recipe.getOutputs();

        int phase = recipe.getRequiredPhase();

        int[][] inputPos = new int[0][];
        int[][] outputPos = new int[0][];

        switch (phase) {
            case 1 -> {
                inputPos = new int[][]{
                        {menu.IN_X_0, menu.IN_Y_0},
                        {menu.IN_X_1, menu.IN_Y_1},
                        {menu.IN_X_2, menu.IN_Y_2},
                        {menu.IN_X_3, menu.IN_Y_3},
                        {menu.IN_X_4, menu.IN_Y_4},
                        {menu.IN_X_5, menu.IN_Y_5},
                        {menu.IN_X_6, menu.IN_Y_6},
                        {menu.IN_X_7, menu.IN_Y_7},
                        {menu.IN_X_8, menu.IN_Y_8}                };

                outputPos = new int[][]{
                        {menu.OUT_X_0, menu.OUT_Y_0}
                };
            }
        }

        for (int i = 0; i < inputs.size() && i < inputPos.length; i++) {
            builder.addSlot(RecipeIngredientRole.INPUT, inputPos[i][0], inputPos[i][1])
                    .addItemStack(inputs.get(i));
        }

        for (int i = 0; i < outputs.size() && i < outputPos.length; i++) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, outputPos[i][0], outputPos[i][1])
                    .addItemStack(outputs.get(i));
        }
    }

    private static final int[] RAINBOW = {
            0xFF0000, 0xFFFF00, 0x00FF00,
            0x00FFFF, 0x0000FF, 0xFF00FF
    };

    private static final int[] GLAY_SCALE = {
            0x404040, 0x808080, 0xFFFFFF
    };

    private static Component rainbowText(String text) {
        MutableComponent result = Component.empty();

        int len = text.length();

        for (int i = 0; i < len; i++) {
            int index = i * RAINBOW.length / len;

            int color = RAINBOW[index];

            result.append(
                    Component.literal(String.valueOf(text.charAt(i)))
                            .withStyle(style -> style
                                    .withColor(color)
                                    .withBold(true)
                                    .withUnderlined(true))
            );
        }

        return result;
    }

    private static Component grayText(String text) {
        MutableComponent result = Component.empty();

        int len = text.length();

        for (int i = 0; i < len; i++) {
            int index = i * GLAY_SCALE.length / len;

            int color = GLAY_SCALE[index];

            result.append(
                    Component.literal(String.valueOf(text.charAt(i)))
                            .withStyle(style -> style
                                    .withColor(color)
                                    .withBold(true)
                                    .withUnderlined(true))
            );
        }

        return result;
    }
}



