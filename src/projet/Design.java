package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class Design extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Design frame = new Design();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Design() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Ajouter = new JLabel("");
		Ajouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				Ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\ajouter22.png"));

			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Ajouter.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\ajouter11.png"));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ajout(arg0);
			}
		});
		Ajouter.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\ajouter11.png"));
		Ajouter.setBounds(215, 144, 355, 50);
		contentPane.add(Ajouter);
		
		JLabel Supprimer = new JLabel("");
		Supprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Supprimer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\sup2.png"));
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Supprimer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\sup1.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				supp(arg0);
			}
		});
		Supprimer.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\sup1.png"));
		Supprimer.setBounds(215, 223, 355, 50);
		contentPane.add(Supprimer);
		
		JLabel Vente = new JLabel("");
		Vente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Vente.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\vente2.png"));

			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Vente.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\vente1.png"));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vente1(arg0);
			}
		});
		Vente.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\vente1.png"));
		Vente.setBounds(215, 301, 355, 50);
		contentPane.add(Vente);
		
		JLabel stat = new JLabel("");
		stat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				stat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\stat2.png"));

			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				stat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\stat1.png"));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				graph(arg0);
			}
		});
		stat.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\stat1.png"));
		stat.setBounds(215, 380, 355, 50);
		contentPane.add(stat);
		
		JLabel nom = new JLabel("");
		nom.setIcon(new ImageIcon("C:\\Users\\Hatem\\workspace\\projet\\src\\projet\\abc.png"));
		nom.setBounds(72, 11, 638, 105);
		contentPane.add(nom);
		
		JLabel back = new JLabel("");
		back.setIcon(new ImageIcon(Design.class.getResource("/projet/couleur(y).jpg")));
		back.setBounds(0, 0, 790, 455);
		contentPane.add(back);
	}



	protected void vente1(MouseEvent arg0) {
		this.dispose();
		new Vente_Film().show();
		
	}

	protected void supp(MouseEvent arg0) {
		this.dispose();
		new Supprimer_Film().show();
	}

	protected void ajout(MouseEvent arg0) {
		this.dispose();
		new Ajouter_Film().show();
	}

	protected void graph(MouseEvent arg0) {
		//this.dispose();
		//new graphe().show();
	Statement stmt;
		
		try {
			
			stmt = Main.connection.createStatement();
			String SQL = "select id_film from Vente";
		    ResultSet rs = stmt.executeQuery(SQL);
		    int s=0;
		    while(rs.next())
		    {
		    	StringTokenizer st=new StringTokenizer(rs.getString("id_film"),"/");
		    	 s=Integer.parseInt(st.nextToken());
			
			
		    }
		    
		    String query="SELECT id_film,total FROM Vente";
			
			JDBCCategoryDataset dataset= new JDBCCategoryDataset(Main.connect(),query);
			JFreeChart chart =ChartFactory.createBarChart("Statestiques", "vente", "prix", dataset, PlotOrientation.VERTICAL, false, true, false);
			BarRenderer render=null;
			CategoryPlot plot=null;
			render=new BarRenderer();

			ChartFrame frame =new ChartFrame("Statestiques", chart);
			frame.setVisible(true);
			frame.setSize(400, 650);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
