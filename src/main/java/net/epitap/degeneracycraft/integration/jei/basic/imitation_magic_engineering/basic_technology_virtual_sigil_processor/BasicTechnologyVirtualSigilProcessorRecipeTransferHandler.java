package net.epitap.degeneracycraft.integration.jei.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.block.machine.basic.imitation_magic_engineering.basic_technology_virtual_sigil_processor.BasicTechnologyVirtualSigilProcessorMenu;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCTransferRecipeC2SPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Optional;

public class BasicTechnologyVirtualSigilProcessorRecipeTransferHandler
        implements IRecipeTransferHandler<BasicTechnologyVirtualSigilProcessorMenu, BasicTechnologyVirtualSigilProcessorRecipe> {

    private final Class containerClass;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;
    private final IRecipeTransferHandlerHelper helper;

    public BasicTechnologyVirtualSigilProcessorRecipeTransferHandler(
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
    public Class<BasicTechnologyVirtualSigilProcessorMenu> getContainerClass() {
        return containerClass;
    }

    @Override
    public Optional<MenuType<BasicTechnologyVirtualSigilProcessorMenu>> getMenuType() {
        return Optional.of(DCMenuTypes.BASIC_TECHNOLOGY_VIRTUAL_SIGIL_PROCESSOR_MENU.get());
    }

    @Override
    public RecipeType<BasicTechnologyVirtualSigilProcessorRecipe> getRecipeType() {
        return BasicTechnologyVirtualSigilProcessorRecipeCategory.TYPE;
    }

    private boolean hasAllItems(Player player, BasicTechnologyVirtualSigilProcessorRecipe recipe, boolean maxTransfer) {
        int[] required = new int[recipeSlotCount];

        ItemStack[] inputs = new ItemStack[]{
                recipe.getInput0Item(),
                recipe.getInput1Item(),
                recipe.getInput2Item(),
                recipe.getInput3Item(),
                recipe.getInput4Item()
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
            BasicTechnologyVirtualSigilProcessorMenu container,
            BasicTechnologyVirtualSigilProcessorRecipe recipe,
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