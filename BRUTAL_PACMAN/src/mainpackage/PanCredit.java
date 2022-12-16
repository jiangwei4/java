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
public class PanCredit extends JPanel
{
    private Donnees donnees;
    
    public PanCredit(final Donnees d) {
        this.donnees = d;
        final JLabel credits = new JLabel("Credits");
        credits.setBackground(Color.black);
        this.setLayout(new BorderLayout(0, 0));
        final PanCreditsFin pcf = new PanCreditsFin(this.donnees);
        this.add((Component)pcf, "Center");
        credits.setHorizontalAlignment(0);
        credits.setFont(new Font("Impact", 1, 72));
        credits.setForeground(new Color(176, 64, 176));
        this.add(credits, "North");
        this.setBackground(Color.BLACK);
        this.boutonMenu();
        this.validate();
        this.repaint();
    }
    
    private void boutonMenu() {
        final BoutonMenu Menu = new BoutonMenu("Menu");
        final ControleurMenu listenerRetour = new ControleurMenu(this.donnees, Menu);
        final StyleMenu styleRetour = new StyleMenu(this.donnees, Menu);
        Menu.addActionListener((ActionListener)listenerRetour);
        Menu.addMouseListener((MouseListener)styleRetour);
        this.add((Component)Menu, "South");
    }
}