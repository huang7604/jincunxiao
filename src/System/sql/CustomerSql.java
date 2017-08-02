package System.sql;
import java.sql.*;

import System.sql.JdbcConnection;
import System.datemodel.Customer;
import System.datemodel.Item;
public class CustomerSql {
	private Connection con=null;
	public int insertCustomer(Customer ct)
	{
		int i=0;
		String sql="insert into customer(id,name,shortname,address,phone,email,post_id,account,bank_name,fax_id,managename,"
				+ "managenamephone) values(?,?,?,?,?,?,?,?,?,?,?,?);";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
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
			ps.setString(8, ct.getAccount());
			ps.setString(9, ct.getBankname());
			ps.setString(10, ct.getFax());
			ps.setString(11, ct.getManagename());
			ps.setString(12, ct.getManagenamephone());
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
	public ResultSet SelectCustomer(String sql)
	{
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet set=null;
	    try
		{
			ps=con.prepareStatement(sql);
			set=ps.executeQuery();
			return set;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	    return set;
	}
	public void UpdateCustomer(Customer ct,Item it)
	{
		String sql="update customer name=?,shortname=?,address=?,phone=?,"
				+ "email=?,post_id=?,account=?,bank_name=?,fax_id=?,managename=?,"
				+ "managenamephone=? where id=?;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, ct.getName());
			ps.setString(2, ct.getShorttname());
			ps.setString(3, ct.getAddress());
			ps.setString(4, ct.getPhone());
			ps.setString(5, ct.getEmail());
			ps.setString(6, ct.getPost_id());
			ps.setString(7, ct.getAccount());
			ps.setString(8, ct.getBankname());
			ps.setString(9, ct.getFax());
			ps.setString(10, ct.getManagename());
			ps.setString(11, ct.getManagenamephone());
			ps.setString(12,it.getId());
			ps.executeUpdate();
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
	}
	public int deleteCustomer(Item it)
	{
		String sql="delete from customer where id=?;";
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
