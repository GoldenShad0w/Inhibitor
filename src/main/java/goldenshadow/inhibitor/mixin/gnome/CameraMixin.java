package goldenshadow.inhibitor.mixin.gnome;

import goldenshadow.inhibitor.client.InhibitorClient;
import net.minecraft.client.Camera;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Shadow private Vec3 position;

    @Inject(at = @At("HEAD"), method = "position", cancellable = true)
    private void getPos(CallbackInfoReturnable<Vec3> cir) {
        if (InhibitorClient.CONFIG.gnomeMode) {
            cir.setReturnValue(position.add(0, -0.92, 0));
        }
    }
}
