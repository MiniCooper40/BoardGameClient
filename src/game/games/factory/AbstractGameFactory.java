package game.games.factory;

import game.games.Game;

public interface AbstractGameFactory {
    public Game createNetworkGame();
    public Game createLocalGame();
}
