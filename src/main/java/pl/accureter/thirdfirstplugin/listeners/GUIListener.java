/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class GUIListener implements Listener {

    ThirdFirstPlugin plugin;
    public GUIListener(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.ITALIC + "Custom GUI")){

            switch (event.getCurrentItem().getType()){
                case TNT -> {
                    player.closeInventory();
                    player.setHealth(0.0);
                    player.sendMessage(ChatColor.RED + "You killed yourself!");
                }
                case COOKED_BEEF -> {
                    player.closeInventory();
                    player.setFoodLevel(20);
                    player.sendMessage("Bon Apetit!");
                }
                case GOLDEN_SWORD -> {
                    player.closeInventory();
                    player.getInventory().addItem(new ItemStack(Material.GOLDEN_SWORD));
                    player.sendMessage("Go and fight!");
                }
            }

            event.setCancelled(true);
        }

    }
}
