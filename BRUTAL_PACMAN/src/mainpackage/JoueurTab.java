package mainpackage;

public class JoueurTab
{
    private double score;
    private String nom;
    
    public JoueurTab(final double i, final String j) {
        this.score = i;
        this.nom = j;
    }
    
    public JoueurTab() {
        this.score = 0.0;
        this.nom = "";
    }
    
    public double getScore() {
        return this.score;
    }
    
    public void setScore(final double score) {
        this.score = score;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(final String nom) {
        this.nom = nom;
    }
}