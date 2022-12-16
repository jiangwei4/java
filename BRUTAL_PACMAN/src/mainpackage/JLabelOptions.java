package mainpackage;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JLabelOptions extends JLabel
{
    public JLabelOptions() {
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setFont(new Font("Impact", 0, 20));
        this.setOpaque(true);
    }
    
    public JLabelOptions(final String nom, final int sens) {
        super(nom, sens);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
        this.setFont(new Font("Impact", 0, 24));
        this.setOpaque(true);
    }
}