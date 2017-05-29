package chess;

/**
 * Created by Maxime on 15/05/2017.
 */
public class Player {
    private String nom;
    private double score;
    private int nbCoup;

    public Player(String s) {
        this.nom = s;
        this.score = 0;
        this.nbCoup = 0;
    }
    public boolean joue(Plateau p) {
        System.out.println("Au tour de "+nom+" de jouer.");
        //faire ici la detection de la case jouée
        int a; //coordonnée y de la pièce sélectionnée
        int b; //coordonnée x de la pièce séléctionnée
        int y; //coordonnée y de la case séléctionnée
        int x; //coordonnée x de la case séléctionnée
        if(!p.deplacer(p.plateau[a][b], y, x)){
            System.out.println("Le déplacement n'a pas été effectué.");
            return false;
        }
        return true;
    }
}