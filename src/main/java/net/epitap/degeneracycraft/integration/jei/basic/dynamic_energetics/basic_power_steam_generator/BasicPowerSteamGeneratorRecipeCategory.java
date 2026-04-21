package net.epitap.degeneracycraft.integration.jei.basic.dynamic_energetics.basic_power_steam_generator;

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
import net.epitap.degeneracycraft.block.machine.basic.dynamic_energetics.basic_power_steam_generator.BasicPowerSteamGeneratorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BasicPowerSteamGeneratorRecipeCategory implements IRecipeCategory<BasicPowerSteamGeneratorRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Degeneracycraft.MOD_ID, "basic_power_steam_generator_recipe");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/basic/engineering/basic_power_steam_generator/basic_power_steam_generator_uid.png");
    BasicPowerSteamGeneratorBlockEntity blockEntity;
    private final IDrawable background;
    private final IDrawable icon;

    public BasicPowerSteamGeneratorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 151);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DCBlocks.BASIC_POWER_STEAM_GENERATOR_BLOCK.get()));
    }

    @Override
    public RecipeType<BasicPowerSteamGeneratorRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    public static final RecipeType<BasicPowerSteamGeneratorRecipe> TYPE =
            new RecipeType<>(UID, BasicPowerSteamGeneratorRecipe.class);

    @Override
    public void draw(BasicPowerSteamGeneratorRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics stack, double mouseX, double mouseY) {
        drawPhase(stack);
        drawRequiredEnergy(recipe, stack);
        drawRequiredEnergyUsage(recipe, stack);
        drawRequiredTime(recipe, stack);
    }

    protected void drawPhase(GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("screen." + "degeneracycraft" + ".phase0"), 15, 67, 0xFFFFFF);
    }

    protected void drawRequiredEnergy(BasicPowerSteamGeneratorRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredenergy."), 17, 87, 0xFFFFFF);
        guiGraphics.drawString(fontRenderer, (blockEntity.MACHINE_OUTPUT + " FE"), 17, 97, 0xFFFFFF);
    }

    protected void drawRequiredEnergyUsage(BasicPowerSteamGeneratorRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredenergyusage."), 17, 107, 0xFFFFFF);
        guiGraphics.drawString(fontRenderer, (blockEntity.MACHINE_OUTPUT + " FE/t"), 17, 117, 0xFFFFFF);

    }

    protected void drawRequiredTime(BasicPowerSteamGeneratorRecipe recipe, GuiGraphics guiGraphics) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, Component.translatable("tooltip.degeneracycraft.requiredtime."), 17, 127, 0xFFFFFF);
        guiGraphics.drawString(fontRenderer, blockEntity.MACHINE_OUTPUT + " Sec" + ")", 17, 137, 0xFFFFFF);
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BasicPowerSteamGeneratorRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 7).addItemStack(recipe.getInput0Item());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 25).addItemStack(recipe.getOutput0Item());
    }
}



