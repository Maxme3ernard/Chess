package chess.display;

import chess.display.paint.PaintSkin;

/**
 * Created by coni on 27/05/2017.
 */
public class Skin {
    private final PaintSkin tileBackgroundLight;
    private final PaintSkin tileBackgroundDark;
    private final PaintSkin tileHoverEffectLight;
    private final PaintSkin tileHoverEffectDark;
    private final PaintSkin tileSelectEffectLight;
    private final PaintSkin tileSelectEffectDark;
    private final PaintSkin tileHighlightEffect;
    private final PaintSkin piecePaintSkin;
    private final PaintSkin[] piecesSkin;
    private final PaintSkin whiteName;

    public Skin(PaintSkin tileBackgroundLight, PaintSkin tileBackgroundDark,
                PaintSkin tileHoverEffectLight, PaintSkin tileHoverEffectDark,
                PaintSkin tileSelectEffectLight, PaintSkin tileSelectEffectDark,
                PaintSkin tileHighlightEffect, PaintSkin piecePaintSkin, PaintSkin[] piecesSkin,
                PaintSkin whiteName) {
        this.tileBackgroundLight = tileBackgroundLight;
        this.tileBackgroundDark = tileBackgroundDark;
        this.tileHoverEffectLight = tileHoverEffectLight;
        this.tileHoverEffectDark = tileHoverEffectDark;
        this.tileSelectEffectLight = tileSelectEffectLight;
        this.tileSelectEffectDark = tileSelectEffectDark;
        this.tileHighlightEffect = tileHighlightEffect;
        this.piecePaintSkin = piecePaintSkin;
        this.piecesSkin = piecesSkin;
        this.whiteName = whiteName;
    }

    public PaintSkin getTileBackgroundLight() {
        return tileBackgroundLight;
    }

    public PaintSkin getTileBackgroundDark() {
        return tileBackgroundDark;
    }

    public PaintSkin getTileHoverEffectLight() {
        return tileHoverEffectLight;
    }

    public PaintSkin getTileHoverEffectDark() {
        return tileHoverEffectDark;
    }

    public PaintSkin getTileSelectEffectLight() {
        return tileSelectEffectLight;
    }

    public PaintSkin getTileSelectEffectDark() {
        return tileSelectEffectDark;
    }

    public PaintSkin getTileHighlightEffect() {
        return tileHighlightEffect;
    }

    public PaintSkin getPiecePaintSkin(){
        return piecePaintSkin;
    }

    public PaintSkin getPiecePaint(int pieceTypeId) {
        return piecesSkin[pieceTypeId];
    }

    public PaintSkin getWhiteName() {
        return whiteName;
    }
}
