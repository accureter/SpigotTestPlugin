package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class FeedCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    HashMap<UUID, Long> cooldown;

    public FeedCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if(!this.cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) >= 10000) {
                if (player.hasPermission("thirdfirstplugin.feed")) {
                    player.setFoodLevel(20);
                    player.sendMessage("Nakarmiono Cię :D");
                    this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                } else {
                    player.sendMessage(ChatColor.RED + "Nie masz wymaganej permisji (thirdfirstplugin.feed).");
                }
            }else {
                player.sendMessage("Nie możesz się nażreć przez następne "+ TimeUnit.MILLISECONDS.toSeconds(10000 - (System.currentTimeMillis() - cooldown.get(player.getUniqueId()))) + " sekund.");
            }
        }

        return true;
    }
}
