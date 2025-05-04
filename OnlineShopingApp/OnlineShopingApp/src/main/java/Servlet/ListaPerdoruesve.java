package Servlet;
import java.util.List;
import DataAccessObject.PerdoruesiDataAccess;
import Model.Perdoruesi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * Servlet implementation class ListaPerdoruesve
 */
@WebServlet("/ListaPerdoruesve")
public class ListaPerdoruesve extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListaPerdoruesve() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
	   	out.println("<span>Admin panel</span>");
	   	out.println("</div>");
	   	
	   	out.println("<ul class=\"nav-links\">");
	   	out.println("<li>");
	   	out.println("<a href=\"ListoProduktet\">");
	   	out.println("<i class='bx bx-list-ul'></i>");
	   	out.println("<span>Produktet</span>");
	   	out.println("</a>");
	   	out.println("</li>");
	   
	   	out.println("<li>");
	   	out.println("<a href=\"shtoProduktin.html\">");
	   	out.println("<i class='bx bx-add-to-queue'></i>");
	   	out.println("<span>Regjistro Produktin</span>");
	   	out.println("</a>");
	   	out.println("</li>");
	
	   	out.println("<li>");
	   	out.println("<a href='ListaPerdoruesve'>");
	   	out.println("<i class='bx bx-user'></i>");
	   	out.println("<span>Perdoruesit</span>");
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
	   	out.println("<h1 style = 'margin-left: 270px;\r\n"
	   			+ "	font-size: 24px;\r\n"
	   			+ "	text-transform: uppercase;\r\n"
	   			+ "	margin-bottom: 20px;'>Perdoruesi e Regjistruar</h1>");
	   	
	   	List<Perdoruesi> perdoruesit = PerdoruesiDataAccess.listaPerdoruesve();
	   	out.println("<table border=1 width=90%>");  
        out.println("<tr style=\"height: 40px; color: #fff; background:#0b9d8a; text-align:center\"><th>Emri</th><th>Mbiemri</th><th>Adresa</th><th>Email</th><th>Nr.Telefonit</th><th>Roli</th><th>Perditeso</th><th>Fshij</th></tr>");  
        
        for(Perdoruesi p: perdoruesit)
        {
        	out.println("<tr style=\"text-align:center; height: 40px\"><td>" + p.getEmri() + "</td><td>" + 
					p.getMbiemri() + "</td><td>" + p.getAdresa() +"</td><td>" + p.getEmail() + "</td><td>"+ p.getNrTelefonit() +
					"</td><td>"+p.getRoli() +"</td><td><a href = 'PerditesoPerdoruesinForm?id="+p.getId()+"'><i class ='bx bx-edit'></i></a></td><td><a href = 'FshijePerdoruesin?id="+p.getId()+"'><i class ='bx bx-trash'></i></a></td></tr>");   
	    
        }
        out.println("</table>");  
		out.println("</div>"); 
		out.println("</section>");
		out.println("</html></body>");  
	}

}
