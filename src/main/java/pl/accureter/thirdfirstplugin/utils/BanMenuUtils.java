/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collection;
import java.util.List;

public class BanMenuUtils {

    public static void openBanGUI(Player player) {
        Collection<? extends Player> playersList = player.getServer().getOnlinePlayers();
        Inventory banGUI = Bukkit.createInventory(player, 45, ChatColor.RED + "Players List");

        for (Player player1 : playersList) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();

            playerHeadMeta.setOwnerProfile(player1.getPlayerProfile());
            playerHeadMeta.setDisplayName(player1.getDisplayName());
            playerHeadMeta.setLore(List.of(ChatColor.GOLD + "Player Health: " + ChatColor.RED + player1.getHealth(),
                    ChatColor.GOLD + "EXP: " + ChatColor.AQUA + player1.getExp()));
            playerHead.setItemMeta(playerHeadMeta);

            banGUI.addItem(playerHead);
        }
        player.openInventory(banGUI);
    }
}
