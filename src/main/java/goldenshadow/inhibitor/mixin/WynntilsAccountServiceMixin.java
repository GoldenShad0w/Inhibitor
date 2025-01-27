package goldenshadow.inhibitor.mixin;

import goldenshadow.inhibitor.client.InhibitorClient;
import goldenshadow.inhibitor.client.InhibitorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.wynntils.services.athena.WynntilsAccountService")
public abstract class WynntilsAccountServiceMixin {

    @Inject(at = @At("HEAD"), method = "Lcom/wynntils/services/athena/WynntilsAccountService;doLogin()V", cancellable = true)
    private void doLogin(CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopAthenaConnection) {
            ci.cancel();
        }
    }
}
