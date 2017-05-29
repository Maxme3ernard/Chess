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
}
