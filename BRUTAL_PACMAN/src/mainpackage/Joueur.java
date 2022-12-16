package mainpackage;
public class Joueur
{
    private String nom;
    private Pacman pacman;
    private double scoreF;
    
    public Joueur(final Donnees d) {
        this.pacman = new Pacman(0, 0, 0, 0, 0, d);
        this.scoreF = 0.0;
        this.nom = "";
    }
    
    public Joueur(final Donnees d, final double f) {
        this.pacman = new Pacman(0, 0, 0, 0, 0, d);
        this.scoreF = f;
        this.nom = "";
    }
    
    public void zero(final Pacman pm) {
        this.pacman = pm;
    }
    
    public Pacman getPacman() {
        return this.pacman;
    }
    
    public void setPacman(final Pacman pacman) {
        this.pacman = pacman;
    }
    
    public double getScoreF() {
        return this.scoreF;
    }
    
    public void setScoreF(final double scoreF) {
        this.scoreF = scoreF;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(final String nom) {
        this.nom = nom;
    }
}