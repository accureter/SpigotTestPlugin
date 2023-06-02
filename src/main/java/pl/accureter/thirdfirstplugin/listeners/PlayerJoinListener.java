/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftPlayer;
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

        String text = ChatColor.RED + "Welcome!";
        Component chatComponent = Component.Serializer.fromJsonLenient(text);
        ClientboundSetActionBarTextPacket packet = new ClientboundSetActionBarTextPacket(chatComponent);

        ServerGamePacketListenerImpl connection = ((CraftPlayer) player.getPlayer()).getHandle().connection;
        connection.send(packet);
    }
}
