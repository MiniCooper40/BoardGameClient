package display.frame;

import display.panel.GamePanel;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(GamePanel gamePanel) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(gamePanel);
        pack();
    }

    public void pack() {
        super.pack();
        setLocationRelativeTo(null);
    }
}
