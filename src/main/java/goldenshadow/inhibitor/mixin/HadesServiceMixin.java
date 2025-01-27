package goldenshadow.inhibitor.mixin;

import goldenshadow.inhibitor.client.InhibitorClient;
import goldenshadow.inhibitor.client.InhibitorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.wynntils.services.hades.HadesService")
public abstract class HadesServiceMixin {

    @Inject(at = @At("HEAD"), method = "Lcom/wynntils/services/hades/HadesService;tryCreateConnection()V", cancellable = true)
    private void tryCreateConnection(CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopHadesConnection) {
            ci.cancel();
        }
    }
}
