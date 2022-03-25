package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Staff;
import utility.ConnectionClass;

public class StaffDao {
	
    public static Connection getConnection(){  
        Connection con=null;  

        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inxdb","root","");  
        }
        catch(Exception e)
        {
        	System.out.println(e);
  
        }
        return con;  
    }  
    @SuppressWarnings("unused")
	public static int insert(Staff staff)
    {
    	int status = 0;
    	InputStream file = null;
    	try {
    		Connection con = StaffDao.getConnection();
    		PreparedStatement ps = con.prepareStatement("insert into user (firstname,middlename,lastname,gender,dob,email,password,mobile_number,picture,security_ans) values (?,?,?,?,STR_TO_DATE(?,'%m/%d/%Y'),?,?,?,?,?)");
    		//ps.setInt(1, staff.getId());
    		ps.setString(1, staff.getFirstname());
    		ps.setString(2, staff.getMiddlename());
    		ps.setString(3, staff.getLastname());
    		ps.setString(4, staff.getGender());
    		ps.setString(5, staff.getDob());
    		ps.setString(6, staff.getEmail());
    		ps.setString(7, staff.getPassword());
    		ps.setString(8, staff.getMobile_number());
    		//ps.setString(9, staff.getPicture());
    		ps.setString(10, staff.getSecurity_answer());
    		
    		if(file != null)
    		{
    			ps.setBlob(9, staff.getPicture());
    		}
    		
    		
    		status = ps.executeUpdate();
    		
    		con.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return status;
    }
}
	



