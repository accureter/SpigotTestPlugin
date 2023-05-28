/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.utility.BowUtils;

public class TeleportBowListener implements Listener {

    ThirdFirstPlugin plugin;
    public TeleportBowListener(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent event){

        if (event.getEntity().getType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player player){
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (itemInMainHand.getItemMeta().hasItemFlag(ItemFlag.HIDE_ATTRIBUTES)){

                Location location = event.getEntity().getLocation();
                player.teleport(location);
                event.getEntity().remove();
                player.sendMessage("You have been teleported by Teleport Bow!");
                player.playSound(player, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 2.0f, 1.0f);
            }
        }

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (plugin.getConfig().getBoolean("give-bow-on-join")){
            Player player = event.getPlayer();
            player.getInventory().addItem(BowUtils.createTeleportBow());
            player.getInventory().addItem(new ItemStack(Material.ARROW));

            player.sendMessage("You received teleportation BOW D:");
        }
    }
}
