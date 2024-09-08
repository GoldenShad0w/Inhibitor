package dragxd.wynntilssuppressor.mixin.wynntils;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.wynntils.models.character.CharacterModel")
public abstract class CharacterModelMixin {

    @Inject(at = @At("HEAD"), method = "Lcom/wynntils/models/character/CharacterModel;scanCharacterInfo(Z)V", cancellable = true)
    private void sendCharacterInfo(boolean forceParseEverything, CallbackInfo ci) {
        ci.cancel();
    }
}
