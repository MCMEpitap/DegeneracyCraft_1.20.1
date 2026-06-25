package net.epitap.degeneracycraft.world.feature.dimention;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.world.feature.dimention.moon.MoonDimensionEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;

public class DCDimensionEffects {

    public static void register(
            RegisterDimensionSpecialEffectsEvent event
    ) {

        event.register(
                new ResourceLocation(Degeneracycraft.MOD_ID, "moon"),
                new MoonDimensionEffects()
        );

        // 将来
        // event.register(..., new MarsDimensionEffects());
        // event.register(..., new OrbitDimensionEffects());
    }
}