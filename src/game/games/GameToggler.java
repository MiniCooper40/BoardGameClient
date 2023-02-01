package game.games;

import misc.interfaces.Togglable;

public class GameToggler implements Togglable {

    private final Game game;

    public GameToggler(Game game) {
        this.game = game;
    }

    @Override
    public void start() {
        game.start();
    }

    @Override
    public boolean isRunning() {
        return game.isRunning();
    }

    @Override
    public void stop() {
        game.stop();
    }
}
