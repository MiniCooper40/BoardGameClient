package server.connection;

import communication.constants.games.GameType;

import java.io.IOException;

public class CheckersServerConnection extends GameServerConnection {

    public CheckersServerConnection() throws IOException, ClassNotFoundException {
        super(GameType.CHECKERS);
    }
}
