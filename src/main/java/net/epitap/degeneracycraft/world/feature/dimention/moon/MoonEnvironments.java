package net.epitap.degeneracycraft.world.feature.dimention.moon;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class MoonEnvironments {

    public static void applyGravity(Player player) {

        if(player.onGround()) {
            return;
        }

        Vec3 motion = player.getDeltaMovement();

        player.setDeltaMovement(
                motion.x,
                motion.y + 0.022,
                motion.z
        );
    }

    public static void applyFallDamage(LivingFallEvent event) {
        event.setDamageMultiplier(1F / 6F);
    }
}