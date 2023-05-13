package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/login")
public class Login extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name = req.getParameter("myname");
		String password = req.getParameter("password");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/webpageprojecta","root","root");
			PreparedStatement ps= con.prepareStatement("select * from  studentloginservlets where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				RequestDispatcher rd =req.getRequestDispatcher("Homepage.html");
				rd.forward(req, res);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
			pw.print("<h2>Incorrect E-mail or Password </h2>");
			RequestDispatcher rd= req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
}
