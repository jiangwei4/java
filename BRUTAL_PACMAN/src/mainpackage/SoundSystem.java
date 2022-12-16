package mainpackage;
import javax.sound.sampled.AudioSystem;

public class SoundSystem
{
    private Sound[] son;
    private int taille;
    private float volumeTheme;
    private float volumeEffet;
    private Donnees donnees;
    
    public SoundSystem(final Donnees d) {
        this.donnees = d;
        this.taille = 15;
        this.son = new Sound[this.taille];
        for (int i = 0; i < this.taille; ++i) {
            try {
                this.son[i] = new Sound(AudioSystem.getAudioInputStream(this.getClass().getResource("/musiques/" + i + ".wav")), AudioSystem.getClip());
            }
            catch (Exception e) {
                System.out.println("prb chargement musique : " + i + ".wav");
            }
        }
    }
    
    public void jouer(final int i) {
        this.son[i].jouer();
    }
    
    public void jouerEnBoucle(final int i) {
        this.son[i].jouerEnBoucle();
    }
    
    public void close() {
        for (int i = 0; i < this.taille; ++i) {
            this.son[i].close();
        }
    }
    
    public void stop(final int i) {
        this.son[i].stop();
    }
    
    public void menu(final int j) {
        if (j == 7) {
            this.son[j].jouerEnBoucle();
            this.son[j].setVolume(this.volumeTheme);
        }
        else {
            for (int i = 0; i < this.taille; ++i) {
                this.son[i].stop();
                try {
                    if (i < 5) {
                        this.son[i].setJouerDepuisLeDebut(this.donnees.getOptions().isJouerDepuisDebut(i));
                    }
                    if (this.son[i].isJouerDepuisLeDebut() && this.son[i].isOpen()) {
                        this.son[i].initialiserAZero();
                    }
                }
                catch (Exception ex) {}
                try {
                    this.son[j].jouerEnBoucle();
                    this.son[j].setVolume(this.volumeTheme);
                }
                catch (Exception ex2) {}
            }
        }
    }
    
    public void effet(final int i) {
        if (this.son[i].isOpen()) {
            this.son[i].initialiserAZero();
        }
        try {
            this.son[i].jouer();
            this.son[i].setVolume(this.volumeEffet);
        }
        catch (Exception ex) {}
    }
    
    public Sound[] getSon() {
        return this.son;
    }
    
    public void setSon(final Sound[] son) {
        this.son = son;
    }
    
    public int getTaille() {
        return this.taille;
    }
    
    public void setTaille(final int taille) {
        this.taille = taille;
    }
    
    public void jouerDepuisLeDebut(final boolean b, final int i) {
        this.son[i].setJouerDepuisLeDebut(b);
    }
    
    public void volume(final int i, final float v) {
        this.son[i].setVolume(v);
    }
    
    public float getVolumeTheme() {
        return this.volumeTheme;
    }
    
    public void setVolumeTheme(final float theme) {
        this.volumeTheme = theme;
    }
    
    public float getVolumeEffet() {
        return this.volumeEffet;
    }
    
    public void setVolumeEffet(final float effet) {
        this.volumeEffet = effet;
    }
    
    public Sound sound(final int i) {
        return this.son[i];
    }
}