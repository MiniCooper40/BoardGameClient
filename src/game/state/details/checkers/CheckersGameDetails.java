package game.state.details.checkers;

import communication.constants.players.Player;
import game.state.details.GameStateDetails;
import game.pieces.GamePiece;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckersGameDetails implements GameStateDetails {

    private Map<Player, Set<GamePiece>> activePlayerPieces;
    private Map<Player, Set<GamePiece>> deletedPlayerPieces;

    @Override
    public Set<GamePiece> getPiecesForPlayer(Player player) {
        if(!activePlayerPieces.containsKey(player)) throw new IllegalArgumentException("Player: " + player + " is not in this game!");
        return activePlayerPieces.get(player);
    }

    @Override
    public Set<GamePiece> getAllGamePieces() {
        return usablePieceStream()
                .collect(Collectors.toSet());
    }

    @Override
    public Player getPlayerWithPiece(int id) {
        GamePiece piece = getGamePieceByID(id);
        if(piece == null) return null;
        return activePlayerPieces.
                entrySet().
                stream()
                .filter(entry -> entry.getValue().contains(piece))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private Stream<GamePiece> usablePieceStream() {
        return activePlayerPieces
                .values()
                .stream()
                .flatMap(Set::stream);
    }

    @Override
    public GamePiece getGamePieceByID(int ID) {
        return usablePieceStream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }
}
