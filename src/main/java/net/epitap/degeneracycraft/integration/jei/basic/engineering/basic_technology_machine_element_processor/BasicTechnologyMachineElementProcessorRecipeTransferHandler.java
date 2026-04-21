package net.epitap.degeneracycraft.integration.jei.basic.engineering.basic_technology_machine_element_processor;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.engineering.basic_technology_machine_element_processor.BasicTechnologyMachineElementProcessorMenu;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCTransferRecipeC2SPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;

import javax.annotation.Nullable;
import java.util.Optional;

public class BasicTechnologyMachineElementProcessorRecipeTransferHandler<T extends BasicTechnologyMachineElementProcessorMenu, R extends BasicTechnologyMachineElementProcessorRecipe>
        implements IRecipeTransferHandler<T, BasicTechnologyMachineElementProcessorRecipe> {

    private final Class<T> containerClass;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;

    public BasicTechnologyMachineElementProcessorRecipeTransferHandler(Class<T> containerClass,
                                                                       int recipeSlotStart, int recipeSlotCount,
                                                                       int inventorySlotStart, int inventorySlotCount) {
        this.containerClass = containerClass;
        this.recipeSlotStart = recipeSlotStart;
        this.recipeSlotCount = recipeSlotCount;
        this.inventorySlotStart = inventorySlotStart;
        this.inventorySlotCount = inventorySlotCount;
    }

    @Override
    public Class<T> getContainerClass() {
        return containerClass;
    }

    @Override
    public Optional<MenuType<T>> getMenuType() {
        return Optional.empty();
    }

    @Override
    public RecipeType<BasicTechnologyMachineElementProcessorRecipe> getRecipeType() {
        return BasicTechnologyMachineElementProcessorRecipeCategory.TYPE;
    }

    @Override
    public @Nullable IRecipeTransferError transferRecipe(
            BasicTechnologyMachineElementProcessorMenu container,
            BasicTechnologyMachineElementProcessorRecipe recipe,
            IRecipeSlotsView recipeSlots,
            Player player,
            boolean maxTransfer,
            boolean doTransfer
    ) {
        if (!doTransfer) {
            return null;
        }

        DCMessages.sendToServer(new DCTransferRecipeC2SPacket(container.blockEntity.getBlockPos(),recipe.getId(),maxTransfer)
        );

        return null;
    }
}