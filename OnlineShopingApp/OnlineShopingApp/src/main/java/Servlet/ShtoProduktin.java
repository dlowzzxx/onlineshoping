package Servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.util.Random;
import DataAccessObject.ProduktiDataAccess;
import Model.Produkti;

@MultipartConfig(location = "C:\\Users\\G1PraktikaXI6\\eclipse-workspace\\OnlineShopingApp\\src\\main\\webapp\\img", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/ShtoProduktin")
public class ShtoProduktin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShtoProduktin() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Random rand = new Random();
		int randId = 2000;
		
		int id = rand.nextInt(randId);
		String emri = request.getParameter("emri");
		String kodi = request.getParameter("kodi");
		String detajet = request.getParameter("detajet");
		String cmimi = request.getParameter("cmimi");
		String sasia = request.getParameter("sasia");
		Part foto = request.getPart("foto");
//		InputStream is = foto.getInputStream();
		String is = foto.getSubmittedFileName();
		
		Produkti produkti = new Produkti(id, emri, kodi, detajet, Integer.parseInt(cmimi), Integer.parseInt(sasia), is);
		int res = ProduktiDataAccess.ruaj(produkti);
		
		if(res > 0)
		{
			response.sendRedirect("shtoProduktin.html");
			
		}
		else
		{
			pw.println("Ruajtja e te dhenave nuk eshte bere!");
		}
	}

}
