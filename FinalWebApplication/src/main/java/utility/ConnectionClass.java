package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	private static ConnectionClass instance = null;
	
	private static String username = "root";
	private static String password = "";
	private static String databasename = "inxdb";
	private static String url = "jdbc:mysql://localhost:3306/inxdb" +databasename;
	
	private Connection con = null;
	
	public static ConnectionClass getInstance() {
		if(instance == null)
		{
			instance = new ConnectionClass();
		}
		return instance;
	}
	private boolean OpenConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			return true;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.err.println("Error"+e);
			return false;
		}
	}
	
	public Connection geConnection() {
		if(con == null)
		{
			if(OpenConnection()) {
				System.out.println("Connection opened");
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	public void close()
	{
		System.out.println("Closing connection");
		try {
			con.close();
			con=null;
			
		}
		catch(Exception e) {
			
		}
	}
}
