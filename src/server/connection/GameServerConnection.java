package server.connection;

import communication.constants.games.GameType;
import communication.constants.players.Player;
import communication.formats.GameRequest;
import server.io.NetworkInputStream;
import server.io.NetworkOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public abstract class GameServerConnection {

    protected Socket serverSocket;
    private final Player localPlayer;

    public GameServerConnection(GameType gameType) throws IOException, ClassNotFoundException {
            System.out.println("In GameServerConnection for " + gameType);
            GameRequest request = fetchGameServerRequestFor(gameType);
            System.out.println("got game invite: " + request);
            String hostname = request.getHostname();
            int port = request.getPort();
            localPlayer = request.getPlayer();
            serverSocket = new Socket(hostname, port);
            System.out.println("Connected to game!");
    }

    private GameRequest fetchGameServerRequestFor(GameType gameType) throws IOException, ClassNotFoundException {
        System.out.println("before dispatcherInstance");
        GameDispatcherServer dispatcherServer = GameDispatcherServer.getInstance();
        System.out.println("got dispatcherInstance");
        GameRequest request = GameRequest.forGameType(gameType);
        System.out.println("Sending request: " + request);
        dispatcherServer.sendRequest(request);
        return dispatcherServer.readResponse();
    }

    public NetworkInputStream getNetworkInputStream() throws IOException {
        return NetworkInputStream.forSocket(serverSocket);
    }

    public NetworkOutputStream getNetworkOutputStream() throws IOException {
        return NetworkOutputStream.forSocket(serverSocket);
    }

    public void close() throws IOException {
        serverSocket.close();
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }
}
