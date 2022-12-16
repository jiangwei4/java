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
public class PanBestScore extends JPanel
{
    private Donnees donnees;
    
    public PanBestScore(final Donnees d) {
        this.donnees = d;
        final JLabel credits = new JLabel("Best Scores");
        credits.setBackground(Color.black);
        this.setLayout(new BorderLayout(0, 0));
        final PanBestScore2 pbs2 = new PanBestScore2(d);
        this.add((Component)pbs2, "Center");
        credits.setHorizontalAlignment(0);
        credits.setFont(new Font("Impact", 1, 72));
        credits.setForeground(new Color(176, 64, 176));
        this.add(credits, "North");
        this.setBackground(Color.BLACK);
        this.boutonMenu();
        this.validate();
        this.repaint();
    }
    
    public void boutonMenu() {
        this.donnees.getJ1().setScoreF(0.0);
        final BoutonMenu Menu = new BoutonMenu("Menu");
        Menu.setBackground(Color.BLACK);
        Menu.setOpaque(true);
        final ControleurMenu listenerMenu = new ControleurMenu(this.donnees, Menu);
        final StyleMenu styleMenu = new StyleMenu(this.donnees, Menu);
        Menu.addActionListener((ActionListener)listenerMenu);
        Menu.addMouseListener((MouseListener)styleMenu);
        this.add((Component)Menu, "South");
        this.validate();
    }
}