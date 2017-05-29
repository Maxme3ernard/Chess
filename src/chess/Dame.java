package chess;

/**
 * Created by Maxime on 03/04/2017.
 */
public class Dame extends Piece {
    public Dame(int x, int y, boolean c) {
        super(x, y, c);
    }
    public String toString(){
        return "O";
    }
    public boolean canMove(int a,int b){
        for(int i=1;i<8;i++){
            if(a==x+i&&b==y) return true;
            if(a==x-i&&b==y) return true;
            if(a==x&&b==y+i) return true;
            if(a==x&&b==y-i) return true;
            if(a==x+i&&b==y+i)return true;
            if(a==x+i&&b==y-i)return true;
            if(a==x-i&&b==y-i)return true;
            if(a==x-i&&b==y+i)return true;
        }
        return false;
    }

    @Override
    protected int pieceTypeId() {
        return 4;
    }
}
