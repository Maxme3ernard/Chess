/**
 * Created by Maxime on 03/04/2017.
 */
public class Cavalier extends Piece {
    public Cavalier(int x, int y, boolean c) {
        super(x, y, c);
    }
    public String toString(){
        return "p";
    }
    public boolean canMove(int a,int b){
        //if(Math.sqrt(Math.pow(a,2)+Math.pow(b,2))==Math.sqrt(10)) return true;

        if(a==x+2&&b==y+1) return true;
        if(a==x+2&&b==y-1) return true;
        if(a==x-2&&b==y-1) return true;
        if(a==x-2&&b==y+1) return true;
        if(a==x+1&&b==y+2) return true;
        if(a==x-1&&b==y+2) return true;
        if(a==x+1&&b==y-2) return true;
        if(a==x-1&&b==y-2) return true;
        return false;
    }
}
