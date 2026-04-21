package net.epitap.degeneracycraft.integration.jei.basic.formal_science.basic_performance_machine_data_installer;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import net.epitap.degeneracycraft.block.machine.basic.formal_science.basic_performance_machine_data_installer.BasicPerformanceMachineDataInstallerMenu;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCTransferRecipeC2SPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;

import javax.annotation.Nullable;
import java.util.Optional;

public class BasicPerformanceMachineDataInstallerRecipeTransferHandler<T extends BasicPerformanceMachineDataInstallerMenu, R extends BasicPerformanceMachineDataInstallerRecipe>
        implements IRecipeTransferHandler<T, BasicPerformanceMachineDataInstallerRecipe> {

    private final Class<T> containerClass;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;

    public BasicPerformanceMachineDataInstallerRecipeTransferHandler(Class<T> containerClass,
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
    public RecipeType<BasicPerformanceMachineDataInstallerRecipe> getRecipeType() {
        return BasicPerformanceMachineDataInstallerRecipeCategory.TYPE;
    }

    @Override
    public @Nullable IRecipeTransferError transferRecipe(
            BasicPerformanceMachineDataInstallerMenu container,
            BasicPerformanceMachineDataInstallerRecipe recipe,
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