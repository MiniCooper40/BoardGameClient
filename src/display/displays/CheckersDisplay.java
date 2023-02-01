package display.displays;

import display.drawers.GameDrawer;
import game.games.CheckersGame;
import game.moves.capture.GameMoveCapturer;
import game.moves.capture.checkers.CheckersMoveCapturer;

public class CheckersDisplay extends GameDisplay {
    public CheckersDisplay(GameDrawer gameDrawer) {
        super(gameDrawer, CheckersGame.SCREEN_DIMENSION);
    }

    @Override
    public GameMoveCapturer retrieveGameMoveCapturer() {
        GameMoveCapturer moveCapturer = new CheckersMoveCapturer(getScreenUpdater());
        addMoveCapturer(moveCapturer);
        return moveCapturer;
    }
}
