package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Selldetail;
public class SelldatailSql {
	private Connection con=null;
	public void insertSelldetail(Selldetail sd)
	{
		String sql="insert into selldetail(id,sellid, productid," 
			 +"price,number)"
			 + "values(?,?,?,?,?);";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setInt(1,sd.getId());
			ps.setString(2, sd.getSellid());
			ps.setString(3, sd.getProduct());
			ps.setDouble(4, sd.getPrice());
			ps.setInt(5, sd.getNumber());
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
	public List<Selldetail> selectSelldatail()
	{
		String sql="select * from selldetail;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Selldetail> list=new ArrayList<Selldetail>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Selldetail sd=new Selldetail(set.getInt("id"),set.getString("sellid"),set.getString("productid"),
						set.getDouble("price"),set.getInt("number"));
				list.add(sd);
			}
			return list;
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
		return null;
	}
	public void updateSelldetail(Selldetail sd,Selldetail sd1)
	{
		String sql="update selldetail set id=?,sellid=?, productid=?," 
				 +"price=?,number=? where id=?;";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setInt(1,sd.getId());
				ps.setString(2, sd.getSellid());
				ps.setString(3, sd.getProduct());
				ps.setDouble(4, sd.getPrice());
				ps.setInt(5, sd.getNumber());
				ps.setInt(6,sd1.getId());
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
	public void deleteSelldetail(Selldetail sd)
	{
		String sql="delete from selldetail where id=?;";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setInt(1,sd.getId());
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
}
