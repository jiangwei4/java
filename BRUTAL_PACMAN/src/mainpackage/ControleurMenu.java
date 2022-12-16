package mainpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurMenu extends Controleur implements ActionListener {
   public ControleurMenu(Donnees d, BoutonMenu b) {
      super(d);
   }

   public void actionPerformed(ActionEvent e) {
      String source = e.getActionCommand();
      if (source == "Jouer") {
         this.donnees.getThreadpacman().setJouerPM(true);
         this.donnees.getOptions().setSurvie(false);
         this.donnees.getOptions().setMulti(false);
         this.donnees.getAffichage().afficherChargement();
      }

      if (source == "Survie") {
         this.donnees.getThreadpacman().setJouerPM(true);
         this.donnees.getOptions().setAleatoire(true);
         this.donnees.getOptions().setSurvie(true);
         this.donnees.getOptions().setMulti(false);
         this.donnees.getOptions().setNbSgumm((int)(Math.random() * 16.0D + 4.0D));
         this.donnees.getOptions().setHauteur((int)(Math.random() * 40.0D + 20.0D));
         this.donnees.getOptions().setLargeur((int)(Math.random() * 40.0D + 20.0D));
         this.donnees.getAffichage().afficherChargement();
      }

      if (source == "Multi") {
         this.donnees.getThreadpacman().setJouerPM(true);
         this.donnees.getOptions().setAleatoire(true);
         this.donnees.getOptions().setMulti(true);
         this.donnees.getOptions().setSurvie(false);
         this.donnees.getOptions().setNbSgumm((int)(Math.random() * 4.0D + 2.0D));
         this.donnees.getOptions().setHauteur((int)(Math.random() * 15.0D + 5.0D));
         this.donnees.getOptions().setLargeur((int)(Math.random() * 12.0D + 8.0D));
         this.donnees.getAffichage().afficherChargement();
      }

      if (source == "Options") {
         this.donnees.getAffichage().afficherOptions();
      }

      if (source == "Score") {
         this.donnees.getAffichage().afficherBestScore();
      }

      if (source == "Retour") {
         this.donnees.getThreadpacman().setJouerPM(false);
         this.donnees.getJ2().setScoreF(0.0D);
         if (this.donnees.getInscription().test()) {
            this.donnees.getAffichage().afficherInscription();
         } else {
            this.donnees.getJ1().setScoreF(0.0D);
            this.donnees.getAffichage().afficherMenu();
         }
      }

      if (source == "Menu") {
         this.donnees.getThreadpacman().setJouerPM(false);
         this.donnees.getAffichage().afficherMenu();
      }

      if (source == "menu") {
         this.donnees.getThreadpacman().setJouerPM(false);
         this.donnees.getInscription().affectationJoueurTab();
         this.donnees.getJ1().setScoreF(0.0D);
         this.donnees.getJ2().setScoreF(0.0D);
         this.donnees.getAffichage().afficherMenu();
      }

      if (source == "Suite") {
         this.donnees.getAffichage().afficherChargement();
         this.donnees.getThreadpacman().setJouerPM(false);
         this.donnees.getThreadpacman().interrupt(this.donnees.getThreadpacman().getJouer());
      }

      if (source == "Quitter") {
         this.donnees.getThreadpacman().setJouerPM(false);
         this.donnees.getS().close();
         Premiere.Quiter();
      }

      if (source == "Best-Scores") {
         this.donnees.lireBestScores();
         this.donnees.getAffichage().afficherBestScore();
      }

      if (source == "Credits") {
         this.donnees.getS().menu(5);
         this.donnees.getAffichage().afficherCredit();
      }

   }
}