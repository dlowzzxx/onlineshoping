package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Perdoruesi;

public class PerdoruesiDataAccess {

	public static int ruaj(Perdoruesi p)
	{
		int res = 0;
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Perdoruesi(ID, emri, mbiemri, adresa, email, telefoni, emriPerdoruesit, fjalekalimi, roli) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 'perdorues')");
		
			ps.setInt(1, p.getId());
			ps.setString(2, p.getEmri());
			ps.setString(3, p.getMbiemri());
			ps.setString(4, p.getAdresa());
			ps.setString(5, p.getEmail());
			ps.setString(6, p.getNrTelefonit());
			ps.setString(7, p.getEmriPerdoruesit());
			ps.setString(8, p.getFjalekalimi());
			
			res = ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return res;
	}
	
	public static List<Perdoruesi> listaPerdoruesve()
	{
		List<Perdoruesi> perdoruesit = new ArrayList<Perdoruesi>();
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Perdoruesi");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Perdoruesi perdoruesi = new Perdoruesi();
				perdoruesi.setId(rs.getInt(1));
				perdoruesi.setEmri(rs.getString(2));
				perdoruesi.setMbiemri(rs.getString(3));
				perdoruesi.setAdresa(rs.getString(4));
				perdoruesi.setEmail(rs.getString(5));
				perdoruesi.setNrTelefonit(rs.getString(6));
				perdoruesi.setEmriPerdoruesit(rs.getString(7));
				perdoruesi.setFjalekalimi(rs.getString(8));
				perdoruesi.setRoli(rs.getString(9));
				
				perdoruesit.add(perdoruesi);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return perdoruesit;
	}
	
	
	
	public static int fshij(int id)
	{
		int res = 0;
		
		try
		{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM Perdoruesi WHERE id = ?");
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
	
	public static int perditeso(Perdoruesi p)
	{
		int res = 0;
		
		try {
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE Perdoruesi SET emri = ?, mbiemri = ?, adresa = ?, email = ?, telefoni = ?, emriPerdoruesit = ?, fjalekalimi = ? WHERE ID = ?");
			ps.setString(1, p.getEmri());
			ps.setString(2, p.getMbiemri());
			ps.setString(3, p.getAdresa());
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getNrTelefonit());
			ps.setString(6, p.getEmriPerdoruesit());
			ps.setString(7, p.getFjalekalimi());
			ps.setInt(8, p.getId());
			
			res = ps.executeUpdate();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return res;
	}
}
