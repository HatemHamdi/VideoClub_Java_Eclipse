package projet;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FenetreAvecBouton extends JFrame{
	/**
	 * 
	 */
	

	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
 
		JButton bouton = new JButton("Cliquez ici !");
		panel.add(bouton);
 
		JButton bouton2 = new JButton("Ou là !");
		panel.add(bouton2);
 
		return panel;
	}
}