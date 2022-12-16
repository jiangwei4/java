package mainpackage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class ClavierListener extends Controleur implements KeyListener {
   private JTextField textfield;
   private ControleurOptions listenerTextField;

   public ClavierListener(Donnees d, JTextField tf, ControleurOptions TextField) {
      super(d);
      this.textfield = tf;
      this.listenerTextField = TextField;
   }

   public void keyPressed(KeyEvent arg0) {
   }

   public void keyReleased(KeyEvent arg0) {
      label39: {
         this.textfield.setText(KeyEvent.getKeyText(arg0.getKeyCode()));
         String var2;
         switch((var2 = this.textfield.getName()).hashCode()) {
         case -714991786:
            if (var2.equals("1gauche")) {
               this.listenerTextField.ControleurOptionsTextField(this.textfield, 2, arg0.getKeyCode());
               break label39;
            }
            break;
         case 1557059:
            if (var2.equals("1bas")) {
               this.listenerTextField.ControleurOptionsTextField(this.textfield, 1, arg0.getKeyCode());
               break label39;
            }
            break;
         case 1586850:
            if (var2.equals("2bas")) {
               this.listenerTextField.ControleurOptionsTextField(this.textfield, 5, arg0.getKeyCode());
               break label39;
            }
            break;
         case 48447753:
            if (var2.equals("1haut")) {
               this.listenerTextField.ControleurOptionsTextField(this.textfield, 0, arg0.getKeyCode());
               break label39;
            }
            break;
         case 49371274:
            if (var2.equals("2haut")) {
               this.listenerTextField.ControleurOptionsTextField(this.textfield, 4, arg0.getKeyCode());
               break label39;
            }
            break;
         case 172511895:
            if (var2.equals("2gauche")) {
               this.listenerTextField.ControleurOptionsTextField(this.textfield, 6, arg0.getKeyCode());
               break label39;
            }
            break;
         case 1498591902:
            if (var2.equals("1doite")) {
               this.listenerTextField.ControleurOptionsTextField(this.textfield, 3, arg0.getKeyCode());
               break label39;
            }
         }

         this.listenerTextField.ControleurOptionsTextField(this.textfield, 7, arg0.getKeyCode());
      }

      this.listenerTextField.appliquerChangementTouche();
   }

   public void keyTyped(KeyEvent arg0) {
   }
}