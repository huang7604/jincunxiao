package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Item;
import System.datemodel.Stockmain;
public class StockmainSql {
	private Connection con=null;
	public void insertStockmain(Stockmain sm)
	{
		String sql="insert into stockmain(id,varietynumber, money," 
			 +"conclusion,customername,stocktime,manage,brokerage,accountmethod)"
			 + "values(?,?,?,?,?,?,?,?,?);";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,sm.getId());
			ps.setString(2, sm.getVarietynumber());
			ps.setString(3, sm.getMoney());
			ps.setString(4, sm.getConclusion());
			ps.setString(5, sm.getCustomername());
			ps.setString(6, sm.getStocktime());
			ps.setString(7, sm.getManage());
			ps.setString(8, sm.getBrokerage());
			ps.setString(9, sm.getAccountmethod());
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
	public List<Stockmain> selectStockmain()
	{
		String sql="select * from stocklmain;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Stockmain> list=new ArrayList<Stockmain>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Stockmain sm=new Stockmain(set.getString("id"),set.getString("varietynumber"),set.getString("money"),
						set.getString("conclusion"),set.getString("customername"),set.getString("stocktime"),
						set.getString("manage"),set.getString("brokerahr"),set.getString("accountmethod"));
				
				list.add(sm);
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
	public void  updateStockmain(Stockmain sm,Item it)
	{
		String sql="update stockmain set id=?,varietynumber=?, money=?," 
				 +"conclusion=?,customername=?,stocktime=?,manage=?,brokerage=?,accountmethod=? where id=?"
				 + "values(?,?,?,?,?,?,?,?,?);";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setString(1,sm.getId());
				ps.setString(2, sm.getVarietynumber());
				ps.setString(3, sm.getMoney());
				ps.setString(4, sm.getConclusion());
				ps.setString(5, sm.getCustomername());
				ps.setString(6, sm.getStocktime());
				ps.setString(7, sm.getManage());
				ps.setString(8, sm.getBrokerage());
				ps.setString(9, sm.getAccountmethod());
				ps.setString(10,it.getId());
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
	public void deleteStockmain(Item it)
	{
		String sql="delete from stockmain where id=?;";
			con=JdbcConnection.getConnection();
			PreparedStatement ps=null;
			try
			{
				ps=con.prepareStatement(sql);
				ps.setString(10,it.getId());
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
