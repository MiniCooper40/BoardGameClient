package game.moves.options;

import java.awt.*;

public class SimpleMoveOption implements GameMoveOption {

    private final Rectangle position;

    public SimpleMoveOption(Point center, int radius) {
        int diameter = radius*2;
        Point topLeft = new Point(
                center.x - radius,
                center.y-radius
        );
        Dimension dimension = new Dimension(diameter, diameter);

        position = new Rectangle(topLeft, dimension);
    }

    @Override
    public boolean containsPoint(Point p) {
        return position.contains(p);
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(position.x, position.y,
                position.width, position.height);
    }
}
