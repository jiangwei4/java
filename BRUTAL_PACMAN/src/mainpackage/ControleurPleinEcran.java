package mainpackage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControleurPleinEcran extends Controleur implements KeyListener {
   public ControleurPleinEcran(Donnees d) {
      super(d);
   }

   public void keyPressed(KeyEvent arg0) {
   }

   public void keyReleased(KeyEvent arg0) {
      if (arg0.getKeyCode() == 20) {
         if (!this.donnees.getAffichage().isUndecorated()) {
            this.donnees.getThreadpacman().setJouerPM(false);
            this.donnees.getS().close();
            Premiere.nouv(true);
         } else {
            this.donnees.getThreadpacman().setJouerPM(false);
            this.donnees.getS().close();
            Premiere.nouv(false);
         }
      }

      if (arg0.getKeyCode() == 27) {
         this.donnees.getThreadpacman().setJouerPM(false);
         this.donnees.getS().close();
         Premiere.Quiter();
      }

      this.donnees.getAffichage().repaint();
   }

   public void keyTyped(KeyEvent arg0) {
   }
}