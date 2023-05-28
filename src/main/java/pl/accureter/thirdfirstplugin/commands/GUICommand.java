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

public class GUICommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public GUICommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){

            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.ITALIC + "Custom GUI");

            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack feed = new ItemStack(Material.COOKED_BEEF);
            ItemStack sword = new ItemStack(Material.GOLDEN_SWORD);

            ItemMeta suicideMeta = suicide.getItemMeta();
            suicideMeta.setDisplayName(ChatColor.RED + "Suicide");
            ArrayList<String> suicideLore = new ArrayList<>();
            suicideLore.add("Kill yourself!");
            suicideMeta.setLore(suicideLore);
            suicide.setItemMeta(suicideMeta);

            ItemMeta feedMeta = feed.getItemMeta();
            feedMeta.setDisplayName(ChatColor.GREEN + "Feed");
            ArrayList<String> feedLore = new ArrayList<>();
            feedLore.add("No more hunger!");
            feedMeta.setLore(feedLore);
            feed.setItemMeta(feedMeta);

            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.GOLD + "Sword");
            ArrayList<String> swordLore = new ArrayList<>();
            swordLore.add("Get a sword!");
            swordMeta.setLore(swordLore);
            sword.setItemMeta(swordMeta);

            ItemStack[] menuItems = {suicide, feed, sword};
            gui.setContents(menuItems);
            player.openInventory(gui);
        }

        return true;
    }
}
