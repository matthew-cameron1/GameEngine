package ca.innov8solutions.gameengine;

import ca.innov8solutions.gameengine.game.Game;
import ca.innov8solutions.gameengine.game.GameState;
import ca.innov8solutions.gameengine.player.EnginePlayer;
import ca.innov8solutions.gameengine.strategy.ConnectionStrategy;
import ca.innov8solutions.gameengine.strategy.DamageStrategy;
import ca.innov8solutions.gameengine.strategy.TeamStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameMediator<T extends Game, E extends EnginePlayer> {

    private @Autowired T game;

    @Autowired
    private ConnectionStrategy<E> connectionStrategy;

    @Autowired
    private TeamStrategy<E> teamStrategy;

    @Autowired
    private DamageStrategy damageStrategy;

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

    public void sendMessage(String msg) {
        getPlayers().forEach(p -> p.sendMessage(msg));
    }

    public void nextState() {
        GameState current = game.getCurrentState();
        int index = game.getPossibleStates().indexOf(current);
        int possibleIndex = index+1;
        if (possibleIndex >= game.getPossibleStates().size()) {
            possibleIndex = 0;
        }

        current.stop();
        GameState next = game.getPossibleStates().get(possibleIndex);

        game.setCurrentState(next);
        next.start();
    }
}
