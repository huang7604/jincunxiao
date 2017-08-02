package System.sql;
import java.sql.*;
import System.datemodel.Item;
import System.datemodel.Suppleman;
import System.sql.JdbcConnection;
public class SuppleSql {
		private Connection con=null;
		public int insertSupple(Suppleman ct)
		{
			String sql="insert into supple(id,name,shortname,address,phone,email,post_id,bank_name,fax_id,managename,"
					+ "managenamephone) values(?,?,?,?,?,?,?,?,?,?,?);";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			int i=0;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setString(1,ct.getId());
				ps.setString(2, ct.getName());
				ps.setString(3, ct.getShorttname());
				ps.setString(4, ct.getAddress());
				ps.setString(5, ct.getPhone());
				ps.setString(6, ct.getEmail());
				ps.setString(7, ct.getPost_id());
				ps.setString(8, ct.getBankname());
				ps.setString(9, ct.getFax());
				ps.setString(10, ct.getManagename());
				ps.setString(11, ct.getManagenamephone());
				i=ps.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(ps!=null)
				{
					try
					{
						ps.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try
					{
						con.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
			return i;
		}
		public ResultSet SelectSupple(String sql)
		{
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			
			try
			{
				ps=con.prepareStatement(sql);
				ResultSet set=ps.executeQuery();
				return set;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
				return null;
		}
public int updateSupple(Suppleman ct,Item it)
{
	String sql="update supple set id=?,name=?,shortname=?,address=?,phone=?,email=?,post_id=?,"
			+ "bank_name=?,fax_id=?,managename=?,"
					+ "managenamephone=? where id=?";
	con=JdbcConnection.getConnection();
	PreparedStatement ps=null;
	int i=0;
	try
	{
		ps=con.prepareStatement(sql);
		ps.setString(1,ct.getId());
		ps.setString(2, ct.getName());
		ps.setString(3, ct.getShorttname());
		ps.setString(4, ct.getAddress());
		ps.setString(5, ct.getPhone());
		ps.setString(6, ct.getEmail());
		ps.setString(7, ct.getPost_id());
		ps.setString(8, ct.getBankname());
		ps.setString(9, ct.getFax());
		ps.setString(10, ct.getManagename());
		ps.setString(11, ct.getManagenamephone());
		ps.setString(12,it.getId());
		i=ps.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	return i;
}
public int deleteSupple(Item it)
{
	String sql="delete from supple where id=?;";
	con=JdbcConnection.getConnection();
	PreparedStatement ps=null;
	int i=0;
	try
	{
		ps=con.prepareStatement(sql);
		ps.setString(1,it.getId());
		i=ps.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	return i;
}
}
