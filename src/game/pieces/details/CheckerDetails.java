package game.pieces.details;

import communication.constants.pieces.CheckerType;
import communication.constants.players.Player;
import game.games.CheckersGame;
import resources.checkers.CheckersResources;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CheckerDetails implements GamePieceDetails {


    public static final long serialVersionUID = -2140850129444L;

    private final int id;
    private final GamePieceProperties pieceProperties;
    private final Point cell;

    public CheckerDetails(int id, GamePieceProperties pieceProperties, Point cell) {
        this.id = id;
        this.pieceProperties = pieceProperties;
        this.cell = cell;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Rectangle getPosition() {
        int screenX = cell.x * CheckersGame.CELL_LENGTH + CheckersGame.CHECKER_OFFSET;
        int screenY = cell.y * CheckersGame.CELL_LENGTH + CheckersGame.CHECKER_OFFSET;
        Point screenLocation = new Point(screenX, screenY);
        return new Rectangle(screenLocation, CheckersGame.CHECKER_DIMENSION);
    }

    @Override
    public BufferedImage getImage() {
        return CheckersResources.getIconFor(pieceProperties);
    }

    @Override
    public void moveTo(Point point) {
        cell.setLocation(point);
    }

    @Override
    public Enum<?> getPieceType() {
        return (Enum<?>) pieceProperties.getPieceType();
    }

    @Override
    public Point getCell() {
        return cell;
    }
}
