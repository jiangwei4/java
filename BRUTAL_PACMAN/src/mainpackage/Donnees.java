package mainpackage;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Donnees {
   private SoundSystem s;
   public Image background = Toolkit.getDefaultToolkit().createImage("src/images/backgroundPacman.gif");
   private Labyrinthe laby;
   private Affichage affichage;
   private Options options;
   private int Score;
   private Fantome[] listeFantomes;
   private BufferedImage[] listeSprites;
   private int nbrgumm;
   private int nbrSgumm;
   private Joueur j1;
   private Joueur j2;
   private int[] control;
   private JoueurTab[] joueur = new JoueurTab[10];
   private Inscription inscription;
   private ThreadPACMAN threadpacman = new ThreadPACMAN(this);

   public Donnees(Affichage affichage) {
      this.lireBestScores();
      this.inscription = new Inscription(this);
      this.control = new int[8];
      this.control[0] = 38;
      this.control[1] = 40;
      this.control[2] = 37;
      this.control[3] = 39;
      this.control[4] = 90;
      this.control[5] = 83;
      this.control[6] = 81;
      this.control[7] = 68;
      this.options = new Options();
      this.affichage = affichage;
      this.s = new SoundSystem(this);
      this.listeSprites = this.extraireSprites();
      this.j1 = new Joueur(this);
      this.j2 = new Joueur(this);
   }

   public void DonneesS() {
      this.nbrgumm = 0;
      this.nbrSgumm = 0;
      this.j1 = new Joueur(this, this.j1.getScoreF());
      this.j1.getPacman().setPosX(this.getAffichage().getPanchargement().getLaby().getPosX());
      this.j1.getPacman().setPosY(this.getAffichage().getPanchargement().getLaby().getPosY());
      this.j1.getPacman().setPixelX(0);
      this.j1.getPacman().setPixelY(0);
      this.j1.getPacman().setVitesse(this.j1.getPacman().getBasevitesse() - 70);
      this.j1.getPacman().setDonnees(this);
      this.j1.getPacman().setDirection(2);
      this.j1.getPacman().setScore(0);
      if (this.options.isMulti()) {
         this.j2 = new Joueur(this, this.j2.getScoreF());
         this.j2.getPacman().setPosX(this.getAffichage().getPanchargement().getLaby().getPosX());
         this.j2.getPacman().setPosY(this.getAffichage().getPanchargement().getLaby().getLargeur() - this.getAffichage().getPanchargement().getLaby().getPosY() - 1);
         this.j2.getPacman().setPixelX(0);
         this.j2.getPacman().setPixelY(0);
         this.j2.getPacman().setVitesse(this.j2.getPacman().getBasevitesse() - 70);
         this.j2.getPacman().setDonnees(this);
         this.j2.getPacman().setDirection(0);
         this.j2.getPacman().setScore(0);
      }

      this.listeFantomes = new Fantome[this.options.getNbFantomes()];

      for(int i = 0; i < this.options.getNbFantomes(); ++i) {
         this.listeFantomes[i] = new Fantome(this.laby.getXDepartFantome(), this.laby.getYDepartFantome(), 60, this.j1.getPacman(), this, i % 4);
      }

   }

   public void lireBestScores() {
      String nom = "";
      File score = new File("score.txt");
      int taille = 1;
      if (!score.exists()) {
         try {
            score.createNewFile();
         } catch (IOException var14) {
            var14.printStackTrace();
         }
      }

      int i = 1;
      int j = 0;

      try {
         BufferedReader buff = new BufferedReader(new FileReader(score));
         String ligne = "";

         try {
            for(; (ligne = buff.readLine()) != null && taille < 11; ++i) {
               if (i % 2 == 1) {
                  nom = ligne;
               } else {
                  double scoreJ = Double.parseDouble(ligne);
                  this.joueur[j] = new JoueurTab(scoreJ, nom);
                  ++taille;
                  ++j;
               }
            }

            --taille;

            while(taille != 10) {
               this.joueur[taille] = new JoueurTab();
               ++taille;
            }
         } finally {
            buff.close();
         }
      } catch (Exception var16) {
         System.out.println("quoi" + var16.toString());
      }

   }

   BufferedImage[] extraireSprites() {
      BufferedImage[] sprites = new BufferedImage[156];

      for(int i = 0; i < 89; ++i) {
         if (i == 20) {
            //i += 2;
         }

         try {
            BufferedImage img = ImageIO.read(this.getClass().getResource("/images/" + i + ".gif"));
            sprites[i] = img;
         } catch (Exception var5) {
            System.out.println("Erreur dans la lecture du fichier image " + i);
         }
      }

      return sprites;
   }

   public void changerJoueur(double score, String nom) {
      this.joueur[this.joueur.length - 1].setNom(nom);
      this.joueur[this.joueur.length - 1].setScore(score);
   }

   public JoueurTab avoirJoueur(double score) {
      JoueurTab j = new JoueurTab();

      for(int i = 0; i < this.joueur.length; ++i) {
         if (this.joueur[i].getScore() == score) {
            j = this.joueur[i];
         }
      }

      return j;
   }

   public Fantome[] getListeFantomes() {
      return this.listeFantomes;
   }

   public void setListeFantomes(Fantome[] listeFantomes) {
      this.listeFantomes = listeFantomes;
   }

   public BufferedImage[] getListeSprites() {
      return this.listeSprites;
   }

   public void setListeSprites(BufferedImage[] listeSprites) {
      this.listeSprites = listeSprites;
   }

   public BufferedImage avoirImageJ(int i) {
      return this.listeSprites[i];
   }

   public Labyrinthe getLaby() {
      return this.laby;
   }

   public void setLaby(Labyrinthe laby) {
      this.laby = laby;
   }

   public Affichage getAffichage() {
      return this.affichage;
   }

   public Options getOptions() {
      return this.options;
   }

   public SoundSystem getS() {
      return this.s;
   }

   public void setS(SoundSystem s) {
      this.s = s;
   }

   public int getScore() {
      return this.Score;
   }

   public void setScore(int score) {
      this.Score = score;
   }

   public Joueur getJ1() {
      return this.j1;
   }

   public void setJ1(Joueur j1) {
      this.j1 = j1;
   }

   public Joueur getJ2() {
      return this.j2;
   }

   public void setJ2(Joueur j2) {
      this.j2 = j2;
   }

   public int getNbrgumm() {
      return this.nbrgumm;
   }

   public void setNbrgumm(int nbrgumm) {
      this.nbrgumm = nbrgumm;
   }

   public int getNbrSgumm() {
      return this.nbrSgumm;
   }

   public void setNbrSgumm(int nbrSgumm) {
      this.nbrSgumm = nbrSgumm;
   }

   public int[] getControl() {
      return this.control;
   }

   public void setControl(int[] control) {
      this.control = control;
   }

   public void setControl(int i, int j) {
      this.control[i] = j;
   }

   public int getControlInt(int i) {
      return this.control[i];
   }

   public JoueurTab[] getJoueur() {
      return this.joueur;
   }

   public void setJoueur(JoueurTab[] joueur) {
      this.joueur = joueur;
   }

   public Inscription getInscription() {
      return this.inscription;
   }

   public void setInscription(Inscription inscription) {
      this.inscription = inscription;
   }

   public ThreadPACMAN getThreadpacman() {
      return this.threadpacman;
   }

   public void setThreadpacman(ThreadPACMAN threadpacman) {
      this.threadpacman = threadpacman;
   }
}