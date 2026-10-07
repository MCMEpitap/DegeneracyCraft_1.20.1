package net.epitap.degeneracycraft.integration.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class DCMultiblockEmiRecipe implements EmiRecipe {
    private final DCMultiblockDisplayData data;

    public DCMultiblockEmiRecipe(DCMultiblockDisplayData data) {
        this.data = data;
    }

    public DCMultiblockDisplayData getData() {
        return data;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return DCMultiblockEmiPlugin.MULTIBLOCK_CATEGORY;
    }

    @Override
    public ResourceLocation getId() {
        return data.getId();
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of();
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of();
    }

    @Override
    public int getDisplayWidth() {
        return DCMultiblockEmiWidget.TOTAL_WIDGET_WIDTH;
    }

    @Override
    public int getDisplayHeight() {
        return DCMultiblockEmiWidget.TOTAL_WIDGET_HEIGHT;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.add(
                new DCMultiblockEmiWidget(
                        0,
                        0,
                        getDisplayWidth(),
                        getDisplayHeight(),
                        data
                )
        );
    }
}