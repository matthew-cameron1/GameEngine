package ca.innov8solutions.gameengine.strategy;

import ca.innov8solutions.gameengine.game.Game;
import ca.innov8solutions.gameengine.player.EnginePlayer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public interface ConnectionStrategy<E extends EnginePlayer> extends GameStrategy {

    List<E> getConnections();

    void join(E e);
    void leave(E e);

    boolean canJoin(E e);
    boolean canLeave(E e);

    E getConnectedPlayer(UUID uuid);
}
