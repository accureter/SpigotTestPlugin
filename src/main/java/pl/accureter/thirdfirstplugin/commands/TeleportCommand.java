package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class TeleportCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public TeleportCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length == 0){
                player.sendMessage(ChatColor.RED + "You need provide player");
                player.sendMessage(ChatColor.YELLOW + "To teleport yourself: /tp <otherplayer>");
                player.sendMessage(ChatColor.YELLOW + "To teleport someone: /tp <player> <otherPlayer>");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null){
                    player.sendMessage(ChatColor.RED + "Provide online players");
                    return true;
                }
                player.teleport(target.getLocation());
                player.sendMessage(ChatColor.GREEN + "Teleported to " + target.getDisplayName());
            } else if (args.length == 2) {
                Player target1 = Bukkit.getPlayerExact(args[0]);
                Player target2 = Bukkit.getPlayerExact(args[1]);
                if (target1 == null || target2 == null){
                    player.sendMessage(ChatColor.RED + "Provide online players");
                    return true;
                }
                target1.teleport(target2.getLocation());
                player.sendMessage(ChatColor.GREEN + "Teleported " + target1.getDisplayName() + "to " + target2.getDisplayName());
            }
        }

        return true;
    }
}
