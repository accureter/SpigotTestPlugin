package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class FlyCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public FlyCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            player.setAllowFlight(!player.getAllowFlight());
            if (player.getAllowFlight()){
                player.setFlying(true);
            }
            player.sendMessage("Latanie " + (player.isFlying() ? "włączone" : "wyłączone"));
        }

        return true;
    }
}
