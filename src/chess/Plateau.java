package chess;

import chess.*;

/**
 * Created by Maxime on 03/04/2017.
 */
public class Plateau {
    int x;
    int y;
    Piece[][] plateau;
    Piece[] cimetiere;

    public Plateau(){
        plateau = new Piece[8][8];
        cimetiere= new Piece[32];
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
        if(p.canMove(a,b)){
            if(cheminLibre(p,a,b)||p instanceof Cavalier){
                if(caseLibre(a,b)){
                    plateau[p.y][p.x]=null;
                    plateau[b][a]=p;
                } else if(!p.sameColor(plateau[b][a])){
                    plateau[p.y][p.x]=null;
                    ajouterMort(plateau[b][a]);
                    plateau[b][a]=p;
                }
                p.firstMove=false;
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
    public void ajouterMort(Piece p){
        boolean done=false;
        while(!done){
            for(int i=0;i<32;i++){
                if(cimetiere[i]==null){
                    cimetiere[i]=p;
                    done=true;
                }
            }
        }
    }
    public double score(boolean c){
        double score=0.;
        for(int i=0;i<32;i++){
            Piece p=cimetiere[i];
            if(p.color!=c){
                if(p instanceof Pion) score+=1;
                if(p instanceof Cavalier) score+=3.2;
                if(p instanceof Fou) score+=3.33;
                if(p instanceof Tour) score+=5.1;
                if(p instanceof Dame) score+=8.8;
            }
        }
        return score;
    }

    public void Roque(Piece Tour,Piece Roi, boolean Taille){// true petit false grand
        if(Tour instanceof Tour && Roi instanceof Roi){ //vérification du type de piece
            boolean chemin =false;
            if(Tour.color == true) {// vérification du placement des pieces
                if(Roi.x == 8 && Roi.y == 5) {
                    if (Tour.firstMove && Roi.firstMove) {
                        if (Taille) {
                            chemin = cheminLibre(Tour, 8, 6);
                            if (Tour.x == 8 && Tour.y == 8 && chemin) {
                                Tour.y = 6;
                                Roi.y = 7;
                            }
                        } else {
                            chemin = cheminLibre(Tour, 8, 4);
                            if (Tour.x == 8 && Tour.y == 1 && chemin) {
                                Tour.y = 4;
                                Roi.y = 3;
                            }
                        }
                    }
                }
            } else{
                if(Roi.x == 1 && Roi.y == 4) {
                    if (Tour.firstMove && Roi.firstMove) {
                        if (Taille) {
                            chemin = cheminLibre(Tour, 1, 3);
                            if (Tour.x == 1 && Tour.y == 1 && chemin) {
                                Tour.y = 3;
                                Roi.y = 2;
                            }
                        } else {
                            chemin = cheminLibre(Tour, 1    , 5);
                            if (Tour.x == 1 && Tour.y == 8 && chemin) {
                                Tour.y = 5;
                                Roi.y = 6;
                            }
                        }
                    }
                }
            }
        }else System.out.println("Roque impossible!");
    }


}
