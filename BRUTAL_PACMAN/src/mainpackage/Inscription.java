package mainpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Inscription {
   private Donnees donnees;
   private JoueurTab[] e;

   public Inscription(Donnees d) {
      this.donnees = d;
      this.e = this.donnees.getJoueur();
   }

   public boolean test() {
      boolean test = false;
      if (!this.donnees.getOptions().isMulti() && this.donnees.getJ1().getScoreF() >= 10.0D) {
         for(int i = 0; i < this.e.length; ++i) {
            if (this.donnees.getJ1().getScoreF() > this.e[i].getScore()) {
               this.trier(0);
               test = true;
            }
         }
      } else {
         test = false;
      }

      return test;
   }

   public void trier(int i) {
      if (i == this.e.length - 1) {
         this.donnees.setJoueur(this.e);
      } else {
         new JoueurTab();
         if (this.e[i].getScore() < this.e[i + 1].getScore()) {
            JoueurTab jt = this.e[i];
            this.e[i] = this.e[i + 1];
            this.e[i + 1] = jt;
            this.trier(0);
         } else {
            this.trier(i + 1);
         }
      }

   }

   public void affectationJoueurTab() {
      this.e[this.e.length - 1].setScore(this.donnees.getJ1().getScoreF());
      this.trier(0);
      this.changerNomJoueur(this.donnees.getJ1().getScoreF());
      this.ecrire();
   }

   public void changerNomJoueur(double score) {
      for(int i = 0; i < this.e.length; ++i) {
         if (this.e[i].getScore() == score) {
            this.e[i].setNom(this.donnees.getJ1().getNom());
         }
      }

   }

   public void ecrire() {
      File score = new File("score.txt");

      try {
         BufferedWriter buff = new BufferedWriter(new FileWriter(score));

         for(int i = 0; i < this.donnees.getJoueur().length; ++i) {
            buff.write(this.e[i].getNom());
            buff.newLine();
            buff.write(String.valueOf(this.e[i].getScore()));
            buff.newLine();
         }

         buff.close();
      } catch (Exception var4) {
         var4.getMessage();
      }

   }
}