/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class MoveListener implements Listener {

    ThirdFirstPlugin plugin;
    public MoveListener(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Entity entity = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 20, 90, 40), EntityType.SKELETON);
        entity.setGravity(false);
        entity.setGlowing(true);
        entity.setCustomName("Super Duper Skeleton");
    }
}
