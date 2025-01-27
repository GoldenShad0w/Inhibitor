package goldenshadow.inhibitor.mixin;

import goldenshadow.inhibitor.client.InhibitorClient;
import goldenshadow.inhibitor.client.InhibitorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.wynntils.models.activities.ActivityModel")
public abstract class ActivityModelMixin {

    @Inject(at = @At("HEAD"), method = "Lcom/wynntils/models/activities/ActivityModel;onCharacterUpdated(Lcom/wynntils/models/character/event/CharacterUpdateEvent;)V", cancellable = true)
    private void onCharacterUpdate(CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopContentBookScraping) {
            ci.cancel();
        }
    }
}
