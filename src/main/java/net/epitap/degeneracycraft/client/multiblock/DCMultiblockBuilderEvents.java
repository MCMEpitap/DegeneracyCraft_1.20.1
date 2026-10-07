package net.epitap.degeneracycraft.client.multiblock;

import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockEntityBase;
import net.epitap.degeneracycraft.item.tool.CreativeMultiblockBuilderItem;
import net.epitap.degeneracycraft.item.tool.MultiblockBuilderItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "degeneracycraft")
public class DCMultiblockBuilderEvents {

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Level level = player.level();
        BlockPos pos = event.getPos();

        ItemStack stack = player.getMainHandItem();

        boolean isCreativeBuilder =
                stack.getItem() instanceof CreativeMultiblockBuilderItem;

        boolean isSurvivalBuilder =
                stack.getItem() instanceof MultiblockBuilderItem;

        if (!isCreativeBuilder && !isSurvivalBuilder) {
            return;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (!(blockEntity instanceof DCMachineBlockEntityBase machine)) {
            return;
        }

        event.setCanceled(true);

        if (level.isClientSide()) {
            return;
        }

        int levelCount =
                machine.getMultiblockLevelCount();

        if (levelCount <= 0) {
            return;
        }

        int multiblockLevel;

        if (isCreativeBuilder) {
            multiblockLevel =
                    CreativeMultiblockBuilderItem.getMultiblockLevel(stack);

            if (multiblockLevel < 0 ||
                    multiblockLevel >= levelCount) {

                multiblockLevel = 0;

                CreativeMultiblockBuilderItem.setMultiblockLevel(
                        stack,
                        multiblockLevel
                );
            }

            boolean success =
                    machine.clearMultiblock(multiblockLevel);

            if (success) {
                player.displayClientMessage(
                        Component.literal("Multiblock cleared.")
                                .withStyle(
                                        style -> style.withColor(0xFFFFFF)
                                ),
                        true
                );
            }

        } else if (isSurvivalBuilder) {
            multiblockLevel =
                    MultiblockBuilderItem.getMultiblockLevel(stack);

            if (multiblockLevel < 0 ||
                    multiblockLevel >= levelCount) {

                multiblockLevel = 0;

                MultiblockBuilderItem.setMultiblockLevel(
                        stack,
                        multiblockLevel
                );
            }

            boolean success =
                    machine.clearMultiblockSurvival(
                            (ServerPlayer) player,
                            multiblockLevel
                    );

            if (success) {
                player.displayClientMessage(
                        Component.literal("Multiblock cleared.")
                                .withStyle(
                                        style -> style.withColor(0xFFFFFF)
                                ),
                        true
                );
            }
        }
    }
}