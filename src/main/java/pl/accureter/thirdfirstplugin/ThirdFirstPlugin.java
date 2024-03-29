/*
 * Accureter Development Copyright (c) 2023.
 */

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
import pl.accureter.thirdfirstplugin.files.CustomConfig;
import pl.accureter.thirdfirstplugin.listeners.*;

import java.util.HashSet;

public final class ThirdFirstPlugin extends JavaPlugin {

    public HashSet<Player> vanishList = new HashSet<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("Siema skurwielu!");

        getServer().getWorlds().get(0).setTime(1000);
        getServer().getWorlds().get(0).setClearWeatherDuration(Integer.MAX_VALUE);

        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand(this));
        getCommand("config").setExecutor(new ConfigCommand());
        getCommand("repeat").setExecutor(new RepeatCommand(this));
        getCommand("fart").setExecutor(new FartCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("menu").setExecutor(new MenuCommand(this));
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("givetpbow").setExecutor(new GiveBowCommand(this));
        getCommand("armorstand").setExecutor(new ArmorStandCommand(this));
        getCommand("gui").setExecutor(new GUICommand(this));
        getCommand("asgui").setExecutor(new ArmorStandGUICommand(this));
        getCommand("hologram").setExecutor(new HologramCommand(this));
        getCommand("customConfig").setExecutor(new CustomConfigCommand(this));
        getCommand("customConfigReload").setExecutor(new ReloadCustomConfigCommand(this));
        getCommand("sign").setExecutor(new SignCommand(this));
        getCommand("bangui").setExecutor(new BanGUICommand(this));
        getCommand("rtp").setExecutor(new RandomTeleportCommand(this));
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("tp").setExecutor(new TeleportCommand(this));
        getCommand("pluginTitle").setExecutor(new PacketTitleCommand(this));
        getCommand("gameend").setExecutor(new GameEndCommand());

        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerSpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
        getServer().getPluginManager().registerEvents(new TeleportBowListener(this), this);
        getServer().getPluginManager().registerEvents(new GUIListener(this), this);
        getServer().getPluginManager().registerEvents(new ArmorStandGUIListener(this), this);
        getServer().getPluginManager().registerEvents(new SignListener(this), this);
        getServer().getPluginManager().registerEvents(new BanGUIListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new GameEndListener(this), this);
        //getServer().getPluginManager().registerEvents(new MoveListener(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        CustomConfig.setup();
        CustomConfig.get().addDefault("message", "This is the default message!");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

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
