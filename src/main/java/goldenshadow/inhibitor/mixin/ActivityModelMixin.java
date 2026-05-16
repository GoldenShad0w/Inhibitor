package goldenshadow.inhibitor.mixin;

import com.wynntils.models.activities.ActivityModel;
import goldenshadow.inhibitor.client.InhibitorClient;
import goldenshadow.inhibitor.client.InhibitorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(ActivityModel.class)
public abstract class ActivityModelMixin {

    @Inject(at = @At("HEAD"), method = "onCharacterUpdated(Lcom/wynntils/models/character/event/CharacterUpdateEvent;)V", cancellable = true)
    private void onCharacterUpdate(CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopContentBookScraping) {
            ci.cancel();
        }
    }
}
