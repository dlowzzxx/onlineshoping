package Servlet;

import java.io.IOException;

import DataAccessObject.ProduktiDataAccess;
import Model.Produkti;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/PerditesoProduktin")
public class PerditesoProduktin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PerditesoProduktin() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String emri = request.getParameter("emri");
		String kodi = request.getParameter("kodi");
		String detajet = request.getParameter("detajet");
		int cmimi = Integer.parseInt(request.getParameter("cmimi"));
		int sasia = Integer.parseInt(request.getParameter("sasia"));
		
		Produkti produkti = new Produkti(id, emri, kodi, detajet, cmimi, sasia);
		ProduktiDataAccess.perditeso(produkti);
		response.sendRedirect("ListoProduktet");
		
		pw.close();
	}

}
