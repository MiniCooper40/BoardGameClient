package server;

import communication.constants.network.RequestStatus;
import communication.constants.players.Player;
import communication.formats.NetworkMessage;
import game.moves.types.GameStateChange;
import server.connection.GameServerConnection;
import server.io.NetworkInputStream;
import server.io.NetworkOutputStream;

import java.io.IOException;

public abstract class GameServer {

    private final NetworkInputStream inputStream;
    private final NetworkOutputStream outputStream;
    private final GameServerConnection serverConnection;

    public GameServer(GameServerConnection serverConnection) throws IOException {
        this.serverConnection = serverConnection;
        inputStream = serverConnection.getNetworkInputStream();
        outputStream = serverConnection.getNetworkOutputStream();
    }

    public Player getLocalPlayer() {
        return serverConnection.getLocalPlayer();
    }

    public NetworkMessage awaitUpdate() throws IOException, ClassNotFoundException {
        return inputStream.readMessage();
    }

    public void sendMessage(NetworkMessage update) throws IOException {
        outputStream.sendMessage(update);
    }

    public void sendGameStateChange(GameStateChange change) throws IOException {
        NetworkMessage message = NetworkMessage.madeMove(change);
        sendMessage(message);
    }

    public void close() throws IOException {
        inputStream.close();
        outputStream.close();
        serverConnection.close();
    }
}
