package net.epitap.degeneracycraft;

import com.mojang.logging.LogUtils;
import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.integration.jei.DCRecipeTypes;
import net.epitap.degeneracycraft.items.DCCreativeTabs;
import net.epitap.degeneracycraft.items.DCItems;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Degeneracycraft.MOD_ID)
public class Degeneracycraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "degeneracycraft";    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Degeneracycraft() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);
        DCItems.register(bus);
        DCCreativeTabs.register(bus);
        DCBlocks.register(bus);
        DCBlockEntities.register(bus);
        DCMenuTypes.register(bus);
        DCMessages.register();
        DCRecipeTypes.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
