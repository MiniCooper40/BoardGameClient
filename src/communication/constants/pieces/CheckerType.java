package communication.constants.pieces;

import java.awt.image.BufferedImage;

public enum CheckerType implements GamePieceType {

    BASE,
    KING,
    DARK_BASE,
    LIGHT_BASE,
    DARK_KING,
    LIGHT_KING;

    @Override
    public BufferedImage getIcon() {
        return null;
    }
}
