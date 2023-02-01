package communication.formats;

import communication.constants.games.GameType;
import communication.constants.players.Player;

import java.io.Serializable;

public class GameRequest implements Serializable {

    public static final long serialVersionUID = 9094221748744L;

    private GameType gameType;
    private Player player;
    private String hostname;
    private int port;

    public GameRequest() {

    }
    private GameRequest(GameType gameType) {
        this.gameType = gameType;
    }

    public static GameRequest forGameType(GameType gameType) {
        return new GameRequest(gameType);
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "GameRequest{" +
                "gameType=" + gameType +
                ", player=" + player +
                ", hostname='" + hostname + '\'' +
                ", port=" + port +
                '}';
    }
}
