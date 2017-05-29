package chess.display.board;

import chess.Piece;
import chess.Plateau;
import chess.display.Skin;
import chess.display.board.TileUI;
import chess.display.paint.PaintSkin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by coni on 27/05/2017.
 */
public class PiecePaintSkin implements PaintSkin {
    private final Plateau plateau;
    private Skin skin;

    public PiecePaintSkin(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public void paint(Graphics2D g2, JComponent c) {
        TileUI tileUI = ((TileUI)((JLayer)c).getUI());
        Piece piece = plateau.pieceAt(tileUI.getX(), tileUI.getY());
        if (piece == null) return;
        PaintSkin piecePaint = skin.getPiecePaint(piece.getPieceTypeId());
        piecePaint.paint(g2, c);
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }
}
