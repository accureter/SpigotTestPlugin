/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class VanishCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public VanishCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (!plugin.vanishList.contains(player)){
                plugin.vanishList.add(player);
                for (Player players : Bukkit.getOnlinePlayers()){
                    players.hidePlayer(plugin, player);
                }
                player.sendMessage(ChatColor.AQUA + "You're now invisible!");
            }else {
                plugin.vanishList.remove(player);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.showPlayer(plugin, player);
                }
                player.sendMessage(ChatColor.AQUA + "You're now visible!");
            }
        }

        return true;
    }
}
