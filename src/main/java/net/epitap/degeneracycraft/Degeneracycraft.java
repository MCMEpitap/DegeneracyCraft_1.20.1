package net.epitap.degeneracycraft;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.block.DCMenuTypes;
import net.epitap.degeneracycraft.integration.jei.DCRecipeTypes;
import net.epitap.degeneracycraft.item.DCCreativeTabs;
import net.epitap.degeneracycraft.item.DCItems;
import net.epitap.degeneracycraft.item.icon.DCIcons;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.transport.pipe.parametor.PipeModelRegistry;
import net.epitap.degeneracycraft.transport.pipe.pipebase.PipeBlockClickEvent;
import net.epitap.degeneracycraft.world.feature.DCFeatures;
import net.epitap.degeneracycraft.world.feature.vein.veinbase.VeinCapability;
import net.epitap.degeneracycraft.world.feature.vein.veinbase.VeinGeneratedCapability;
import net.epitap.degeneracycraft.world.feature.vein.veinbase.VeinWorldGenDataLoader;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Degeneracycraft.MOD_ID)
public class Degeneracycraft {
    public static final String MOD_ID = "degeneracycraft";
    public static Logger LOGGER = LogManager.getLogger();
    private static Degeneracycraft instance;
    public final DCFeatures REGISTRY;

    public Degeneracycraft() {
        instance = this;
        REGISTRY = new DCFeatures();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);
        DCItems.register(bus);
        DCCreativeTabs.register(bus);
        DCBlocks.register(bus);
        DCBlockEntities.register(bus);
        DCMenuTypes.register(bus);
        DCMessages.register();
        DCRecipeTypes.register(bus);
        DCIcons.register(bus);
        DCFeatures.Register(bus);

        bus.addListener(PipeModelRegistry::onModelRegister);
        bus.addListener(PipeModelRegistry::onModelBake);
        MinecraftForge.EVENT_BUS.register(this);

//        this.configSetup();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new PipeBlockClickEvent());
    }

    @SubscribeEvent
    public void onSlashReload(AddReloadListenerEvent event) {
        event.addListener(new VeinWorldGenDataLoader());
    }


    @SubscribeEvent
    public void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(VeinCapability.class);
        event.register(VeinGeneratedCapability.class);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            DCBlocks.clientSetup();
            DCBlockEntities.clientSetup();
        }
    }

    @SubscribeEvent
    public void veinEvents(AttachCapabilitiesEvent<Level> event) {

        if (event.getObject().isClientSide()) {
            return;
        }

        veinCapability(event, new ResourceLocation(MOD_ID, "veins"), VeinCapability.CAPABILITY, VeinCapability::new);
        veinCapability(event, new ResourceLocation(MOD_ID, "chunks_generated"), VeinGeneratedCapability.CAPABILITY, VeinGeneratedCapability::new);
    }

    private <T> void veinCapability(AttachCapabilitiesEvent<Level> event, ResourceLocation id, Capability<T> capability, Supplier<T> supplier) {
        LazyOptional<T> instance = LazyOptional.of(supplier::get);
        ICapabilitySerializable<CompoundTag> provider = new ICapabilitySerializable<>() {

            @Override
            public <C> @NotNull LazyOptional<C> getCapability(
                    @NotNull Capability<C> cap,
                    Direction side
            ) {
                return capability.orEmpty(cap, instance);
            }

            @Override
            public CompoundTag serializeNBT() {

                if (instance.orElse(null) instanceof INBTSerializable<?> serializable) {
                    return (CompoundTag) serializable.serializeNBT();
                }

                return new CompoundTag();
            }

            @Override
            @SuppressWarnings("unchecked")
            public void deserializeNBT(CompoundTag nbt) {

                if (instance.orElse(null) instanceof INBTSerializable<?> serializable) {
                    ((INBTSerializable<CompoundTag>) serializable).deserializeNBT(nbt);
                }
            }
        };

        event.addCapability(id, provider);
        event.addListener(instance::invalidate);
    }
}
