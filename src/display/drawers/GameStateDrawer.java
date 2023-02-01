package display.drawers;

import game.pieces.GamePiece;
import game.services.GameStateService;
import misc.interfaces.Drawable;

import java.awt.Graphics;
import java.util.List;

public class GameStateDrawer implements Drawable {

    private final GameStateService stateService;

    public GameStateDrawer(GameStateService stateService) {
        this.stateService = stateService;
    }

    @Override
    public void draw(Graphics g) {
        List<GamePiece> pieces = stateService.getDrawablePieces();
        pieces.forEach(piece -> piece.draw(g));
    }
}
