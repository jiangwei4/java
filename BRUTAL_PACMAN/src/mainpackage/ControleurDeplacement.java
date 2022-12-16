package mainpackage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurDeplacement extends Controleur implements KeyListener, MouseListener {
   private int[] control;

   public ControleurDeplacement(Donnees d, int[] ctr) {
      super(d);
      this.control = ctr;
   }

   public void sleep(int i) {
      try {
         Thread.sleep(3L);
      } catch (InterruptedException var3) {
         var3.printStackTrace();
      }

   }

   public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == this.control[0]) {
         this.donnees.getJ1().getPacman().setDirection(3);
         this.sleep(3);
      }

      if (e.getKeyCode() == this.control[1]) {
         this.donnees.getJ1().getPacman().setDirection(1);
         this.sleep(3);
      }

      if (e.getKeyCode() == this.control[2]) {
         this.donnees.getJ1().getPacman().setDirection(2);
         this.sleep(3);
      }

      if (e.getKeyCode() == this.control[3]) {
         this.donnees.getJ1().getPacman().setDirection(0);
         this.sleep(3);
      }

      if (e.getKeyCode() == this.control[4]) {
         this.donnees.getJ2().getPacman().setDirection(3);
         this.sleep(3);
      }

      if (e.getKeyCode() == this.control[5]) {
         this.donnees.getJ2().getPacman().setDirection(1);
         this.sleep(3);
      }

      if (e.getKeyCode() == this.control[6]) {
         this.donnees.getJ2().getPacman().setDirection(2);
         this.sleep(3);
      }

      if (e.getKeyCode() == this.control[7]) {
         this.donnees.getJ2().getPacman().setDirection(0);
         this.sleep(3);
      }

   }

   public void keyReleased(KeyEvent arg0) {
   }

   public void keyTyped(KeyEvent arg0) {
   }

   public void mouseClicked(MouseEvent e) {
      int X = e.getX() - 50 - this.donnees.getAffichage().getJeu().getLarg();
      int Y = e.getY() - 110 - this.donnees.getAffichage().getJeu().getHaut();
      if (X < this.donnees.getJ1().getPacman().getPixelX() + this.donnees.getAffichage().getJeu().getHauteurCasePix() && X > this.donnees.getJ1().getPacman().getPixelX() - this.donnees.getAffichage().getJeu().getHauteurCasePix()) {
         if (Y > this.donnees.getJ1().getPacman().getPixelY()) {
            this.donnees.getJ1().getPacman().setDirection(1);
         } else {
            this.donnees.getJ1().getPacman().setDirection(3);
         }
      } else if (Y < this.donnees.getJ1().getPacman().getPixelY() + this.donnees.getAffichage().getJeu().getLargeurCasePix() && Y > this.donnees.getJ1().getPacman().getPixelY() - this.donnees.getAffichage().getJeu().getLargeurCasePix()) {
         if (X > this.donnees.getJ1().getPacman().getPixelX()) {
            this.donnees.getJ1().getPacman().setDirection(0);
         } else {
            this.donnees.getJ1().getPacman().setDirection(2);
         }
      }

   }

   public void mouseEntered(MouseEvent arg0) {
   }

   public void mouseExited(MouseEvent arg0) {
   }

   public void mousePressed(MouseEvent arg0) {
   }

   public void mouseReleased(MouseEvent arg0) {
   }
}