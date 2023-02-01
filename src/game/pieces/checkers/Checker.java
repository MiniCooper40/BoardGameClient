package game.pieces.checkers;

import game.pieces.GamePiece;
import game.pieces.details.GamePieceDetails;

import java.awt.*;

public class Checker extends GamePiece {

    public static final long serialVersionUID = 12094801295800L;

    public Checker(GamePieceDetails pieceDetails) {
        super(pieceDetails);
    }

    @Override
    public void draw(Graphics g) {
        if(isSelected()) {
            g.setColor(Color.yellow);
            Rectangle pos = getPosition();
            g.fillOval(
                    pos.x -4, pos.y-4,
                    pos.width+8, pos.height+8
            );
        }
        super.draw(g);
    }
}
