package game.games;

import display.displays.GameDisplay;
import game.engine.GameEngine;
import game.services.GameStateService;
import misc.interfaces.Togglable;

public abstract class Game implements Togglable {

    private final GameEngine gameEngine;

    private boolean running = false;

    protected Game(GameEngine gameEngine, GameDisplay gameDisplay, GameStateService stateService) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void start() {
        running = true;
        gameEngine.playGame();
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void stop() {
        running = false;
    }
}
