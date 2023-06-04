package pl.accureter.thirdfirstplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    Player winner;
    Player loser;
    int finalScore;

    public GameEndEvent(Player winner, Player loser, int finalScore) {
        this.winner = winner;
        this.loser = loser;
        this.finalScore = finalScore;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
