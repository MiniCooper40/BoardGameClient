package game.services;

import communication.constants.players.Player;
import game.moves.capture.GameMoveCapturer;
import game.moves.types.GameStateChange;
import game.pieces.GamePiece;
import misc.interfaces.Updatable;

import java.util.List;

public class GameMoveCaptureService {

    // todo: add client side move options for capturing continuous moves
    //      - add visual functionality to display custom graphics on cell(s) ( change to a display service?)
    // todo: switch NetworkMessages to contain a list of GameState changes - server can minimize computation needed on client side, and just tell what pieces to delete and move where + in what order
    private final GameMoveCapturer moveCapturer;
    private final GameStateService stateService;

    public GameMoveCaptureService(GameMoveCapturer moveCapturer, GameStateService stateService) {
        this.moveCapturer = moveCapturer;
        this.stateService = stateService;
    }

    public GameStateChange captureNextMoveForPlayer(Player player) throws Exception {
        List<GamePiece> movablePieces = stateService.getMovablePiecesFor(player);
        return moveCapturer.captureMoveWithPieces(movablePieces);
    }
}
