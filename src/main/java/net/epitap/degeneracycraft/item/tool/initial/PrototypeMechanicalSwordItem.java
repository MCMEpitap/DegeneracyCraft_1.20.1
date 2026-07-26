package net.epitap.degeneracycraft.item.tool.initial;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PrototypeMechanicalSwordItem extends SwordItem {

    private static final String MODE_KEY = "Mode";

    public PrototypeMechanicalSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(isPierceMode(stack)
                ? Component.translatable("tool.degeneracycraft_attack_pierce")
                .withStyle(style -> style.withColor(0xFFFFFF).withUnderlined(true))
                : Component.translatable("tool.degeneracycraft_attack_normal")
                .withStyle(style -> style.withColor(0xFFFFFF).withUnderlined(true))
        );
        tooltip.add(Component.translatable("tooltip.degeneracycraft.tools")
                .withStyle(style -> style.withColor(0xFFFFFF)));

        tooltip.add(Component.translatable("tooltip.degeneracycraft.prototype_mechanical_sword").withStyle(style -> style.withColor(0xFFFFFF)));

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
                                ? Component.translatable("tool.degeneracycraft_attack_normal")
                                .withStyle(style -> style.withColor(0xFFFFFF))
                                : Component.translatable("tool.degeneracycraft_attack_pierce")
                                .withStyle(style -> style.withColor(0xFFFFFF)),
                        true
                );
            }

            return InteractionResultHolder.success(stack);
        }

        return super.use(level, player, hand);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        boolean result = super.hurtEnemy(stack, target, attacker);

        if (attacker instanceof Player player) {

            if (isPierceMode(stack)) {
                // superで1消費済みなので追加2消費
                stack.hurtAndBreak(2, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));
            }
        }

        return result;
    }

    private int getMode(ItemStack stack) {
        return stack.getOrCreateTag().getInt(MODE_KEY);
    }

    public boolean isPierceMode(ItemStack stack) {
        return getMode(stack) == 1;
    }
}
