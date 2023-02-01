package server.connection;

import communication.formats.GameRequest;
import server.io.GameRequestInputStream;
import server.io.GameRequestOutputStream;

import java.io.IOException;
import java.net.Socket;

public class GameDispatcherServer {

    private static final int PORT = 5503;
    private static final String HOSTNAME = "127.0.0.1";

    private static GameDispatcherServer INSTANCE;

    private final GameRequestOutputStream outputStream;
    private final GameRequestInputStream inputStream;
    private final Socket dispatcherSocket;

    private GameDispatcherServer() throws IOException {
        dispatcherSocket = new Socket(HOSTNAME, PORT);
        dispatcherSocket.setReuseAddress(true);
        System.out.println("Got dispatcherSocket: " + dispatcherSocket);
        outputStream = new GameRequestOutputStream(dispatcherSocket.getOutputStream());
        inputStream = new GameRequestInputStream(dispatcherSocket.getInputStream());
    }

    public void sendRequest(GameRequest request) throws IOException {
        outputStream.sendRequest(request);
    }

    public GameRequest readResponse() throws IOException, ClassNotFoundException {
        return inputStream.readRequest();
    }

    public static GameDispatcherServer getInstance() throws IOException {
        if(INSTANCE == null) INSTANCE = new GameDispatcherServer();
        return INSTANCE;
    }

    public void close() throws IOException {
        dispatcherSocket.close();
    }
}
