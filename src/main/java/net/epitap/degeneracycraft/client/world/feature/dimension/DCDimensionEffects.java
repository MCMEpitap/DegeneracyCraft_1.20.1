package net.epitap.degeneracycraft.client.world.feature.dimension;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.client.world.feature.dimension.moon.MoonDimensionEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = Degeneracycraft.MOD_ID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class DCDimensionEffects {

    @SubscribeEvent
    public static void register(RegisterDimensionSpecialEffectsEvent event) {

        event.register(
                new ResourceLocation(Degeneracycraft.MOD_ID, "moon"),
                new MoonDimensionEffects()
        );
    }
}