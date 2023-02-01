package display.drawers;

import display.boards.GameBoard;
import misc.interfaces.Drawable;

import java.awt.*;

public abstract class GameDrawer implements Drawable {

    private final GameBoard gameBoardDrawer;
    private final Drawable gameStateDrawer;

    public GameDrawer(GameBoard gameBoardDrawer, Drawable gameStateDrawer) {
        this.gameBoardDrawer = gameBoardDrawer;
        this.gameStateDrawer = gameStateDrawer;
    }

    @Override
    public void draw(Graphics g) {
        gameBoardDrawer.draw(g);
        gameStateDrawer.draw(g);
    }
}
