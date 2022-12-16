package mainpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ControleurOptions extends Controleur implements ActionListener {
   private JCheckBox[] checkbox = new JCheckBox[6];
   @SuppressWarnings("unchecked")
private JComboBox<Integer>[] combobox = new JComboBox[4];
   private JTextField[] textfield = new JTextField[8];
   private int[] ctr = new int[8];
   private float volume = 0.0F;

   public ControleurOptions(Donnees d) {
      super(d);

      for(int i = 0; i < 8; ++i) {
         this.ctr[i] = 0;
      }

   }

   public void actionPerformed(ActionEvent e) {
      String source = e.getActionCommand();
      if (source == "mapdebase") {
         this.donnees.getOptions().setAleatoire(false);
         this.donnees.getAffichage().setOptionsChangees(true);
      }

      if (source == "aleatoire") {
         this.donnees.getOptions().setAleatoire(true);
         this.donnees.getAffichage().setOptionsChangees(true);
      }

      if (source == "theme1") {
         this.donnees.getOptions().setThemeDepuisDebut(0, this.checkbox[0].isSelected());
      }

      if (source == "theme2") {
         this.donnees.getOptions().setThemeDepuisDebut(1, this.checkbox[1].isSelected());
      }

      if (source == "theme3") {
         this.donnees.getOptions().setThemeDepuisDebut(2, this.checkbox[2].isSelected());
      }

      if (source == "theme4") {
         this.donnees.getOptions().setThemeDepuisDebut(3, this.checkbox[3].isSelected());
      }

      if (source == "theme5") {
         this.donnees.getOptions().setThemeDepuisDebut(4, this.checkbox[4].isSelected());
      }

      if (source == "hauteur") {
         this.donnees.getOptions().setHauteur(this.combobox[0].getSelectedIndex() + this.donnees.getOptions().getHauteurMin());
         this.donnees.getAffichage().setOptionsChangees(true);
      }

      if (source == "largeur") {
         this.donnees.getOptions().setLargeur(this.combobox[1].getSelectedIndex() + this.donnees.getOptions().getLargeurMin());
         this.donnees.getAffichage().setOptionsChangees(true);
      }

      if (source == "nbrSgumm") {
         this.donnees.getOptions().setNbSgumm(this.combobox[2].getSelectedIndex());
         this.donnees.getAffichage().setOptionsChangees(true);
      }

      if (source == "nbrFantome") {
         this.donnees.getOptions().setNbFantomes(this.combobox[3].getSelectedIndex());
         this.donnees.getAffichage().setOptionsChangees(true);
      }

      if (source == "coupertheme") {
         this.donnees.getOptions().setCouperVolumeTheme(this.checkbox[5].isSelected());
         if (this.checkbox[5].isSelected()) {
            this.volume = this.donnees.getS().getVolumeTheme();
            this.donnees.getS().setVolumeTheme(-1000.0F);
         } else {
            this.donnees.getS().setVolumeTheme(this.volume);
         }
      }

   }

   public void ControleurOptionsCheckBox(JCheckBox b, int i) {
      this.checkbox[i] = b;
   }

   public void ControleurOptionsComboBox(JComboBox<Integer> cb, int i) {
      this.combobox[i] = cb;
   }

   public void ControleurOptionsTextField(JTextField tf, int i, int j) {
      this.textfield[i] = tf;
      this.ctr[i] = j;
   }

   public void appliquerChangementTouche() {
      for(int i = 0; i < 8; ++i) {
         if (this.ctr[i] != 0) {
            this.donnees.setControl(i, this.ctr[i]);
         }
      }

   }
}