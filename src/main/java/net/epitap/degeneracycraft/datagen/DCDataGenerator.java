package net.epitap.degeneracycraft.datagen;


import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Degeneracycraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class DCDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        BlockTagsProvider blockTagsProvider = new DCBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), new DCBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), blockTagsProvider);

        generator.addProvider(event.includeServer(), new DCItemTagGenerator(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new DCItemModelGenerator(packOutput, existingFileHelper));

    }
}
