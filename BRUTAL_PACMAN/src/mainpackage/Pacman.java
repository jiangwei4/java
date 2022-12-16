package mainpackage;
public class Pacman extends Personnage implements Runnable
{
    @SuppressWarnings("unused")
	private static final int fractionCaseParImage = 10;
    @SuppressWarnings("unused")
	private static final int dureeSgumm = 6000;
    @SuppressWarnings("unused")
	private static final int baseVitesse = 110;
    @SuppressWarnings("unused")
	private static final int acceleration = 15;
    private int etatAnimation;
    private int parcouruX;
    private int parcouruY;
    private int compteurSgumm;
    private int ratioCaseX;
    private int ratioCaseY;
    private int[][] mappage;
    private int theme;
    private boolean sgummEnCours;
    private int gumm;
    private int sgumm;
    private int score;
    private int vie;
    private int mort;
    private int ftuer;
    private boolean jouer;
    
    public Pacman(final int caseX, final int caseY, final int x, final int y, final int vitesse, final Donnees d) {
        super(caseX, caseY, d);
        this.sgummEnCours = false;
        this.vitesse = 110 - vitesse;
        this.compteurSgumm = 0;
        this.pixelX = x;
        this.pixelY = y;
        this.etatAnimation = 0;
        this.parcouruX = 0;
        this.parcouruY = 0;
        this.posX = caseX;
        this.posY = caseY;
        this.vie = 3;
        this.gumm = 0;
        this.sgumm = 0;
        this.jouer = true;
        if (this.donnees.getOptions().isMulti()) {
            this.theme = 4;
        }
        else if (this.donnees.getOptions().isSurvie()) {
            this.theme = 3;
        }
        else {
            this.theme = 1;
        }
    }
    
    public void run() {
        while (this.donnees.getThreadpacman().isJouerPM() && this.jouer) {
            this.ratioCaseX = this.tailleX / 10;
            this.ratioCaseY = this.tailleY / 10;
            this.vie();
            this.mangerGumm();
            this.mangerSgumm();
            if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).getImage() == 15) {
                if (this.posY < 1) {
                    this.posY = this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - 2 - this.posY;
                }
                else {
                    this.posY = this.donnees.getAffichage().getPanchargement().getLaby().getLargeur() - this.posY;
                }
                this.pixelX = this.posY * this.donnees.getAffichage().getJeu().getLargeurCasePix();
            }
            switch (this.direction) {
                case 0: {
                    if (this.parcouruX == 5) {
                        this.parcouruX = -5;
                        ++this.posY;
                        this.pixelX += this.ratioCaseX;
                        break;
                    }
                    if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionD() || this.parcouruX < 0) {
                        this.pixelX += this.ratioCaseX;
                        ++this.parcouruX;
                        this.parcouruY = 0;
                        this.pixelY = this.posX * this.donnees.getAffichage().getJeu().getHauteurCasePix();
                        break;
                    }
                    if (this.parcouruX == 0) {
                        this.pixelX = this.posY * this.donnees.getAffichage().getJeu().getLargeurCasePix();
                        break;
                    }
                    break;
                }
                case 1: {
                    if (this.parcouruY == 5) {
                        this.parcouruY = -5;
                        ++this.posX;
                        this.pixelY += this.ratioCaseY;
                        break;
                    }
                    if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionB() || this.parcouruY < 0) {
                        this.pixelY += this.ratioCaseY;
                        ++this.parcouruY;
                        this.parcouruX = 0;
                        this.pixelX = this.posY * this.donnees.getAffichage().getJeu().getLargeurCasePix();
                        break;
                    }
                    if (this.parcouruY == 0) {
                        this.pixelY = this.posX * this.donnees.getAffichage().getJeu().getHauteurCasePix();
                        break;
                    }
                    break;
                }
                case 2: {
                    if (this.parcouruX == -5) {
                        this.parcouruX = 5;
                        --this.posY;
                        this.pixelX -= this.ratioCaseX;
                        break;
                    }
                    if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionG() || this.parcouruX > 0) {
                        this.pixelX -= this.ratioCaseX;
                        --this.parcouruX;
                        this.parcouruY = 0;
                        this.pixelY = this.posX * this.donnees.getAffichage().getJeu().getHauteurCasePix();
                        break;
                    }
                    if (this.parcouruX == 0) {
                        this.pixelX = this.posY * this.donnees.getAffichage().getJeu().getLargeurCasePix();
                        break;
                    }
                    break;
                }
                case 3: {
                    if (this.parcouruY == -5) {
                        this.parcouruY = 5;
                        --this.posX;
                        this.pixelY -= this.ratioCaseY;
                        break;
                    }
                    if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isDirectionH() || this.parcouruY > 0) {
                        this.pixelY -= this.ratioCaseY;
                        --this.parcouruY;
                        this.parcouruX = 0;
                        this.pixelX = this.posY * this.donnees.getAffichage().getJeu().getLargeurCasePix();
                        break;
                    }
                    if (this.parcouruY == 0) {
                        this.pixelY = this.posX * this.donnees.getAffichage().getJeu().getHauteurCasePix();
                        break;
                    }
                    break;
                }
            }
            try {
                if (this.compteurSgumm > 0) {
                    Thread.sleep(this.vitesse - 15);
                    this.compteurSgumm -= this.vitesse - 15;
                }
                else {
                    if (this.sgummEnCours) {
                        this.donnees.getS().stop(7);
                        this.donnees.getS().jouer(this.theme);
                        this.sgummEnCours = false;
                    }
                    Thread.sleep(this.vitesse);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            if (this.donnees.getAffichage().getPanchargement().getLaby() != null && this.donnees.getNbrgumm() == this.donnees.getAffichage().getPanchargement().getLaby().getNbGumm()) {
                if (this == this.donnees.getJ1().getPacman()) {
                    this.donnees.getJ1().setScoreF(this.donnees.getJ1().getScoreF() + this.donnees.getJ1().getPacman().getScore());
                }
                else if (this == this.donnees.getJ2().getPacman()) {
                    this.donnees.getJ2().setScoreF(this.donnees.getJ2().getScoreF() + this.donnees.getJ2().getPacman().getScore());
                }
                if (this != this.donnees.getJ1().getPacman()) {
                    continue;
                }
                this.donnees.getAffichage().afficherFin();
                this.jouer = false;
            }
        }
    }
    
    public int getEtatAnimation() {
        if (this.etatAnimation == 5) {
            this.etatAnimation = 0;
        }
        return this.etatAnimation++;
    }
    
    public void setEtatAnimation(final int etatAnimation) {
        this.etatAnimation = etatAnimation;
    }
    
    private void mangerGumm() {
        if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isGumm()) {
            this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).setGumm(false);
            this.donnees.getS().effet(11);
            this.score += 20 / (this.donnees.getAffichage().getPanchargement().getLaby().getNbSgumm() - this.donnees.getNbrSgumm() + 1) + 1;
            ++this.gumm;
            this.donnees.setNbrgumm(this.donnees.getNbrgumm() + 1);
        }
    }
    
    private void mangerSgumm() {
        if (this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).isSgumm()) {
            this.compteurSgumm += 6000;
            this.donnees.getAffichage().getPanchargement().getLaby().avoirCase(this.posX, this.posY).setSgumm(false);
            this.donnees.getS().stop(this.theme);
            this.donnees.getS().effet(8);
            this.donnees.getS().menu(7);
            this.donnees.setNbrSgumm(this.donnees.getNbrSgumm() + 1);
            ++this.sgumm;
            this.sgummEnCours = true;
        }
    }
    
    public void vie() {
        if (this.vie == 0) {
            this.posX = 0;
            this.posY = 0;
        }
        if (this.donnees.getOptions().isMulti()) {
            if (this.donnees.getJ1().getPacman().getPosX() == 0 && this.donnees.getJ2().getPacman().getPosX() == 0 && this == this.donnees.getJ1().getPacman()) {
                this.donnees.getAffichage().afficherFin();
                this.jouer = false;
            }
        }
        else if (this.donnees.getJ1().getPacman().getPosX() == 0 && this.donnees.getJ1().getPacman().getPosY() == 0) {
            this.donnees.getAffichage().afficherFin();
            this.jouer = false;
        }
    }
    
    public int[][] getMappage() {
        return this.mappage;
    }
    
    public void setMappage(final int[][] mappage) {
        this.mappage = mappage;
    }
    
    public boolean isSgummEnCours() {
        return this.sgummEnCours;
    }
    
    public void setSgummEnCours(final boolean sgummEnCours) {
        this.sgummEnCours = sgummEnCours;
    }
    
    public float getTailleX() {
        return (float)this.tailleX;
    }
    
    public void setTailleX(final int tailleX) {
        this.tailleX = tailleX;
    }
    
    public float getTailleY() {
        return (float)this.tailleY;
    }
    
    public void setTailleY(final int tailleY) {
        this.tailleY = tailleY;
    }
    
    public int getCompteurSgumm() {
        return this.compteurSgumm;
    }
    
    public void setCompteurSgumm(final int compteurSgumm) {
        this.compteurSgumm = compteurSgumm;
    }
    
    public int getGumm() {
        return this.gumm;
    }
    
    public void setGumm(final int gumm) {
        this.gumm = gumm;
    }
    
    public int getSgumm() {
        return this.sgumm;
    }
    
    public void setSgumm(final int sgumm) {
        this.sgumm = sgumm;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(final int score) {
        this.score = score;
    }
    
    public int getVie() {
        return this.vie;
    }
    
    public void setVie(final int vie) {
        this.vie = vie;
    }
    
    public int getMort() {
        return this.mort;
    }
    
    public void setMort(final int mort) {
        this.mort = mort;
    }
    
    public int getFtuer() {
        return this.ftuer;
    }
    
    public void setFtuer(final int ftuer) {
        this.ftuer = ftuer;
    }
    
    public int getBasevitesse() {
        return 110;
    }
    
    public boolean isJouer() {
        return this.jouer;
    }
    
    public void setJouer(final boolean jouer) {
        this.jouer = jouer;
    }
}