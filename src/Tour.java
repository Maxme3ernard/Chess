/**
 * Created by Maxime on 03/04/2017.
 */
public class Tour extends Piece {
    public Tour(int x, int y, boolean c) {
        super(x, y, c);
    }
    public String toString(){
        return "I";
    }
    public boolean canMove(int a,int b, Plateau p){
        for(int i=1;i<8;i++){
            if(a==x+i&&b==y) return true;
            if(a==x-i&&b==y) return true;
            if(a==x&&b==y+i) return true;
            if(a==x&&b==y-i) return true;
        }
        return false;
    }
}
