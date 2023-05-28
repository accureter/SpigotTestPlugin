package pl.accureter.thirdfirstplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class PlayerDeath implements Listener {

    ThirdFirstPlugin plugin;

    public PlayerDeath(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){

        new BukkitRunnable(){
            @Override
            public void run() {
                Bukkit.getLogger().info(event.getEntity().getName() + " wyjebal sie");
            }
        }.runTaskLater(plugin, 20L);
    }
}
