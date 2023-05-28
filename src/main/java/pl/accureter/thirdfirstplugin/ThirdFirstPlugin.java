package pl.accureter.thirdfirstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pl.accureter.thirdfirstplugin.commands.*;
import pl.accureter.thirdfirstplugin.events.MenuListener;
import pl.accureter.thirdfirstplugin.events.PlayerDeath;
import pl.accureter.thirdfirstplugin.events.PlayerMove;
import pl.accureter.thirdfirstplugin.events.SpawnListener;

public final class ThirdFirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Siema skurwielu!");
        getServer().getWorlds().get(0).setTime(1000);
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("config").setExecutor(new ConfigCommand());
        getCommand("repeat").setExecutor(new RepeatCommand(this));
        getCommand("fart").setExecutor(new FartCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("menu").setExecutor(new MenuCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Zawijam mandzur");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("die")) {
            if (sender instanceof Player player) {
                player.setHealth(0.0);
                player.sendMessage(ChatColor.RED + "Debilu zabiłeś się XD");
            } else if (sender instanceof ConsoleCommandSender) {
                Bukkit.getLogger().warning("This command is only for Player (sent by Console)");
            } else if (sender instanceof BlockCommandSender) {
                Bukkit.getLogger().warning("This command is only for Player (sent by CommandBlock)");
            }
        } else if (command.getName().equalsIgnoreCase("messageFromConfig")) {
            if (sender instanceof Player player) {
                int number = getConfig().getInt("Number");
                boolean Boolean = getConfig().getBoolean("Boolean");
                String thirdItem = getConfig().getStringList("FoodList").get(2);
                player.sendMessage(getConfig().getString("Food") + number + Boolean + thirdItem);
            }
        } else if (command.getName().equalsIgnoreCase("setFood")) {
            if (sender instanceof Player player) {
                getConfig().set("Food", args[1]);
            }
        }

        return true;
    }
}
