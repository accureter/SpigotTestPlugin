package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;
import pl.accureter.thirdfirstplugin.events.GameEndEvent;

public class GameEndListener implements Listener {
    ThirdFirstPlugin plugin;

    public GameEndListener(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        Bukkit.getServer().broadcastMessage("Game has ended!");
        Bukkit.getServer().broadcastMessage("Winner is: " + event.getWinner().getDisplayName());
        Bukkit.getServer().broadcastMessage("Loser is: " + event.getLoser().getDisplayName());
    }
}
