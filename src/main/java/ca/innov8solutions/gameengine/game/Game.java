package ca.innov8solutions.gameengine.game;

import java.util.List;

public abstract class Game {

    /**
     * This will have content at some point
     */

    private String name;
    private List<GameState> possibleStates;
    private GameState currentState;
    private int time;

    public String getName() {
        return name;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public final void tick() {
        this.time++;
        if (time*20 % 60 == 0) {
            minute();
        }
        if (time % 20 == 0) {
            second();
        }
        currentState.tick(time);
    }
    public void minute() {

    }
    public void second() {

    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    void addGameState(GameState state) {
        this.getPossibleStates().add(state);
    }

    public abstract void stop();
    public abstract void start();

    public List<GameState> getPossibleStates() {
        return possibleStates;
    }
}
