package goldenshadow.inhibitor.mixin.gnome;

import com.mojang.blaze3d.vertex.PoseStack;
import goldenshadow.inhibitor.client.InhibitorClient;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AvatarRenderer.class)
public abstract class PlayerEntityRenderer {

    @Inject(at = @At("HEAD"), method = "scale(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;)V", cancellable = true)
    private void scale(AvatarRenderState avatarRenderState, PoseStack poseStack, CallbackInfo ci) {
        if (InhibitorClient.CONFIG.gnomeMode) {
            poseStack.scale(1f, 0.6f, 1f);
            ci.cancel();
        }
    }
}
