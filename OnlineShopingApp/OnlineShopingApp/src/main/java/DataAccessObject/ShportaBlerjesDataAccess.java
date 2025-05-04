package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Produkti;
import Model.ShportaBlerjes;

public class ShportaBlerjesDataAccess {
	public static int ruaj(ShportaBlerjes sh)
	{
		int res = 0;
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO shportaBlerjes(ID, idProduktit, emriPerdoruesit) VALUES(?,?,?)");
			
			ps.setInt(1, sh.getId());
			ps.setInt(2, sh.getIdProduktit());
			ps.setString(3, sh.getEmriPerdoruesit());
//			ps.setInt(4, sh.getSasia());
			
			res = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
	}
	
	public static List<Produkti> listaProdukteve()
	{
		List<Produkti> produktet = new ArrayList<Produkti>();
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM produktet prod, shportaBlerjes shB, Perdoruesi p WHERE prod.ID = shB.idProduktit AND shB.emriPerdoruesit = p.emriPerdoruesit");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Produkti produkti = new Produkti();
				produkti.setId(rs.getInt(1));
				produkti.setEmri(rs.getString(2));
				produkti.setKodi(rs.getString(3));
				produkti.setDetajet(rs.getString(4));
				produkti.setCmimi(rs.getInt(5));
				produkti.setSasia(rs.getInt(6));
				produkti.setFoto(rs.getString(7));
		       
				produktet.add(produkti);
			}
			
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return produktet;
	}
	
	public static int fshij(int id)
	{
		int res = 0;
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM shportaBlerjes WHERE idProduktit = ?");
			ps.setInt(1, id);
			res = ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return res;
	}
}
