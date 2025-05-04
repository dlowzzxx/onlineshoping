package Servlet;

import java.io.IOException;
import java.util.List;
import DataAccessObject.ShportaBlerjesDataAccess;
import Model.Produkti;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/ShportaBlerjes")
public class ShportaBlerjes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShportaBlerjes() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
	    out.println("<head>");
	    out.println("<link href='css/style.css' type='text/css' rel='stylesheet'/>");
	   	out.println("<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>");
	   	out.println("<title>Online Shopping</title>");
	   	out.println("</head>");
	   
	   	out.println("<body>");
	   	out.println("<div class=\"sidebar\">");
	   	out.println("<div class = \"details\">");
	   	out.println("<i class='bx bx-copyright'></i>");
	   	out.println("<span>Paneli Perdoruesit</span>");
	   	out.println("</div>");
	   	
	   	out.println("<ul class=\"nav-links\">");
	   	out.println("<li>");
	   	out.println("<a href=\"ShportaBlerjes\">");
	   	out.println("<i class='bx bx-list-ul'></i>");
	   	out.println("<span>Shporta Blerjes</span>");
	   	out.println("</a>");
	   	out.println("</li>");
	   
	   	out.println("<li>");
	   	out.println("<a href=\"ShfaqProduktet\">");
	   	out.println("<i class='bx bx-home-smile'></i>");
	   	out.println("<span>Ballina</span>");
	   	out.println("</a>");
	   	out.println("</li>");
	   	
	   	out.println("<li>");
   		out.println("<a href='LogoutServlet'>");
   		out.println("<i class='bx bx-log-out'></i>");
	   	out.println("<span>Log out</span>");
	   	out.println("</a>");
	   	out.println("</li>");
	   	
	   	out.println("</ul>");
	   	out.println("</div>");
	   
	   	out.println("<section class=\"home\">");
	   	out.println("<nav>");
	   	out.println("</nav>");
	   	out.println("<div style = 'position: relative;\r\n"
	   			+ "	padding-top: 110px;\r\n"
	   			+ "	padding-left: 100px;'>");
	   	out.println("<h1 style = 'margin-left: 290px;\r\n"
	   			+ "	font-size: 24px;\r\n"
	   			+ "	text-transform: uppercase;\r\n"
	   			+ "	margin-bottom: 20px;'>Shporta Blerjes</h1>");
	   	
	   	List<Produkti> produktet = ShportaBlerjesDataAccess.listaProdukteve();
	   	out.println("<table border=1 width=90%>");  
        out.println("<tr style=\"height: 40px; color: #fff; background:#0b9d8a; text-align:center\"><th>Emri</th><th>Cmimi</th><th>Fshirja</th></tr>");  
        
	   	for(Produkti p : produktet)
	   	{
	   		out.println("<tr style=\"text-align:center; height: 40px\"><td>" + p.getEmri() + "</td><td>" + p.getSasia() +
					" Euro</td><td><a href = 'FshijShportaBlerjes?id=" +p.getId() + "'><i class ='bx bx-trash'></i></a></td></tr>"); 
	    }
	   	
	    out.println("</table>");  
		out.println("</div>"); 
		out.println("</section>");
		out.println("</html></body>");  
	}

}
