package game.engine;

import communication.constants.players.Player;
import communication.formats.NetworkMessage;
import game.moves.types.GameStateChange;
import game.services.GameStateChangeService;
import misc.interfaces.Togglable;
import server.GameServer;

public abstract class NetworkGameEngine extends GameEngine {

    private final GameServer gameServer;
    private final Player localPlayer;

    public NetworkGameEngine(GameServer gameServer, GameStateChangeService changeService) {
        super(changeService);
        this.gameServer = gameServer;
        localPlayer = gameServer.getLocalPlayer();
    }

    private void handleReceivedNetworkMessage(NetworkMessage message) {
        GameStateChange change = message.getChange();
        System.out.println("Got change: " + change);
        try {
            switch (message.getStatus()) {
                case UPDATE -> applyGameStateChange(change);
                case YOUR_TURN -> handleLocalTurn();
                case GAME_START -> start();
                case GAME_END -> stop();
            }
            handleLocalTurn();
        } catch (Exception e) {
            e.printStackTrace();
            stop();
        }
    }

    private void handleLocalTurn() throws Exception {
        GameStateChange move = getMoveFor(localPlayer);
        gameServer.sendGameStateChange(move);
    }

    @Override
    protected void playGameCycle() throws Exception {
        NetworkMessage message = gameServer.awaitUpdate();
        handleReceivedNetworkMessage(message);
    }
}
