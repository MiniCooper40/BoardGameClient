package game.state;

import game.moves.validation.checkers.CheckersCellValidator;

public class CheckersGameState extends GameState  {

    public CheckersGameState() {
        super(new CheckersCellValidator());
    }
}
