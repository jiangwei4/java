package mainpackage;

import javax.swing.SwingWorker;

class Task extends SwingWorker<Void, Void>
{
    private Donnees donnees;
    private int progress;
    private Labyrinthe laby;
    
    public Task(final Donnees d) {
        this.progress = 0;
        this.donnees = d;
    }
    
    public Void doInBackground() {
        this.setProgress(0);
        try {
            if (!this.donnees.getOptions().isAleatoire()) {
                this.setProgress(Math.min(100, 100));
            }
            else {
                this.laby = new Labyrinthe(this.donnees);
                this.donnees.getThreadpacman().setJouerPM(true);
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    public void done() {
        if (this.getProgress() == 100) {
            this.donnees.setLaby(this.laby);
            this.donnees.getAffichage().afficherJeu();
        }
    }
    
    public void progressF(final int i) {
        this.progress = i;
        this.setProgress(Math.min(this.progress, 100));
    }
    
    public void progress(final int i) {
        this.progress += i;
        this.setProgress(Math.min(this.progress, 100));
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Labyrinthe getLaby() {
        return this.laby;
    }
    
    public void setLaby(final Labyrinthe laby) {
        this.laby = laby;
    }
}