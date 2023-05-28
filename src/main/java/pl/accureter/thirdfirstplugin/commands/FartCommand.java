package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class FartCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public FartCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length == 0){
                player.sendMessage("Imbecyl. Sam się opierdziałeś!");
                player.setHealth(0.0);
            }else {
                String playerName = args[0];
                Player target = plugin.getServer().getPlayerExact(playerName);
                if (target != null){
                    player.sendMessage("Udało ci się opierdzieć " + target.getName());
                    target.sendMessage("Zostałeś opierdziany przez " + player.getName() + " jak się z tym czujesz?");
                    target.setHealth(0.0);
                }else {
                    player.sendMessage("Gracz nie jest online.");
                }
            }
        }

        return true;
    }
}
