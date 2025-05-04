package DataAccessObject;
import java.sql.*;

public class DB
{
	public static Connection getCon()
	{
		Connection conn = null;
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				
			conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//G1PraktikaXI6//eclipse-workspace//OnlineShopingApp//DB//ShitjaProdukteveOnline.accdb");
		}
		catch (ClassNotFoundException | SQLException ex) 
		{
			System.out.println(ex);
		}
		
		return conn;
	}
}
