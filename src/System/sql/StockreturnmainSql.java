package System.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import System.datemodel.Item;
import System.datemodel.Stockreturnmain;

public class StockreturnmainSql {
	private Connection con=null;
	public void insertSellreturnmain(Stockreturnmain sm)
	{
		String sql="insert into stockreturnmain(id,varietynumber, money," 
			 +"conclusion,customername,stockreturntime,manage,brokerage,accountmethod)"
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
			ps.setString(6, sm.getStockreturntime());
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
	public List<Stockreturnmain> selectStockreturnmain()
	{
		String sql="select * from stockreturnmain;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Stockreturnmain> list=new ArrayList<Stockreturnmain>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Stockreturnmain sm=new Stockreturnmain(set.getString("id"),set.getString("varietynumber"),set.getString("money"),
						set.getString("conclusion"),set.getString("customername"),set.getString("stockreturntime"),
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
	public void  updateStockreturnmain(Stockreturnmain sm,Item it)
	{
		String sql="update stockreturnmain set id=?,varietynumber=?, money=?," 
				 +"conclusion=?,customername=?,stockreturntime=?,manage=?,brokerage=?,accountmethod=? where id=?"
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
				ps.setString(6, sm.getStockreturntime());
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
	public void deleteStockreturnmain(Item it)
	{
		String sql="delete from stockreturnmain where id=?;";
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

