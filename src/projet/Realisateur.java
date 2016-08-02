package projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Realisateur {
	
	
	
	private int id;
	private String nom;
	private String prenom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void insert(String nom,String prenom){
		PreparedStatement stmt = null;
		Statement stm;
		try {
			
			stm = Main.connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM Realisateur where nom = '"+nom+"' AND prenom ='"+prenom+"'");
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "realisateur existe deja");
				return;
			}else{
			
			stmt = Main.connection.prepareStatement("insert into Realisateur values(null,'"+nom+"','"+prenom+"')");
			stmt.executeUpdate();}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//x++;
		//stmt.setString(1,chaine2);
		
	}
	
	public int get_last_id(){
		
		try {
			Statement stm=Main.connection.createStatement();
			//stm = Main.connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT id_realisateur FROM realisateur order by id_realisateur desc");
			rs.next();
			return rs.getInt("id_realisateur");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int get_id(){
		Statement stm;
		try {
			stm = Main.connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT id_realisateur FROM realisateur where nom = '"+this.nom+"' and prenom = '"+this.prenom+"'");
			rs.next();
			return rs.getInt("id_realisateur");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet select()
	{
		Statement stm;
		try {
			stm = Main.connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM realisateur");
			return(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return(null);
	}
	public void sup_rel(String nom,String prenom)
	{
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setId(this.get_id());
		Statement stm;
		try {
			stm = Main.connection.createStatement();
			stm.executeUpdate("delete FROM film where id_realisateur = "+this.id);
			stm.executeUpdate("delete FROM realisateur where id_realisateur = "+this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
