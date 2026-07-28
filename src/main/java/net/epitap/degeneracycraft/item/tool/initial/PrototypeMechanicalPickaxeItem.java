package net.epitap.degeneracycraft.item.tool.initial;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;
import java.util.List;

public class PrototypeMechanicalPickaxeItem extends PickaxeItem {
    private static final String MODE_KEY = "MiningMode";
    public PrototypeMechanicalPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(isWideMode(stack)
                ? Component.translatable("tool.degeneracycraft_mining_3x1x3")
                .withStyle(style -> style.withColor(0xFFFFFF).withUnderlined(true))
                : Component.translatable("tool.degeneracycraft_mining_1x1x1")
                .withStyle(style -> style.withColor(0xFFFFFF).withUnderlined(true))
        );
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.degeneracycraft.tools").withStyle(style -> style.withColor(0xFFFFFF)));
            tooltip.add(Component.translatable("tooltip.degeneracycraft.prototype_mechanical_pickaxe").withStyle(style -> style.withColor(0xFFFFFF)));        } else {
            tooltip.add(Component.translatable("tooltip.degeneracycraft.toolitem").withStyle(style -> style.withColor(0xFFFF00)));
        }
        super.appendHoverText(stack, level, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(player.isShiftKeyDown()) {

            CompoundTag tag = stack.getOrCreateTag();

            int mode = tag.getInt(MODE_KEY);

            mode = (mode + 1) % 2;

            tag.putInt(MODE_KEY, mode);

            if (!level.isClientSide) {
                player.displayClientMessage(
                        mode == 0
                                ? Component.translatable("tool.degeneracycraft_mining_1x1x1")
                                .withStyle(style -> style.withColor(0xFFFFFF))
                                : Component.translatable("tool.degeneracycraft_mining_3x1x3")
                                .withStyle(style -> style.withColor(0xFFFFFF)),
                        true
                );
            }

            return InteractionResultHolder.success(stack);
        }

        return super.use(level, player, hand);
    }

    private int getMode(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.getInt(MODE_KEY);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state,
                             BlockPos pos, LivingEntity entity) {

        if (level.isClientSide) {
            return super.mineBlock(stack, level, state, pos, entity);
        }

        if (!(entity instanceof Player player)) {
            return super.mineBlock(stack, level, state, pos, entity);
        }

        if (getMode(stack) == 1) {

            HitResult hit = player.pick(20.0D, 0.0F, false);

            if (hit instanceof BlockHitResult blockHit) {

                int broken = mine3x1x3(level, pos, player, stack, blockHit.getDirection());

                if (broken > 0) {
                    stack.hurtAndBreak(
                            broken,
                            player,
                            p -> p.broadcastBreakEvent(player.getUsedItemHand())
                    );
                }
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }


    private int mine3x1x3(Level level, BlockPos center, Player player, ItemStack stack, Direction face) {
        int broken = 0;

        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                BlockPos targetPos;
                switch (face) {
                    case UP:
                    case DOWN:
                        targetPos = center.offset(a, 0, b);
                        break;

                    case NORTH:
                    case SOUTH:
                        targetPos = center.offset(a, b, 0);
                        break;

                    case EAST:
                    case WEST:
                        targetPos = center.offset(0, b, a);
                        break;

                    default:
                        continue;
                }

                if (targetPos.equals(center))
                    continue;

                BlockState targetState = level.getBlockState(targetPos);

                if (targetState.isAir())
                    continue;

                if (level.getBlockEntity(targetPos) != null)
                    continue;

                if (!stack.isCorrectToolForDrops(targetState))
                    continue;

                if (targetState.getDestroySpeed(level, targetPos) < 0)
                    continue;

                level.destroyBlock(targetPos, true);
                broken++;
            }
        }

        return broken;
    }

    public boolean isWideMode(ItemStack stack) {
        return getMode(stack) == 1;
    }
}