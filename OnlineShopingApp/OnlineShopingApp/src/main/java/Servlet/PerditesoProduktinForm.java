package Servlet;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PerditesoProduktinForm")
public class PerditesoProduktinForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PerditesoProduktinForm() {
        // TODO Auto-generated constructor stub
    }

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
		pw.println("<a href ='#'>");
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
Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
String url = "jdbc:ucanaccess://C://Users//G1PraktikaXI6//eclipse-workspace//OnlineShopingApp//"
		+ "DB//ShitjaProdukteveOnline.accdb";
		
			Connection conn = DriverManager.getConnection(url);
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM produktet WHERE ID = "+ID);
			
			if(rs.next())
			{
				String emri = rs.getString("emri");
				String kodi = rs.getString("kodi");
				String detajet = rs.getString("detajet");
				String cmimi = rs.getString("cmimi");
				String sasia = rs.getString("sasia");
//				String foto = rs.getString("foto");
				
				pw.println("<div class = \"shto-produktin\">");
				pw.println("<h1>Perditeso Produktin</h1>");
				pw.println("<form method = 'post' action = 'PerditesoProduktin'>");
				pw.println("<input type = \"hidden\" name =\"id\" value = '" + id + "'/>");
				pw.println("<input type = \"text\" name =\"emri\" value = '" + emri + "'/>");
				pw.println("<input type = \"text\" name =\"kodi\" value = '" + kodi + "'/>");
				pw.println("<input type = \"text\" name =\"detajet\" value = '" + detajet + "'/>");
				pw.println("<input type = \"text\" name =\"cmimi\" value = '" + cmimi + "'/>");
				pw.println("<input type = \"text\" name =\"sasia\" value = '" + sasia + "'/>");
//				pw.println("<input type = \"hidden\" name =\"foto\"value = '" + foto + "'/>");
		pw.println("<button type = \"submit\" formaction='PerditesoProduktin'>Perditeso Produktin"
				+ "</button>");
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			pw.println(e);
		}
    }
}
