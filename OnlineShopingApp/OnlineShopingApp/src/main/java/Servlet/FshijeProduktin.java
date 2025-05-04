package Servlet;

import java.io.IOException;

import DataAccessObject.ProduktiDataAccess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FshijeProduktin")
public class FshijeProduktin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FshijeProduktin() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int ID = Integer.parseInt(id);
		ProduktiDataAccess.fshij(ID);
		response.sendRedirect("ListoProduktet");
	}
}
