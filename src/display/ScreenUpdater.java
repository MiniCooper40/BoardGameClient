package display;

import display.displays.GameDisplay;
import misc.interfaces.Updatable;

public class ScreenUpdater implements Updatable {

    private final GameDisplay gameDisplay;

    public ScreenUpdater(GameDisplay gameDisplay) {

        this.gameDisplay = gameDisplay;
    }

    @Override
    public void update() {
        gameDisplay.update();
    }
}
