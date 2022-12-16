package mainpackage;

import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class PanScore extends JPanel
{
    private int largeurPix;
    private int hauteurPix;
    private int largeurCasePix;
    private int hauteurCasePix;
    private Donnees donnees;
    private boolean multi;
    
    public PanScore(final Donnees d) {
        this.multi = false;
        this.donnees = d;
        this.multi = this.donnees.getOptions().isMulti();
    }
    
    public int avoirTaille() {
        String scoref = "";
        if (this.donnees.getOptions().isMulti()) {
            double plusG;
            if (this.donnees.getJ1().getScoreF() > this.donnees.getJ2().getScoreF()) {
                plusG = this.donnees.getJ1().getScoreF();
            }
            else {
                plusG = this.donnees.getJ2().getScoreF();
            }
            double plusG2;
            if (this.donnees.getJ1().getPacman().getScore() > this.donnees.getJ1().getPacman().getScore()) {
                plusG2 = this.donnees.getJ1().getPacman().getScore();
            }
            else {
                plusG2 = this.donnees.getJ2().getPacman().getScore();
            }
            if (plusG > plusG2) {
                scoref = new StringBuilder(String.valueOf(plusG)).toString();
            }
            else {
                scoref = new StringBuilder(String.valueOf(plusG2)).toString();
            }
        }
        else if (this.donnees.getJ1().getScoreF() > this.donnees.getJ1().getPacman().getScore()) {
            scoref = new StringBuilder(String.valueOf(this.donnees.getJ1().getScoreF())).toString();
        }
        else {
            scoref = new StringBuilder(String.valueOf(this.donnees.getJ1().getPacman().getScore())).toString();
        }
        return scoref.length();
    }
    
    public void paintComponent(final Graphics g) {
        this.largeurPix = this.getWidth();
        this.hauteurPix = this.getHeight();
        final int taillett = this.avoirTaille();
        this.largeurCasePix = this.largeurPix / (2 * taillett + 13);
        this.hauteurCasePix = this.hauteurPix / (2 * taillett + 13);
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(this.donnees.getListeSprites()[82], 5 * this.largeurCasePix, this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        g.drawImage(this.donnees.getListeSprites()[78], 7 * this.largeurCasePix, this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        if (this.multi) {
            g.drawImage(this.donnees.getListeSprites()[79], (taillett + 3 + 5) * this.largeurCasePix, this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        }
        g.drawImage(this.donnees.getListeSprites()[22], 5 * this.largeurCasePix, 3 * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        this.afficherScore(g, this.donnees.getJ1().getPacman().getGumm(), 7, 3);
        if (this.multi) {
            this.afficherScore(g, this.donnees.getJ2().getPacman().getGumm(), 8 + taillett, 3);
        }
        g.drawImage(this.donnees.getListeSprites()[23], 5 * this.largeurCasePix, 5 * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        this.afficherScore(g, this.donnees.getJ1().getPacman().getSgumm(), 7, 5);
        if (this.multi) {
            this.afficherScore(g, this.donnees.getJ2().getPacman().getSgumm(), 8 + taillett, 5);
        }
        g.drawImage(this.donnees.getListeSprites()[84], 5 * this.largeurCasePix, 7 * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        this.afficherScore(g, this.donnees.getJ1().getPacman().getFtuer(), 7, 7);
        if (this.multi) {
            this.afficherScore(g, this.donnees.getJ2().getPacman().getFtuer(), 8 + taillett, 7);
        }
        g.drawImage(this.donnees.getListeSprites()[81], 5 * this.largeurCasePix, 9 * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        this.afficherScore(g, 3 - this.donnees.getJ1().getPacman().getVie(), 7, 9);
        if (this.multi) {
            this.afficherScore(g, 3 - this.donnees.getJ2().getPacman().getVie(), 8 + taillett, 9);
        }
        g.drawImage(this.donnees.getListeSprites()[80], 5 * this.largeurCasePix, 11 * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        this.afficherScore(g, this.donnees.getJ1().getPacman().getScore(), 7, 11);
        if (this.multi) {
            this.afficherScore(g, this.donnees.getJ2().getPacman().getScore(), 8 + taillett, 11);
        }
        g.drawImage(this.donnees.getListeSprites()[83], 5 * this.largeurCasePix, 13 * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
        this.afficherScore(g, (int)this.donnees.getJ1().getScoreF(), 7, 13);
        if (this.multi) {
            this.afficherScore(g, (int)this.donnees.getJ2().getScoreF(), 8 + taillett, 13);
        }
    }
    
    public void afficherScore(final Graphics g, final int score, final int l, final int h) {
        final String Score = new StringBuilder(String.valueOf(score)).toString();
        for (int i = 0; i < Score.length(); ++i) {
            switch (Score.charAt(i)) {
                case '9': {
                    g.drawImage(this.donnees.getListeSprites()[77], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '1': {
                    g.drawImage(this.donnees.getListeSprites()[69], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '2': {
                    g.drawImage(this.donnees.getListeSprites()[70], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '3': {
                    g.drawImage(this.donnees.getListeSprites()[71], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '4': {
                    g.drawImage(this.donnees.getListeSprites()[72], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '5': {
                    g.drawImage(this.donnees.getListeSprites()[73], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '6': {
                    g.drawImage(this.donnees.getListeSprites()[74], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '7': {
                    g.drawImage(this.donnees.getListeSprites()[75], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                case '8': {
                    g.drawImage(this.donnees.getListeSprites()[76], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                default: {
                    g.drawImage(this.donnees.getListeSprites()[68], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
            }
        }
    }
}