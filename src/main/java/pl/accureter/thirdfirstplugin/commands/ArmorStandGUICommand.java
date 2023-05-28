/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

import java.util.ArrayList;

public class ArmorStandGUICommand implements CommandExecutor {

    ThirdFirstPlugin plugin;

    public ArmorStandGUICommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){

            Inventory mainMenu = Bukkit.createInventory(player, 9, ChatColor.BLUE + "ArmorStand GUI");

            ItemStack create = new ItemStack(Material.ARMOR_STAND);
            ItemMeta createMeta = create.getItemMeta();
            createMeta.setDisplayName(ChatColor.GOLD + "Create");
            ArrayList<String> createLore = new ArrayList<>();
            createLore.add("Create an Armor Stand");
            createMeta.setLore(createLore);
            create.setItemMeta(createMeta);

            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta closeMeta = close.getItemMeta();
            closeMeta.setDisplayName(ChatColor.RED + "Close");
            close.setItemMeta(closeMeta);

            mainMenu.setItem(0, create);
            mainMenu.setItem(8, close);

            player.openInventory(mainMenu);
        }

        return true;
    }
}
