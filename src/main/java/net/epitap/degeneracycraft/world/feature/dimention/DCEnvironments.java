package net.epitap.degeneracycraft.world.feature.dimention;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.dimention.moon.MoonEnvironments;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Degeneracycraft.MOD_ID)
public class DCEnvironments {

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {

        Player player = event.player;

        if(player.level().dimension() == DCDimensions.MOON_LEVEL) {
            MoonEnvironments.applyGravity(player);
        }
    }

    @SubscribeEvent
    public static void fallDamage(LivingFallEvent event) {

        if(!(event.getEntity() instanceof Player player)) {
            return;
        }

        if(player.level().dimension() == DCDimensions.MOON_LEVEL) {
            MoonEnvironments.applyFallDamage(event);
        }
    }
}