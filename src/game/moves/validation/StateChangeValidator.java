package game.moves.validation;

import game.moves.types.*;

public interface StateChangeValidator {

    default boolean validate(GameStateChange change) throws Exception {
        return change.acceptValidation(this);
    }
    default boolean doValidation(PieceDeletion deletion) throws Exception {
        throw new Exception("PieceDeletion is not a valid operation for this game");
    }
    default boolean doValidation(SimplePositionalMove move) throws Exception {
        throw new Exception("SimplePositionalMove movement is not a valid operation for this game");
    }

    default boolean doValidation(PieceUpdate update) throws Exception {
        throw new Exception("PieceUpdate is not a valid operation for this game");
    }

    default boolean doValidation(AllGameItems state) throws Exception {
        throw new Exception("AllGameItems is not a valid operation for this game");
    }

    default boolean doValidation(ContinuousPositionalMove move) throws Exception {
        throw new Exception("ContinuousPositionalMove is not a valid operation for this game.");
    }
}
