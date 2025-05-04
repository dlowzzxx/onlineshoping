package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import DataAccessObject.PerdoruesiDataAccess;
import Model.Perdoruesi;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class RegjistroPerdoruesin
 */
@WebServlet("/RegjistroPerdoruesin")
public class RegjistroPerdoruesin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegjistroPerdoruesin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Random rand  = new Random();
		int rId = 20000;
		
		int id = rand.nextInt(rId);
		String emri = request.getParameter("emri");
		String mbiemri = request.getParameter("mbiemri");
		String adresa = request.getParameter("adresa");
		String email = request.getParameter("email");
		String nrTelefonit = request.getParameter("tel");
		String ePerdoruesit = request.getParameter("emriPerdoruesit");
		String fjalekalimi = request.getParameter("fjalekalimi");
		
		Perdoruesi perdoruesi = new Perdoruesi(id, emri, mbiemri, adresa, email, nrTelefonit, ePerdoruesit, fjalekalimi);
	
		int resultati = PerdoruesiDataAccess.ruaj(perdoruesi);
		System.out.println(resultati);
		
		if(resultati > 0)
		{
			response.sendRedirect("login.html");
		}
		else
		{
			pw.println("Ruajtja e te dhenave nuk eshte bere!");
		}
	}

}
