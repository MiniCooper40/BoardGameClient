package game.moves.capture;

import game.moves.types.GameStateChange;
import game.pieces.GamePiece;
import game.pieces.GameConsumable;

import java.awt.event.MouseListener;
import java.util.List;

public interface GameMoveCapturer extends MouseListener {

    default GameStateChange captureMoveWithPieces(List<GamePiece> movablePieces) throws Exception {
        throw new Exception("This game cannot capture a move consisting of only pieces!");
    }

    default GameStateChange captureMoveWithPlayables(List<GameConsumable> playable) throws Exception {
        throw new Exception("This game cannot capture a move consisting of only playables!");
    }

    default GameStateChange captureMoveWithAll(List<GamePiece> pieces, List<GameConsumable> playables) throws Exception {
        throw new Exception("This game cannot capture a move consisting of pieces and playables!");
    }
}
