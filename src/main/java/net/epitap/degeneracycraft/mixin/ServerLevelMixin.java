package net.epitap.degeneracycraft.mixin;

import net.epitap.degeneracycraft.world.feature.dimention.DCDimensionTimes;
import net.epitap.degeneracycraft.world.feature.dimention.DCDimensions;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {

    @Inject(
            method = "tickTime",
            at = @At("TAIL")
    )
    private void dc$tickMoonTime(CallbackInfo ci) {

        ServerLevel level = (ServerLevel)(Object)this;

        if (!level.dimension().equals(DCDimensions.MOON_LEVEL)) {
            return;
        }


        if (level.dimension().equals(DCDimensions.MOON_LEVEL)) {
            DCDimensionTimes.tick(level, 10);
        }
//        DCTimeSavedData.get(level)
//                .addMoonTime(10);
//        System.out.println(
//                DCTimeSavedData.get(level).getMoonTime()
//        );
    }
}