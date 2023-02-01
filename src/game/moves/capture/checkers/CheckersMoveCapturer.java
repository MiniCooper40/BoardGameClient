package game.moves.capture.checkers;

import game.games.CheckersGame;
import game.moves.capture.GameMoveCapturer;
import game.moves.types.GameStateChange;
import game.moves.types.SimplePositionalMove;
import game.pieces.GamePiece;
import misc.interfaces.Updatable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class CheckersMoveCapturer implements GameMoveCapturer {

    private List<GamePiece> movablePieces;
    private final Updatable screenUpdater;
    private volatile boolean capturing = false;
    private GamePiece selectedPiece;
    private GameStateChange move;
    //private GameMoveOptionGenerator optionGenerator

    public CheckersMoveCapturer(Updatable screenUpdater) {
        this.screenUpdater = screenUpdater;
    }

    @Override
    public GameStateChange captureMoveWithPieces(List<GamePiece> movablePieces) {
        this.movablePieces = movablePieces;
        startTurn();
        while(capturing) {
            Thread.onSpinWait();
        }
        return move;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("In mouseClicked!");
        if(capturing) {
            Point clickedPoint = screenCoordinateOfClick(e);
            if(selectedPiece != null)
                //completeMoveTo(clickedPoint);
                continueMoveTo(clickedPoint);
            testForClickedPiece(clickedPoint);
        }
    }

    private Point screenCoordinateOfClick(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        return new Point(x, y);
    }

    private Point screenPointToCheckersCell(Point clickedPoint) {
        int x = clickedPoint.x % CheckersGame.CELL_LENGTH;
        int y = clickedPoint.y % CheckersGame.CELL_LENGTH;
        return new Point(x, y);
    }

    private void startTurn() {
        capturing = true;
    }

    private void completeTurn() {
        capturing = false;
        move = null;
        deselectPiece();
    }

    private void continueMoveTo(Point clickedPoint) {
        Point checkerCell = screenPointToCheckersCell(clickedPoint);
    }

    private void completeMoveTo(Point clickedPoint) {
        Point checkerCell = screenPointToCheckersCell(clickedPoint);
        move = new SimplePositionalMove.Builder()
                .forPiece(selectedPiece)
                .toLocation(checkerCell);
        completeTurn();
    }

    private void testForClickedPiece(Point clickedPoint) {
        System.out.println("Clicked point is @ " + clickedPoint);
        for(GamePiece piece : movablePieces) {
            if(piece.containsClickedPoint(clickedPoint))
                selectPiece(piece);
        }
    }

    public void selectPiece(GamePiece piece) {
        selectedPiece = piece;
        piece.select();
        updatedScreen();
    }

    public void deselectPiece() {
        selectedPiece.deselect();
        selectedPiece = null;
        updatedScreen();
    }

    public void updatedScreen() {
        screenUpdater.update();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
