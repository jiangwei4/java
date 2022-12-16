package mainpackage;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.JPanel;


@SuppressWarnings({ "serial", "unused" })
public class PanInscritpion2 extends JPanel
{
    private Donnees donnees;
    private JTextField nom;
    private int largeurPix;
    private int hauteurPix;
    private int largeurCasePix;
    private int hauteurCasePix;
    
    public PanInscritpion2(final Donnees d) {
        this.donnees = d;
        final ControleurInscription listenerTextField = new ControleurInscription(this.donnees);
        (this.nom = new JTextField()).setText("Entrer votre nom ici (moins de 14 caracteres)");
        this.nom.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
        		nom.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        this.nom.addKeyListener((KeyListener)listenerTextField);
        this.add(this.nom);
    }
    
    public void paintComponent(final Graphics g) {
        this.largeurPix = this.getWidth();
        this.hauteurPix = this.getHeight();
        int taillet = 1;
        final String taille = new StringBuilder(String.valueOf((int)this.donnees.getJ1().getScoreF())).toString();
        if (taille.length() != 0) {
            taillet = taille.length();
        }
        this.largeurCasePix = this.largeurPix / taillet;
        this.hauteurCasePix = this.hauteurPix / taillet;
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.afficherScore(g, this.donnees.getJ1().getScoreF(), 0, (taillet - 1) / 2);
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
            }
        }
    }
}