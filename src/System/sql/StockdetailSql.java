package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Stockdetail;
public class StockdetailSql {
	private Connection con=null;
	public void insertStockdetail(Stockdetail sd)
	{
		String sql="insert into stockdetail(id,sellid, productid," 
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
	public List<Stockdetail> selectStockdatail()
	{
		String sql="select * from stockdetail;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Stockdetail> list=new ArrayList<Stockdetail>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Stockdetail sd=new Stockdetail(set.getInt("id"),set.getString("sellid"),set.getString("productid"),
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
	public void updateStockdetail(Stockdetail sd,Stockdetail sd1)
	{
		String sql="update stockdetail set id=?,sellid=?, productid=?," 
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
	public void deleteStockdetail(Stockdetail sd)
	{
		String sql="delete from stockdetail where id=?;";
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
