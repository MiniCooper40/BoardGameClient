package game.services;

import communication.constants.players.Player;
import game.pieces.GamePiece;
import game.state.GameState;

import java.util.List;

public class GameStateService {

    private final GameState gameState;

    public GameStateService(GameState gameState) {
        this.gameState = gameState;
    }


    public List<GamePiece> getMovablePiecesFor(Player player) {
        return gameState.getMovableGamePiecesFor(player)
                .stream()
                .toList();
    }

    public List<GamePiece> getDrawablePieces() {
        return gameState.getAllGamePieces()
                .stream()
                .toList();
    }

}
