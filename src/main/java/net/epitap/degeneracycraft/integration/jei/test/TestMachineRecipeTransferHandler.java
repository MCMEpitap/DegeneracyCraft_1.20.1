package net.epitap.degeneracycraft.integration.jei.test;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.block.test.TestMachineMenu;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCTransferRecipeC2SPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;

import javax.annotation.Nullable;
import java.util.Optional;

public class TestMachineRecipeTransferHandler
        implements IRecipeTransferHandler<TestMachineMenu, TestMachineRecipe> {

    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;

    public TestMachineRecipeTransferHandler(
            int recipeSlotStart, int recipeSlotCount,
            int inventorySlotStart, int inventorySlotCount) {
        this.recipeSlotStart = recipeSlotStart;
        this.recipeSlotCount = recipeSlotCount;
        this.inventorySlotStart = inventorySlotStart;
        this.inventorySlotCount = inventorySlotCount;
    }

    @Override
    public Class<TestMachineMenu> getContainerClass() {
        return TestMachineMenu.class;
    }

    @Override
    public Optional<MenuType<TestMachineMenu>> getMenuType() {
        return Optional.of(DCMenuTypes.TEST_MACHINE_MENU.get());
    }

    @Override
    public RecipeType<TestMachineRecipe> getRecipeType() {
        return TestMachineRecipeCategory.TYPE;
    }

    @Override
    public @Nullable IRecipeTransferError transferRecipe(
            TestMachineMenu container,
            TestMachineRecipe recipe,
            IRecipeSlotsView recipeSlots,
            Player player,
            boolean maxTransfer,
            boolean doTransfer
    ) {
        if (!doTransfer) return null;

        DCMessages.sendToServer(new DCTransferRecipeC2SPacket(container.blockEntity.getBlockPos(), recipe.getId(), maxTransfer));

        return null;
    }
}