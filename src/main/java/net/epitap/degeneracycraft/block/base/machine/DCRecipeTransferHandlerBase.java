package net.epitap.degeneracycraft.block.base.machine;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class DCRecipeTransferHandlerBase<M extends AbstractContainerMenu, R extends Recipe<?>> implements IRecipeTransferHandler<M, R> {

    protected final IRecipeTransferHandlerHelper helper;
    private final Class<M> containerClass;

    protected DCRecipeTransferHandlerBase(IRecipeTransferHandlerHelper helper, Class<M> containerClass) {
        this.helper = helper;
        this.containerClass = containerClass;
    }

    @Override
    public Class<M> getContainerClass() {
        return containerClass;
    }

    @Override
    public Optional<MenuType<M>> getMenuType() {
        return Optional.of(getDCMenuType());
    }

    protected abstract MenuType<M> getDCMenuType();

    @Override
    public RecipeType<R> getRecipeType() {
        return getDCRecipeType();
    }

    protected abstract RecipeType<R> getDCRecipeType();

    protected abstract void sendTransferPacket(M container, R recipe, boolean maxTransfer);

    protected boolean hasAllItems(Player player, R recipe) {
        Map<Item, Integer> requiredMap = new HashMap<>();

        for (ItemStack input : getRecipeInputs(recipe)) {
            if (input.isEmpty()) continue;

            requiredMap.merge(input.getItem(), input.getCount(), Integer::sum);
        }

        Map<Item, Integer> foundMap = new HashMap<>();

        for (int i = 0;
             i < player.getInventory().getContainerSize();
             i++) {

            ItemStack stack = player.getInventory().getItem(i);

            if (stack.isEmpty()) continue;

            if (requiredMap.containsKey(stack.getItem())) {
                foundMap.merge(stack.getItem(), stack.getCount(), Integer::sum);
            }
        }

        for (Item item : requiredMap.keySet()) {
            int required = requiredMap.get(item);
            int found = foundMap.getOrDefault(item, 0);

            if (found < required) {
                return false;
            }
        }

        return true;
    }

    protected abstract List<ItemStack> getRecipeInputs(R recipe);

    @Override
    public @Nullable IRecipeTransferError transferRecipe(M container, R recipe, IRecipeSlotsView recipeSlots,
            Player player, boolean maxTransfer, boolean doTransfer) {
        if (!doTransfer) {
            if (!hasAllItems(player, recipe)) {
                return helper.createUserErrorWithTooltip(Component.translatable(
                                "jei.tooltip.error.recipe.transfer.missing"
                        ));
            }

            return null;
        }

        sendTransferPacket(container, recipe, maxTransfer);

        return null;
    }
}