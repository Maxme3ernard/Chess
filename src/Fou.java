/**
 * Created by Maxime on 03/04/2017.
 */
public class Fou extends Piece {
    public Fou(int x, int y, boolean c) {
        super(x, y, c);
    }
    public String toString(){
        return "*";
    }
    public boolean canMove(int a,int b){
        for(int i=1;i<8;i++){
            if(a==x+i&&b==y+i)return true;
            if(a==x+i&&b==y-i)return true;
            if(a==x-i&&b==y-i)return true;
            if(a==x-i&&b==y+i)return true;
        }
        return false;
    }
}
