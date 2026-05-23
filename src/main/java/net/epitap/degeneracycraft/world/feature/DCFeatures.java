package net.epitap.degeneracycraft.world.feature;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.vein.veinbase.VeinFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DCFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Degeneracycraft.MOD_ID);
    public DCFeatures() {
        RegisterWorldGen();
    }

    public void RegisterWorldGen() {
        FEATURES.register("veins", () -> new VeinFeature(NoneFeatureConfiguration.CODEC));
    }

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}