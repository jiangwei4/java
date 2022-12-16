package mainpackage;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoutonMenu extends JButton {
   public BoutonMenu(String name) {
      super(name);
      this.setBorderPainted(false);
      this.setContentAreaFilled(false);
      this.setFocusPainted(false);
      this.setOpaque(false);
      this.setFont(new Font("Impact", 1, 44));
      this.setForeground(new Color(176, 64, 176));
   }
}