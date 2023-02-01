package display.displays;

import display.ScreenUpdater;
import display.drawers.GameDrawer;
import display.frame.GameFrame;
import display.panel.GamePanel;
import game.moves.capture.GameMoveCapturer;
import misc.interfaces.Updatable;

import java.awt.*;

public abstract class GameDisplay implements Updatable {

    private final GamePanel gamePanel;

    protected GameDisplay(GameDrawer gameDrawer, Dimension screenDimension) {
        gamePanel = new GamePanel(screenDimension, gameDrawer);
        new GameFrame(gamePanel);
    }

    @Override
    public void update() {
        gamePanel.repaint();
    }

    public Updatable getScreenUpdater() {
        return new ScreenUpdater(this);
    }

    protected void addMoveCapturer(GameMoveCapturer moveCapturer) {
        gamePanel.addMouseListener(moveCapturer);
    }

    public abstract GameMoveCapturer retrieveGameMoveCapturer();
}
