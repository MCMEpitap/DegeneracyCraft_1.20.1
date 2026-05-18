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
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class TestMachineRecipeCategory implements IRecipeCategory<TestMachineRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Degeneracycraft.MOD_ID, "test_machine_recipe");
    public final static ResourceLocation TEXTURE1 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/basic/chemistry/basic_performance_chemical_reactor/basic_performance_chemical_reactor_uid.png");
    public final static ResourceLocation TEXTURE2 =
            new ResourceLocation(Degeneracycraft.MOD_ID, "textures/gui/low/chemistry/basic_performance_chemical_reactor/basic_performance_chemical_reactor_uid.png");

    private final IDrawable bgPhase1;
    private final IDrawable bgPhase2;
    private final IDrawable icon;

    public TestMachineRecipeCategory(IGuiHelper helper) {
        this.bgPhase1 = helper.createDrawable(TEXTURE1,0, 0, 176, 154);
        this.bgPhase2 = helper.createDrawable(TEXTURE2,0, 0, 176, 154);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DCBlocks.BASIC_PERFORMANCE_CHEMICAL_REACTOR_BLOCK.get()));
    }

    @Override
    public RecipeType<TestMachineRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.test_machine_recipe");
    }

    @Override
    public IDrawable getBackground() {
        return this.bgPhase1;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    public static final RecipeType<TestMachineRecipe> TYPE =
            new RecipeType<>(UID, TestMachineRecipe.class);

    @Override
    public void draw(TestMachineRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics stack, double mouseX, double mouseY) {
        int phase = recipe.getRequiredPhase();
        if (phase == 1) {
            bgPhase1.draw(stack);
        } else if (phase == 2) {
            bgPhase2.draw(stack);
        }

        drawPhase(recipe, stack);
        drawRequiredEnergy(recipe, stack);
        drawRequiredEnergyUsage(recipe, stack);
        drawRequiredTime(recipe, stack);
    }

    protected void drawPhase(TestMachineRecipe recipe, GuiGraphics guiGraphics) {
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

    // 入力スロット位置（今の配置そのまま）
    private static final int[][] INPUT_POS = {
            {8, 7},
            {44, 7},
            {8, 25},
            {44, 25},
            {26, 43}
    };

    // 出力スロット位置
    private static final int[][] OUTPUT_POS = {
            {98, 25},
            {116, 25},
            {134, 25},
            {98, 43} // phase2で使ってたやつ
    };

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder,
                          @Nonnull TestMachineRecipe recipe,
                          @Nonnull IFocusGroup focusGroup) {

        List<ItemStack> inputs = recipe.getInputs();
        List<ItemStack> outputs = recipe.getOutputs();

        // ===== 入力 =====
        for (int i = 0; i < inputs.size() && i < INPUT_POS.length; i++) {
            int x = INPUT_POS[i][0];
            int y = INPUT_POS[i][1];

            builder.addSlot(RecipeIngredientRole.INPUT, x, y)
                    .addItemStack(inputs.get(i));
        }

        // ===== 出力 =====
        for (int i = 0; i < outputs.size() && i < OUTPUT_POS.length; i++) {
            int x = OUTPUT_POS[i][0];
            int y = OUTPUT_POS[i][1];

            builder.addSlot(RecipeIngredientRole.OUTPUT, x, y)
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