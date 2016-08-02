package projet;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static Connection connection = null;
	public static Connection connect()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			connection  = DriverManager.getConnection("jdbc:sqlite:bd_projet1.sqlite");
		
	
		} catch (Exception e) {
			e.printStackTrace();
		}
return connection;
	}
		
	public static void main(String[] args) {

	connect();

		new Design().setVisible(true);
		
	}

}
