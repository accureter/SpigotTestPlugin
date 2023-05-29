/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class HologramCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public HologramCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){

            ArmorStand hologram = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            hologram.setVisible(false);
            hologram.setGravity(false);
            hologram.setCustomNameVisible(true);
            hologram.setCustomName(ChatColor.RED + "Hologram");

            ArmorStand hologram2 = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0,-0.25,0), EntityType.ARMOR_STAND);
            hologram2.setVisible(false);
            hologram2.setGravity(false);
            hologram2.setCustomNameVisible(true);
            hologram2.setCustomName(ChatColor.GREEN + "Second Line");

        }

        return true;
    }
}
