package mainpackage;
public class Labyrinthe
{
    private int posX;
    private int posY;
    private Cases[][] mapp;
    private int hauteur;
    private int largeur;
    private int nbSgumm;
    private int nbGumm;
    Donnees donnees;
    
    public Labyrinthe(final Labyrinthe a) {
        this.donnees = a.donnees;
        this.hauteur = a.getHauteur();
        this.largeur = a.getLargeur();
        this.mapp = new Cases[this.hauteur][this.largeur];
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur; ++j) {
                this.mapp[i][j] = a.mapp[i][j];
            }
        }
    }
    
    public Labyrinthe(final Donnees d) {
        this.donnees = d;
        if (this.donnees.getOptions().isAleatoire()) {
            this.generateurDeMap();
        }
        else {
            this.mapDeBase();
        }
        this.setXetY();
    }
    
    public void mapDeBase() {
        this.hauteur = 13;
        this.largeur = 14;
        this.nbSgumm = 4;
        this.nbGumm = 102;
        this.mapp = new Cases[this.hauteur][this.largeur];
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur; ++j) {
                if (i == 0 || i == this.hauteur - 1 || j == 0 || j == this.largeur - 1) {
                    this.mapp[i][j] = new Cases(15);
                }
                else {
                    this.mapp[i][j] = new Cases(0);
                }
            }
        }
        this.mapp[1][1] = new Cases(10);
        this.mapp[1][2] = new Cases(12);
        this.mapp[1][3] = new Cases(8);
        this.mapp[1][4] = new Cases(12);
        this.mapp[1][5] = new Cases(12);
        this.mapp[1][6] = new Cases(9);
        this.mapp[2][1] = new Cases(3);
        this.mapp[2][2] = new Cases(15);
        this.mapp[2][3] = new Cases(3);
        this.mapp[2][4] = new Cases(15);
        this.mapp[2][5] = new Cases(15);
        this.mapp[2][6] = new Cases(3);
        this.mapp[3][1] = new Cases(2);
        this.mapp[3][2] = new Cases(12);
        this.mapp[3][3] = new Cases(0);
        this.mapp[3][4] = new Cases(8);
        this.mapp[3][5] = new Cases(12);
        this.mapp[3][6] = new Cases(4);
        (this.mapp[4][1] = new Cases(6)).setGumm(false);
        this.mapp[4][1].setSgumm(true);
        this.mapp[4][2] = new Cases(12);
        this.mapp[4][3] = new Cases(1);
        this.mapp[4][4] = new Cases(6);
        this.mapp[4][5] = new Cases(12);
        this.mapp[4][6] = new Cases(9);
        this.mapp[5][1] = new Cases(15);
        this.mapp[5][2] = new Cases(15);
        this.mapp[5][3] = new Cases(3);
        this.mapp[5][4] = new Cases(10);
        this.mapp[5][5] = new Cases(12);
        this.mapp[5][6] = new Cases(16);
        (this.mapp[6][1] = new Cases(12)).setGumm(false);
        (this.mapp[6][2] = new Cases(12)).setGumm(false);
        this.mapp[6][3] = new Cases(0);
        this.mapp[6][4] = new Cases(1);
        this.mapp[6][5] = new Cases(14);
        this.mapp[6][6] = new Cases(4);
        this.mapp[7][1] = new Cases(15);
        this.mapp[7][2] = new Cases(15);
        this.mapp[7][3] = new Cases(3);
        this.mapp[7][4] = new Cases(2);
        this.mapp[7][5] = new Cases(12);
        this.mapp[7][6] = new Cases(12);
        (this.mapp[8][1] = new Cases(10)).setGumm(false);
        this.mapp[8][1].setSgumm(true);
        this.mapp[8][2] = new Cases(12);
        this.mapp[8][3] = new Cases(0);
        this.mapp[8][4] = new Cases(4);
        this.mapp[8][5] = new Cases(12);
        this.mapp[8][6] = new Cases(9);
        this.mapp[9][1] = new Cases(6);
        this.mapp[9][2] = new Cases(9);
        this.mapp[9][3] = new Cases(2);
        this.mapp[9][4] = new Cases(8);
        this.mapp[9][5] = new Cases(12);
        this.mapp[9][6] = new Cases(4);
        this.mapp[10][1] = new Cases(10);
        this.mapp[10][2] = new Cases(4);
        this.mapp[10][3] = new Cases(5);
        this.mapp[10][4] = new Cases(6);
        this.mapp[10][5] = new Cases(12);
        this.mapp[10][6] = new Cases(9);
        this.mapp[11][1] = new Cases(6);
        this.mapp[11][2] = new Cases(12);
        this.mapp[11][3] = new Cases(12);
        this.mapp[11][4] = new Cases(12);
        this.mapp[11][5] = new Cases(12);
        this.mapp[11][6] = new Cases(4);
        for (int e = 1; e < 6; ++e) {
            this.mapp[12][e] = new Cases(15);
        }
        this.posX = 10;
        this.posY = 6;
        this.miroir();
        this.retirerGummCentre();
    }
    
    public void generateurDeMap() {
        this.hauteur = this.donnees.getOptions().getHauteur();
        this.largeur = this.donnees.getOptions().getLargeur();
        if (this.largeur % 2 != 0) {
            --this.largeur;
        }
        this.nbSgumm = this.donnees.getOptions().getNbSgumm() * 2;
        this.mapp = new Cases[this.hauteur][this.largeur];
        final boolean[][] tab = new boolean[this.hauteur][this.largeur];
        boolean mapIncorect = true;
        while (mapIncorect) {
            this.donnees.getAffichage().getPanchargement().setNbrDeLaby(this.donnees.getAffichage().getPanchargement().getNbrDeLaby() + 1);
            this.donnees.getAffichage().getPanchargement().getTask().progressF(0);
            this.remplir0(0, 0);
            this.donnees.getAffichage().getPanchargement().getTask().progressF(90);
            this.ajouterCentre();
            this.donnees.getAffichage().getPanchargement().getTask().progress(1);
            this.initialisation(tab);
            this.donnees.getAffichage().getPanchargement().getTask().progress(1);
            this.casesFranchissable(this.hauteur / 2 - 1, this.largeur / 2 - 1, tab);
            this.donnees.getAffichage().getPanchargement().getTask().progress(1);
            if (this.compterCasesInfranchissable(tab) * 2 - (this.hauteur * 2 + this.largeur * 2) < (this.hauteur - 2) * (this.largeur - 2) / 3) {
                this.retirerCasesInfranchissable(tab);
                this.donnees.getAffichage().getPanchargement().getTask().progress(1);
                this.mettreSgumm(tab);
                this.donnees.getAffichage().getPanchargement().getTask().progress(1);
                this.ajouterSortie(this.hauteur / 2, 1);
                this.donnees.getAffichage().getPanchargement().getTask().progress(1);
                this.miroir();
                this.donnees.getAffichage().getPanchargement().getTask().progress(1);
                this.retirerGummCentre();
                this.donnees.getAffichage().getPanchargement().getTask().progress(1);
                if (this.compterGummMoitie() == 0) {
                    continue;
                }
                this.nbGumm = 2 * this.compterGummMoitie();
                this.donnees.getAffichage().getPanchargement().getTask().progress(1);
                this.posXetY(tab);
                this.donnees.getAffichage().getPanchargement().getTask().progress(1);
                mapIncorect = false;
            }
        }
    }
    
    public void miroir() {
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur / 2; ++j) {
                final int k = this.mapp[i][j].getImage();
                final boolean gumm = this.mapp[i][j].isGumm();
                final boolean Sgumm = this.mapp[i][j].isSgumm();
                if (k == 1 || k == 5 || k == 9 || k == 13 || k == 17 || k == 25) {
                    this.mapp[i][this.largeur - 1 - j] = new Cases(this.mapp[i][j].getImage() + 1);
                }
                else if (k == 2 || k == 6 || k == 10 || k == 14 || k == 18 || k == 26) {
                    this.mapp[i][this.largeur - 1 - j] = new Cases(this.mapp[i][j].getImage() - 1);
                }
                else {
                    this.mapp[i][this.largeur - 1 - j] = new Cases(this.mapp[i][j].getImage());
                }
                this.mapp[i][this.largeur - 1 - j].setGumm(gumm);
                this.mapp[i][this.largeur - 1 - j].setSgumm(Sgumm);
            }
        }
    }
    
    public void retirerGummCentre() {
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 1].setGumm(false);
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 2].setGumm(false);
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2].setGumm(false);
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 + 1].setGumm(false);
        (this.mapp[this.hauteur / 2][this.largeur / 2 - 1] = new Cases(4)).setGumm(false);
        this.mapp[this.hauteur / 2][this.largeur / 2 - 1].setSpawnFantome(true);
        (this.mapp[this.hauteur / 2][this.largeur / 2 - 2] = new Cases(14)).setGumm(false);
        this.mapp[this.hauteur / 2][this.largeur / 2 - 2].setSpawnFantome(true);
        (this.mapp[this.hauteur / 2][this.largeur / 2] = new Cases(4)).setGumm(false);
        this.mapp[this.hauteur / 2][this.largeur / 2].setSpawnFantome(true);
        (this.mapp[this.hauteur / 2][this.largeur / 2 + 1] = new Cases(13)).setGumm(false);
        this.mapp[this.hauteur / 2][this.largeur / 2 + 1].setSpawnFantome(true);
        this.mapp[this.hauteur / 2][this.largeur / 2].setGumm(false);
        this.mapp[this.hauteur / 2][this.largeur / 2 + 1].setGumm(false);
    }
    
    public void ajouterCentre() {
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 2].setDirectionB(false);
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 2].setImage(this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 2].quelleImage());
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 1].setDirectionB(false);
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 1].setInterdictionB(true);
        this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 1].setImage(this.mapp[this.hauteur / 2 - 1][this.largeur / 2 - 1].quelleImageInterdictionB());
        this.mapp[this.hauteur / 2][this.largeur / 2 - 3].setDirectionD(false);
        this.mapp[this.hauteur / 2][this.largeur / 2 - 3].setImage(this.mapp[this.hauteur / 2][this.largeur / 2 - 3].quelleImage());
        this.mapp[this.hauteur / 2][this.largeur / 2 - 2].setImage(14);
        this.mapp[this.hauteur / 2][this.largeur / 2 - 1].setImage(4);
        this.mapp[this.hauteur / 2 + 1][this.largeur / 2 - 2].setDirectionH(false);
        this.mapp[this.hauteur / 2 + 1][this.largeur / 2 - 2].setImage(this.mapp[this.hauteur / 2 + 1][this.largeur / 2 - 2].quelleImage());
        this.mapp[this.hauteur / 2 + 1][this.largeur / 2 - 1].setDirectionH(false);
        this.mapp[this.hauteur / 2 + 1][this.largeur / 2 - 1].setImage(this.mapp[this.hauteur / 2 + 1][this.largeur / 2 - 1].quelleImage());
    }
    
    public void remplir0(final int i, final int j) {
        final float a = 150.0f / (this.hauteur * (float)this.largeur);
        final float prog = 0.0f;
        final int pr = 0;
        this.remplir(i, j, prog, pr, a);
    }
    
    public void remplir(final int i, final int j, float prog, int pr, final float a) {
        prog += a;
        pr = (int)prog;
        if (pr > 0) {
            prog -= pr;
        }
        this.donnees.getAffichage().getPanchargement().getTask().progress(pr);
        boolean directionH = false;
        boolean directionB = false;
        boolean directionG = false;
        boolean directionD = false;
        final double coeffAleat = 1.7;
        if (i != this.hauteur) {
            if (j == 0) {
                this.mapp[i][j] = new Cases(15);
                this.remplir(i, j + 1, prog, pr, a);
            }
            else if (i == 0 || i == this.hauteur - 1) {
                this.mapp[i][j] = new Cases(15);
                if (j != this.largeur / 2) {
                    this.remplir(i, j + 1, prog, pr, a);
                }
                else {
                    this.remplir(i + 1, 0, prog, pr, a);
                }
            }
            else {
                directionH = this.mapp[i - 1][j].isDirectionB();
                directionG = this.mapp[i][j - 1].isDirectionD();
                int k = (int)(Math.random() * coeffAleat + 1.0);
                if (k != 2) {
                    directionD = true;
                }
                if (i == this.hauteur - 2) {
                    directionB = false;
                    this.mapp[i][j] = new Cases(directionH, directionB, directionG, directionD);
                }
                else {
                    k = (int)(Math.random() * coeffAleat + 1.0);
                    if (k != 2) {
                        directionB = true;
                    }
                    this.mapp[i][j] = new Cases(directionH, directionB, directionG, directionD);
                }
                if (j != this.largeur / 2) {
                    this.remplir(i, j + 1, prog, pr, a);
                }
                else {
                    this.remplir(i + 1, 0, prog, pr, a);
                }
            }
        }
    }
    
    public void initialisation(final boolean[][] tab) {
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur / 2; ++j) {
                tab[i][j] = false;
            }
        }
    }
    
    public void casesFranchissable(final int i, final int j, final boolean[][] tab) {
        if (this.mapp[i][j].getImage() != 15 && !tab[i][j]) {
            tab[i][j] = true;
            this.mapp[i][j].setGumm(true);
            if (this.mapp[i][j].isDirectionH()) {
                this.casesFranchissable(i - 1, j, tab);
            }
            if (this.mapp[i][j].isDirectionB()) {
                this.casesFranchissable(i + 1, j, tab);
            }
            if (this.mapp[i][j].isDirectionG()) {
                this.casesFranchissable(i, j - 1, tab);
            }
            if (this.mapp[i][j].isDirectionD() && j < this.largeur / 2 - 1) {
                this.casesFranchissable(i, j + 1, tab);
            }
        }
    }
    
    public int compterCasesInfranchissable(final boolean[][] tab) {
        int CF = 0;
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur / 2; ++j) {
                if (!tab[i][j]) {
                    ++CF;
                }
            }
        }
        return CF;
    }
    
    public void retirerCasesInfranchissable(final boolean[][] tab) {
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur / 2; ++j) {
                if (!tab[i][j]) {
                    this.mapp[i][j] = new Cases(15);
                }
            }
        }
    }
    
    public void ajouterSortie(final int i, final int j) {
        if (j < this.largeur / 2 - 2 && this.mapp[i][j].getImage() != 15) {
            this.mapp[i][j].setDirectionG(true);
            this.mapp[i][j].setImage(this.mapp[i][j].quelleImage());
            this.mapp[i][j].setGumm(false);
        }
        else {
            this.mapp[i][j].setDirectionD(true);
            this.mapp[i][j].setDirectionG(true);
            this.mapp[i][j].setImage(12);
            this.mapp[i][j].setGumm(false);
            this.ajouterSortie(i, j + 1);
        }
    }
    
    public void mettreSgumm(final boolean[][] tab) {
        final int nbrDeCaseDispo = (this.hauteur - 3) * (this.largeur - 3) - (this.compterCasesInfranchissable(tab) * 2 - (this.hauteur * 2 + this.largeur * 2)) / 2;
        if (nbrDeCaseDispo < this.nbSgumm) {
            this.nbSgumm = nbrDeCaseDispo;
        }
        for (int i = 0; i < this.nbSgumm / 2; ++i) {
            this.mettreSgumm2(tab, i);
        }
    }
    
    public void mettreSgumm2(final boolean[][] tab, final int e) {
        final int i = (int)(Math.random() * this.hauteur) + 0;
        final int j = (int)(Math.random() * this.largeur / 2.0) + 0;
        if (this.mapp[i][j].getImage() != 15 && i != this.hauteur / 2 && !this.mapp[i][j].isSgumm()) {
            this.mapp[i][j].setGumm(false);
            this.mapp[i][j].setSgumm(true);
            try {
                Thread.sleep(10L);
            }
            catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        else {
            this.mettreSgumm2(tab, e);
        }
    }
    
    public int compterGummMoitie() {
        int CG = 0;
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur / 2; ++j) {
                if (this.mapp[i][j].isGumm()) {
                    ++CG;
                }
            }
        }
        return CG;
    }
    
    public void posXetY(final boolean[][] tab) {
        int i;
        int j;
        for (i = this.hauteur - 3, j = this.largeur / 2 - 1; !tab[i][j]; --i, j = this.largeur / 2) {
            if (--j == 0) {}
        }
        this.posY = j;
        this.posX = i;
    }
    
    private void setXetY() {
        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur; ++j) {
                this.mapp[i][j].setPosX(i);
                this.mapp[i][j].setPosY(j);
            }
        }
    }
    
    public int getI(final int i, final int j) {
        return this.mapp[i][j].getImage();
    }
    
    public boolean isGumm(final int i, final int j) {
        return this.mapp[i][j].isGumm();
    }
    
    public boolean isSgumm(final int i, final int j) {
        return this.mapp[i][j].isSgumm();
    }
    
    public Cases avoirCase(final int i, final int j) {
        return this.mapp[i][j];
    }
    
    public int getHauteur() {
        return this.hauteur;
    }
    
    public void setHauteur(final int hauteur) {
        this.hauteur = hauteur;
    }
    
    public int getLargeur() {
        return this.largeur;
    }
    
    public void setLongeur(final int longeur) {
        this.largeur = longeur;
    }
    
    public int getNbSgumm() {
        return this.nbSgumm;
    }
    
    public void setNbSgumm(final int nbSgumm) {
        this.nbSgumm = nbSgumm;
    }
    
    public int getNbGumm() {
        return this.nbGumm;
    }
    
    public void setNbGumm(final int nbGumm) {
        this.nbGumm = nbGumm;
    }
    
    public int getXDepartPacman() {
        return 0;
    }
    
    public int getYDepartPacman() {
        return 0;
    }
    
    public int getXDepartFantome() {
        return this.largeur / 2;
    }
    
    public int getYDepartFantome() {
        return this.hauteur / 2;
    }
    
    public int getPosX() {
        return this.posX;
    }
    
    public void setPosX(final int posX) {
        this.posX = posX;
    }
    
    public int getPosY() {
        return this.posY;
    }
    
    public void setPosY(final int posY) {
        this.posY = posY;
    }
}