package game.moves.options;

import game.moves.options.tree.GameMoveOptionTree;
import game.pieces.GamePiece;

public interface GameMoveOptionGenerator {
    GameMoveOptionTree getMoveTreeFor(GamePiece piece);
}
