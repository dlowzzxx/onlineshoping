package Servlet;

import java.io.IOException;

import DataAccessObject.PerdoruesiDataAccess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FshijePerdoruesin
 */
@WebServlet("/FshijePerdoruesin")
public class FshijePerdoruesin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FshijePerdoruesin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int ID = Integer.parseInt(id);
		PerdoruesiDataAccess.fshij(ID);
		response.sendRedirect("ListaPerdoruesve");
	}

}
