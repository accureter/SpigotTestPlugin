package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class SpawnCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public SpawnCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){
                player.teleport(location);
                player.sendMessage("Dostałeś tp do spawnu!");
            }else {
                player.sendMessage("Nie ma ustawionego spawnu. Użyj /setspawn aby go ustawić");
            }
        }

        return true;
    }
}
