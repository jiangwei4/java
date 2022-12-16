package mainpackage;
public class Premiere
{
    private static Affichage affichage;
    
    public static void main(final String[] args) {
        Premiere.affichage = new Affichage(false);
    }
    
    public static void Quiter() {
        Premiere.affichage.dispose();
    }
    
    public static void nouv(final boolean pe) {
        Premiere.affichage.dispose();
        Premiere.affichage = new Affichage(pe);
    }
}