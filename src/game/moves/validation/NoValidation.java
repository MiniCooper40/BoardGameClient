package game.moves.validation;

import game.moves.types.GameStateChange;
import game.moves.types.PieceDeletion;
import game.moves.types.PieceUpdate;
import game.moves.types.SimplePositionalMove;

public class NoValidation implements StateChangeValidator {
    @Override
    public boolean validate(GameStateChange change) throws Exception {
        return true;
    }

    @Override
    public boolean doValidation(PieceDeletion deletion) throws Exception {
        return true;
    }

    @Override
    public boolean doValidation(SimplePositionalMove move) throws Exception {
        return true;
    }

    @Override
    public boolean doValidation(PieceUpdate update) throws Exception {
        return true;
    }
}
