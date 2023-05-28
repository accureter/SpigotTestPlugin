package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (player.hasPermission("thirdfirstplugin.feed")) {
                player.setFoodLevel(20);
                player.sendMessage("Nakarmiono Cię :D");
            }else {
                player.sendMessage(ChatColor.RED + "Nie masz wymaganej permisji (thirdfirstplugin.feed).");
            }
        }

        return true;
    }
}
