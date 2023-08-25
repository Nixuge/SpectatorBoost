package me.nixuge.spectatorboost;

import lombok.Getter;
import lombok.Setter;
import me.nixuge.spectatorboost.command.commands.BoostSpeedCommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(
        modid = McMod.MOD_ID,
        name = McMod.NAME,
        version = McMod.VERSION,
        clientSideOnly = true
)
@Getter
@Setter
public class McMod {
    public static final String MOD_ID = "spectatorboost";
    public static final String NAME = "SpectatorBoost";
    public static final String VERSION = "1.0.0";

    
    @Getter
    @Mod.Instance(value = McMod.MOD_ID)
    private static McMod instance;

    private float boostSpeed = 1; 

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new BoostSpeedCommand());
    }
}
