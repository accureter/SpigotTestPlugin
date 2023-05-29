/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.utils.BanMenuUtils;

public class BanGUIListener implements Listener {

    ThirdFirstPlugin plugin;

    public BanGUIListener(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    Player playerToBan = null;
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        if (item == null) {
            return;
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Players List")) {
            event.setCancelled(true);
            if (item.getType() == Material.PLAYER_HEAD) {
                SkullMeta skullMeta = (SkullMeta) event.getCurrentItem().getItemMeta();
                playerToBan = skullMeta.getOwningPlayer().getPlayer();
                if (!playerToBan.isOnline()) {
                    return;
                }
                Inventory confirmBanGUI = Bukkit.createInventory(player, 9, ChatColor.RED + "BAN Menu");

                ItemStack ban = new ItemStack(Material.GOLDEN_AXE);
                ItemMeta banMeta = ban.getItemMeta();
                banMeta.setDisplayName(ChatColor.DARK_RED + "BAN");
                ban.setItemMeta(banMeta);

                ItemStack cancel = new ItemStack(Material.BARRIER);
                ItemMeta cancelMeta = cancel.getItemMeta();
                cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
                cancel.setItemMeta(cancelMeta);

                ItemStack[] menuItems = {null, null, ban, null, event.getCurrentItem(), null, cancel, null, null};

                confirmBanGUI.setContents(menuItems);
                player.openInventory(confirmBanGUI);
            }
        } else if (event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "BAN Menu")) {
            event.setCancelled(true);
            switch (item.getType()) {
                case BARRIER -> {
                    BanMenuUtils.openBanGUI(player);
                }
                case GOLDEN_AXE -> {
                    player.closeInventory();
                    player.getServer().getBanList(BanList.Type.NAME).addBan(playerToBan.getName(), "Beacuse of YES (BAN GUI)", null, null);
                    player.sendMessage(ChatColor.GREEN + "Banned " + playerToBan.getDisplayName());
                }
            }
        }
    }
}
