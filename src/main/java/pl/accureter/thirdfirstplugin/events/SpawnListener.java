package pl.accureter.thirdfirstplugin.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class SpawnListener implements Listener {

    ThirdFirstPlugin plugin;
    public SpawnListener(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (!event.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){
                player.teleport(location);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){

        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null){
            event.setRespawnLocation(location);
        }
    }
}
