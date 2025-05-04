package Servlet;
import java.io.IOException;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
	  response.setContentType("text/html");
	  PrintWriter out = response.getWriter(); 
	  
	  String username = request.getParameter("emriPerdoruesit");
	  String password = request.getParameter("fjalekalimi");

	  try {
		  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		  String url = "jdbc:ucanaccess://C://Users//G1PraktikaXI6//eclipse-workspace//OnlineShopingApp//DB//ShitjaProdukteveOnline.accdb";
			
		  Connection conn = DriverManager.getConnection(url);
PreparedStatement pst = conn.prepareStatement("Select * from Perdoruesi where emriPerdoruesit=? and fjalekalimi=?");
		  
		  pst.setString(1, username);
		  pst.setString(2, password);
		  
		  ResultSet rs = pst.executeQuery();
		   
		  if (rs.next()) 
		  {
			  String eP = rs.getString("emriPerdoruesit");
			  String f = rs.getString("fjalekalimi");
			  String r = rs.getString("roli");
		  		
			  if(eP.equals(username) && f.equals(password) && r.equals("admin"))
			  {
				  HttpSession session = request.getSession(true); 
				  session.setAttribute("emriPerdoruesit", username);
				  response.sendRedirect("admin.html");
			  }
			  else if(eP.equals(username) && f.equals(password) && r.equals("perdorues"))
			  {
				  HttpSession session = request.getSession(true); 
				  session.setAttribute("emriPerdoruesit", username);
				  response.sendRedirect("perdoruesi.html");
			  }
			  else
			  {
				  out.println("Emri i perdoruesit, fjalekalimi ose roli i perdoruesit jane gabim!");
			  }
		  } 
		  else 
		  {
			  out.println("Username or Password incorrect");
		  }
	  } 
	  catch (ClassNotFoundException | SQLException e) 
	  {
	   	out.print("Error");
	  }
 	}
}