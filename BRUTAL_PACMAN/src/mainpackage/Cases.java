package mainpackage;

public class Cases {
   private boolean directionH;
   private boolean directionB;
   private boolean directionG;
   private boolean directionD;
   private boolean interdictionB;
   private int image;
   private int posX;
   private int posY;
   private boolean gumm;
   private boolean Sgumm;
   private boolean spawnFantome;

   public Cases(boolean directionH, boolean directionB, boolean directionG, boolean directionD) {
      this.gumm = true;
      this.Sgumm = false;
      this.spawnFantome = false;
      this.interdictionB = false;
      this.directionH = directionH;
      this.directionB = directionB;
      this.directionG = directionG;
      this.directionD = directionD;
      if (directionH) {
         if (directionB) {
            if (directionG) {
               if (directionD) {
                  this.image = 0;
               } else {
                  this.image = 1;
               }
            } else if (directionD) {
               this.image = 2;
            } else {
               this.image = 3;
            }
         } else if (directionG) {
            if (directionD) {
               this.image = 4;
            } else {
               this.image = 5;
            }
         } else if (directionD) {
            this.image = 6;
         } else {
            this.image = 7;
         }
      } else if (directionB) {
         if (directionG) {
            if (directionD) {
               this.image = 8;
            } else {
               this.image = 9;
            }
         } else if (directionD) {
            this.image = 10;
         } else {
            this.image = 11;
         }
      } else if (directionG) {
         if (directionD) {
            this.image = 12;
         } else {
            this.image = 13;
         }
      } else if (directionD) {
         this.image = 14;
      } else {
         this.image = 15;
         this.gumm = false;
         this.Sgumm = false;
      }

   }

   public Cases(int image) {
      this.Sgumm = false;
      this.interdictionB = false;
      this.directionH = false;
      this.directionB = false;
      this.directionG = false;
      this.directionD = false;
      this.spawnFantome = false;
      if (image != 15) {
         this.gumm = true;
      }

      this.image = image;
      if (image < 8) {
         this.directionH = true;
      }

      if (image < 4 || image < 12 && image > 7) {
         this.directionB = true;
      }

      if (image % 4 == 0 || image % 4 == 1) {
         this.directionG = true;
      }

      if (image % 2 == 0) {
         this.directionD = true;
      }

      if (image > 15) {
         this.interdictionB = true;
      }

      if (image > 15 && image < 20) {
         this.directionH = true;
      }

   }

   public int quelleImage() {
      if (this.directionH) {
         if (this.directionB) {
            if (this.directionG) {
               return this.directionD ? 0 : 1;
            } else {
               return this.directionD ? 2 : 3;
            }
         } else if (this.directionG) {
            return this.directionD ? 4 : 5;
         } else {
            return this.directionD ? 6 : 7;
         }
      } else if (this.directionB) {
         if (this.directionG) {
            return this.directionD ? 8 : 9;
         } else {
            return this.directionD ? 10 : 11;
         }
      } else if (this.directionG) {
         return this.directionD ? 12 : 13;
      } else {
         return this.directionD ? 14 : 15;
      }
   }

   public int quelleImageInterdictionB() {
      int qc = this.quelleImage();
      if (qc != 0 && qc != 1 && qc != 2 && qc != 3 && qc != 8 && qc != 9 && qc != 10) {
         return qc != 4 && qc != 5 && qc != 6 && qc != 7 && qc != 12 && qc != 13 && qc != 14 ? 15 : qc + 12;
      } else {
         return qc + 16;
      }
   }

   public boolean isInterdictionB() {
      return this.interdictionB;
   }

   public void setInterdictionB(boolean interdictionB) {
      this.interdictionB = interdictionB;
   }

   public boolean isGumm() {
      return this.gumm;
   }

   public void setGumm(boolean gumm) {
      this.gumm = gumm;
   }

   public boolean isDirectionH() {
      return this.directionH;
   }

   public void setDirectionH(boolean directionH) {
      this.directionH = directionH;
   }

   public boolean isDirectionB() {
      return this.directionB;
   }

   public void setDirectionB(boolean directionB) {
      this.directionB = directionB;
   }

   public boolean isDirectionG() {
      return this.directionG;
   }

   public void setDirectionG(boolean directionG) {
      this.directionG = directionG;
   }

   public boolean isDirectionD() {
      return this.directionD;
   }

   public void setDirectionD(boolean directionD) {
      this.directionD = directionD;
   }

   public void setImage(int image) {
      this.image = image;
   }

   public int getImage() {
      return this.image;
   }

   public boolean isSgumm() {
      return this.Sgumm;
   }

   public void setSgumm(boolean sgumm) {
      this.Sgumm = sgumm;
   }

   public int getPosX() {
      return this.posX;
   }

   public void setPosX(int posX) {
      this.posX = posX;
   }

   public int getPosY() {
      return this.posY;
   }

   public boolean isSpawnFantome() {
      return this.spawnFantome;
   }

   public void setSpawnFantome(boolean spawnFantome) {
      this.spawnFantome = spawnFantome;
   }

   public void setPosY(int posY) {
      this.posY = posY;
   }
}