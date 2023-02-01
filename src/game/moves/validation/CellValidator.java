package game.moves.validation;

import communication.constants.players.Player;

import java.awt.*;

public interface CellValidator {
    boolean isValidCell(Point point);
}
