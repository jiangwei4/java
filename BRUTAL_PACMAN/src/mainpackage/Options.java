package mainpackage;
public class Options
{
    private int nbFantomes;
    private int largeur;
    private int hauteur;
    private int largeurMin;
    private int hauteurMin;
    private int nbSgumm;
    private boolean aleatoire;
    private boolean couperVolumeTheme;
    private boolean[] themeDepuisDebut;
    private int[] volume;
    private boolean survie;
    private boolean multi;
    
    public Options() {
        this.themeDepuisDebut = new boolean[5];
        this.volume = new int[2];
        this.survie = false;
        this.survie = false;
        this.largeurMin = 8;
        this.hauteurMin = 5;
        this.nbFantomes = 4;
        this.aleatoire = true;
        this.nbSgumm = 2;
        this.hauteur = 12;
        this.largeur = 14;
        this.volume[0] = 0;
        this.volume[1] = 0;
        this.themeDepuisDebut[0] = true;
        this.themeDepuisDebut[1] = true;
        this.themeDepuisDebut[2] = true;
        this.themeDepuisDebut[3] = true;
        this.themeDepuisDebut[4] = true;
        this.couperVolumeTheme = false;
    }
    
    public void setThemeDepuisDebut(final int i, final boolean b) {
        this.themeDepuisDebut[i] = b;
    }
    
    public boolean isJouerDepuisDebut(final int i) {
        return this.themeDepuisDebut[i];
    }
    
    public int getNbFantomes() {
        return this.nbFantomes;
    }
    
    public void setNbFantomes(final int nbFantomes) {
        this.nbFantomes = nbFantomes;
    }
    
    public int getLargeur() {
        return this.largeur;
    }
    
    public void setLargeur(final int largeur) {
        this.largeur = largeur;
    }
    
    public int getHauteur() {
        return this.hauteur;
    }
    
    public void setHauteur(final int hauteur) {
        this.hauteur = hauteur;
    }
    
    public int getNbSgumm() {
        return this.nbSgumm;
    }
    
    public void setNbSgumm(final int nbrSgumm) {
        this.nbSgumm = nbrSgumm;
    }
    
    public boolean isAleatoire() {
        return this.aleatoire;
    }
    
    public void setAleatoire(final boolean aleatoire) {
        this.aleatoire = aleatoire;
    }
    
    public boolean[] getThemeDepuisDebut() {
        return this.themeDepuisDebut;
    }
    
    public void setThemeDepuisDebut(final boolean[] themeDepuisDebut) {
        this.themeDepuisDebut = themeDepuisDebut;
    }
    
    @Override
    public String toString() {
        String res = "Options: \n";
        res = String.valueOf(res) + this.aleatoire;
        return res;
    }
    
    public int[] getVolume() {
        return this.volume;
    }
    
    public int getVolume(final int i) {
        return this.volume[i];
    }
    
    public void setVolume(final int i, final int s) {
        this.volume[i] = s;
    }
    
    public void setVolume(final int[] volume) {
        this.volume = volume;
    }
    
    public int getLargeurMin() {
        return this.largeurMin;
    }
    
    public void setLargeurMin(final int largeurMin) {
        this.largeurMin = largeurMin;
    }
    
    public int getHauteurMin() {
        return this.hauteurMin;
    }
    
    public void setHauteurMin(final int hauteurMin) {
        this.hauteurMin = hauteurMin;
    }
    
    public boolean isSurvie() {
        return this.survie;
    }
    
    public void setSurvie(final boolean survie) {
        this.survie = survie;
    }
    
    public boolean isMulti() {
        return this.multi;
    }
    
    public void setMulti(final boolean multi) {
        this.multi = multi;
    }
    
    public boolean isCouperVolumeTheme() {
        return this.couperVolumeTheme;
    }
    
    public void setCouperVolumeTheme(final boolean couperVolumeTheme) {
        this.couperVolumeTheme = couperVolumeTheme;
    }
}