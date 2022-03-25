package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.StaffDao;
import model.Staff;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
@MultipartConfig
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
HttpSession session = request.getSession(false);

//if(session == null)
//{
			Part filepart = request.getPart("picture");
			InputStream inputStream = filepart.getInputStream();

			String fname =request.getParameter("firstname");
			String mname = request.getParameter("middlename");
			String lname = request.getParameter("lastname");
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String mob_number = request.getParameter("mobile_number");
			//Blob picture = request.getparameter("picture");
			String sec_ans = request.getParameter("security_answer");
						
			Staff staff = new Staff();
			staff.setFirstname(fname);
			staff.setMiddlename(mname);
			staff.setLastname(lname);
			staff.setGender(gender);
			staff.setDob(dob);
			staff.setEmail(email);
			staff.setPassword(password);
			staff.setMobile_number(mob_number);
			staff.setPicture(inputStream);
			staff.setSecurity_answer(sec_ans);
			
			int status = StaffDao.insert(staff);
			if(status>0)
			{
				System.err.println("<p> Record Saved Successfully</p>");
				request.getRequestDispatcher("index.html").include(request, response);
				
			}
			else
			{
				System.err.println("Sorry! unable to save record !!!");
			}
			
		//}
	}

}
