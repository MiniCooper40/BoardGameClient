package display.boards;

import game.games.CheckersGame;

import java.awt.*;

public class CheckersBoard implements GameBoard {
    @Override
    public void draw(Graphics g) {
        for(int i = 0; i < CheckersGame.SCREEN_LENGTH; i+=100) {
            for(int j = 0; j < CheckersGame.SCREEN_LENGTH; j+=100) {
                if( (i+j)/100 % 2 != 0) g.setColor(Color.BLACK);
                else g.setColor(Color.WHITE);
                g.fillRect(i, j, CheckersGame.CELL_LENGTH, CheckersGame.CELL_LENGTH);
            }
        }
    }
}
