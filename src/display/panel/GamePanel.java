package display.panel;

import display.drawers.GameDrawer;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final GameDrawer gameDrawer;

    public GamePanel(Dimension screenDimension, GameDrawer gameDrawer) {
        this.gameDrawer = gameDrawer;

        setEnabled(true);
        setVisible(true);
        setPreferredSize(screenDimension);
    }

    public void paintComponent(Graphics g) {
        gameDrawer.draw(g);
    }
}
