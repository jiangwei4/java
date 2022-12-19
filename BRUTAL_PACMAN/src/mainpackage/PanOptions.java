package mainpackage;
import java.awt.Graphics;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class PanOptions extends JPanel
{
    Donnees donnees;
    
    @SuppressWarnings({ "removal", "unchecked", "rawtypes" })
	public PanOptions(final Donnees d) {
        this.donnees = d;
        final JPanel contenu = new JPanel();
        contenu.setBackground(Color.black);
        this.setLayout(new BorderLayout(0, 0));
        final JLabel intitule = new JLabel("Options");
        intitule.setHorizontalAlignment(0);
        intitule.setFont(new Font("Impact", 1, 72));
        intitule.setForeground(new Color(176, 64, 176));
        this.add(intitule, "North");
        final GridLayout grille = new GridLayout(14, 4);
        contenu.setLayout(grille);
        this.add(contenu, "Center");
        final BoutonMenu Menu = new BoutonMenu("Menu");
        final ControleurMenu listenerRetour = new ControleurMenu(this.donnees, Menu);
        final StyleMenu styleRetour = new StyleMenu(this.donnees, Menu);
        Menu.addActionListener((ActionListener)listenerRetour);
        Menu.addMouseListener((MouseListener)styleRetour);
        this.add((Component)Menu, "South");
        final ControleurOptions listenerComboBox = new ControleurOptions(this.donnees);
        final JComboBox<Integer> hauteur = new JComboBox<Integer>();
        hauteur.setActionCommand("hauteur");
        listenerComboBox.ControleurOptionsComboBox((JComboBox)hauteur, 0);
        hauteur.addItem(new Integer(5));
        hauteur.addItem(new Integer(6));
        hauteur.addItem(new Integer(7));
        this.remplirJComboBox(hauteur);
        hauteur.setName("Hauteur de la map  ");
        hauteur.setSelectedIndex(this.donnees.getOptions().getHauteur() - this.donnees.getOptions().getHauteurMin());
        hauteur.addActionListener((ActionListener)listenerComboBox);
        final JComboBox<Integer> largeur = new JComboBox<Integer>();
        largeur.setActionCommand("largeur");
        listenerComboBox.ControleurOptionsComboBox((JComboBox)largeur, 1);
        this.remplirJComboBox(largeur);
        largeur.setName("Largeur de la map  ");
        largeur.setSelectedIndex(this.donnees.getOptions().getLargeur() - this.donnees.getOptions().getLargeurMin());
        largeur.addActionListener((ActionListener)listenerComboBox);
        final JComboBox<Integer> nbrSgumm = new JComboBox<Integer>();
        nbrSgumm.setActionCommand("nbrSgumm");
        listenerComboBox.ControleurOptionsComboBox((JComboBox)nbrSgumm, 2);
        this.remplirJComboBoxNbrSgumm(nbrSgumm);
        nbrSgumm.setName("Nombre de Sgumm  ");
        nbrSgumm.setSelectedIndex(this.donnees.getOptions().getNbSgumm());
        nbrSgumm.addActionListener((ActionListener)listenerComboBox);
        final JComboBox<Integer> nbrFantome = new JComboBox<Integer>();
        nbrFantome.setActionCommand("nbrFantome");
        listenerComboBox.ControleurOptionsComboBox((JComboBox)nbrFantome, 3);
        this.remplirJComboBoxNbrFantome(nbrFantome);
        nbrFantome.setName("Nombre de fantome  ");
        nbrFantome.setSelectedIndex(this.donnees.getOptions().getNbFantomes());
        nbrFantome.addActionListener((ActionListener)listenerComboBox);
        final ControleurOptions listenerMap = new ControleurOptions(this.donnees);
        final JRadioButton mapdebase = new JRadioButton("Carte de base");
        mapdebase.setActionCommand("mapdebase");
        mapdebase.setBackground(Color.black);
        mapdebase.setForeground(Color.white);
        mapdebase.setFont(new Font("Impact", 0, 20));
        mapdebase.addActionListener((ActionListener)listenerMap);
        final JRadioButton aleatoire = new JRadioButton("Carte aleatoire");
        aleatoire.setActionCommand("aleatoire");
        aleatoire.setBackground(Color.black);
        aleatoire.setForeground(Color.white);
        aleatoire.setForeground(Color.white);
        aleatoire.setFont(new Font("Impact", 0, 20));
        aleatoire.addActionListener((ActionListener)listenerMap);
        final ControleurOptions listenerCheckBox = new ControleurOptions(this.donnees);
        final JCheckBox theme1JouerDepuisDebut = new JCheckBox("jouer depuis le debut theme : Menu");
        listenerCheckBox.ControleurOptionsCheckBox(theme1JouerDepuisDebut, 0);
        theme1JouerDepuisDebut.setActionCommand("theme1");
        theme1JouerDepuisDebut.setSelected(this.donnees.getOptions().isJouerDepuisDebut(0));
        theme1JouerDepuisDebut.setBackground(Color.black);
        theme1JouerDepuisDebut.setForeground(Color.white);
        theme1JouerDepuisDebut.setFont(new Font("Impact", 0, 20));
        theme1JouerDepuisDebut.addActionListener((ActionListener)listenerCheckBox);
        final JCheckBox theme2JouerDepuisDebut = new JCheckBox("jouer depuis le debut theme : jeu");
        listenerCheckBox.ControleurOptionsCheckBox(theme2JouerDepuisDebut, 1);
        theme2JouerDepuisDebut.setActionCommand("theme2");
        theme2JouerDepuisDebut.setSelected(this.donnees.getOptions().isJouerDepuisDebut(1));
        theme2JouerDepuisDebut.setBackground(Color.black);
        theme2JouerDepuisDebut.setForeground(Color.white);
        theme2JouerDepuisDebut.setFont(new Font("Impact", 0, 20));
        theme2JouerDepuisDebut.addActionListener((ActionListener)listenerCheckBox);
        final JCheckBox theme3JouerDepuisDebut = new JCheckBox("jouer depuis le debut theme : option");
        listenerCheckBox.ControleurOptionsCheckBox(theme3JouerDepuisDebut, 2);
        theme3JouerDepuisDebut.setActionCommand("theme3");
        theme3JouerDepuisDebut.setSelected(this.donnees.getOptions().isJouerDepuisDebut(2));
        theme3JouerDepuisDebut.setBackground(Color.black);
        theme3JouerDepuisDebut.setForeground(Color.white);
        theme3JouerDepuisDebut.setFont(new Font("Impact", 0, 20));
        theme3JouerDepuisDebut.addActionListener((ActionListener)listenerCheckBox);
        final JCheckBox theme4JouerDepuisDebut = new JCheckBox("jouer depuis le debut theme : survie");
        listenerCheckBox.ControleurOptionsCheckBox(theme4JouerDepuisDebut, 3);
        theme4JouerDepuisDebut.setActionCommand("theme4");
        theme4JouerDepuisDebut.setSelected(this.donnees.getOptions().isJouerDepuisDebut(3));
        theme4JouerDepuisDebut.setBackground(Color.black);
        theme4JouerDepuisDebut.setForeground(Color.white);
        theme4JouerDepuisDebut.setFont(new Font("Impact", 0, 20));
        theme4JouerDepuisDebut.addActionListener((ActionListener)listenerCheckBox);
        final JCheckBox theme5JouerDepuisDebut = new JCheckBox("jouer depuis le debut theme : multi");
        listenerCheckBox.ControleurOptionsCheckBox(theme5JouerDepuisDebut, 4);
        theme5JouerDepuisDebut.setActionCommand("theme5");
        theme5JouerDepuisDebut.setSelected(this.donnees.getOptions().isJouerDepuisDebut(4));
        theme5JouerDepuisDebut.setBackground(Color.black);
        theme5JouerDepuisDebut.setForeground(Color.white);
        theme5JouerDepuisDebut.setFont(new Font("Impact", 0, 20));
        theme5JouerDepuisDebut.addActionListener((ActionListener)listenerCheckBox);
        final ControleurOptionsChangeListener listenerSlider = new ControleurOptionsChangeListener(this.donnees);
        final JSlider theme = new JSlider();
        listenerSlider.ControleurOptionsSlider(theme, 0);
        theme.setMaximum(3);
        theme.setMinimum(-10);
        theme.setBackground(Color.black);
        theme.setValue(this.donnees.getOptions().getVolume(0));
        theme.setPaintTicks(true);
        theme.setPaintLabels(true);
        theme.addChangeListener((ChangeListener)listenerSlider);
        final JSlider effet = new JSlider();
        listenerSlider.ControleurOptionsSlider(effet, 1);
        effet.setMaximum(3);
        effet.setMinimum(-10);
        effet.setBackground(Color.black);
        effet.setValue(this.donnees.getOptions().getVolume(1));
        effet.setPaintTicks(true);
        effet.setPaintLabels(true);
        effet.addChangeListener((ChangeListener)listenerSlider);
        if (this.donnees.getOptions().isAleatoire()) {
            aleatoire.setSelected(true);
        }
        else {
            mapdebase.setSelected(true);
        }
        contenu.add(new JLabelOptions());
        contenu.add(mapdebase);
        contenu.add(aleatoire);
        contenu.add(new JLabelOptions());
        final ButtonGroup group = new ButtonGroup();
        group.add(mapdebase);
        group.add(aleatoire);
        contenu.add(new JLabelOptions());
        final ControleurOptions listenerTextField = new ControleurOptions(this.donnees);
        final JTextField j1H = new JTextField();
        j1H.addKeyListener((KeyListener)new ClavierListener(this.donnees, j1H, listenerTextField));
        j1H.setText(KeyEvent.getKeyText(this.donnees.getControlInt(0)));
        j1H.setName("1haut");
        j1H.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j1H.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        j1H.setActionCommand("1haut");
        final JTextField j1B = new JTextField();
        j1B.addKeyListener((KeyListener)new ClavierListener(this.donnees, j1B, listenerTextField));
        j1B.setText(KeyEvent.getKeyText(this.donnees.getControlInt(1)));
        j1B.setName("1bas");
        j1B.setActionCommand("1bas");
        j1B.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j1B.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        final JTextField j1G = new JTextField();
        j1G.addKeyListener((KeyListener)new ClavierListener(this.donnees, j1G, listenerTextField));
        j1G.setText(KeyEvent.getKeyText(this.donnees.getControlInt(2)));
        j1G.setName("1gauche");
        j1G.setActionCommand("1gauche");
        j1G.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j1G.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        final JTextField j1D = new JTextField();
        j1D.addKeyListener((KeyListener)new ClavierListener(this.donnees, j1D, listenerTextField));
        j1D.setText(KeyEvent.getKeyText(this.donnees.getControlInt(3)));
        j1D.setName("1droite");
        j1D.setActionCommand("1droite");
        j1D.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j1D.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        final JTextField j2H = new JTextField();
        j2H.addKeyListener((KeyListener)new ClavierListener(this.donnees, j2H, listenerTextField));
        j2H.setText(KeyEvent.getKeyText(this.donnees.getControlInt(4)));
        j2H.setName("2haut");
        j2H.setActionCommand("2haut");
        j2H.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j2H.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        final JTextField j2B = new JTextField();
        j2B.addKeyListener((KeyListener)new ClavierListener(this.donnees, j2B, listenerTextField));
        j2B.setText(KeyEvent.getKeyText(this.donnees.getControlInt(5)));
        j2B.setName("2bas");
        j2B.setActionCommand("2bas");
        j2B.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j2B.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        final JTextField j2G = new JTextField();
        j2G.addKeyListener((KeyListener)new ClavierListener(this.donnees, j2G, listenerTextField));
        j2G.setText(KeyEvent.getKeyText(this.donnees.getControlInt(6)));
        j2G.setName("2gauche");
        j2G.setActionCommand("2gauche");
        j2G.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j2G.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        final JTextField j2D = new JTextField();
        j2D.addKeyListener((KeyListener)new ClavierListener(this.donnees, j2D, listenerTextField));
        j2D.setText(KeyEvent.getKeyText(this.donnees.getControlInt(7)));
        j2D.setName("2droite");
        j2D.setActionCommand("2droite");
        j2D.addFocusListener(new FocusListener() {
        	@Override
            public void focusGained(final FocusEvent e) {
            	j2D.setText("");
                //displayMessage("Focus gained", e);
              }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
        final JCheckBox coupertheme = new JCheckBox("couper le volume des themes");
        listenerCheckBox.ControleurOptionsCheckBox(coupertheme, 5);
        coupertheme.setActionCommand("coupertheme");
        coupertheme.setSelected(this.donnees.getOptions().isCouperVolumeTheme());
        coupertheme.setBackground(Color.black);
        coupertheme.setForeground(Color.white);
        coupertheme.setFont(new Font("Impact", 0, 20));
        coupertheme.addActionListener((ActionListener)listenerCheckBox);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions(hauteur.getName(), 4));
        contenu.add(hauteur);
        contenu.add(new JLabelOptions(nbrSgumm.getName(), 4));
        contenu.add(nbrSgumm);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions(largeur.getName(), 4));
        contenu.add(largeur);
        contenu.add(new JLabelOptions(nbrFantome.getName(), 4));
        contenu.add(nbrFantome);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(theme1JouerDepuisDebut);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions("Deplacement Joueur 1", 0));
        contenu.add(new JLabelOptions("Deplacement Joueur 2", 0));
        contenu.add(new JLabelOptions());
        contenu.add(theme2JouerDepuisDebut);
        contenu.add(new JLabelOptions("Haut  ", 4));
        contenu.add(j1H);
        contenu.add(j2H);
        contenu.add(new JLabelOptions());
        contenu.add(theme3JouerDepuisDebut);
        contenu.add(new JLabelOptions("Bas  ", 4));
        contenu.add(j1B);
        contenu.add(j2B);
        contenu.add(new JLabelOptions());
        contenu.add(theme4JouerDepuisDebut);
        contenu.add(new JLabelOptions("Gauche  ", 4));
        contenu.add(j1G);
        contenu.add(j2G);
        contenu.add(new JLabelOptions());
        contenu.add(theme5JouerDepuisDebut);
        contenu.add(new JLabelOptions("Droite  ", 4));
        contenu.add(j1D);
        contenu.add(j2D);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions("Volume theme:  ", 4));
        contenu.add(theme);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions("Volume effet:  ", 4));
        contenu.add(effet);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(coupertheme);
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
        contenu.add(new JLabelOptions());
    }
    
    public void paintComponent(final Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    @SuppressWarnings("removal")
	public void remplirJComboBox(final JComboBox<Integer> cb) {
        for (int i = 8; i < 80; ++i) {
            cb.addItem(new Integer(i));
        }
    }
    
    @SuppressWarnings("removal")
	public void remplirJComboBoxNbrSgumm(final JComboBox<Integer> cb) {
        for (int i = 0; i < 80; ++i) {
            if (i % 2 != 0) {
                ++i;
            }
            cb.addItem(new Integer(i));
        }
    }
    
    @SuppressWarnings("removal")
	public void remplirJComboBoxNbrFantome(final JComboBox<Integer> cb) {
        for (int i = 0; i <= 20; ++i) {
            cb.addItem(new Integer(i));
        }
    }
}