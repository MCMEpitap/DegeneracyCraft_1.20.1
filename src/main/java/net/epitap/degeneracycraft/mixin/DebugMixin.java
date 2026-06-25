package net.epitap.degeneracycraft.mixin;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerLevel.class)
public abstract class DebugMixin {

//    @Inject(
//            method = "tickTime",
//            at = @At("HEAD")
//    )
//    private void dc$debugTickTime(CallbackInfo ci) {
//
//        ServerLevel level = (ServerLevel)(Object)this;
//
//        System.out.println(
//                "tickTime: " +
//                        level.dimension().location()
//        );
//
//    }
}
