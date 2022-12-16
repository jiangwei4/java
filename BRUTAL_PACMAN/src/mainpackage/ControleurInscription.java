package mainpackage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControleurInscription extends Controleur implements KeyListener {
   private String nom = "";

   public ControleurInscription(Donnees d) {
      super(d);
   }

   public void keyReleased(KeyEvent arg0) {
      if (arg0.getKeyCode() == 8 && this.nom.length() > 0) {
         this.nom = this.nom.substring(0, this.nom.length() - 1);
      } else if (this.nom.length() < 14) {
         this.nom = this.nom + arg0.getKeyChar();
         this.donnees.getJ1().setNom(this.nom);
      }

   }

   public void keyPressed(KeyEvent arg0) {
   }

   public void keyTyped(KeyEvent arg0) {
   }
}