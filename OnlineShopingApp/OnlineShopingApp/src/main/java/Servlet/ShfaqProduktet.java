package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.io.*;
import DataAccessObject.ProduktiDataAccess;
import Model.Produkti;

@WebServlet("/ShfaqProduktet")
public class ShfaqProduktet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShfaqProduktet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
	    out.println("<head>");
	    out.println("<link href='css/home-page-style.css' type='text/css' rel='stylesheet'/>");
	    
	   	out.println("<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>");
	  
	   	out.println("<link rel=\"stylesheet\" href=\"css/lightslider.css\">");
	   	out.println("<script src=\"js/Jquery.js\"></script>");
	   	out.println("<script src=\"js/lightslider.js\"></script>");
	   	
	   	out.println("<title>Online Shopping</title>");
	   	out.println("</head>");
	   
	   	out.println("<body>");
	   	
	   	//Header	   	
	   	out.println("<nav>");
	   	out.println("<div class = 'navigation'>");
	   	out.println("<a href = 'ShfaqProduktet' class='logo'>LOGO - ONLINE SHOPING</a>");
	   	
	   	out.println("<ul class='menu'>");
	   	out.println("<li><a href='ShfaqProduktet'>Ballina</a></li>");
	   	out.println("<li><a href='#'>Teknologji</a></li>");
	   	out.println("<li><a href='#'>Libra</a></li>");
	   	out.println("<li><a href='#'>Aksesore</a></li>");
	   	out.println("<li><a href='#'>Veshje</a></li>");
	   	out.println("</ul>");
	   	
	   	out.println("<div class = 'right-menu'>");

	   	HttpSession session = request.getSession(false);
	   	
	   	if(session != null) {
	   		out.println("<a href='LogoutServlet'><i class='bx bx-log-out'></i></a>");
   		}
	   	else
	   	{
	   		out.println("<a href='login.html'><i class='bx bx-user'></i></a>");
	   	}
	   	
		if(session != null) {
			out.println("<a href='ShportaBlerjes'><i class='bx bx-shopping-bag'></i></a>");
   		}
	   	else
	   	{
	   		out.println("<a href='login.html'><i class='bx bx-shopping-bag'></i></a>");
	   	}
	   	
	   	out.println("</div>");
	   	
	   	out.println("</div>");
	   	out.println("</nav>");
	   	
	   	//Slideri
	   	out.println("<ul id = 'adaptive' class = 'cs-hidden'>");
	   	out.println("<li class = 'item-a'>");
	   	out.println("<div class = 'full-slider-box f-slide-1'>");
	   	out.println("<div class = 'f-slider-text-container'>");
	   	out.println("<div class='f-slider-text'>");
	   	out.println("<span>Oferte</span>");
	   	out.println("<strong> 20% Zbritje</strong>");
	   	out.println("</div>");
	   	out.println("</div>");
	   	out.println("</div>");
	   	out.println("</li>");
	   	
		out.println("<li class = 'item-b'>");
	   	out.println("<div class = 'full-slider-box f-slide-2'>");
	   	out.println("<div class = 'f-slider-text-container'>");
	   	out.println("<div class='f-slider-text'>");
	   	out.println("<span>Oferte</span>");
	   	out.println("<strong> 50% Zbritje</strong>");
	   	out.println("</div>");
	   	out.println("</div>");
	   	out.println("</div>");
	   	out.println("</li>");

		out.println("<li class = 'item-c'>");
	   	out.println("<div class = 'full-slider-box f-slide-3'>");
	   	out.println("<div class = 'f-slider-text-container'>");
	   	out.println("<div class='f-slider-text'>");
	   	out.println("<span>Oferte</span>");
	   	out.println("<strong> 80% Zbritje</strong>");
	   	out.println("</div>");
	   	out.println("</div>");
	   	out.println("</div>");
	   	out.println("</li>");
	   	out.println("</ul>");
	   	
	   	//Produktet
	   	out.println("<section class='korniza-produkteve'>");
	   	out.println("<div class = 'produktet'>");
	   	out.println("<strong>Produktet ne stok</strong>");
	   	out.println("</div>");
	   	out.println("<div class='hapsira-produkteve'>");
	    
	   	List<Produkti> produktet = ProduktiDataAccess.listaProdukteve();
	   	
	   	for(Produkti p : produktet)
	   	{ 
		   	out.println("<div class = 'produkti'>"); 
		   	out.println("<div class = 'produkti-img'>");
			out.println("<a href = 'RegjistroShportaBlerjes?id=" +  p.getId() +"'class = 'shporta-blerjes'><i class = 'bx bx-shopping-bag'></i></a>");
		   	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
		   	out.println("<img src='" + basePath + "img/" + p.getFoto() +"'>");
		   	out.println("</div>");
		   	out.println("<div class = 'produkti-detajet'>");
		   	out.println("<span>"+ p.getEmri() + "</span>");
		   	out.println("<span class = 'produkti-cmimi'>" + p.getSasia() + " Euro</span>");
		   	out.println("</div>");
		   	out.println("</div>");
	   	}
	   	
	   	out.println("</div>");
	   	out.println("</section>");
	   	
	   	//Sherbimet
	   	out.println("<section class='services'>");
		out.println("<div class='services-box'>");
	   	out.println("<i class='bx bx-package'></i>");
		out.println("<span>Transporti Falas</span>");
		out.println("<p>Transporti falas per gjitha porosite</p>");
		out.println("</div>");

		out.println("<div class='services-box'>");
		out.println("<i class='bx bx-phone'></i>");
		out.println("<span>Mbeshtejte 24/7</span>");
		out.println("<p>Ne ju mbeshtetim 24h dhe 7 dite ne jave</p>");
		out.println("</div>");

		out.println("<div class='services-box'>");
		out.println("<i class='bx bx-sync'></i>");
		out.println("<span>100% Kthimi i parave</span>");
		out.println("<p>Keni 30 dite per te kthyer porosine</p>");
		out.println(" </div>");
		out.println("</section>");
		
	   	//Footeri
		out.println("<footer>");
		out.println("<span class='copyright'>");
		out.println("Copyright 2022 - Online Shopping");
		out.println("</span>");
		out.println("</footer>");
									
		//Slider 
	   	out.println("<script type=\"text/javascript\">");
	   	out.println("$(document).ready(function() {\r\n"
	   			+ "		  $('#adaptive').lightSlider({\r\n"
	   			+ "		      adaptiveHeight:true,\r\n"
	   			+ "		      auto:true,\r\n"
	   			+ "		      item:1,\r\n"
	   			+ "		      slideMargin:0,\r\n"
	   			+ "		      loop:true,\r\n"
	   			+ "		      pauseOnHover: true\r\n"
	   			+ "		  });\r\n"
	   			+ "		});");
	   	out.println("</script>");

	   	out.println("</body>");
	   	out.println("</html>");
	   	
	}

}
