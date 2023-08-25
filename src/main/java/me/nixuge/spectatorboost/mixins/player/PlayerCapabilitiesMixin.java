package me.nixuge.spectatorboost.mixins.player;

import me.nixuge.spectatorboost.McMod;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerCapabilities.class)
public class PlayerCapabilitiesMixin {
    @Shadow private float flySpeed;

    /**
     * @author Nixuge
     * @reason Quite a bit dirty, but without that it doesn't work on all servers
     */
    @SideOnly(Side.CLIENT)
    @Overwrite
    public void setFlySpeed(float speed) {
        this.flySpeed = .05f * McMod.getInstance().getBoostSpeed();
    }
}
