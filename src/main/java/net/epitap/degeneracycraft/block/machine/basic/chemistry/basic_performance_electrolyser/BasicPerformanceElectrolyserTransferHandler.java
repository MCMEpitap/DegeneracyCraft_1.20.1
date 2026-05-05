package net.epitap.degeneracycraft.block.machine.basic.chemistry.basic_performance_electrolyser;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.electrolyser.ElectrolyserRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.chemistry.electrolyser.ElectrolyserRecipeCategory;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCTransferRecipeC2SPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BasicPerformanceElectrolyserTransferHandler
        implements IRecipeTransferHandler<BasicPerformanceElectrolyserMenu, ElectrolyserRecipe> {

    private final Class containerClass;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;
    private final IRecipeTransferHandlerHelper helper;

    public BasicPerformanceElectrolyserTransferHandler(
            IRecipeTransferHandlerHelper helper,
            Class containerClass,
            int recipeSlotStart, int recipeSlotCount,
            int inventorySlotStart, int inventorySlotCount
    ) {
        this.helper = helper;
        this.containerClass = containerClass;
        this.recipeSlotStart = recipeSlotStart;
        this.recipeSlotCount = recipeSlotCount;
        this.inventorySlotStart = inventorySlotStart;
        this.inventorySlotCount = inventorySlotCount;
    }

    @Override
    public Class<BasicPerformanceElectrolyserMenu> getContainerClass() {
        return containerClass;
    }

    @Override
    public Optional<MenuType<BasicPerformanceElectrolyserMenu>> getMenuType() {
        return Optional.of(DCMenuTypes.BASIC_PERFORMANCE_ELECTROLYSER_MENU.get());
    }

    @Override
    public RecipeType<ElectrolyserRecipe> getRecipeType() {
        return ElectrolyserRecipeCategory.TYPE;
    }

    private boolean hasAllItems(Player player, ElectrolyserRecipe recipe, boolean maxTransfer) {

        Map<Item, Integer> requiredMap = new HashMap<>();

        for (ItemStack input : recipe.getInputs()) {
            if (input.isEmpty()) continue;

            requiredMap.merge(input.getItem(), input.getCount(), Integer::sum);
        }

        Map<Item, Integer> foundMap = new HashMap<>();

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.isEmpty()) continue;

            if (requiredMap.containsKey(stack.getItem())) {
                foundMap.merge(stack.getItem(), stack.getCount(), Integer::sum);
            }
        }

        for (Item item : requiredMap.keySet()) {
            int required = requiredMap.get(item);
            int found = foundMap.getOrDefault(item, 0);

            if (found < required) return false;
        }

        return true;
    }


    @Override
    public @Nullable IRecipeTransferError transferRecipe(
            BasicPerformanceElectrolyserMenu container,
            ElectrolyserRecipe recipe,
            IRecipeSlotsView recipeSlots,
            Player player,
            boolean maxTransfer,
            boolean doTransfer
    ) {
        if (!doTransfer) {
            if (!hasAllItems(player, recipe, maxTransfer)) {
                return helper.createUserErrorWithTooltip(Component.translatable("jei.tooltip.error.recipe.transfer.missing"));
            }
            return null;
        }

        DCMessages.sendToServer(new DCTransferRecipeC2SPacket(container.blockEntity.getBlockPos(), recipe.getId(), maxTransfer)
        );

        return null;
    }
}