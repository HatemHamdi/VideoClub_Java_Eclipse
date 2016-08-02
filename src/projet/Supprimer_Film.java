package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class Supprimer_Film extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supprimer_Film frame = new Supprimer_Film();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Supprimer_Film() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JComboBox combo_film = new JComboBox();
		combo_film.setBounds(200, 135, 190, 20);
		contentPane.add(combo_film);
		
		JComboBox combo_rel = new JComboBox();
		combo_rel.setBounds(467, 135, 197, 20);
		contentPane.add(combo_rel);
		
		
		JRadioButton sup_rel = new JRadioButton("");
		sup_rel.setOpaque(false);

		
		JRadioButton sup_film = new JRadioButton("");
		sup_film.setOpaque(false);
		sup_film.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sup_film.isSelected())
				{
				combo_rel.hide();
				combo_film.show();
				sup_rel.setSelected(false);
				
				}
				
			}
		});
		sup_film.setBounds(185, 89, 21, 23);
		contentPane.add(sup_film);
		
		sup_rel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sup_rel.isSelected())
				{
					combo_rel.show();
					combo_film.hide();
					sup_film.setSelected(false);
				}
			}
		});
		sup_rel.setBounds(452, 89, 21, 23);
		contentPane.add(sup_rel);
		sup_film.setSelected(true);
		combo_rel.hide();
		combo_film.show();
		sup_rel.setSelected(false);
		
		
		ResultSet r = new Realisateur().select();
		try {
			while (r.next()) {
				combo_rel.addItem(r.getString("nom") + " / "
						+ r.getString("prenom"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		ResultSet f = new Film().select();
		try {
			while (f.next()) {
				combo_film.addItem(f.getString("titre") + " / "
						+ f.getString("id_realisateur"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
JLabel bouton = new JLabel("");
		
		bouton.setForeground(new Color(255, 255, 255));
		bouton.setHorizontalAlignment(SwingConstants.LEFT);
		bouton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				bouton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\retour2.png"));
				
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
		
		JLabel supp = new JLabel("");
		supp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				supp.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\supp1.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				supp.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\supp.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(sup_film.isSelected())
				{
					StringTokenizer st=new StringTokenizer(combo_film.getSelectedItem().toString()," / ");
					String t=st.nextToken();
					int i=Integer.parseInt(st.nextToken());
					
					new Film().sup_film(t,i);
				}else{
					StringTokenizer st=new StringTokenizer(combo_rel.getSelectedItem().toString()," / ");
					String n=st.nextToken();
					String p=st.nextToken();
					new Realisateur().sup_rel(n,p);
				}
				JOptionPane.showMessageDialog(null, "suppression effectuer");
			}
		});
		supp.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\supp.png"));
		supp.setHorizontalAlignment(SwingConstants.LEFT);
		supp.setForeground(Color.WHITE);
		supp.setBounds(333, 372, 118, 35);
		contentPane.add(supp);
		
		JLabel sf = new JLabel("");
		sf.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\s_f.png"));
		sf.setBounds(206, 86, 190, 28);
		contentPane.add(sf);
		
		JLabel sr = new JLabel("");
		sr.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\s_r.png"));
		sr.setBounds(474, 86, 190, 28);
		contentPane.add(sr);
		
		JLabel back = new JLabel("");
		back.setIcon(new ImageIcon(Supprimer_Film.class.getResource("/projet/couleur(y).jpg")));
		back.setBounds(0, 0, 790, 455);
		contentPane.add(back);
		
		
	}

	protected void retour(MouseEvent arg0) {
		this.dispose();
		new Design().setVisible(true);
		
	}
	
	
	
	
	
	
	
}
