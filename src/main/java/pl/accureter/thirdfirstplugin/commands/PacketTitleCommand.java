package pl.accureter.thirdfirstplugin.commands;

import com.google.gson.JsonElement;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class PacketTitleCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public PacketTitleCommand(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player player) {
            if (args.length >= 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + args[0] + " is not a player");
                }else {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        sb.append(args[i] + " ");
                    }
                    String titleString = sb.toString().trim();
                    String title = ChatColor.translateAlternateColorCodes('&', titleString);
                    Component text = Component.Serializer.fromJsonLenient("{'text': '" + title + "'}");

                    CraftPlayer craftPlayer = (CraftPlayer) target.getPlayer();
                    ServerPlayer serverPlayer = craftPlayer.getHandle();

                    ServerGamePacketListenerImpl connection = serverPlayer.connection;
                    ClientboundSetTitleTextPacket packet = new ClientboundSetTitleTextPacket(text);

                    connection.send(packet);
                }
            }
        }

        return true;
    }
}
