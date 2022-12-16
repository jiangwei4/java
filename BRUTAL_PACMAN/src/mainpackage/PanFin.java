package mainpackage;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanFin extends JPanel
{
    private Donnees donnees;
    
    public PanFin(final Donnees d) {
        this.donnees = d;
        final JLabel fin = new JLabel("Resultats");
        fin.setBackground(Color.black);
        this.setLayout(new BorderLayout(0, 0));
        final PanScore ps = new PanScore(this.donnees);
        this.add((Component)ps, "Center");
        fin.setHorizontalAlignment(0);
        fin.setFont(new Font("Impact", 1, 72));
        fin.setForeground(new Color(176, 64, 176));
        this.add(fin, "North");
        this.setBackground(Color.BLACK);
        final BoutonMenu suite = new BoutonMenu("Suite");
        final ControleurMenu listenerRetour = new ControleurMenu(this.donnees, suite);
        final StyleMenu styleRetour = new StyleMenu(this.donnees, suite);
        suite.addActionListener((ActionListener)listenerRetour);
        suite.addMouseListener((MouseListener)styleRetour);
        this.add((Component)suite, "South");
        this.validate();
        this.repaint();
    }
}