package server;

import communication.formats.NetworkMessage;
import server.connection.CheckersServerConnection;

import java.io.IOException;

public class CheckersServer extends GameServer {

    private static CheckersServer INSTANCE;

    public static CheckersServer getInstance() throws IOException, ClassNotFoundException {
        System.out.println("in CheckersServer getInstance()");
        if(INSTANCE == null)
            INSTANCE = new CheckersServer();
        return INSTANCE;
    }

    private CheckersServer() throws IOException, ClassNotFoundException {
        super(new CheckersServerConnection());
    }
}
