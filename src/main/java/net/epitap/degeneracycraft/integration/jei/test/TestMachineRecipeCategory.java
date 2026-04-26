package net.epitap.degeneracycraft.integration.jei.test;

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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class TestMachineRecipeCategory implements IRecipeCategory<TestMachineRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Degeneracycraft.MOD_ID, "test_machine_recipe");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/basic/chemistry/basic_performance_chemical_reactor/basic_performance_chemical_reactor_uid.png");
    private final IDrawable background;
    private final IDrawable icon;

    public TestMachineRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 154);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DCBlocks.BASIC_PERFORMANCE_CHEMICAL_REACTOR_BLOCK.get()));
    }

    @Override
    public RecipeType<TestMachineRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.degeneracycraft_basic_performance_chemical_reactor");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    public static final RecipeType<TestMachineRecipe> TYPE =
            new RecipeType<>(UID, TestMachineRecipe.class);

    @Override
    public void draw(TestMachineRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics stack, double mouseX, double mouseY) {
        drawPhase(recipe, stack);
        drawRequiredEnergy(recipe, stack);
        drawRequiredEnergyUsage(recipe, stack);
        drawRequiredTime(recipe, stack);
    }

    protected void drawPhase(TestMachineRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        int phaseRequired = recipe.getRequiredPhase();
        guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase" + phaseRequired), 115, 87, 0xFFFFFF);
    }

    protected void drawRequiredEnergy(TestMachineRecipe recipe, GuiGraphics guiGraphics) {
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

    protected void drawRequiredEnergyUsage(TestMachineRecipe recipe, GuiGraphics guiGraphics) {
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

    protected void drawRequiredTime(TestMachineRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredtime."), 17, 127, 0xFFFFFF);
        guiGraphics.drawString(fontRenderer, recipe.getRequiredTime() * 20 + " tick" + " " + "(" + recipe.getRequiredTime() + " Sec" + ")", 17, 137, 0xFFFFFF);
    }


    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull TestMachineRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 7).addItemStack(recipe.getInput0Item());
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 7).addItemStack(recipe.getInput1Item());
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 25).addItemStack(recipe.getInput2Item());
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 25).addItemStack(recipe.getInput3Item());
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 43).addItemStack(recipe.getInput4Item());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 98, 25).addItemStack(recipe.getOutput0Item());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 25).addItemStack(recipe.getOutput1Item());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 25).addItemStack(recipe.getOutput2Item());
    }
}