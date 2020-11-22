package ca.innov8solutions.gameengine.factory;

import ca.innov8solutions.gameengine.game.Game;
import ca.innov8solutions.gameengine.GameMediator;
import ca.innov8solutions.gameengine.player.EnginePlayer;

public interface GameMediatorFactory {

    default GameMediator getMediator(Game game) {
        return new GameMediator<>();
    }
}
