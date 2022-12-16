package mainpackage;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanBestScore2 extends JPanel
{
    private JoueurTab[] joueur;
    private int largeurPix;
    private int hauteurPix;
    private int largeurCasePix;
    private int hauteurCasePix;
    private Donnees donnees;
    
    public PanBestScore2(final Donnees d) {
        this.donnees = d;
        this.joueur = this.donnees.getJoueur();
    }
    
    public void paintComponent(final Graphics g) {
        final Graphics2D g2 = (Graphics2D)g;
        this.largeurPix = this.getWidth();
        this.hauteurPix = this.getHeight();
        final String lo = new StringBuilder(String.valueOf((int)this.joueur[0].getScore())).toString();
        this.largeurCasePix = this.largeurPix / (6 + lo.length() + 6);
        this.hauteurCasePix = this.hauteurPix / 22;
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int i = 0; i < this.joueur.length; ++i) {
            this.afficherScoreInt(g, i + 1, 0, i * 2 + 1);
            if (this.joueur[i].getScore() != 0.0) {
                this.afficherScore(g, this.joueur[i].getScore(), 12, i * 2 + 1);
            }
            g2.setFont(new Font("Impact", 1, this.largeurCasePix - 20));
            g2.setColor(Color.GREEN);
            g2.drawString(this.joueur[i].getNom(), 4 * this.largeurCasePix, (2 * i + 2) * this.hauteurCasePix);
        }
    }
    
    public void afficherScore(final Graphics g, final double score, final int l, final int h) {
        final String Score = new StringBuilder(String.valueOf(score)).toString();
        for (int i = 0; i < Score.length(); ++i) {
            switch (Score.charAt(i)) {
                case '0': {
                    g.drawImage(this.donnees.getListeSprites()[68], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
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
                case '9': {
                    g.drawImage(this.donnees.getListeSprites()[77], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
                default: {
                    i = Score.length();
                    break;
                }
            }
        }
    }
    
    public void afficherScoreInt(final Graphics g, final int score, final int l, final int h) {
        final String Score = new StringBuilder(String.valueOf(score)).toString();
        for (int i = 0; i < Score.length(); ++i) {
            switch (Score.charAt(i)) {
                case '0': {
                    g.drawImage(this.donnees.getListeSprites()[68], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
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
                case '9': {
                    g.drawImage(this.donnees.getListeSprites()[77], (i + l) * this.largeurCasePix, h * this.hauteurCasePix, this.largeurCasePix, this.hauteurCasePix, null);
                    break;
                }
            }
        }
    }
}