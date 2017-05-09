/**
 * Created by Maxime on 03/04/2017.
 */
public class Chess {
    public static void main(String[] args) {
        Plateau p=new Plateau();
        p.init();
        p.afficher();
        p.deplacer(p.plateau[1][0],0,2);
        p.deplacer(p.plateau[0][1],2,2);
        p.afficher();
    }
}
