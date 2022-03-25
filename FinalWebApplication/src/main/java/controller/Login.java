package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet{

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	    }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(LoginDao.validate(email,password))
		{
			RequestDispatcher rd = request.getRequestDispatcher("welcome.html"); //welcome page after login
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Incorrect email id and password");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}
	    }
	 
	 
}
