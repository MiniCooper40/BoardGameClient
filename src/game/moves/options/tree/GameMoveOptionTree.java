package game.moves.options.tree;

import game.moves.options.GameMoveOption;
import misc.interfaces.Drawable;

import java.util.List;

public interface GameMoveOptionTree extends Drawable {
    List<GameMoveOption> treeAsOptionList();
    List<GameMoveOption> immediateMoveOptionList();
    void selectMoveOption(GameMoveOption option);
}
