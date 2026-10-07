package net.epitap.degeneracycraft.multiblock;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DCMultiblockManager {

    public static final DCMultiblockLoader LOADER = new DCMultiblockLoader();

    @SubscribeEvent
    public static void onAddReloadListener(AddReloadListenerEvent event) {
        System.out.println(
                "[DegeneracyCraft] AddReloadListenerEvent fired!"
        );

        event.addListener(LOADER);

        System.out.println(
                "[DegeneracyCraft] DCMultiblockLoader registered!"
        );
    }

    public static DCMultiblockFile get(ResourceLocation id) {
        return LOADER.get(id);
    }
}