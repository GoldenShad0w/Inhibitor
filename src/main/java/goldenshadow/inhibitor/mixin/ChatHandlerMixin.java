package goldenshadow.inhibitor.mixin;

import com.wynntils.core.components.Handlers;
import com.wynntils.handlers.chat.ChatHandler;
import goldenshadow.inhibitor.client.InhibitorClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(ChatHandler.class)
public abstract class ChatHandlerMixin {

    @Inject(at = @At("HEAD"), method = "queueChatCommand", cancellable = true)
    private void queueChatCommand(String command, CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopCommandRateLimiting) {
            Handlers.Command.sendCommandImmediately(command);
            ci.cancel();
        }
    }
}
