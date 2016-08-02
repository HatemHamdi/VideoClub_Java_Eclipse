package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Vente_Film extends JFrame {

	private JPanel contentPane;
	private JTable table_film;
	private JTable facture;
	private JTextField total;
	private JTextField rech;
	DefaultTableModel model_fournisseur;
	DefaultTableModel model_facture;
	double somme=0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vente_Film frame = new Vente_Film();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Vente_Film() {
		
		
		
		
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_film = new JTable();
		table_film.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouse(arg0);
			}
		});
		table_film.setBounds(10, 89, 393, 344);
		contentPane.add(table_film);
		
		facture = new JTable();
		facture.setBounds(413, 89, 356, 229);
		contentPane.add(facture);
		
		JLabel lblRechercheSelon = new JLabel("");
		lblRechercheSelon.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\recherche.png"));
		lblRechercheSelon.setBounds(20, 17, 132, 30);
		contentPane.add(lblRechercheSelon);
		
		JLabel Films = new JLabel("");
		Films.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\films1.png"));
		Films.setBounds(114, 64, 183, 14);
		contentPane.add(Films);
		
		total = new JTextField();
		total.setText("0.0");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setForeground(SystemColor.window);
		total.setOpaque(false);
		total.setBorder(null);
		total.setBounds(687, 329, 82, 30);
		contentPane.add(total);
		total.setColumns(10);
		
		JLabel Total1 = new JLabel("");
		Total1.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\totale.png"));
		Total1.setBounds(595, 329, 82, 30);
		contentPane.add(Total1);
		
		
		
		
		
		
		 model_facture= new DefaultTableModel();
		 model_facture.addColumn("id film");
		 model_facture.addColumn("titre");
		 model_facture.addColumn("prix");
		 model_facture.addColumn("id realisateur");
		 model_facture.addColumn("type");
		 String k[]= new String[5];
	        k[0] = "id film";
	        k[1] = "titre";
	        k[2] = "prix";
	        k[3] = "id realisateur";
	        k[4] = "type";
	        model_facture.addRow((String[]) k);
	       facture.setModel(model_facture);
	        
		
		try 
		{
		    model_fournisseur = new DefaultTableModel();
		    model_fournisseur.addColumn("id film");
		    model_fournisseur.addColumn("titre");
		    model_fournisseur.addColumn("prix");
		    model_fournisseur.addColumn("id realisateur");
		    model_fournisseur.addColumn("type");
		   // model_fournisseur.addColumn("");
		    Statement stmt = Main.connection.createStatement();
		    String SQL = "select * from Film";
		    ResultSet rs = stmt.executeQuery(SQL);

	        String a[]= new String[6];
	        a[0] = "id film";
	        a[1] = "titre";
	        a[2] = "prix";
	        a[3] = "id realisateur";
	        a[4] = "type";
	        //a[5] = "";
	        model_fournisseur.addRow((String[]) a);

		    
		    while (rs.next())
		    {
		        String O[]= new String[5];
		        O[0] = (String) rs.getString(1);
		        O[1] = (String) rs.getString(2);
		        O[2] = (String) rs.getString(3);
		        O[3] = (String) rs.getString(4);
		        O[4] = (String) rs.getString(5);
		       
		        model_fournisseur.addRow((String[]) O);
		    }
		    table_film.setModel(model_fournisseur);
		    
		    rech = new JTextField();
		    rech.setBorder(null);
		    rech.setOpaque(false);
		    rech.addKeyListener(new KeyAdapter() {
		    	@Override
		    	public void keyReleased(KeyEvent arg0) {
		    		key(arg0);
		    	}
		    });
		    rech.setBounds(167, 23, 177, 20);
		    contentPane.add(rech);
		    rech.setColumns(10);
		    
		    
		    
		
		}
		
		catch (SQLException ex) 
		{
		    System.out.println(ex);
		}
		
JLabel bouton = new JLabel("Retour au Menu");
		
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
		
		JLabel text = new JLabel("");
		text.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\text.png"));
		text.setBounds(152, 13, 211, 40);
		contentPane.add(text);
		
		JLabel tot = new JLabel("");
		tot.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\totalll.png"));
		tot.setBounds(687, 329, 82, 30);
		contentPane.add(tot);
		
		JLabel valider = new JLabel("");
		valider.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				valider.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\valider.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				valider.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\valider1.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s="";
				int i; 
				double t;
				for(i=1 ; i<facture.getRowCount()-1;i++){
		         	
		         	//System.out.println("df :"+facture.getCellRenderer(i, 0)..toString());
		         	
		         	s=s+facture.getValueAt(i,0).toString()+"/";
		         	
		         	
		         }
		      	s=s+facture.getValueAt(i,0).toString();
		        t=Double.parseDouble(total.getText());
		        PreparedStatement stmt;
		        try {
		        	stmt = Main.connection.prepareStatement("insert into Vente values('"+s+"',null,"+t+",current_timestamp)");
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vente effectuer");
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
		});
		valider.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\valider1.png"));
		valider.setHorizontalAlignment(SwingConstants.LEFT);
		valider.setForeground(Color.WHITE);
		valider.setBounds(543, 391, 118, 35);
		contentPane.add(valider);
		
		JLabel facture1 = new JLabel("");
		facture1.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\facture.png"));
		facture1.setBounds(500, 64, 183, 14);
		contentPane.add(facture1);
		
		JLabel back = new JLabel("");
		back.setIcon(new ImageIcon(Vente_Film.class.getResource("/projet/couleur(y).jpg")));
		back.setBounds(0, 0, 790, 455);
		contentPane.add(back);
		
		
	}

	protected void retour(MouseEvent arg0) {
		this.dispose();
		new Design().setVisible(true);
		
	}
	

	


	protected void mouse(MouseEvent arg0) {
		int row = table_film.rowAtPoint(arg0.getPoint());
		System.out.println(row);
		
		
	       
	        
	        String b[]= new String[5];
	        b[0] = table_film.getValueAt(row,0).toString();
	        b[1] = table_film.getValueAt(row,1).toString();
	        b[2] = table_film.getValueAt(row,2).toString();
	        b[3] = table_film.getValueAt(row,3).toString();
	        b[4] = table_film.getValueAt(row,4).toString();

            //int[] rows = facture..getSelectedRows();

            //System.out.println("row :"+rows[0]);
            for(int i=1 ; i<facture.getRowCount();i++){
            	
            	//System.out.println("df :"+facture.getCellRenderer(i, 0)..toString());
            	
            	if(Integer.parseInt(facture.getValueAt(i,0).toString())==Integer.parseInt(b[0]))
            		return;
            	
            	System.out.println("df :"+facture.getValueAt(i,0));
            }
	       somme=somme+Double.parseDouble(b[2]);
	       total.setText(""+somme);
	        model_facture.addRow((String[]) b);
	       facture.setModel(model_facture);
		 
		 
System.out.println(table_film.getValueAt(row,0).toString());
		
	}

	protected void key(KeyEvent arg0) {
	
		model_fournisseur= new DefaultTableModel();
		 model_fournisseur.addColumn("id film");
		    model_fournisseur.addColumn("titre");
		    model_fournisseur.addColumn("prix");
		    model_fournisseur.addColumn("id realisateur");
		    model_fournisseur.addColumn("type");
		   // model_fournisseur.addColumn("");
		
		  Statement stmt;
		try {
			stmt = Main.connection.createStatement();
			String SQL = "select * from Film where id_film like '%"+rech.getText().toString()+"%' or titre like'%"+rech.getText().toString()+"%' or prix like '%"+rech.getText().toString()+"%' or id_realisateur like '%"+rech.getText().toString()+"%' or type like'%"+rech.getText().toString()+"%'";
		    ResultSet rs = stmt.executeQuery(SQL);

	        String a[]= new String[5];
	        a[0] = "id film";
	        a[1] = "titre";
	        a[2] = "prix";
	        a[3] = "id realisateur";
	        a[4] = "type";
	        //a[5] = "";
	        model_fournisseur.addRow((String[]) a);

		    
		    while (rs.next())
		    {
		    	
		        String O[]= new String[5];
		        O[0] = (String) rs.getString(1);
		        O[1] = (String) rs.getString(2);
		        O[2] = (String) rs.getString(3);
		        O[3] = (String) rs.getString(4);
		        O[4] = (String) rs.getString(5);

		        model_fournisseur.addRow((String[]) O);
		        
		    }
		    table_film.setModel(model_fournisseur);
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		
	}
	
	
	
}
