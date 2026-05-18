package net.epitap.degeneracycraft.item.tool.initial;

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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PrototypeMechanicalPickaxeItem extends PickaxeItem {
    private static final String MODE_KEY = "MiningMode";
    public PrototypeMechanicalPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(player.isShiftKeyDown()) {

            CompoundTag tag = stack.getOrCreateTag();

            int mode = tag.getInt(MODE_KEY);

            mode = (mode + 1) % 2;

            tag.putInt(MODE_KEY, mode);

            if(!level.isClientSide) {
                player.displayClientMessage(Component.literal(mode == 0 ? "Normal Mining Mode" : "3x3 Mining Mode"), true);
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
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        if(level.isClientSide) {
            return super.mineBlock(stack, level, state, pos, entity);
        }

        if(!(entity instanceof Player player)) {
            return super.mineBlock(stack, level, state, pos, entity);
        }

        int mode = getMode(stack);

        if(mode == 1) {
            Direction direction = player.getDirection();

            int broken = mine3x3(level, pos, player, stack, direction);

            if(broken > 0) {
                stack.hurtAndBreak(broken, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }

    private int mine3x3(Level level, BlockPos center, Player player, ItemStack stack, Direction direction) {
        int broken = 0;
        for(int x = -1; x <= 1; x++) {
            for(int y = -1; y <= 1; y++) {

                BlockPos targetPos;

                if(direction == Direction.NORTH || direction == Direction.SOUTH) {

                    targetPos = center.offset(x, y, 0);

                } else {

                    targetPos = center.offset(0, y, x);
                }

                if(targetPos.equals(center)) continue;

                BlockState targetState = level.getBlockState(targetPos);

                if(targetState.isAir()) continue;

                if(level.getBlockEntity(targetPos) != null) continue;

                if(!stack.isCorrectToolForDrops(targetState)) continue;

                if(targetState.getDestroySpeed(level, targetPos) < 0) continue;

                level.destroyBlock(targetPos, true);

                broken++;
            }
        }
        return broken;
    }
}