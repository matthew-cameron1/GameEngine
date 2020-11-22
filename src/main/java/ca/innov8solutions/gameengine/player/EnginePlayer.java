package ca.innov8solutions.gameengine.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class EnginePlayer {

    private UUID uuid;
    private String name;

    public EnginePlayer(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public void teleport(Location loc) {
        getBukkitPlayer().teleport(loc);
    }

    private Player getBukkitPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public void sendMessage(String message) {
        getBukkitPlayer().sendMessage(message);
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
