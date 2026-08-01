package net.epitap.degeneracycraft.client.transport.pipe;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.client.transport.pipe.parametor.PipeModelRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = Degeneracycraft.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class DCClientPipeModel {

    @SubscribeEvent
    public static void onModelRegister(ModelEvent.RegisterAdditional event) {
        PipeModelRegistry.onModelRegister(event);
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.BakingCompleted event) {
        PipeModelRegistry.onModelBake(event);
    }
}