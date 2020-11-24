package ca.innov8solutions.gameengine.game;

public interface GameState {

    void tick(int time);
    int length();

    void start();
    void stop();
}
