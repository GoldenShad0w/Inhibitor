package goldenshadow.inhibitor.mixin;

import com.wynntils.handlers.command.CommandHandler;
import goldenshadow.inhibitor.client.InhibitorClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(CommandHandler.class)
public abstract class CommandHandlerMixin {

    @Shadow
    public abstract void sendCommandImmediately(String command);

    @Inject(at = @At("HEAD"), method = "queueCommand", cancellable = true)
    private void queueCommand(String command, CallbackInfo ci) {
        if (InhibitorClient.CONFIG.stopCommandRateLimiting) {
            sendCommandImmediately(command);
            ci.cancel();
        }
    }
}
