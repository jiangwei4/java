package mainpackage;

public class Jouer implements Runnable
{
    private Donnees donnees;
    
    public Jouer(final Donnees d) {
        this.donnees = d;
    }
    
    @Override
    public void run() {
        this.donnees.getThreadpacman().setJeu(new Thread((Runnable)this.donnees.getAffichage().getJeu()));
        this.donnees.getThreadpacman().getJeu().start();
        this.donnees.getThreadpacman().setPacman(new Thread((Runnable)this.donnees.getJ1().getPacman()), 0);
        this.donnees.getThreadpacman().getPacman(0).start();
        try {
            Thread.sleep(10L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.donnees.getOptions().isMulti()) {
            this.donnees.getThreadpacman().setPacman(new Thread((Runnable)this.donnees.getJ2().getPacman()), 1);
            this.donnees.getThreadpacman().getPacman(1).start();
        }
        for (int i = 0; i < this.donnees.getListeFantomes().length; ++i) {
            this.donnees.getThreadpacman().setFantome(new Thread((Runnable)this.donnees.getListeFantomes()[i]), i);
            this.donnees.getThreadpacman().getFantome(i).start();
        }
    }
}