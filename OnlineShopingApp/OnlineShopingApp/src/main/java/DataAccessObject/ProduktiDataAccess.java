package DataAccessObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Produkti;

public class ProduktiDataAccess 
{
	public static int ruaj(Produkti produkti)
	{
		int resultati = 0;
		try
		{
			Connection con = DB.getCon();
			if(!(con.isClosed()))
			{
				PreparedStatement ps = con.prepareStatement("INSERT INTO produktet(ID, emri, kodi, detajet, cmimi, sasia, foto) VALUES(?, ?, ?, ?, ?, ?, ?)");
				
				ps.setInt(1, produkti.getId());
				ps.setString(2, produkti.getEmri());
				ps.setString(3, produkti.getKodi());
				ps.setString(4, produkti.getDetajet());
				ps.setInt(5, produkti.getCmimi());
				ps.setInt(6, produkti.getSasia());
				ps.setString(7, produkti.getFoto());
				
				resultati = ps.executeUpdate();
			}
			else
			{
				System.out.println("error");
			}
//			con.close();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return resultati;
	}
	
	
	public static List<Produkti> listaProdukteve()
	{
		List<Produkti> produktet = new ArrayList<Produkti>();
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM produktet");
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
	
	public static int perditeso(Produkti p)
	{
		int res = 0;
		
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE produktet SET emri = ?, kodi = ?, detajet = ?, cmimi = ?, sasia = ? WHERE ID = ?");
			ps.setString(1, p.getEmri());
			ps.setString(2, p.getKodi());
			ps.setString(3, p.getDetajet());
			ps.setInt(4, p.getCmimi());
			ps.setInt(5, p.getSasia());
			ps.setInt(6, p.getId());
			
			res = ps.executeUpdate();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return res;
	}
	
	public static Produkti produktiSipasID(int id)
	{
		Produkti produkti = new Produkti();
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM produktet WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				produkti.setId(rs.getInt(1));
				produkti.setEmri(rs.getString(2));
				produkti.setKodi(rs.getString(3));
				produkti.setDetajet(rs.getString(4));
				produkti.setCmimi(rs.getInt(5));
				produkti.setSasia(rs.getInt(6));
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return produkti;
	}
	
	public static int fshij(int id)
	{
		int res = 0;
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM produktet WHERE id = ?");
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











