package mainpackage;


import java.beans.PropertyChangeEvent;
import java.awt.Graphics;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanChargement extends JPanel implements PropertyChangeListener
{
    private JProgressBar pb;
    private JTextArea taskOutput;
    private Task task;
    private int nbrDeLaby;
    
    public PanChargement(final Donnees donnees) {
        this.nbrDeLaby = 0;
        donnees.getS().menu(6);
        final JPanel contenu = new JPanel();
        this.setLayout(new BorderLayout(0, 0));
        (this.pb = new JProgressBar(0, 100)).setStringPainted(true);
        this.pb.setForeground(Color.LIGHT_GRAY);
        this.pb.setValue(0);
        this.pb.setVisible(true);
        this.pb.setBackground(Color.black);
        final GridLayout grille = new GridLayout(14, 1);
        contenu.setLayout(grille);
        contenu.setBackground(Color.black);
        this.add(contenu, "Center");
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(this.pb);
        (this.taskOutput = new JTextArea(5, 20)).setMargin(new Insets(5, 5, 5, 5));
        this.taskOutput.setEditable(false);
        this.taskOutput.setBackground(Color.black);
        this.taskOutput.setForeground(Color.DARK_GRAY);
        this.add(new JScrollPane(this.taskOutput), "South");
        this.setCursor(Cursor.getPredefinedCursor(3));
        (this.task = new Task(donnees)).addPropertyChangeListener((PropertyChangeListener)this);
        this.task.execute();
    }
    
    public void paintComponent(final Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            final int progress = (int)evt.getNewValue();
            this.pb.setValue(progress);
            if (this.task.getProgress() <= 90) {
                this.taskOutput.append(String.format("MAP N°" + this.nbrDeLaby + " Completed %d%% Generation  map.\n", this.task.getProgress()));
            }
            else if (this.task.getProgress() <= 93) {
                this.taskOutput.append(String.format("MAP N°" + this.nbrDeLaby + " Completed %d%% Gestion Gumm .\n", this.task.getProgress()));
            }
            else {
                this.taskOutput.append(String.format("MAP N°" + this.nbrDeLaby + " Completed %d%% Finalisation.\n", this.task.getProgress()));
            }
        }
    }
    
    public JProgressBar getPb() {
        return this.pb;
    }
    
    public void setPb(final JProgressBar pb) {
        this.pb = pb;
    }
    
    public void incrementerPB(final int i) {
        this.pb.setValue(this.pb.getValue() + i);
    }
    
    public int getValeur() {
        return this.pb.getValue();
    }
    
    public Labyrinthe getLaby() {
        return this.task.getLaby();
    }
    
    public void setLaby(final Labyrinthe e) {
        this.task.setLaby(e);
    }
    
    public Task getTask() {
        return this.task;
    }
    
    public void setTask(final Task task) {
        this.task = task;
    }
    
    public int getNbrDeLaby() {
        return this.nbrDeLaby;
    }
    
    public void setNbrDeLaby(final int nbrDeLaby) {
        this.nbrDeLaby = nbrDeLaby;
    }
}
