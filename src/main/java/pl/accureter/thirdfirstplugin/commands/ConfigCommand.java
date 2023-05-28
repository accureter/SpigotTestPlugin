package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class ConfigCommand implements CommandExecutor {

    Plugin plugin = ThirdFirstPlugin.getPlugin(ThirdFirstPlugin.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            FileConfiguration config = plugin.getConfig();
            player.sendMessage(config.getString("Food"));
        }

        return true;
    }
}
