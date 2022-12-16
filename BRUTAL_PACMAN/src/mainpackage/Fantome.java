package mainpackage;

import java.awt.Color;
import java.util.Random;

public class Fantome extends Personnage implements Runnable {
   @SuppressWarnings("unused")
private static final int fractionCaseParImage = 10;
   private int parcouruX;
   private int parcouruY;
   private int ratioCaseX;
   private int ratioCaseY;
   private Color couleur;
   private int pos;
   private int aspect;
   private int NbGummLaby;

   public Fantome(int x, int y, int v, Entite cible, Donnees d, int pos) {
      super(x, y, d);
      this.pixelX = x;
      this.pixelY = y;
      this.parcouruX = 0;
      this.parcouruY = 0;
      this.NbGummLaby = this.donnees.getAffichage().getPanchargement().getLaby().getNbGumm();
      this.pos = pos;
      Random random = new Random();
      float hue = random.nextFloat();
      @SuppressWarnings("unused")
	float saturation = 0.9F;
      @SuppressWarnings("unused")
	float luminance = 1.0F;
      this.couleur = Color.getHSBColor(hue, 0.9F, 1.0F);
      this.posX = this.donnees.getAffichage().getPanchargement().getLaby().getHauteur() / 2;
      this.posY = (this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - 3) / 2 + pos;
      this.intelligence(pos);
   }

   private void intelligence(int pos) {
      switch(pos) {
      case 0:
         this.aspect = 1;
         break;
      case 1:
         if (this.donnees.getOptions().isMulti()) {
            this.aspect = 2;
         } else {
            this.aspect = 0;
         }
         break;
      default:
         this.aspect = 0;
      }

   }

   public void run() {
      while(this.donnees.getThreadpacman().isJouerPM() && this.NbGummLaby != this.donnees.getNbrgumm()) {
         this.memeCaseJoueur();
         this.ratioCaseX = this.tailleX / 10;
         this.ratioCaseY = this.tailleY / 10;
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).getImage() == 15) {
            if (this.posY < 1) {
               this.posY = this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - 2 - this.posY;
            } else {
               this.posY = this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - this.posY;
            }

            this.pixelX = this.posY * this.donnees.getAffichage().getJeu().getLargeurCasePix();
         }

         if (this.parcouruX == 0 && this.parcouruY == 0) {
            this.pixelX = this.posY * this.donnees.getAffichage().getJeu().getLargeurCasePix();
            this.pixelY = this.posX * this.donnees.getAffichage().getJeu().getHauteurCasePix();
            this.choisirDirection();
         }

         switch(this.direction) {
         case 0:
            if (this.parcouruX == 5) {
               this.parcouruX = -5;
               ++this.posY;
               this.pixelX += this.ratioCaseX;
            } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD() || this.parcouruX < 0) {
               this.pixelX += this.ratioCaseX;
               ++this.parcouruX;
               this.parcouruY = 0;
            }
            break;
         case 1:
            if (this.parcouruY == 5) {
               this.parcouruY = -5;
               ++this.posX;
               this.pixelY += this.ratioCaseY;
            } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionB() || this.parcouruY < 0) {
               this.pixelY += this.ratioCaseY;
               ++this.parcouruY;
               this.parcouruX = 0;
            }
            break;
         case 2:
            if (this.parcouruX == -5) {
               this.parcouruX = 5;
               --this.posY;
               this.pixelX -= this.ratioCaseX;
            } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG() || this.parcouruX > 0) {
               this.pixelX -= this.ratioCaseX;
               --this.parcouruX;
               this.parcouruY = 0;
            }
            break;
         case 3:
            if (this.parcouruY == -5) {
               this.parcouruY = 5;
               --this.posX;
               this.pixelY -= this.ratioCaseY;
            } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH() || this.parcouruY > 0) {
               this.pixelY -= this.ratioCaseY;
               --this.parcouruY;
               this.parcouruX = 0;
            }
         }

         try {
            Thread.sleep(50L);
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

   }

   public int choisirCaseBis2(Joueur j, int directionaprendre) {
      if (this.posX == j.getPacman().posX) {
         if (this.posY < j.getPacman().posY) {
            directionaprendre = 0;
         } else {
            directionaprendre = 2;
         }
      }

      if (this.posY == j.getPacman().posY) {
         if (this.posX < j.getPacman().posX) {
            directionaprendre = 1;
         } else {
            directionaprendre = 3;
         }
      }

      if (this.posX < j.getPacman().posX && this.posY < j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionB()) {
            directionaprendre = 1;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            directionaprendre = 0;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            directionaprendre = 2;
         } else {
            directionaprendre = 3;
         }
      } else if (this.posX > j.getPacman().posX && this.posY < j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH()) {
            directionaprendre = 3;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            directionaprendre = 0;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            directionaprendre = 2;
         } else {
            directionaprendre = 1;
         }
      } else if (this.posX < j.getPacman().posX && this.posY > j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionB()) {
            directionaprendre = 1;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            directionaprendre = 2;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            directionaprendre = 0;
         } else {
            directionaprendre = 3;
         }
      }

      if (this.posX > j.getPacman().posX && this.posY > j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH()) {
            directionaprendre = 3;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            directionaprendre = 2;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            directionaprendre = 0;
         } else {
            directionaprendre = 1;
         }
      }

      return directionaprendre;
   }

   public int choisirCaseBis22(Joueur j) {
      int directionaprendre = 1;
      if (this.posX == j.getPacman().posX) {
         if (this.posY < j.getPacman().posY) {
            directionaprendre = 2;
         } else {
            directionaprendre = 0;
         }
      }

      if (this.posY == j.getPacman().posY) {
         if (this.posX < j.getPacman().posX) {
            directionaprendre = 3;
         } else {
            directionaprendre = 1;
         }
      }

      if (this.posX < j.getPacman().posX && this.posY > j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH()) {
            directionaprendre = 3;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            directionaprendre = 0;
         } else {
            directionaprendre = 2;
         }
      } else if (this.posX > j.getPacman().posX && this.posY < j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionB()) {
            directionaprendre = 1;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            directionaprendre = 2;
         } else {
            directionaprendre = 0;
         }
      } else if (this.posX > j.getPacman().posX && this.posY > j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionB()) {
            directionaprendre = 1;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            directionaprendre = 0;
         } else {
            directionaprendre = 2;
         }
      }

      if (this.posX < j.getPacman().posX && this.posY < j.getPacman().posY) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH()) {
            directionaprendre = 3;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            directionaprendre = 2;
         } else {
            directionaprendre = 0;
         }
      }

      return directionaprendre;
   }

   private int choisirCaseBis() {
      int directionaprendre = 3;
      if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isSpawnFantome()) {
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH()) {
            directionaprendre = 3;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            directionaprendre = 0;
         } else if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            directionaprendre = 2;
         }
      } else if (this.aspect == 1) {
         directionaprendre = this.choisirCaseBis2(this.donnees.getJ1(), directionaprendre);
      } else if (this.aspect == 2) {
         directionaprendre = this.choisirCaseBis2(this.donnees.getJ2(), directionaprendre);
      }

      return directionaprendre;
   }

   private int choisirCaseBis44(Joueur j1, Joueur j2) {
      Joueur pp = j1;
      if (this.donnees.getOptions().isMulti()) {
         int EcartX1 = this.posX - this.donnees.getJ1().getPacman().getPosX();
         int EcartY1 = this.posY - this.donnees.getJ1().getPacman().getPosY();
         int EcartX2 = this.posX - this.donnees.getJ2().getPacman().getPosX();
         int EcartY2 = this.posY - this.donnees.getJ2().getPacman().getPosY();
         if (EcartX1 < 0) {
            EcartX1 *= -1;
         }

         if (EcartX2 < 0) {
            EcartX2 *= -1;
         }

         if (EcartY1 < 0) {
            EcartY1 *= -1;
         }

         if (EcartY2 < 0) {
            EcartY2 *= -1;
         }

         int Somme1 = EcartX1 + EcartY1;
         int Somme2 = EcartX2 + EcartY2;
         if (Somme1 <= Somme2) {
            pp = j1;
         } else {
            pp = j2;
         }
      }

      return this.choisirCaseBis22(pp);
   }

   private int choisirDirectionAleatoire() {
      int prendredirection = 3;
      if (this.posX - this.donnees.getJ1().getPacman().getPosX() <= 4) {
         prendredirection = this.choisirCaseBis();
      }

      if (this.donnees.getJ1().getPacman().getPosX() - this.posX <= 4) {
         prendredirection = this.choisirCaseBis();
      }

      if (this.posY - this.donnees.getJ1().getPacman().getPosY() <= 4) {
         prendredirection = this.choisirCaseBis();
      }

      if (this.donnees.getJ1().getPacman().getPosY() - this.posY <= 4) {
         prendredirection = this.choisirCaseBis();
      }

      int Random = (int)(Math.random() * 6.0D);
      switch(Random) {
      case 0:
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD()) {
            prendredirection = Random;
         }
         break;
      case 1:
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionB()) {
            prendredirection = Random;
         }
         break;
      case 2:
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG()) {
            prendredirection = Random;
         }
         break;
      case 3:
         if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH()) {
            prendredirection = Random;
         }
         break;
      default:
         prendredirection = this.direction;
      }

      return prendredirection;
   }

   private void choisirDirection() {
      if (this.donnees.getOptions().isMulti()) {
         if (this.donnees.getJ1().getPacman().isSgummEnCours()) {
            this.direction = this.choisirCaseBis44(this.donnees.getJ1(), this.donnees.getJ2());
         } else if (this.donnees.getJ2().getPacman().isSgummEnCours()) {
            this.direction = this.choisirCaseBis44(this.donnees.getJ1(), this.donnees.getJ2());
         } else if (this.aspect == 0) {
            this.direction = this.choisirDirectionAleatoire();
         } else {
            this.direction = this.choisirCaseBis();
         }
      } else if (this.donnees.getJ1().getPacman().isSgummEnCours()) {
         this.direction = this.choisirCaseBis44(this.donnees.getJ1(), this.donnees.getJ2());
      } else if (this.aspect == 0) {
         this.direction = this.choisirDirectionAleatoire();
      } else {
         this.direction = this.choisirCaseBis();
      }

   }

   public void memeCaseJoueur() {
      if (this.posX == this.donnees.getJ1().getPacman().getPosX() && this.posY == this.donnees.getJ1().getPacman().getPosY()) {
         if (this.donnees.getJ1().getPacman().isSgummEnCours()) {
            this.donnees.getS().effet(14);
            this.donnees.getJ1().getPacman().setScore(this.donnees.getJ1().getPacman().getScore() + 100);
            this.donnees.getJ1().getPacman().setFtuer(this.donnees.getJ1().getPacman().getFtuer() + 1);
         } else {
            this.donnees.getS().effet(10);
            if (this.donnees.getJ1().getPacman().getScore() > 200) {
               this.donnees.getJ1().getPacman().setScore(this.donnees.getJ1().getPacman().getScore() - 200);
            } else {
               this.donnees.getJ1().getPacman().setScore(0);
            }

            this.donnees.getJ1().getPacman().setVie(this.donnees.getJ1().getPacman().getVie() - 1);
         }

         this.posX = this.donnees.getAffichage().getPanchargement().getLaby().getHauteur() / 2;
         this.posY = (this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - 3) / 2 + this.pos;
      }

      if (this.donnees.getOptions().isMulti() && this.posX == this.donnees.getJ2().getPacman().getPosX() && this.posY == this.donnees.getJ2().getPacman().getPosY()) {
         if (this.donnees.getJ2().getPacman().isSgummEnCours()) {
            this.donnees.getS().effet(14);
            this.donnees.getJ2().getPacman().setScore(this.donnees.getJ2().getPacman().getScore() + 100);
            this.donnees.getJ2().getPacman().setFtuer(this.donnees.getJ2().getPacman().getFtuer() + 1);
         } else {
            this.donnees.getS().effet(10);
            if (this.donnees.getJ2().getPacman().getScore() > 200) {
               this.donnees.getJ2().getPacman().setScore(this.donnees.getJ2().getPacman().getScore() - 200);
            } else {
               this.donnees.getJ2().getPacman().setScore(0);
            }

            this.donnees.getJ2().getPacman().setVie(this.donnees.getJ2().getPacman().getVie() - 1);
         }

         this.posX = this.donnees.getAffichage().getPanchargement().getLaby().getHauteur() / 2;
         this.posY = (this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - 3) / 2 + this.pos;
      }

   }

   public float getTailleX() {
      return (float)this.tailleX;
   }

   public void setTailleX(int tailleX) {
      this.tailleX = tailleX;
   }

   public float getTailleY() {
      return (float)this.tailleY;
   }

   public void setTailleY(int tailleY) {
      this.tailleY = tailleY;
   }

   public Color getCouleur() {
      return this.couleur;
   }

   public void setCouleur(Color couleur) {
      this.couleur = couleur;
   }
}