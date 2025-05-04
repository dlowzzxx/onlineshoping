package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DataAccessObject.PerdoruesiDataAccess;
import Model.Perdoruesi;

/**
 * Servlet implementation class PerditesoPerdoruesin
 */
@WebServlet("/PerditesoPerdoruesin")
public class PerditesoPerdoruesin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PerditesoPerdoruesin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String emri = request.getParameter("emri");
		String mbiemri = request.getParameter("mbiemri");
		String adresa = request.getParameter("adresa");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String emriP = request.getParameter("emriPerdoruesit");
		String fjalekalimi = request.getParameter("fjalekalimi");
		
		Perdoruesi perdoruesi = new Perdoruesi(id, emri, mbiemri, adresa, email, tel, emriP, fjalekalimi);
		PerdoruesiDataAccess.perditeso(perdoruesi);
		response.sendRedirect("ListaPerdoruesve");
		
		pw.close();
	}

}
