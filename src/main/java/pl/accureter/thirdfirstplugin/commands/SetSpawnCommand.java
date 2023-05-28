package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class SetSpawnCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public SetSpawnCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            Location location = player.getLocation();
            plugin.getConfig().set("spawn", location);
            plugin.saveDefaultConfig();

            player.sendMessage("Zapisano lokalizację spawnu");
        }

        return true;
    }
}
