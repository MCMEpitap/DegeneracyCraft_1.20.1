package net.epitap.degeneracycraft.item.tool.initial;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class PrototypeMechanicalAxeItem extends AxeItem {

    private static final String MODE_KEY = "MiningMode";
    private static final int MAX_LOGS = 128;

    public PrototypeMechanicalAxeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(isChainMode(stack)
                ? Component.translatable("tool.degeneracycraft_cutting_chain")
                .withStyle(style -> style.withColor(0xFFFFFF).withUnderlined(true))
                : Component.translatable("tool.degeneracycraft_cutting_1x1x1")
                .withStyle(style -> style.withColor(0xFFFFFF).withUnderlined(true))
        );

        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.degeneracycraft.tools").withStyle(style -> style.withColor(0xFFFFFF)));
            tooltip.add(Component.translatable("tooltip.degeneracycraft.prototype_mechanical_axe").withStyle(style -> style.withColor(0xFFFFFF)));
        } else {
            tooltip.add(Component.translatable("tooltip.degeneracycraft.toolitem").withStyle(style -> style.withColor(0xFFFF00)));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        if (player.isShiftKeyDown()) {

            CompoundTag tag = stack.getOrCreateTag();

            int mode = tag.getInt(MODE_KEY);
            mode = (mode + 1) % 2;

            tag.putInt(MODE_KEY, mode);

            if (!level.isClientSide) {
                player.displayClientMessage(
                        mode == 0
                                ? Component.translatable("tool.degeneracycraft_cutting_1x1x1")
                                .withStyle(style -> style.withColor(0xFFFFFF))
                                : Component.translatable("tool.degeneracycraft_cutting_chain")
                                .withStyle(style -> style.withColor(0xFFFFFF)),
                        true
                );
            }

            return InteractionResultHolder.success(stack);
        }

        return super.use(level, player, hand);
    }

    private int getMode(ItemStack stack) {
        return stack.getOrCreateTag().getInt(MODE_KEY);
    }

    @Override
    public boolean mineBlock(ItemStack stack,
                             Level level,
                             BlockState state,
                             BlockPos pos,
                             LivingEntity entity) {

        if (level.isClientSide) {
            return super.mineBlock(stack, level, state, pos, entity);
        }

        if (!(entity instanceof Player player)) {
            return super.mineBlock(stack, level, state, pos, entity);
        }

        if (getMode(stack) == 1) {

            HitResult hit = player.pick(20.0D, 0.0F, false);

            if (hit instanceof BlockHitResult blockHit) {

                int broken = breakTree(level, pos, player, stack);

                if (broken > 0) {
                    stack.hurtAndBreak(broken, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
                }
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }

    private int breakTree(Level level,
                          BlockPos startPos,
                          Player player,
                          ItemStack stack) {

        BlockState startState = level.getBlockState(startPos);

        if (!startState.is(BlockTags.LOGS)) {
            return 0;
        }

        Queue<BlockPos> queue = new ArrayDeque<>();
        Set<BlockPos> visited = new HashSet<>();

        queue.add(startPos);
        visited.add(startPos);

        int broken = 0;

        while (!queue.isEmpty() && broken < MAX_LOGS) {

            BlockPos pos = queue.poll();
            BlockState state = level.getBlockState(pos);

            if (!state.is(BlockTags.LOGS))
                continue;

            if (level.getBlockEntity(pos) != null)
                continue;

            if (state.getDestroySpeed(level, pos) < 0)
                continue;

            level.destroyBlock(pos, true);

            broken++;

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {

                        if (x == 0 && y == 0 && z == 0)
                            continue;

                        BlockPos next = pos.offset(x, y, z);

                        if (visited.add(next)) {

                            if (level.getBlockState(next).is(BlockTags.LOGS)) {
                                queue.add(next);
                            }

                        }
                    }
                }
            }
        }

        return broken;
    }

    public boolean isChainMode(ItemStack stack) {
        return getMode(stack) == 1;
    }
}