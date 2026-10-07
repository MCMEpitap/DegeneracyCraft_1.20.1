package net.epitap.degeneracycraft.item.tool;

import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockEntityBase;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CreativeMultiblockBuilderItem extends Item {

    private static final String MULTIBLOCK_LEVEL_TAG = "MultiblockLevel";

    public CreativeMultiblockBuilderItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return InteractionResultHolder.pass(
                player.getItemInHand(hand)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player == null) {
            return InteractionResult.PASS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (!(blockEntity instanceof DCMachineBlockEntityBase machine)) {
            return InteractionResult.PASS;
        }

        if (player.isShiftKeyDown()) {

            int levelCount = machine.getMultiblockLevelCount();
            if (levelCount <= 0) {
                return InteractionResult.FAIL;
            }

            int currentLevel = getMultiblockLevel(stack);

            if (currentLevel < 0 || currentLevel >= levelCount) {
                currentLevel = 0;
            }

            int nextLevel = (currentLevel + 1) % levelCount;

            setMultiblockLevel(stack, nextLevel);

            if (!level.isClientSide()) {
                player.displayClientMessage(
                        Component.literal(
                                "Multiblock Level: " + nextLevel
                        ).withStyle(
                                style -> style.withColor(0xFFFFFF)
                        ),
                        true
                );
            }

            return InteractionResult.sidedSuccess(
                    level.isClientSide()
            );
        }

        if (level.isClientSide()) {
            return InteractionResult.sidedSuccess(true);
        }

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return InteractionResult.PASS;
        }

        int levelCount = machine.getMultiblockLevelCount();

        if (levelCount <= 0) {
            player.displayClientMessage(
                    Component.literal(
                            "Multiblock construction failed."
                    ).withStyle(
                            style -> style.withColor(0xFF5555)
                    ),
                    true
            );

            return InteractionResult.FAIL;
        }

        int multiblockLevel = getMultiblockLevel(stack);


        if (multiblockLevel < 0
                || multiblockLevel >= levelCount) {

            multiblockLevel = 0;

            setMultiblockLevel(
                    stack,
                    multiblockLevel
            );
        }

        boolean success = machine.buildMultiblock(serverPlayer, multiblockLevel);

        if (!success) {
            player.displayClientMessage(
                    Component.literal(
                            "Multiblock construction failed."
                    ).withStyle(
                            style -> style.withColor(0xFF5555)
                    ),
                    true
            );

            return InteractionResult.FAIL;
        }

        return InteractionResult.sidedSuccess(false);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        tooltip.add(Component.translatable("tooltip.degeneracycraft.multiblock_builder.level", getMultiblockLevel(stack)));
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.degeneracycraft.multiblock_builder.tooltip").withStyle(style -> style.withColor(0xFFFFFF)));
            tooltip.add(Component.translatable("tooltip.degeneracycraft.multiblock_builder.tooltip2").withStyle(style -> style.withColor(0xFFFFFF)));
            tooltip.add(Component.translatable("tooltip.degeneracycraft.multiblock_builder.tooltip3").withStyle(style -> style.withColor(0xFFFFFF)));
        } else {
            tooltip.add(Component.translatable("tooltip.degeneracycraft.toolitem").withStyle(style -> style.withColor(0xFFFF00)));
        }
    }

    public static int getMultiblockLevel(ItemStack stack) {
        return stack.getOrCreateTag().getInt(MULTIBLOCK_LEVEL_TAG);
    }

    public static void setMultiblockLevel(ItemStack stack, int level) {
        stack.getOrCreateTag().putInt(MULTIBLOCK_LEVEL_TAG, Math.max(0, level));
    }
}
