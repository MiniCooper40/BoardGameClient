package game.moves.types;

import game.moves.application.StateChangeApplier;
import game.moves.validation.StateChangeValidator;
import game.pieces.GamePiece;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// For a move that can be one or many SimplePositionalMove's
public class ContinuousPositionalMove implements GameStateChange {

    private final List<Point> traversed;
    private final int pieceID;

    public ContinuousPositionalMove(int pieceID) {
        this.pieceID = pieceID;
        traversed = new LinkedList<>();
    }

    public ContinuousPositionalMove(GamePiece piece) {
        this.pieceID = piece.getID();
        traversed = new LinkedList<>();
    }

    public void addTraversedCell(Point cell) {
        traversed.add(cell);
    }

    @Override
    public boolean acceptValidation(StateChangeValidator validator) throws Exception {
        return validator.doValidation(this);
    }

    @Override
    public void acceptApplication(StateChangeApplier applier) throws Exception {
        applier.doApplication(this);
    }
}
