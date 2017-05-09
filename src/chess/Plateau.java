package chess;

import chess.*;

/**
 * Created by Maxime on 03/04/2017.
 */
public class Plateau {
    int x;
    int y;
    Piece[][] plateau;

    public Plateau(){
        plateau = new Piece[8][8];
    }
    public void init(){
        for(int i=0;i<8;i++){
            plateau[1][i]=new Pion(i,1,true);
            plateau[6][i]=new Pion(i,6,false);
        }
        plateau[0][0]=new Tour(0,0,true);
        plateau[0][1]=new Cavalier(1,0,true);
        plateau[0][2]=new Fou(2,0,true);
        plateau[0][3]=new Roi(3,0,true);
        plateau[0][4]=new Dame(4,0,true);
        plateau[0][5]=new Fou(5,0,true);
        plateau[0][6]=new Cavalier(6,0,true);
        plateau[0][7]=new Tour(7,0,true);

        plateau[7][0]=new Tour(0,7,false);
        plateau[7][1]=new Cavalier(1,7,false);
        plateau[7][2]=new Fou(2,7,false);
        plateau[7][3]=new Roi(3,7,false);
        plateau[7][4]=new Dame(4,7,false);
        plateau[7][5]=new Fou(5,7,false);
        plateau[7][6]=new Cavalier(6,7,false);
        plateau[7][7]=new Tour(7,7,false);
    }
    public void afficher(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(plateau[i][j]);
            }
            System.out.println();
        }
    }
    public void deplacer(Piece p,int a, int b){
        if(cheminLibre(p,a,b)){
            if(caseLibre(a,b)){
                plateau[p.y][p.x]=null;
                plateau[b][a]=p;
            } else {
                if(!p.sameColor(plateau[b][a])){
                    plateau[p.y][p.x]=null;
                    plateau[b][a]=p;
                }
            }
        }
        else if (p instanceof Cavalier){
            if(caseLibre(a,b)){
                plateau[p.y][p.x]=null;
                plateau[b][a]=p;
            } else {
                if(!p.sameColor(plateau[b][a])){
                    plateau[p.y][p.x]=null;
                    plateau[b][a]=p;
                }
            }
        }
    }
    public boolean cheminLibre(Piece p, int a, int b){
        for(int i=0;i<Math.abs(p.x-a);i++){
            for(int j=0;j<Math.abs(b-p.y);j++){
                if(plateau[j][i]!=null) return false;
            }
        }
        return true;
    }
    public boolean caseLibre(int a,int b){
        if(plateau[b][a]==null) return true;
        return false;
    }
}
