package dragxd.wynntilssuppressor.mixin.wynntils;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.wynntils.models.players.PartyModel")
public abstract class PartyModelMixin {

    @Inject(at = @At("HEAD"), method = "Lcom/wynntils/models/players/PartyModel;requestData()V", cancellable = true)
    private void requestData(CallbackInfo ci) {
        ci.cancel();
    }
}
