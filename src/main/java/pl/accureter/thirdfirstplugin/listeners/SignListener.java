/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class SignListener implements Listener {

    ThirdFirstPlugin plugin;
    public SignListener(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {

        event.getBlock().setType(Material.GOLD_BLOCK);
    }
}
