package display.drawers;

import display.boards.CheckersBoard;
import misc.interfaces.Drawable;

public class CheckersGameDrawer extends GameDrawer {

    public CheckersGameDrawer(Drawable gameStateDrawer) {
        super(new CheckersBoard(), gameStateDrawer);
    }
}
