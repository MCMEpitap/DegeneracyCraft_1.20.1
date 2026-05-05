package net.epitap.degeneracycraft.integration.jei.basic.geo_science.rock_crasher;

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
import net.epitap.degeneracycraft.block.machine.basic.geo_science.basic_performance_rock_crasher.BasicPerformanceRockCrasherMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;


public class RockCrasherRecipeCategory implements IRecipeCategory<RockCrasherRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Degeneracycraft.MOD_ID, "rock_crasher_recipe");
    public final static ResourceLocation TEXTURE1 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/basic/geo_science/basic_performance_rock_crasher/basic_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE2 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/low/geo_science/low_performance_rock_crasher/low_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE3 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/medium/geo_science/medium_performance_rock_crasher/medium_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE4 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/high/geo_science/high_performance_rock_crasher/high_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE5 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/super/geo_science/super_performance_rock_crasher/super_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE6 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/over/geo_science/over_performance_rock_crasher/over_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE7 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/ultra/geo_science/ultra_performance_rock_crasher/ultra_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE8 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/anti/geo_science/anti_performance_rock_crasher/anti_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE9 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/imaginary/geo_science/imaginary_performance_rock_crasher/imaginary_performance_rock_crasher_uid.png");
    public final static ResourceLocation TEXTURE10 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/infinity/geo_science/infinity_performance_rock_crasher/infinity_performance_rock_crasher_uid.png");

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

    public BasicPerformanceRockCrasherMenu menu;

    public RockCrasherRecipeCategory(IGuiHelper helper) {
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
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DCBlocks.BASIC_PERFORMANCE_ROCK_CRASHER_BLOCK.get()));
    }

    @Override
    public RecipeType<RockCrasherRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.degeneracycraft_rock_crasher");
    }

    @Override
    public IDrawable getBackground() {
        return this.background1;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    public static final RecipeType<RockCrasherRecipe> TYPE =
            new RecipeType<>(UID, RockCrasherRecipe.class);


    @Override
    public void draw(RockCrasherRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics stack, double mouseX, double mouseY) {
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

    protected void drawPhase(RockCrasherRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        int phase = recipe.getRequiredPhase();
        guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phase), 115, 87, 0xFF0000);
    }

    protected void drawRequiredEnergy(RockCrasherRecipe recipe, GuiGraphics guiGraphics) {
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

    protected void drawRequiredEnergyUsage(RockCrasherRecipe recipe, GuiGraphics guiGraphics) {
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

    protected void drawRequiredTime(RockCrasherRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredtime."), 17, 127, 0xFFFFFF);
        guiGraphics.drawString(fontRenderer, recipe.getRequiredTime() * 20 + " tick" + " " + "(" + recipe.getRequiredTime() + " Sec" + ")", 17, 137, 0xFFFFFF);
    }

    protected void drawRequiredCondition(RockCrasherRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.night."), 80, 127, 0xFFFFFF);
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder,
                          @Nonnull RockCrasherRecipe recipe,
                          @Nonnull IFocusGroup focusGroup) {

        List<ItemStack> inputs = recipe.getInputs();
        List<ItemStack> outputs = recipe.getOutputs();

        int phase = recipe.getRequiredPhase();

        int[][] inputPos = new int[0][];
        int[][] outputPos = new int[0][];

        switch (phase) {
            case 1 -> {
                inputPos = new int[][]{
                        {menu.IN_X_0, menu.IN_Y_0}
                };

                outputPos = new int[][]{
                        {menu.OUT_X_0, menu.OUT_Y_0},
                        {menu.OUT_X_1, menu.OUT_Y_1},
                        {menu.OUT_X_2, menu.OUT_Y_2}
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
}

