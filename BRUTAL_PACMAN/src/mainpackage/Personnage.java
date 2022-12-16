package mainpackage;
import java.util.LinkedList;

public class Personnage extends Entite
{
    protected int vitesse;
    protected int direction;
    LinkedList<Cases> casesAExaminer;
    LinkedList<Cases> casesAExaminerEnsuite;
    
    public Personnage(final int x, final int y, final Donnees d) {
        super(x, y, d);
        this.direction = 0;
        this.casesAExaminer = new LinkedList<Cases>();
        this.casesAExaminerEnsuite = new LinkedList<Cases>();
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
    
    public int getDirection() {
        return this.direction;
    }
    
    public void setDirection(final int direction) {
        this.direction = direction;
    }
    
    public int getVitesse() {
        return this.vitesse;
    }
    
    public void setVitesse(final int vitesse) {
        this.vitesse = vitesse;
    }
}