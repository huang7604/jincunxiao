package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Stockreturndatail;
public class StockreturndetailSql {
	private Connection con=null;
	public void insertStockreturndetail(Stockreturndatail std)
	{
		String sql="insert into stockreturndetail(id,stockreturnid, productid," 
			 +"price,number)"
			 + "values(?,?,?,?,?);";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setInt(1,std.getId());
			ps.setString(2, std.getStockreturnid());
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
	public List<Stockreturndatail> selectStockreturndatail()
	{
		String sql="select * from stockreturndetail;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Stockreturndatail> list=new ArrayList<Stockreturndatail>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Stockreturndatail sd=new Stockreturndatail(set.getInt("id"),set.getString("stockreturnid"),set.getString("productid"),
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
	public void updateStockreturndetail(Stockreturndatail std,Stockreturndatail std1)
	{
		String sql="update sellreturndetail set id=?,stockreturnid=?, productid=?," 
				 +"price=?,number=? where id=?"
				 + "values(?,?,?,?,?);";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setInt(1,std.getId());
				ps.setString(2, std.getStockreturnid());
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
	public void deleteStockreturndetail(Stockreturndatail std)
	{
		String sql="delete from stockreturndetail where id=?;";
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
