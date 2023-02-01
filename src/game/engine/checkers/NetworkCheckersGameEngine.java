package game.engine.checkers;

import game.engine.NetworkGameEngine;
import game.services.GameStateChangeService;
import misc.interfaces.Togglable;
import server.GameServer;

public class NetworkCheckersGameEngine extends NetworkGameEngine {
    public NetworkCheckersGameEngine(GameServer gameServer, GameStateChangeService changeService) {
        super(gameServer, changeService);
    }
}
