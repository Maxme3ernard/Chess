package chess;

/**
 * Created by Maxime on 03/04/2017.
 */
public abstract class Piece {
    int x;
    int y;
    boolean color; //si true: blanc, si false: noir
    boolean firstMove;

    public Piece(int x, int y, boolean c){
        this.x=x;
        this.y=y;
        color=c;
        firstMove=true;
    }
    public boolean sameColor(Piece p){
        return color == p.color;
    }

    public abstract boolean canMove(int a,int b);

    protected abstract int pieceTypeId();

    public final int getPieceTypeId(){
        return pieceTypeId() + (color ? 0 : 6);
    }
}
