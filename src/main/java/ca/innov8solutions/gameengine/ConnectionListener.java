package ca.innov8solutions.gameengine;

import ca.innov8solutions.gameengine.strategy.ConnectionStrategy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionListener implements Listener {

    @Autowired
    private ConnectionStrategy connectionStrategy;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

    }
}
