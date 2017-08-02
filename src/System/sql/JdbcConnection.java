package System.sql;
import java.sql.*;

import System.sql.Password;
public class JdbcConnection implements Password{
	private static Connection con=null;
	public  static Connection getConnection()
	{
		try
		{
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return con;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}