package mainpackage;
public class Entite {
   int posX;
   int posY;
   int pixelX;
   int pixelY;
   int tailleX;
   int tailleY;
   Donnees donnees;

   public Entite(int x, int y, Donnees d) {
      this.posX = x;
      this.posY = y;
      this.donnees = d;
   }

   public int getPixelX() {
      return this.pixelX;
   }

   public void setPixelX(int pixelX) {
      this.pixelX = pixelX;
   }

   public int getPixelY() {
      return this.pixelY;
   }

   public void setPixelY(int pixelY) {
      this.pixelY = pixelY;
   }

   public Donnees getDonnees() {
      return this.donnees;
   }

   public void setDonnees(Donnees donnees) {
      this.donnees = donnees;
   }
}