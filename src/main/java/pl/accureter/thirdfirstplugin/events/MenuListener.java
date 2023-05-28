package pl.accureter.thirdfirstplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.commands.MenuCommand;

public class MenuListener implements Listener {

    ThirdFirstPlugin plugin;
    public MenuListener(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event){
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Sraka")){
            if (event.getCurrentItem() == null){
                return;
            } else if (event.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) {
                plugin.getLogger().info("Klikles se");
            }else {
                plugin.getLogger().info("Tez se klikles");
            }
            event.setCancelled(true);
        }
    }
}
