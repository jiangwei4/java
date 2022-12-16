package mainpackage;
public class ThreadPACMAN
{
    private Thread[] pacman;
    private Thread[] fantome;
    private Thread jouer;
    private Thread jeu;
    private boolean jouerPM;
    
    public ThreadPACMAN(final Donnees d) {
        this.jouerPM = true;
        this.pacman = new Thread[2];
        this.fantome = new Thread[10];
        this.jouer = null;
    }
    
    @SuppressWarnings("deprecation")
	public void destroy(final Thread t) {
        //t.destroy();
        t.stop();
    }
    
    @SuppressWarnings("deprecation")
	public void stop(final Thread t) {
    	//t.destroy();
        t.stop();
    }
    
    public void interrupt(final Thread t) {
        t.interrupt();
    }
    
    public Thread[] getPacman() {
        return this.pacman;
    }
    
    public void setPacman(final Thread[] pacman) {
        this.pacman = pacman;
    }
    
    public Thread[] getFantome() {
        return this.fantome;
    }
    
    public void setFantome(final Thread[] fantome) {
        this.fantome = fantome;
    }
    
    public Thread getJouer() {
        return this.jouer;
    }
    
    public void setJouer(final Thread jouer) {
        this.jouer = jouer;
    }
    
    public Thread getPacman(final int i) {
        return this.pacman[i];
    }
    
    public void setPacman(final Thread pacman, final int i) {
        this.pacman[i] = pacman;
    }
    
    public Thread getFantome(final int i) {
        return this.fantome[i];
    }
    
    public void setFantome(final Thread fantome, final int i) {
        this.fantome[i] = fantome;
    }
    
    public Thread getJeu() {
        return this.jeu;
    }
    
    public void setJeu(final Thread jeu) {
        this.jeu = jeu;
    }
    
    public boolean isJouerPM() {
        return this.jouerPM;
    }
    
    public void setJouerPM(final boolean jouerPM) {
        this.jouerPM = jouerPM;
    }
}