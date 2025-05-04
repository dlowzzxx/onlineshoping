package Servlet;

import java.io.IOException;
import java.util.Random;

import DataAccessObject.ShportaBlerjesDataAccess;
import Model.ShportaBlerjes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegjistroShportaBlerjes
 */
@WebServlet("/RegjistroShportaBlerjes")
public class RegjistroShportaBlerjes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegjistroShportaBlerjes() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		int rId = 120000;
		int randomId = random.nextInt(rId);
		String id = request.getParameter("id");
		int idProduktit = Integer.parseInt(id);

		HttpSession session = request.getSession(false);
		String emriP = null;
		
		if(session != null)
			emriP = (String) session.getAttribute("emriPerdoruesit");
		
		ShportaBlerjes shportaBlerjes = new ShportaBlerjes(randomId, idProduktit, emriP);
		int resultati = ShportaBlerjesDataAccess.ruaj(shportaBlerjes);
		System.out.println(emriP + idProduktit);
		if(resultati > 0)
		{
			response.sendRedirect("ShfaqProduktet");
		}
		else
		{
			response.sendRedirect("login.html");
		}
	}

}
