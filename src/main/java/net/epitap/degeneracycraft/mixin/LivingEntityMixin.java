package net.epitap.degeneracycraft.mixin;

import net.epitap.degeneracycraft.item.tool.initial.PrototypeMechanicalSwordItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @ModifyArg(
            method = "getDamageAfterArmorAbsorb",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/damagesource/CombatRules;getDamageAfterAbsorb(FFF)F"
            ),
            index = 1
    )
    private float dc$modifyArmor(float armor) {

        LivingEntity target = (LivingEntity)(Object)this;

        DamageSource source = target.getLastDamageSource();

        if (source == null) {
            return armor;
        }

        if (!(source.getEntity() instanceof Player player)) {
            return armor;
        }

        ItemStack stack = player.getMainHandItem();

        if (!(stack.getItem() instanceof PrototypeMechanicalSwordItem sword)) {
            return armor;
        }

        if (!sword.isPierceMode(stack)) {
            return armor;
        }

        // 防御50%無視
        return armor * 0.5F;
    }
}
