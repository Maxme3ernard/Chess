/**
 * Created by Maxime on 03/04/2017.
 */
public class Piece {
    int x;
    int y;
    boolean color; //si true: blanc, si false: noir

    public Piece(int x, int y, boolean c){
        this.x=x;
        this.y=y;
        color=c;
    }
    public boolean sameColor(Piece p){
        if(color==p.color) return true;
        return false;
    }
}