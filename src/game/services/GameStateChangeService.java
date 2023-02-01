package game.services;

import communication.constants.players.Player;
import game.moves.integration.GameStateChangeIntegrator;
import game.moves.types.GameStateChange;
import misc.interfaces.Updatable;

public class GameStateChangeService {
    private final GameStateChangeIntegrator integrator;
    private final GameMoveCaptureService captureService;
    private final Updatable screenUpdater;

    public GameStateChangeService(GameStateChangeIntegrator integrator, GameMoveCaptureService captureService, Updatable screenUpdater) {
        this.integrator = integrator;
        this.captureService = captureService;
        this.screenUpdater = screenUpdater;
    }


    public void applyGameStateChange(GameStateChange stateChange) throws Exception {
        integrator.integrateStateChange(stateChange);
        changed();
    }

    public GameStateChange captureNextMoveForPlayer(Player player) throws Exception {
        return captureService.captureNextMoveForPlayer(player);
    }

    private void changed() {
        screenUpdater.update();
    }
}
