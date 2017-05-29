package chess.display.board;

import chess.Piece;
import chess.Plateau;
import chess.display.util.Action;

/**
 * Created by coni on 27/05/2017.
 */
public class MoveDisplay {
    private final Plateau plateau;
    private final Action repaintBoard;
    private TileUI selectedTile;
    private Piece selectedPiece;
    private long highlightBitmask = 0;

    public MoveDisplay(Plateau plateau, Action repaintBoard) {
        this.plateau = plateau;
        this.repaintBoard = repaintBoard;
    }


    public void click(TileUI tileUI){
        Piece clicked = plateau.pieceAt(tileUI.getX(), tileUI.getY());
        if (selectedTile == null && clicked != null) {
            selectedTile = tileUI;
            selectedPiece = clicked;
            tileUI.select();
            highlight();
            repaintBoard.makeAction();
        } else if (selectedTile != null){
            plateau.deplacer(selectedPiece, tileUI.getX(), tileUI.getY());
            selectedTile.deselect();
            highlightBitmask = 0;
            selectedTile = null;
            selectedPiece = null;
            repaintBoard.makeAction();
        }
    }

    private void highlight(){
        highlightBitmask = 0;
        for (int i = 0; i < 64; i++) if (plateau.canMove(selectedPiece,i % 8,i / 8)) highlightBitmask |= 1 << i;
    }

    public boolean isHighlighted(int x, int y){
        return ((highlightBitmask >> y * 8 + x) & 1) == 1;
    }
}
