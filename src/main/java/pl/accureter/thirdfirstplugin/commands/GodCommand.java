package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            player.setInvulnerable(!player.isInvulnerable());
            player.sendMessage("Tryb nieśmiertelności " + (player.isInvulnerable() ? "włączony" : "wyłączony"));
        }

        return true;
    }
}
