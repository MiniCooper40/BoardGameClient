import game.games.CheckersGame;
import game.games.Game;
import game.games.factory.CheckersGameFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        CheckersGameFactory checkersGameFactory = new CheckersGameFactory();

        Game game = checkersGameFactory.createNetworkGame();
        game.start();
    }
}
