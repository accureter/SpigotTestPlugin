package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.utils.BowUtils;

public class GiveBowCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;

    public GiveBowCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (player.hasPermission("thirdfirstplugin.givebow")){

                if (args.length == 0){

                    ItemStack bow = BowUtils.createTeleportBow();
                    player.getInventory().addItem(bow);
                    player.getInventory().addItem(new ItemStack(Material.ARROW));

                    player.sendMessage(ChatColor.GREEN + "You have been recieved teleport bow");

                }else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null){
                        player.sendMessage(ChatColor.RED + "This player does not exist");
                        return true;
                    }
                    ItemStack bow = BowUtils.createTeleportBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW));

                    target.sendMessage(ChatColor.GREEN + "You have been recieved teleport bow");
                }
            }
        }

        return true;
    }
}
