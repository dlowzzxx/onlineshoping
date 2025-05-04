package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataAccessObject.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerditesoPerdoruesinForm
 */
@WebServlet("/PerditesoPerdoruesinForm")
public class PerditesoPerdoruesinForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PerditesoPerdoruesinForm() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<!DOCTYPE html>");
		pw.println("<head>");
		pw.println("<title>Online Shopping </title>");
		pw.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
		pw.println("<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<div class = 'sidebar'>");
		pw.println("<div class = 'details'>");
		pw.println("<i class = 'bx bx-copyright'></i>");
		pw.println("<span>Admin panel</span>");
		pw.println("</div>");
		
		pw.println("<ul class = 'nav-links'>");
		pw.println("<li>");
		pw.println("<a href ='ListoProduktet'>");
		pw.println("<i class='bx bx-list-ul'></i>");
		pw.println("<span>Produktet</span>");
		pw.println("</a>");
		pw.println("</li>");
		
		pw.println("<li>");
		pw.println("<a href ='shtoProduktin.html'>");
		pw.println("<i class='bx bx-add-to-queue'></i>");
		pw.println("<span>Shto Produktin</span>");
		pw.println("</a>");
		pw.println("</li>");
		
		pw.println("<li>");
		pw.println("<a href ='ListaPerdoruesve'>");
		pw.println("<i class='bx bx-user'></i>");
		pw.println("<span>Perdoruesit</span>");
		pw.println("</a>");
		pw.println("</li>");
		
		pw.println("<li>");
	   	pw.println("<a href=\"ShfaqProduktet\">");
	   	pw.println("<i class='bx bx-home-smile'></i>");
	   	pw.println("<span>Ballina</span>");
	   	pw.println("</a>");
	   	pw.println("</li>");
		
		pw.println("<li>");
   		pw.println("<a href='LogoutServlet'>");
   		pw.println("<i class='bx bx-log-out'></i>");
	   	pw.println("<span>Log out</span>");
	   	pw.println("</a>");
	   	pw.println("</li>");
		pw.println("</ul>");
		pw.println("</div>");
		pw.println("<section class = 'home'>");
		pw.println("<nav>");
		pw.println("</nav>");
		
		String id = request.getParameter("id");
		int ID = Integer.parseInt(id);
		
		try
		{
			Connection conn = DB.getCon();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Perdoruesi WHERE ID = "+ID);
			
			if(rs.next())
			{
				String emri = rs.getString("emri");
				String mbiemri = rs.getString("mbiemri");
				String adresa = rs.getString("adresa");
				String email = rs.getString("email");
				String tel = rs.getString("telefoni");
				String emriP = rs.getString("emriPerdoruesit");
				String fjalekalimi = rs.getString("fjalekalimi");
				
				pw.println("<div class = \"shto-produktin\">");
				pw.println("<h1>Perditeso Perdoruesin</h1>");
				pw.println("<form method = 'post' action = 'PerditesoPerdoruesin'>");
				pw.println("<input type = \"hidden\" name =\"id\" value = '" + id + "'/>");
				pw.println("<input type = \"text\" name =\"emri\" value = '" + emri + "'/>");
				pw.println("<input type = \"text\" name =\"mbiemri\" value = '" + mbiemri + "'/>");
				pw.println("<input type = \"text\" name =\"adresa\" value = '" + adresa + "'/>");
				pw.println("<input type = \"text\" name =\"email\" value = '" + email + "'/>");
				pw.println("<input type = \"text\" name =\"tel\" value = '" + tel + "'/>");
				pw.println("<input type = \"text\" name =\"emriPerdoruesit\" value = '" + emriP + "'/>");
				pw.println("<input type = \"text\" name =\"fjalekalimi\" value = '" + fjalekalimi + "'/>");
				pw.println("<button type = \"submit\" formaction='PerditesoPerdoruesin'>Perditeso</button>");
			}
		}
		catch (SQLException e)
		{
			pw.println(e);
		}
    }
}
