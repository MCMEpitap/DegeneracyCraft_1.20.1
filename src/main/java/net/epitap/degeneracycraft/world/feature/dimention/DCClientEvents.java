package net.epitap.degeneracycraft.world.feature.dimention;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = Degeneracycraft.MOD_ID,
        value = Dist.CLIENT
)
public class DCClientEvents {

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {

        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();

        if (mc.level == null) {
            return;
        }

        if (!mc.level.dimension().equals(DCDimensions.MOON_LEVEL)) {
            return;
        }

//        DCDimensionTimes.CLIENT_MOON_TIME++;
    }
}