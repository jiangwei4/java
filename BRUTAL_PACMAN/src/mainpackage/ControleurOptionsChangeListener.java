package mainpackage;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControleurOptionsChangeListener extends Controleur implements ChangeListener {
   private JSlider[] slider = new JSlider[2];

   public void stateChanged(ChangeEvent e) {
      this.donnees.getOptions().setVolume(0, this.slider[0].getValue());
      this.donnees.getS().setVolumeTheme((float)this.slider[0].getValue());
      this.donnees.getS().volume(2, (float)this.slider[0].getValue());
      this.donnees.getOptions().setVolume(1, this.slider[1].getValue());
      this.donnees.getS().setVolumeEffet((float)this.slider[1].getValue());
   }

   public ControleurOptionsChangeListener(Donnees d) {
      super(d);
   }

   public void ControleurOptionsSlider(JSlider s, int i) {
      this.slider[i] = s;
   }
}