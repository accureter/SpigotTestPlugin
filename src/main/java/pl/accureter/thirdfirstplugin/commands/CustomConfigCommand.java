/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.files.CustomConfig;

public class CustomConfigCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public CustomConfigCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){
            player.sendMessage(CustomConfig.get().getString("message"));
        }

        return true;
    }
}
