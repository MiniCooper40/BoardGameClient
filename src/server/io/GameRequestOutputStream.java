package server.io;

import communication.formats.GameRequest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class GameRequestOutputStream {
    private final ObjectOutputStream objectOutputStream;

    public GameRequestOutputStream(OutputStream outputStream) throws IOException {
        this.objectOutputStream = new ObjectOutputStream(outputStream);
    }

    public void sendRequest(GameRequest gameRequest) throws IOException {
        objectOutputStream.writeObject(gameRequest);
    }

    public void close() throws IOException {
        objectOutputStream.close();
    }
}
