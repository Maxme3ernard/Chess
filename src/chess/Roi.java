package chess;

import chess.Piece;

/**
 * Created by Maxime on 03/04/2017.
 */
public class Roi extends Piece {
    public Roi(int x, int y, boolean c) {
        super(x, y, c);
    }
    public String toString(){
        return "X";
    }
    public boolean canMove(int x,int y){
        if(x==this.x+1||x==this.x-1||x==this.x){
            if(y==this.y+1||y==this.y-1||y==this.y){
                if(x!=this.x&&y!=this.y) return true;
            }
        }
        return false;
    }
    public boolean echec(Plateau p){
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(p.plateau[i][j].canMove(this.x,this.y)&&p.cheminLibre(p.plateau[i][j],this.x,this.y)) return true;
                if(p.plateau[i][j] instanceof Cavalier&&p.cheminLibre(p.plateau[i][j],this.x,this.y)) return true;
            }
        }
        return false;
    }

    @Override
    protected int pieceTypeId() {
        return 5;
    }
}
