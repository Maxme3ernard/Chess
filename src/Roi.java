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
}
