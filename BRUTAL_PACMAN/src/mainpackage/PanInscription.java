package mainpackage;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class PanInscription extends JPanel
{
    private Donnees donnees;
    private JoueurTab[] joueur;
	private PanInscritpion2 pi;
    
    public PanInscription(final Donnees d) {
        this.donnees = d;
        this.donnees = d;
        this.joueur = this.donnees.getJoueur();
        this.trier(0);
        final JLabel pis2 = new JLabel("vous etes dans le top 10 des meilleurs scores");
        pis2.setBackground(Color.black);
        this.setLayout(new BorderLayout(0, 0));
        this.add((Component)(this.pi = new PanInscritpion2(this.donnees)), "Center");
        pis2.setHorizontalAlignment(0);
        pis2.setFont(new Font("Impact", 1, 72));
        pis2.setForeground(new Color(176, 64, 176));
        this.add(pis2, "North");
        this.setBackground(Color.BLACK);
        this.boutonMenu2();
        this.validate();
        this.repaint();
    }
    
    public void trier(final int i) {
        if (i == this.joueur.length - 1) {
            this.donnees.setJoueur(this.joueur);
        }
        else {
            JoueurTab e = new JoueurTab();
            if (this.joueur[i].getScore() < this.joueur[i + 1].getScore()) {
                e = this.joueur[i];
                this.joueur[i] = this.joueur[i + 1];
                this.joueur[i + 1] = e;
                this.trier(0);
            }
            else {
                this.trier(i + 1);
            }
        }
    }
    
    public void boutonMenu2() {
        final BoutonMenu Menu2 = new BoutonMenu("menu");
        Menu2.setBackground(Color.BLACK);
        Menu2.setOpaque(true);
        final ControleurMenu listenerMenu = new ControleurMenu(this.donnees, Menu2);
        final StyleMenu styleMenu = new StyleMenu(this.donnees, Menu2);
        Menu2.addActionListener((ActionListener)listenerMenu);
        Menu2.addMouseListener((MouseListener)styleMenu);
        this.add((Component)Menu2, "South");
        this.validate();
    }
}