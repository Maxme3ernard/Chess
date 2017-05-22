package chess;

import java.util.Scanner;

/**
 * Created by Maxime on 03/04/2017.
 */
public class Chess {
    public static void main(String[] args) {
        Plateau p=new Plateau();
        p.init();

        Player p1=creerJoueur(1);
        Player p2=creerJoueur(2);
        while(!p.gagner()){

        }

    }
    public static Player creerJoueur(int a){
        System.out.println("Le joueur "+a+" rentre son nom:");
        Scanner sc=new Scanner(System.in);
        Player p=new Player(sc.nextLine());
        return p;
    }
}
