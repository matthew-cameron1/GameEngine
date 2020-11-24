package ca.innov8solutions.gameengine.strategy;

import ca.innov8solutions.gameengine.player.EnginePlayer;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LobbyConnectionStrategy<E extends EnginePlayer> implements ConnectionStrategy {

    private List<E> players = new ArrayList<>();
    private Location lobbyLocation;

    @Override
    public List<E> getConnections() {
        return players;
    }

    @Override
    public void join(EnginePlayer enginePlayer) {
        enginePlayer.teleport(lobbyLocation);
        enginePlayer.sendMessage(ChatColor.LIGHT_PURPLE + "Game>> " + ChatColor.GREEN + enginePlayer.getName() + ChatColor.GRAY +  " has joined the lobby");
    }

    @Override
    public void leave(EnginePlayer enginePlayer) {

    }

    @Override
    public boolean canJoin(EnginePlayer enginePlayer) {
        return false;
    }

    @Override
    public boolean canLeave(EnginePlayer enginePlayer) {
        return false;
    }

    @Override
    public EnginePlayer getConnectedPlayer(UUID uuid) {
        return null;
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }
}
