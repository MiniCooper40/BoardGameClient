package resources.checkers;

import communication.constants.pieces.CheckerType;
import communication.constants.players.Player;
import game.pieces.details.GamePieceProperties;
import resources.GameResources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class CheckersResources implements GameResources {

    private static final Map<Player, Map<CheckerType, BufferedImage>> ICONS;

    static {  // Retrieve images required for checkers
        ICONS = new EnumMap<>(Player.class);
        ICONS.put(Player.ONE, new EnumMap<>(CheckerType.class));
        ICONS.put(Player.TWO, new EnumMap<>(CheckerType.class));

        try {
            ICONS.get(Player.ONE).put(CheckerType.BASE, ImageIO.read(
                    new File(Objects.requireNonNull(GameResources.class.getResource("checkers/blackChecker.png")).getFile())));
            ICONS.get(Player.TWO).put(CheckerType.BASE, ImageIO.read(
                    new File(Objects.requireNonNull(GameResources.class.getResource("checkers/redChecker.png")).getFile())));
            ICONS.get(Player.ONE).put(CheckerType.KING, ImageIO.read(
                    new File(Objects.requireNonNull(GameResources.class.getResource("checkers/blackCheckerKing.png")).getFile())));
            ICONS.get(Player.TWO).put(CheckerType.KING, ImageIO.read(
                    new File(Objects.requireNonNull(GameResources.class.getResource("checkers/redCheckerKing.png")).getFile())));
        } catch (Exception e) {
            System.out.println("failed to load checker images");
        }
    }

    public static BufferedImage getIconFor(GamePieceProperties pieceProperties) {
        Player owner = pieceProperties.getOwner();
        CheckerType type = (CheckerType) pieceProperties.getPieceType();
        return CheckersResources.ICONS.get(owner).get(type);
    }
}
