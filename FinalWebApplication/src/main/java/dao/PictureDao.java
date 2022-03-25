package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PictureDao {

	
	PictureDao pdao = new PictureDao();
	
	public Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inxdb","root","");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;
	}
	
	public void insertImage() {
		Connection con = null;
		
		PreparedStatement ps = null;
		FileInputStream fis = null;

		
		
		
		
		
		
		
		
		
	}
}
