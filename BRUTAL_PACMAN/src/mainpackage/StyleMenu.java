package mainpackage;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StyleMenu extends Controleur implements MouseListener
{
    BoutonMenu bouton;
    
    public StyleMenu(final Donnees d, final BoutonMenu b) {
        super(d);
        this.bouton = b;
    }
    
    public void mousePressed(final MouseEvent e) {
        this.bouton.setForeground(Color.BLUE);
    }
    
    public void mouseEntered(final MouseEvent e) {
        this.bouton.setForeground(Color.WHITE);
        this.donnees.getS().effet(9);
    }
    
    public void mouseExited(final MouseEvent e) {
        this.bouton.setForeground(new Color(176, 64, 176));
    }
    
    public void mouseClicked(final MouseEvent e) {
    }
    
    public void mouseReleased(final MouseEvent e) {
    }
}