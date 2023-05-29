/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class SignCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public SignCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length >= 2) {
                player.getWorld().getBlockAt(player.getLocation()).setType(Material.WARPED_WALL_SIGN);
                Sign sign = (Sign) player.getWorld().getBlockAt(player.getLocation()).getState();

                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    builder.append(args[i]);
                }
                sign.setLine(Integer.parseInt(args[0])-1, builder.toString());
                sign.update();
            }else if (Integer.parseInt(args[0])>4 || Integer.parseInt(args[0])<1){
                player.sendMessage("You need to provide a valid line (1-4)");
                player.sendMessage("Usage: /sign <line> <text>");
            }else{
                player.sendMessage("You need to specify a line and text");
                player.sendMessage("Usage: /sign <line> <text>");
            }

        }

        return true;
    }
}
