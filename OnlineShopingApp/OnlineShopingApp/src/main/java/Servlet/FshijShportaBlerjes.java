package Servlet;

import java.io.IOException;
import DataAccessObject.ShportaBlerjesDataAccess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FshijShportaBlerjes
 */
@WebServlet("/FshijShportaBlerjes")
public class FshijShportaBlerjes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FshijShportaBlerjes() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int ID = Integer.parseInt(id);
		ShportaBlerjesDataAccess.fshij(ID);
		response.sendRedirect("ShportaBlerjes");
	}

}
