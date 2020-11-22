package ca.innov8solutions.gameengine;

import ca.innov8solutions.gameengine.game.Game;
import ca.innov8solutions.gameengine.player.EnginePlayer;
import ca.innov8solutions.gameengine.strategy.ConnectionStrategy;
import ca.innov8solutions.gameengine.strategy.TeamStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameMediator<T extends Game, E extends EnginePlayer> {

    private @Autowired T game;

    @Autowired
    private ConnectionStrategy<E> connectionStrategy;

    @Autowired
    private TeamStrategy<E> teamStrategy;

    public void playerJoin(E e) {
        if (connectionStrategy.canJoin(e)) {
            connectionStrategy.join(e);
        }
    }

    public void playerLeave(E e) {
        if (connectionStrategy.canLeave(e)) {
            connectionStrategy.leave(e);
        }
    }

    public List<E> getPlayers() {
        return connectionStrategy.getConnections();
    }

    public void stop() {
        game.stop();
    }
    public void start() {
        game.start();
    }
}
