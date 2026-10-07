package net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope;

import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.block.base.machine.DCRecipeTransferHandlerBase;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.astronomical_telescope.AstronomicalTelescopeRecipe;
import net.epitap.degeneracycraft.integration.jei.basic.astronomy.astronomical_telescope.AstronomicalTelescopeRecipeCategory;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCTransferRecipeC2SPacket;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class BasicPerformanceAstronomicalTelescopeTransferHandler
        extends DCRecipeTransferHandlerBase<BasicPerformanceAstronomicalTelescopeMenu, AstronomicalTelescopeRecipe> {

    public BasicPerformanceAstronomicalTelescopeTransferHandler(IRecipeTransferHandlerHelper helper) {
        super(helper, BasicPerformanceAstronomicalTelescopeMenu.class);
    }

    @Override
    protected MenuType<BasicPerformanceAstronomicalTelescopeMenu> getDCMenuType() {
        return DCMenuTypes.BASIC_PERFORMANCE_ASTROMICAL_TELESCOPE_MENU.get();
    }

    @Override
    protected RecipeType<AstronomicalTelescopeRecipe> getDCRecipeType() {
        return AstronomicalTelescopeRecipeCategory.TYPE;
    }

    @Override
    protected List<ItemStack> getRecipeInputs(AstronomicalTelescopeRecipe recipe) {
        return recipe.getInputs();
    }

    @Override
    protected void sendTransferPacket(BasicPerformanceAstronomicalTelescopeMenu container,
            AstronomicalTelescopeRecipe recipe, boolean maxTransfer) {
        DCMessages.sendToServer(
                new DCTransferRecipeC2SPacket(container.getBlockEntity().getBlockPos(), recipe.getId(), maxTransfer)
        );
    }
}