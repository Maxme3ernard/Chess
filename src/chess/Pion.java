package chess;

import chess.Piece;

/**
 * Created by Maxime on 03/04/2017.
 */
public class Pion extends Piece {

    public Pion(int x, int y, boolean c){
        super(x,y,c);
    }
    public String toString(){
        return "x";
    }
    public boolean canMove(int a, int b){
        if(color){
            if(a==x+1&&b==y) return true;
        }
        if(!color){
            if(a==x-1&&b==y)return true;
        }
        return false;
    }
}
