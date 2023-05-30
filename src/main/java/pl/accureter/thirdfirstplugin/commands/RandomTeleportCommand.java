/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.utils.RandomTeleportUtils;

public class RandomTeleportCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public RandomTeleportCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){

            player.teleport(RandomTeleportUtils.generateLocation(player.getWorld()));

        }

        return true;
    }
}
