package net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_suspected_magic_condenser.BasicTechnologySuspectedMagicCondenserMenu;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCTransferRecipeC2SPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Optional;

public class BasicTechnologySuspectedMagicCondenserRecipeTransferHandler
        implements IRecipeTransferHandler<BasicTechnologySuspectedMagicCondenserMenu, BasicTechnologySuspectedMagicCondenserRecipe> {

    private final Class containerClass;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;
    private final IRecipeTransferHandlerHelper helper;

    public BasicTechnologySuspectedMagicCondenserRecipeTransferHandler(
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
    public Class<BasicTechnologySuspectedMagicCondenserMenu> getContainerClass() {
        return containerClass;
    }

    @Override
    public Optional<MenuType<BasicTechnologySuspectedMagicCondenserMenu>> getMenuType() {
        return Optional.of(DCMenuTypes.BASIC_TECHNOLOGY_SUSPECTED_MAGIC_CONDENSER_MENU.get());
    }

    @Override
    public RecipeType<BasicTechnologySuspectedMagicCondenserRecipe> getRecipeType() {
        return BasicTechnologySuspectedMagicCondenserRecipeCategory.TYPE;
    }

    private boolean hasAllItems(Player player, BasicTechnologySuspectedMagicCondenserRecipe recipe, boolean maxTransfer) {
        int[] required = new int[recipeSlotCount];

        ItemStack[] inputs = new ItemStack[]{
                recipe.getInput0Item()
        };

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].isEmpty()) continue;
            required[i] = inputs[i].getCount();
        }

        int[] found = new int[recipeSlotCount];

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.isEmpty()) continue;

            for (int j = 0; j < inputs.length; j++) {
                if (!inputs[j].isEmpty() && ItemStack.isSameItemSameTags(stack, inputs[j])) {
                    found[j] += stack.getCount();
                }
            }
        }

        for (int i = 0; i < required.length; i++) {
            if (found[i] < required[i]) return false;
        }

        return true;
    }


    @Override
    public @Nullable IRecipeTransferError transferRecipe(
            BasicTechnologySuspectedMagicCondenserMenu container,
            BasicTechnologySuspectedMagicCondenserRecipe recipe,
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

        DCMessages.sendToServer(
                new DCTransferRecipeC2SPacket(
                        container.blockEntity.getBlockPos(),
                        recipe.getId(),
                        maxTransfer
                )
        );

        return null;
    }
}