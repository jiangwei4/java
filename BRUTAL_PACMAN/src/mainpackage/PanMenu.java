package mainpackage;
import java.awt.image.ImageObserver;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class PanMenu extends JPanel
{
    private BoutonMenu jouer;
    private BoutonMenu options;
    private BoutonMenu multi;
    private BoutonMenu survie;
    private BoutonMenu credits;
    private BoutonMenu BestScore;
    private BoutonMenu quitter;
    public Image background;
    private Donnees donnees;
    
    public PanMenu(final Donnees d) {
        d.getS().menu(0);
        this.donnees = d;
        this.background = this.donnees.background;
        this.jouer = new BoutonMenu("Jouer");
        this.options = new BoutonMenu("Options");
        this.survie = new BoutonMenu("Survie");
        this.credits = new BoutonMenu("Credits");
        this.multi = new BoutonMenu("Multi");
        this.BestScore = new BoutonMenu("Best-Scores");
        this.quitter = new BoutonMenu("Quitter");
        final ControleurMenu clicJouer = new ControleurMenu(this.donnees, this.jouer);
        final ControleurMenu clicSurvie = new ControleurMenu(this.donnees, this.survie);
        final ControleurMenu clicCredits = new ControleurMenu(this.donnees, this.credits);
        final ControleurMenu clicOptions = new ControleurMenu(this.donnees, this.options);
        final ControleurMenu clicMulti = new ControleurMenu(this.donnees, this.multi);
        final ControleurMenu clicScore = new ControleurMenu(this.donnees, this.BestScore);
        final ControleurMenu clicquitter = new ControleurMenu(this.donnees, this.quitter);
        final StyleMenu styleJouer = new StyleMenu(this.donnees, this.jouer);
        final StyleMenu styleSurvie = new StyleMenu(this.donnees, this.survie);
        final StyleMenu styleCredits = new StyleMenu(this.donnees, this.credits);
        final StyleMenu styleOptions = new StyleMenu(this.donnees, this.options);
        final StyleMenu styleMulti = new StyleMenu(this.donnees, this.multi);
        final StyleMenu styleScore = new StyleMenu(this.donnees, this.BestScore);
        final StyleMenu stylequitter = new StyleMenu(this.donnees, this.quitter);
        this.BestScore.addActionListener((ActionListener)clicScore);
        this.quitter.addActionListener((ActionListener)clicquitter);
        this.jouer.addActionListener((ActionListener)clicJouer);
        this.survie.addActionListener((ActionListener)clicSurvie);
        this.credits.addActionListener((ActionListener)clicCredits);
        this.options.addActionListener((ActionListener)clicOptions);
        this.multi.addActionListener((ActionListener)clicMulti);
        this.BestScore.addMouseListener((MouseListener)styleScore);
        this.quitter.addMouseListener((MouseListener)stylequitter);
        this.jouer.addMouseListener((MouseListener)styleJouer);
        this.survie.addMouseListener((MouseListener)styleSurvie);
        this.credits.addMouseListener((MouseListener)styleCredits);
        this.options.addMouseListener((MouseListener)styleOptions);
        this.multi.addMouseListener((MouseListener)styleMulti);
        this.remplirGridLayout();
    }
    
    private void remplirGridLayout() {
        final GridLayout grille = new GridLayout(12, 5);
        this.setLayout(grille);
        for (int i = 0; i < 22; ++i) {
            this.add(new JLabel());
        }
        this.add((Component)this.jouer);
        for (int i = 0; i < 4; ++i) {
            this.add(new JLabel());
        }
        this.add((Component)this.survie);
        for (int i = 0; i < 4; ++i) {
            this.add(new JLabel());
        }
        this.add((Component)this.multi);
        for (int i = 0; i < 4; ++i) {
            this.add(new JLabel());
        }
        this.add((Component)this.options);
        for (int i = 0; i < 4; ++i) {
            this.add(new JLabel());
        }
        this.add((Component)this.BestScore);
        for (int i = 0; i < 4; ++i) {
            this.add(new JLabel());
        }
        this.add((Component)this.credits);
        for (int i = 0; i < 4; ++i) {
            this.add(new JLabel());
        }
        this.add((Component)this.quitter);
        for (int i = 0; i < 7; ++i) {
            this.add(new JLabel());
        }
    }
    
	private void remplirBoxLayout() {
        final Box b1 = Box.createVerticalBox();
        this.add(b1);
        b1.add(Box.createRigidArea(new Dimension(0, (int)(0.25 * this.donnees.getAffichage().hauteurEcran))));
        b1.add((Component)this.jouer);
        b1.add(Box.createRigidArea(new Dimension(0, (int)(0.125 * this.donnees.getAffichage().hauteurEcran))));
        b1.add((Component)this.survie);
        b1.add(Box.createRigidArea(new Dimension(0, (int)(0.125 * this.donnees.getAffichage().hauteurEcran))));
        b1.add((Component)this.multi);
        b1.add(Box.createRigidArea(new Dimension(0, (int)(0.125 * this.donnees.getAffichage().hauteurEcran))));
        b1.add((Component)this.options);
        b1.add(Box.createRigidArea(new Dimension(0, (int)(0.125 * this.donnees.getAffichage().hauteurEcran))));
        b1.add((Component)this.credits);
        b1.add(Box.createRigidArea(new Dimension(0, (int)(0.125 * this.donnees.getAffichage().hauteurEcran))));
        b1.add((Component)this.quitter);
        b1.add(Box.createRigidArea(new Dimension(0, (int)(0.125 * this.donnees.getAffichage().hauteurEcran))));
        b1.add((Component)this.BestScore);
    }
    
    public void paintComponent(final Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(this.background, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}