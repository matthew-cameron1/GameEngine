package ca.innov8solutions.gameengine.game;

public abstract class Game {

    /**
     * This will have content at some point
     */

    private String name;
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
    }
    public void minute() {

    }
    public void second() {

    }

    public abstract void stop();
    public abstract void start();
}
