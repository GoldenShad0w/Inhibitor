package goldenshadow.inhibitor.mixin;

import com.wynntils.models.character.CharacterModel;
import goldenshadow.inhibitor.client.InhibitorClient;
import goldenshadow.inhibitor.client.InhibitorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(CharacterModel.class)
public abstract class CharacterModelMixin {

    @Inject(at = @At("HEAD"), method = "scanCharacterInfo()V", cancellable = true)
    private void sendCharacterInfo(CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopCompassScraping) {
            ci.cancel();
        }
    }
}
