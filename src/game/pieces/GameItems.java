package game.pieces;

import communication.constants.players.Player;
import game.pieces.details.GameConsumableType;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameItems implements Serializable {

    public static final long serialVersionUID = 1298401928412L;
    private final Map<Player, Set<GamePiece>>  activePieces;
    private final Map<GameConsumableType, GameConsumable> activeConsumables;

    public GameItems() {
        activePieces = new EnumMap<>(Player.class);
        activeConsumables = new HashMap<>();
    }

    private Map<Player, Set<GamePiece>> removedPieces;
    private Map<GameConsumableType, GameConsumable> usedConsumables;

    public Map<Player, Set<GamePiece>> getPieces() {
        return activePieces;
    }

    public Map<GameConsumableType, GameConsumable> getConsumables() {
        return activeConsumables;
    }

    @Override
    public String toString() {
        return "GameItems{" +
                "activePieces=" + activePieces +
                '}';
    }
}
