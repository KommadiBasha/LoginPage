package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/index")
public class RegistrationFrom extends GenericServlet
{
		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
		{
			String name = req.getParameter("myname");
			String password = req.getParameter("password");
			String dob = req.getParameter("date");
			String address = req.getParameter("gmail");
			String gmail = req.getParameter("address");
			String gender =req.getParameter("gender");
			String phone = req.getParameter("number");
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/webpageprojecta","root","root");
				PreparedStatement ps= con.prepareStatement("insert into studentloginservlets values(?,?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setString(3, dob);
				ps.setString(4, address);
				ps.setString(5, gmail);
				ps.setString(6, gender);
				ps.setString(7, phone);
				
				ps.executeUpdate();
				
				RequestDispatcher rd= req.getRequestDispatcher("login.html");
				
				rd.forward(req, res);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
}
