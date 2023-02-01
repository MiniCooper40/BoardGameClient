package game.engine;

import communication.constants.players.Player;
import game.moves.types.GameStateChange;
import game.services.GameStateChangeService;
import misc.interfaces.Togglable;

public abstract class GameEngine {

    private Togglable gameToggle;
    private final GameStateChangeService changeService;

    protected GameEngine(GameStateChangeService changeService) {
        this.changeService = changeService;
    }


    public void playGame() {
        while(gameToggle.isRunning()) {
            try {
                playGameCycle();
            } catch (Exception e) {
                e.printStackTrace();
                stop();
            }
        }
        System.out.println("Game over!");
    }

    // Only thing the implementation is responsible for is deciding where/how to source the next state change/game move


    protected abstract void playGameCycle() throws Exception;

    protected GameStateChange getMoveFor(Player player) throws Exception {
        return changeService.captureNextMoveForPlayer(player);
    }

    protected void applyGameStateChange(GameStateChange stateChange) throws Exception {
        changeService.applyGameStateChange(stateChange);
    }

    public void start() {
        gameToggle.start();
    }

    public void stop() {
        gameToggle.stop();
    }

    public void setGameToggle(Togglable gameToggle) {
        this.gameToggle = gameToggle;
    }
}
