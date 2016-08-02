package projet;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.processing.SupportedOptions;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import org.omg.PortableInterceptor.NON_EXISTENT;

import java.lang.Integer;
import java.lang.String;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;

public class Ajouter_Film extends JFrame {

	private JPanel contentPane;
	private JTextField titre_film;
	private JTextField nom_realisateur;
	private JTextField pre;
	private JTextField prix_film;




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Ajouter_Film frame = new Ajouter_Film();
					
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Ajouter_Film() {
		this.setResizable(false);
		JLabel text2 = new JLabel("");
		JLabel text3 = new JLabel("");
		JLabel ajout = new JLabel("");

		text3.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\text.png"));
		text2.hide();
		text3.hide();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titre = new JLabel("");
		titre.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\titre.png"));
		titre.setBounds(231, 29, 78, 28);
		contentPane.add(titre);
		JLabel pre_r = new JLabel("");
		pre_r.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\prenom.png"));
		pre_r.setBounds(440, 152, 115, 31);
		contentPane.add(pre_r);

		JLabel Prix = new JLabel("");
		Prix.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\prix.png"));
		Prix.setBounds(142, 209, 100, 28);
		contentPane.add(Prix);

		JLabel nom_r = new JLabel("");
		nom_r.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\nom.png"));
		nom_r.setBounds(82, 152, 78, 31);
		contentPane.add(nom_r);

		JComboBox type_film = new JComboBox();
		type_film.setBorder(null);
		type_film.setBounds(250, 279, 198, 20);
		contentPane.add(type_film);

		type_film.addItem("Film Romance");
		type_film.addItem("Film Action");
		type_film.addItem("Film Science Fiction");

		JLabel type = new JLabel("");
		type.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\type.png"));
		type.setBounds(156, 275, 78, 31);
		contentPane.add(type);

		titre_film = new JTextField();
		titre_film.setOpaque(false);
		titre_film.setBorder(null);
		titre_film.setBounds(335, 32, 173, 20);
		contentPane.add(titre_film);
		titre_film.setColumns(10);

		nom_realisateur = new JTextField();
		nom_realisateur.setBorder(null);
		nom_realisateur.setOpaque(false);
		nom_realisateur.setBounds(180, 159, 186, 20);
		contentPane.add(nom_realisateur);
		nom_realisateur.setColumns(10);

		pre = new JTextField();
		pre.setOpaque(false);
		pre.setBorder(null);
		pre.setBounds(543, 159, 180, 20);
		contentPane.add(pre);
		pre.setColumns(10);

		prix_film = new JTextField();
		prix_film.setOpaque(false);
		prix_film.setBorder(null);
		prix_film.setBounds(250, 212, 180, 20);
		contentPane.add(prix_film);
		prix_film.setColumns(10);

		JComboBox liste_r = new JComboBox();
		liste_r.setBorder(null);
		liste_r.setBounds(250, 159, 198, 20);
		contentPane.add(liste_r);
		ResultSet r = new Realisateur().select();
		try {
			while (r.next()) {
				liste_r.addItem(r.getString("nom") + " / "
						+ r.getString("prenom"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		JLabel Realisateur = new JLabel("");
		Realisateur.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\realisateur.png"));
		Realisateur.setBounds(111, 152, 131, 31);
		contentPane.add(Realisateur);

		nom_r.hide();
		pre_r.hide();
		nom_realisateur.hide();
		pre.hide();

		JRadioButton non_existe = new JRadioButton("");
		non_existe.setContentAreaFilled(false);

		JRadioButton existe = new JRadioButton("");
		existe.setContentAreaFilled(false);
		existe.setBackground(SystemColor.inactiveCaptionBorder);
		existe.setSelected(true);
		existe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (existe.isSelected()) {
					non_existe.setSelected(false);
					liste_r.show();
					Realisateur.show();
					nom_r.hide();
					pre_r.hide();
					nom_realisateur.hide();
					pre.hide();
					text2.hide();
					text3.hide();

				}
			}
		});
		existe.setBounds(156, 85, 21, 23);
		contentPane.add(existe);

		non_existe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (non_existe.isSelected()) {
					existe.setSelected(false);
					text2.show();
					text3.show();
					liste_r.hide();
					Realisateur.hide();
					nom_r.show();
					pre_r.show();
					nom_realisateur.show();
					pre.show();

				}
			}
		});
		non_existe.setBounds(437, 85, 21, 23);
		contentPane.add(non_existe);
		
		JLabel bouton = new JLabel("");
		
		bouton.setForeground(new Color(255, 255, 255));
		bouton.setHorizontalAlignment(SwingConstants.LEFT);
		bouton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				bouton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\retour2.png"));
				bouton.setText("Retour Au Menu");
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				retour(arg0);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				bouton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\retour1.png"));
			}
		});
		bouton.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\retour1.png"));
		bouton.setBounds(623, 21, 118, 35);
		
		contentPane.add(bouton);
		JLabel text1 = new JLabel("");
		text1.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\text.png"));
		text1.setBounds(319, 22, 211, 40);
		contentPane.add(text1);
		
		text2.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\text.png"));
		text2.setBounds(530, 148, 211, 40);
		contentPane.add(text2);
		
		text3.setBounds(170, 148, 211, 40);
		contentPane.add(text3);

		JLabel text4 = new JLabel("");
		text4.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\text.png"));
		text4.setBounds(237, 203, 211, 40);
		contentPane.add(text4);
		
		ajout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ajout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\ajout2.png"));

			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				ajout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\ajout.png"));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id_real;
				double p=Double.parseDouble(prix_film.getText().toString());
				String nom_prenom=liste_r.getSelectedItem().toString();
				StringTokenizer st=new StringTokenizer(nom_prenom," / ");
				String noml=st.nextToken();
				String prl=st.nextToken();
				if(existe.isSelected()){
					Realisateur real = new Realisateur();
					real.setNom(noml);
					real.setPrenom(prl);
					id_real = real.get_id();
				}
				else{
					new Realisateur().insert(nom_realisateur.getText().toString(), pre.getText().toString());
					id_real = new Realisateur().get_last_id();
				}
				
				
				
				new Film().insert(titre_film.getText().toString(), p, id_real, type_film.getSelectedItem().toString());
			
				JOptionPane.showMessageDialog(null, "ajout effectuer");
			}
		});
		ajout.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\ajout.png"));
		ajout.setHorizontalAlignment(SwingConstants.LEFT);
		ajout.setForeground(Color.WHITE);
		ajout.setBounds(330, 381, 118, 35);
		contentPane.add(ajout);
		
		JLabel re = new JLabel("");
		re.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\r_existant.png"));
		re.setBounds(177, 85, 192, 22);
		contentPane.add(re);
		
		JLabel nr = new JLabel("");
		nr.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\r_nouveau.png"));
		nr.setBounds(458, 85, 193, 20);
		contentPane.add(nr);
		
		JLabel back = new JLabel("");
		back.setBackground(UIManager.getColor("Button.background"));
		back.setIcon(new ImageIcon(Ajouter_Film.class.getResource("/projet/couleur(y).jpg")));
		back.setBounds(0, 0, 790, 455);
		contentPane.add(back);
		
		

		
		
		
	}

	protected void retour(MouseEvent arg0) {
		this.dispose();
		new Design().setVisible(true);
		
	}
}
