package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.events.GameEndEvent;

public class GameEndCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length == 1){
                Player target = Bukkit.getPlayerExact(args[0]);
                Bukkit.getServer().getPluginManager().callEvent(new GameEndEvent(player, target, 9999));
            }
        }

        return true;
    }
}
