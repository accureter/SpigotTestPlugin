package pl.accureter.thirdfirstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pl.accureter.thirdfirstplugin.commands.FeedCommand;
import pl.accureter.thirdfirstplugin.commands.GodCommand;

public final class ThirdFirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Siema skurwielu!");
        Bukkit.getServer().getWorlds().get(0).setTime(1000);
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Zawijam mandzur");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("die")){
            if (sender instanceof Player player){
                player.setHealth(0.0);
                player.sendMessage(ChatColor.RED + "Debilu zabiłeś się XD");
            } else if (sender instanceof ConsoleCommandSender) {
                Bukkit.getLogger().warning("This command is only for Player (sent by Console)");
            } else if (sender instanceof BlockCommandSender) {
                Bukkit.getLogger().warning("This command is only for Player (sent by CommandBlock)");
            }
        }

        return true;
    }
}
