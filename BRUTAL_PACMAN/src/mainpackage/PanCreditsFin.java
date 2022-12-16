package mainpackage;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanCreditsFin extends JPanel
{
    private Donnees donnees;
    
    public PanCreditsFin(final Donnees d) {
        this.donnees = d;
    }
    
    public void paintComponent(final Graphics g) {
        final Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(this.donnees.getListeSprites()[85], 0, 0, this.getWidth() / 3, this.getHeight(), null);
        g.drawImage(this.donnees.getListeSprites()[86], this.getWidth() / 3, 0, this.getWidth() / 3, this.getHeight(), null);
        g.drawImage(this.donnees.getListeSprites()[87], 2 * this.getWidth() / 3, 0, this.getWidth() / 3, this.getHeight(), null);
        g2.setFont(new Font("Impact", 1, 40));
        g2.setColor(Color.GREEN);
        g2.drawString("Louis Label", 0, this.getHeight());
        g2.drawString("Donovan Ferre", this.getWidth() / 3, this.getHeight());
        g2.drawString("Khaled Maaroufi", 2 * this.getWidth() / 3, this.getHeight());
    }
}