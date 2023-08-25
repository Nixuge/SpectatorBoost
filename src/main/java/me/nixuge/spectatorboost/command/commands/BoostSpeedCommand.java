package me.nixuge.spectatorboost.command.commands;


import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;

import me.nixuge.spectatorboost.McMod;
import me.nixuge.spectatorboost.MessageBuilder;
import me.nixuge.spectatorboost.command.AbstractCommand;

public class BoostSpeedCommand extends AbstractCommand {
    private final McMod mod;

    public BoostSpeedCommand() {
        super("boostspeed");
        this.mod = McMod.getInstance();
    }

    @Override
    public List<String> getCommandAliases() {
        ArrayList<String> al = new ArrayList<>();
        al.add("bspeed");
        return al;
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        float speed = Float.parseFloat(args[0]);
        mod.setBoostSpeed(speed);
        this.tell(new MessageBuilder("Set boost speed to " + speed, TextFormatting.GRAY));
    }
}
