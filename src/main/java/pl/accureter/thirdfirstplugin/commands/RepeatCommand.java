package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class RepeatCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;

    public RepeatCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length == 0){
                player.sendMessage("Za mało argumentów do komendy bambrze");
                player.sendMessage("Przykład: /repeat <tu wiadomość>");
            }else if (args.length == 1){
                String word = args[0];
                player.sendMessage("Wiadomość: " + word);
            }else {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < args.length; i++){
                    builder.append(args[i]);
                    builder.append(" ");
                }

                String message = builder.toString();
                message = message.stripTrailing();
                player.sendMessage("Twoja wiadomość: " + message);
            }
        }

        return true;
    }
}
