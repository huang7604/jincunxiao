package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Sellreturndatail;
public class SellreturndetailSql {
	private Connection con=null;
	public void insertSellreturndetail(Sellreturndatail std)
	{
		String sql="insert into sellreturndetail(id,sellreturnid, productid," 
			 +"price,number)"
			 + "values(?,?,?,?,?);";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setInt(1,std.getId());
			ps.setString(2, std.getSellreturnid());
			ps.setString(3, std.getProduct());
			ps.setDouble(4, std.getPrice());
			ps.setInt(5, std.getNumber());
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
	public List<Sellreturndatail> selectSellreturndatail()
	{
		String sql="select * from sellreturndetail;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Sellreturndatail> list=new ArrayList<Sellreturndatail>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Sellreturndatail sd=new Sellreturndatail(set.getInt("id"),set.getString("sellreturnid"),set.getString("productid"),
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
	public void updateSellreturndetail(Sellreturndatail std,Sellreturndatail std1)
	{
		String sql="update sellreturndetail set id=?,sellreturnid=?, productid=?," 
				 +"price=?,number=? where id=?"
				 + "values(?,?,?,?,?);";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setInt(1,std.getId());
				ps.setString(2, std.getSellreturnid());
				ps.setString(3, std.getProduct());
				ps.setDouble(4, std.getPrice());
				ps.setInt(5, std.getNumber());
				ps.executeUpdate();
				ps.setInt(1,std1.getId());
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
	public void deleteSellreturndetail(Sellreturndatail std)
	{
		String sql="delete from sellreturndetail where id=?;";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setInt(1,std.getId());
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
