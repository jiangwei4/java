package mainpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Affichage extends JFrame {
   private PanInscription Inscri;
   private PanBestScore Score;
   private PanMenu menu;
   private PanJeu jeu;
   private PanFin panfin;
   private PanOptions panoptions;
   private PanChargement panchargement;
   private PanCredit pancredit;
   int largeurEcran;
   int hauteurEcran;
   private Thread jouer;
   private Donnees donnees = new Donnees(this);
   private boolean optionsChangees = false;
   private ControleurDeplacement controleurDeplacement;

   public Affichage(boolean pe) {
      ControleurPleinEcran CpleinEcran = new ControleurPleinEcran(this.donnees);
      this.addKeyListener(CpleinEcran);
      GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
      this.largeurEcran = gd.getDisplayMode().getWidth();
      this.hauteurEcran = gd.getDisplayMode().getHeight();
      this.setTitle("Pac-Man");
      this.setSize(this.largeurEcran, this.hauteurEcran);
      this.setDefaultCloseOperation(3);
      this.setUndecorated(pe);
      this.setLocationRelativeTo((Component)null);
      this.setVisible(true);
      this.afficherMenu();
      this.setExtendedState(6);
      this.setFocusable(true);
      this.setFocusTraversalKeysEnabled(false);
   }

   public void afficherJeu() {
      this.controleurDeplacement = new ControleurDeplacement(this.donnees, this.donnees.getControl());
      this.addKeyListener(this.controleurDeplacement);
      this.addMouseListener(this.controleurDeplacement);
      JPanel cadreJeu = new JPanel();
      cadreJeu.setLayout(new BorderLayout(0, 0));
      JLabel intitule = new JLabelOptions();
      this.quelnom(intitule);
      intitule.setHorizontalAlignment(0);
      intitule.setFont(new Font("Impact", 1, 36));
      intitule.setForeground(new Color(176, 64, 176));
      cadreJeu.add(intitule, "North");
      BoutonMenu retour = new BoutonMenu("Retour");
      retour.setBackground(Color.BLACK);
      retour.setOpaque(true);
      ControleurMenu listenerRetour = new ControleurMenu(this.donnees, retour);
      StyleMenu styleRetour = new StyleMenu(this.donnees, retour);
      retour.addActionListener(listenerRetour);
      retour.addMouseListener(styleRetour);
      cadreJeu.add(retour, "South");
      this.validate();
      this.jeu = new PanJeu(this.donnees);
      cadreJeu.add(this.jeu, "Center");
      this.setContentPane(cadreJeu);
      cadreJeu.revalidate();
      cadreJeu.repaint();
      this.donnees.getThreadpacman().setJouer(new Thread(new Jouer(this.donnees)));
      this.donnees.getThreadpacman().getJouer().start();
   }

   public void quelnom(JLabel intitule) {
      if (this.donnees.getOptions().isSurvie()) {
         intitule.setText("SURVIE");
      } else if (this.donnees.getOptions().isMulti()) {
         intitule.setText("Multijoueur");
      } else {
         intitule.setText("PACMAN");
      }

   }

   public void afficherOptions() {
      this.donnees.getS().menu(2);
      if (!this.optionsChangees) {
         this.panoptions = new PanOptions(this.donnees);
      }

      this.setContentPane(this.panoptions);
      this.revalidate();
      this.repaint();
   }

   public void afficherChargement() {
      this.panchargement = new PanChargement(this.donnees);
      this.setContentPane(this.panchargement);
      this.revalidate();
      this.repaint();
   }

   public void afficherCredit() {
      this.pancredit = new PanCredit(this.donnees);
      this.setContentPane(this.pancredit);
      this.revalidate();
      this.repaint();
   }

   public void afficherBestScore() {
      JPanel cadreScore = new JPanel();
      cadreScore.setLayout(new BorderLayout(0, 0));
      this.Score = new PanBestScore(this.donnees);
      cadreScore.add(this.Score, "Center");
      this.setContentPane(cadreScore);
      cadreScore.revalidate();
      this.repaint();
   }

   public void afficherInscription() {
      JPanel cadreinscri = new JPanel();
      cadreinscri.setLayout(new BorderLayout(0, 0));
      JLabel nom = new JLabelOptions(this.donnees.getJ1().getNom(), 0);
      nom.setHorizontalAlignment(0);
      nom.setFont(new Font("Impact", 1, 36));
      nom.setForeground(new Color(176, 64, 176));
      cadreinscri.add(nom, "North");
      this.validate();
      this.Inscri = new PanInscription(this.donnees);
      cadreinscri.add(this.Inscri, "Center");
      this.setContentPane(cadreinscri);
      cadreinscri.revalidate();
      this.repaint();
   }

   public void afficherFin() {
      this.panfin = new PanFin(this.donnees);
      this.setContentPane(this.panfin);
      this.revalidate();
      this.repaint();
   }

   public void afficherMenu() {
      this.menu = new PanMenu(this.donnees);
      this.setContentPane(this.menu);
      this.revalidate();
      this.setCursor(Cursor.getPredefinedCursor(1));
      this.repaint();
   }

   public boolean isOptionsChangees() {
      return this.optionsChangees;
   }

   public void setOptionsChangees(boolean optionsChangees) {
      this.optionsChangees = optionsChangees;
   }

   public PanJeu getJeu() {
      return this.jeu;
   }

   public void setJeu(PanJeu jeu) {
      this.jeu = jeu;
   }

   public PanChargement getPanchargement() {
      return this.panchargement;
   }

   public void setPanchargement(PanChargement panchargement) {
      this.panchargement = panchargement;
   }

   public Thread getJouer() {
      return this.jouer;
   }

   public void setJouer(Thread jouer) {
      this.jouer = jouer;
   }
}
