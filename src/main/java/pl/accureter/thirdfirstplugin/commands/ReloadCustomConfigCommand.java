/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.files.CustomConfig;

public class ReloadCustomConfigCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public ReloadCustomConfigCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        CustomConfig.reload();
        Bukkit.broadcastMessage("Reloaded Config");

        return true;
    }
}
