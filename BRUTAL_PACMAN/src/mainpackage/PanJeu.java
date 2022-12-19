package mainpackage;
import java.awt.Font;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class PanJeu extends JPanel implements Runnable
{
    private static final int intervalleRafraichissement = 50;
    private Donnees donnees;
    private Labyrinthe laby;
    private BufferedImage[] listeSprites;
    private int largeurPix;
    private int hauteurPix;
    private int largeurCasePix;
    private int hauteurCasePix;
    private int nbFantomes;
    private boolean premierAppel;
    private int larg;
    private int haut;
    
    public PanJeu(final Donnees d) {
        this.donnees = d;
        this.listeSprites = this.donnees.getListeSprites();
        this.donnees.DonneesS();
        this.nbFantomes = this.donnees.getOptions().getNbFantomes();
        this.laby = this.donnees.getAffichage().getPanchargement().getLaby();
        this.quelleMusique();
        this.premierAppel = true;
    }
    
    public void paintComponent(final Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        final Graphics2D g2 = (Graphics2D)g;
        this.largeurPix = this.getWidth();
        this.hauteurPix = this.getHeight();
        this.largeurCasePix = this.largeurPix / this.laby.getLargeur();
        this.hauteurCasePix = this.hauteurPix / this.laby.getHauteur();
        if (this.largeurCasePix > this.hauteurCasePix) {
            this.larg = (this.largeurCasePix - this.hauteurCasePix) * this.laby.getLargeur() / 2;
            this.largeurCasePix = this.hauteurCasePix;
        }
        else {
            this.haut = (this.hauteurCasePix - this.largeurCasePix) * this.laby.getHauteur() / 2;
            this.hauteurCasePix = this.largeurCasePix;
        }
        if (this.premierAppel) {
            this.premierAppel = false;
            this.initialiserPacmanXetY();
        }
        for (int i = 0; i < this.laby.getHauteur(); ++i) {
            for (int j = 0; j < this.laby.getLargeur(); ++j) {
                g.drawImage(this.listeSprites[this.laby.avoirCase(i, j).getImage()], j * this.largeurCasePix + this.larg, i * this.hauteurCasePix + this.haut, this.largeurCasePix, this.hauteurCasePix, null);
                if (this.laby.avoirCase(i, j).isGumm()) {
                    g.drawImage(this.donnees.getListeSprites()[22], j * this.largeurCasePix + this.larg, i * this.hauteurCasePix + this.haut, this.largeurCasePix, this.hauteurCasePix, null);
                }
                if (this.laby.avoirCase(i, j).isSgumm()) {
                    g.drawImage(this.donnees.getListeSprites()[23], j * this.largeurCasePix + this.larg, i * this.hauteurCasePix + this.haut, this.largeurCasePix, this.hauteurCasePix, null);
                }
            }
        }
        this.afficherScore(g);
        if (this.donnees.getJ1().getPacman().getCompteurSgumm() != 0) {
            g.drawImage(this.listeSprites[48 + this.donnees.getJ1().getPacman().getDirection() * 5 + this.donnees.getJ1().getPacman().getEtatAnimation()], this.donnees.getJ1().getPacman().getPixelX() + this.larg, this.donnees.getJ1().getPacman().getPixelY() + this.haut, this.largeurCasePix, this.hauteurCasePix, null);
        }
        else {
            g.drawImage(this.listeSprites[28 + this.donnees.getJ1().getPacman().getDirection() * 5 + this.donnees.getJ1().getPacman().getEtatAnimation()], this.donnees.getJ1().getPacman().getPixelX() + this.larg, this.donnees.getJ1().getPacman().getPixelY() + this.haut, this.largeurCasePix, this.hauteurCasePix, null);
        }
        if (this.donnees.getOptions().isMulti()) {
            if (this.donnees.getJ2().getPacman().getCompteurSgumm() != 0) {
                g.drawImage(this.listeSprites[48 + this.donnees.getJ2().getPacman().getDirection() * 5 + this.donnees.getJ2().getPacman().getEtatAnimation()], this.donnees.getJ2().getPacman().getPixelX() + this.larg, this.donnees.getJ2().getPacman().getPixelY() + this.haut, this.largeurCasePix, this.hauteurCasePix, null);
            }
            else {
                g.drawImage(this.listeSprites[28 + this.donnees.getJ2().getPacman().getDirection() * 5 + this.donnees.getJ2().getPacman().getEtatAnimation()], this.donnees.getJ2().getPacman().getPixelX() + this.larg, this.donnees.getJ2().getPacman().getPixelY() + this.haut, this.largeurCasePix, this.hauteurCasePix, null);
            }
        }
        if (this.donnees.getOptions().isMulti()) {
            g2.setFont(new Font("Impact", 1, this.largeurCasePix / 2));
            g2.setColor(Color.GREEN);
            g2.drawString("J1", this.donnees.getJ1().getPacman().getPixelX() + this.larg, this.donnees.getJ1().getPacman().getPixelY() + this.haut + this.hauteurCasePix);
            g2.setFont(new Font("Impact", 1, this.largeurCasePix / 2));
            g2.setColor(Color.GREEN);
            g2.drawString("J2", this.donnees.getJ2().getPacman().getPixelX() + this.larg + this.largeurCasePix / 2, this.donnees.getJ2().getPacman().getPixelY() + this.haut + this.hauteurCasePix);
        }
        for (int i = 0; i < this.nbFantomes; ++i) {
            g.setColor(this.donnees.getListeFantomes()[i].getCouleur());
            g.fillRect(this.donnees.getListeFantomes()[i].getPixelX() + this.largeurCasePix / 10 + this.larg, this.donnees.getListeFantomes()[i].getPixelY() + this.hauteurCasePix / 10 + this.haut, this.largeurCasePix - this.largeurCasePix / 2, this.hauteurCasePix - this.hauteurCasePix / 2);
        }
        this.afficherTimerBerserk(g);
        this.afficherVie(g);
    }
    
    public void afficherVie(final Graphics g) {
        if (this.donnees.getOptions().isMulti()) {
            for (int i = 0; i < 2 * this.larg / this.largeurCasePix + this.donnees.getAffichage().getPanchargement().getLaby().getLargeur(); ++i) {
                if (i <= this.donnees.getJ1().getPacman().getVie() - 1 || i >= 2 * this.larg / this.largeurCasePix + this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - this.donnees.getJ2().getPacman().getVie()) {
                    g.drawImage(this.donnees.getListeSprites()[51], i * this.largeurCasePix, (this.laby.getHauteur() - 1) * this.hauteurCasePix + this.haut * 2, this.largeurCasePix, this.hauteurCasePix, null);
                }
            }
        }
        else {
            for (int i = 0; i < this.donnees.getJ1().getPacman().getVie(); ++i) {
                g.drawImage(this.donnees.getListeSprites()[51], i * this.largeurCasePix, (this.laby.getHauteur() - 1) * this.hauteurCasePix + this.haut * 2, this.largeurCasePix, this.hauteurCasePix, null);
            }
        }
    }

    public void afficherTimerBerserk(final Graphics g){
        int score1_j1 = this.donnees.getJ1().getPacman().getCompteurSgumm();
        double score1_j11 = 0.0;
        if(score1_j1 > 0)
            score1_j11 = Math.floor(score1_j1/100) / 10;
        String score1 = new StringBuilder(String.valueOf(score1_j11)).toString();
        final int sc1 = score1.length();
        if (this.donnees.getOptions().isMulti()) {
            int score2_j2 = this.donnees.getJ2().getPacman().getCompteurSgumm();
            double score2_j22 = 0.0;
            if(score2_j2 > 0)
                score2_j22 = Math.floor(score2_j2/100) / 10;
            final String score2 = new StringBuilder(String.valueOf(score2_j22)).toString();
            for (int k = 0; k < 2 * this.larg / this.largeurCasePix + (this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - (sc1 + score2.length())); ++k) {
                score1 = String.valueOf(score1) + "x";
            }
            score1 = String.valueOf(score1) + score2;
            this.chiffre(g, score1, (this.laby.getHauteur() - 1) * this.hauteurCasePix + this.haut * 2 - this.hauteurCasePix * 2);
        }
        else {
            for (int e = 0; e < score1.length(); ++e) {
                this.chiffre(g, score1, (this.laby.getHauteur() -1) * this.hauteurCasePix + this.haut * 2 - this.hauteurCasePix * 2);
            }
        }
    }
    
    public void afficherScore(final Graphics g) {
        String score1 = new StringBuilder(String.valueOf(this.donnees.getJ1().getPacman().getScore())).toString();
        final int sc1 = score1.length();
        if (this.donnees.getOptions().isMulti()) {
            final String score2 = new StringBuilder(String.valueOf(this.donnees.getJ2().getPacman().getScore())).toString();
            for (int k = 0; k < 2 * this.larg / this.largeurCasePix + (this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - (sc1 + score2.length())); ++k) {
                score1 = String.valueOf(score1) + "x";
            }
            score1 = String.valueOf(score1) + score2;
            this.chiffre(g, score1,0);
        }
        else {
            for (int e = 0; e < score1.length(); ++e) {
                this.chiffre(g, score1,0);
            }
        }
    }
    
    public void chiffre(final Graphics g, final String Score, int hauteur) {
        int base = 68;
        for (int i = 0; i < Score.length(); ++i) {
            if(Score.charAt(i) != '.'){
                g.drawImage(this.donnees.getListeSprites()[base+Character.getNumericValue(Score.charAt(i))], i * this.largeurCasePix, hauteur, this.largeurCasePix, this.hauteurCasePix, null);
            } else {
                g.drawImage(this.donnees.getListeSprites()[88], i * this.largeurCasePix, hauteur, this.largeurCasePix, this.hauteurCasePix, null);
            }
        
        
        }
    }
    
    public void quelleMusique() {
        if (this.donnees.getOptions().isMulti()) {
            this.donnees.getS().menu(4);
        }
        else if (this.donnees.getOptions().isSurvie()) {
            this.donnees.getS().menu(3);
        }
        else {
            this.donnees.getS().menu(1);
        }
    }
    
    public void initialiserPacmanXetY() {
        this.donnees.getJ1().getPacman().setPixelX(this.laby.getPosY() * this.largeurCasePix);
        this.donnees.getJ1().getPacman().setPixelY(this.laby.getPosX() * this.hauteurCasePix);
        this.donnees.getJ1().getPacman().setTailleX(this.largeurCasePix);
        this.donnees.getJ1().getPacman().setTailleY(this.hauteurCasePix);
        if (this.donnees.getOptions().isMulti()) {
            this.donnees.getJ2().getPacman().setPixelX((this.laby.getLargeur() - this.laby.getPosY() - 1) * this.largeurCasePix);
            this.donnees.getJ2().getPacman().setPixelY(this.laby.getPosX() * this.hauteurCasePix);
            this.donnees.getJ2().getPacman().setTailleX(this.largeurCasePix);
            this.donnees.getJ2().getPacman().setTailleY(this.hauteurCasePix);
        }
        for (int i = 0; i < this.nbFantomes; ++i) {
            this.donnees.getListeFantomes()[i].setPixelX(this.laby.getXDepartFantome() - 2 + i % 4 * this.largeurCasePix + this.larg);
            this.donnees.getListeFantomes()[i].setPixelY(this.laby.getYDepartFantome() * this.hauteurCasePix + this.haut);
            this.donnees.getListeFantomes()[i].setTailleX(this.largeurCasePix);
            this.donnees.getListeFantomes()[i].setTailleY(this.hauteurCasePix);
        }
    }
    
    @Override
    public void run() {
        while (this.donnees.getAffichage().getPanchargement().getLaby() != null && this.donnees.getThreadpacman().isJouerPM() && this.donnees.getAffichage().getPanchargement().getLaby().getNbGumm() != this.donnees.getNbrgumm()) {
            try {
                Thread.sleep(50L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
    
    public int getLargeurCasePix() {
        return this.largeurCasePix;
    }
    
    public void setLargeurCasePix(final int largeurCasePix) {
        this.largeurCasePix = largeurCasePix;
    }
    
    public int getHauteurCasePix() {
        return this.hauteurCasePix;
    }
    
    public void setHauteurCasePix(final int hauteurCasePix) {
        this.hauteurCasePix = hauteurCasePix;
    }
    
    public int getLarg() {
        return this.larg;
    }
    
    public void setLarg(final int larg) {
        this.larg = larg;
    }
    
    public int getHaut() {
        return this.haut;
    }
    
    public void setHaut(final int haut) {
        this.haut = haut;
    }
}