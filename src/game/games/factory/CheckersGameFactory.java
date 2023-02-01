package game.games.factory;

import display.ScreenUpdater;
import display.displays.CheckersDisplay;
import display.displays.GameDisplay;
import display.drawers.CheckersGameDrawer;
import display.drawers.GameDrawer;
import display.drawers.GameStateDrawer;
import game.engine.GameEngine;
import game.engine.checkers.NetworkCheckersGameEngine;
import game.games.CheckersGame;
import game.games.Game;
import game.games.GameToggler;
import game.moves.capture.GameMoveCapturer;
import game.moves.integration.CheckersStateChangeIntegrator;
import game.moves.integration.GameStateChangeIntegrator;
import game.services.GameMoveCaptureService;
import game.services.GameStateChangeService;
import game.services.GameStateService;
import game.state.CheckersGameState;
import game.state.GameState;
import misc.interfaces.Togglable;
import misc.interfaces.Updatable;
import server.CheckersServer;
import server.GameServer;

import java.io.IOException;

public class CheckersGameFactory implements AbstractGameFactory {

    @Override
    public Game createNetworkGame() {

        GameState checkersState = new CheckersGameState();
        GameStateService checkersStateService = new GameStateService(checkersState);

        GameStateDrawer stateDrawer = new GameStateDrawer(checkersStateService);
        GameDrawer checkersGameDrawer = new CheckersGameDrawer(stateDrawer);

        GameDisplay gameDisplay = new CheckersDisplay(checkersGameDrawer);

        GameMoveCapturer moveCapturer = gameDisplay.retrieveGameMoveCapturer();

        Updatable screenUpdater = gameDisplay.getScreenUpdater();

        GameMoveCaptureService captureService = new GameMoveCaptureService(moveCapturer, checkersStateService);

        GameStateChangeIntegrator stateChangeIntegrator = new CheckersStateChangeIntegrator(checkersState);

        GameStateChangeService changeService = new GameStateChangeService(stateChangeIntegrator, captureService, screenUpdater);

        GameServer server;
        try {
            server = CheckersServer.getInstance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        GameEngine gameEngine = new NetworkCheckersGameEngine(server, changeService);

        Game checkersGame = new CheckersGame(gameEngine, gameDisplay, checkersStateService);
        Togglable gameToggle = new GameToggler(checkersGame);
        gameEngine.setGameToggle(gameToggle);

        return checkersGame;
    }

    @Override
    public Game createLocalGame() {
        return null;
    }
}
