package net.epitap.degeneracycraft.mixin;

import net.epitap.degeneracycraft.world.feature.dimention.DCDimensions;
import net.epitap.degeneracycraft.world.feature.dimention.DCTimeSavedData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {

    @Inject(
            method = "getDayTime",
            at = @At("HEAD"),
            cancellable = true
    )
    private void dc$getDayTime(
            CallbackInfoReturnable<Long> cir) {

        Level level = (Level)(Object)this;

        if (!level.dimension().equals(DCDimensions.MOON_LEVEL)) {
            return;
        }

        if (!(level instanceof ServerLevel server)) {
            return;
        }

        cir.setReturnValue(
                DCTimeSavedData.get(server)
                        .getTime(server.dimension())
        );
    }
}