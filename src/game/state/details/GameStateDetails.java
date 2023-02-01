package game.state.details;

import communication.constants.players.Player;
import game.pieces.GamePiece;

import java.util.Set;

public interface GameStateDetails {
    Set<GamePiece> getPiecesForPlayer(Player player);
    Set<GamePiece> getAllGamePieces();

    Player getPlayerWithPiece(int id);
    default Player getPlayerWithPiece(GamePiece piece) {
        int pieceID = piece.getID();
        return getPlayerWithPiece(pieceID);
    }

    GamePiece getGamePieceByID(int ID);
}
