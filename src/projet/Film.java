package projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Film {

	private int id,id_r;
	private String titre;
	private double prix;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_r() {
		return id_r;
	}
	public void setId_r(int id_r) {
		this.id_r = id_r;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public void insert(String titre,double prix,int id_r, String type)
	{
		Statement stm;
		PreparedStatement stmt = null;	
		try {
			stm = Main.connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM film where id_realisateur ="+id_r+" AND titre ='"+titre+"'");
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "titre existe deja pour ce realisateur");
				return;
			}else{
			
			stmt = Main.connection.prepareStatement("insert into Film values(null,'"+titre+"',"+prix+","+id_r+",'"+type+"')");
			stmt.executeUpdate();}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void sup_film(String titre,int id)
	{
		Statement stm;
		try {
			if(titre != null){
				stm = Main.connection.createStatement();
				stm.executeUpdate("DELETE FROM Film WHERE titre='"+titre+"' AND "+" id_realisateur = "+id);
			}
			else{
				stm = Main.connection.createStatement();
				stm.executeUpdate("DELETE FROM Film WHERE id_realisateur = "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet select()
	{
		Statement stm;
		try {
			stm = Main.connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM film");
			return(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return(null);
	}
	
}
