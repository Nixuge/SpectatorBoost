package me.nixuge.spectatorboost.mixins.player;


import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class PlayerMixin {
    @Shadow
    protected Minecraft mc;

    @Inject(method="onUpdate", at = @At(value = "HEAD"))
    public void onUpdate(CallbackInfo ci) {
        if (this.mc.playerController.isSpectatorMode() || this.mc.playerController.isInCreativeMode()) {
            EntityPlayerAccessor accessor = (EntityPlayerAccessor)this;
            accessor.getCapabilities().setFlySpeed(0);
        }
    }
}
