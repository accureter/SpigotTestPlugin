/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class PlayerJoinListener implements Listener {

    ThirdFirstPlugin plugin;
    public PlayerJoinListener(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for (Player vanishPlayer : plugin.vanishList){
            player.hidePlayer(plugin, vanishPlayer);
        }
    }
}
