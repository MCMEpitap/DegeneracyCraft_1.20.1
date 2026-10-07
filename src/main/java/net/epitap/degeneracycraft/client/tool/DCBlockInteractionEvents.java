package net.epitap.degeneracycraft.client.tool;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiGlassBlockBase;
import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockBase;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiBlockBase;
import net.epitap.degeneracycraft.item.tool.WrenchItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Degeneracycraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DCBlockInteractionEvents {

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();

        if (!player.isShiftKeyDown()) {
            return;
        }

        ItemStack stack = player.getItemInHand(event.getHand());

        if (!WrenchItem.isWrench(stack)) {
            return;
        }

        Level level = player.level();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (!(state.getBlock() instanceof DCMachineBlockBase || state.getBlock() instanceof DCMultiBlockBase
                || state.getBlock() instanceof DCMultiGlassBlockBase)) {
            return;
        }

        event.setCanceled(true);

        if (!level.isClientSide()) {
            level.destroyBlock(pos, true, player);
        }
    }
}