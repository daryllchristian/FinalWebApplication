package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;

public class DatabaseConnection {
		public static Connection getConnection() throws SQLException, IOException{
			Connection con = null;
			
			String insert = "insert into user (user_id,firstname,middlename,lastname,gender,dob,email,password,mobile_number,picture,security_ans) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				
				PreparedStatement ps = con.prepareStatement(insert);
				ps.setInt(1,1);
				
				System.out.println("Connection is established");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			return con;
		}
}
