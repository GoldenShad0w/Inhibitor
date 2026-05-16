package goldenshadow.inhibitor.mixin;

import com.wynntils.models.players.FriendsModel;
import goldenshadow.inhibitor.client.InhibitorClient;
import goldenshadow.inhibitor.client.InhibitorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(FriendsModel.class)
public abstract class FriendsModelMixin {

    @Inject(at = @At("HEAD"), method = "requestData()V", cancellable = true)
    private void requestData(CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopFriendScraping) {
            ci.cancel();
        }
    }
}
