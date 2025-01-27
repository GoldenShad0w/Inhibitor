package goldenshadow.inhibitor.mixin.gnome;

import goldenshadow.inhibitor.client.InhibitorClient;
import goldenshadow.inhibitor.client.InhibitorConfig;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Shadow private Vec3d pos;

    @Inject(at = @At("HEAD"), method = "getPos()Lnet/minecraft/util/math/Vec3d;", cancellable = true)
    private void getPos(CallbackInfoReturnable<Vec3d> cir) {
        if (InhibitorClient.CONFIG.gnomeMode) {
            cir.setReturnValue(pos.add(0, -0.92, 0));
        }
    }
}
