package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Item;
import System.datemodel.Sellmain;
public class SellmainSql {
	private Connection con=null;
	public void insertSellmain(Sellmain sm)
	{
		String sql="insert into sellmain(id,varietynumber, money," 
			 +"conclusion,customername,selltime,manage,brokerage,accountmethod)"
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
			ps.setString(6, sm.getSelltime());
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
	public List<Sellmain> selectSellmain()
	{
		String sql="select * from sellmain;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Sellmain> list=new ArrayList<Sellmain>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Sellmain sm=new Sellmain(set.getString("id"),set.getString("varietynumber"),set.getString("money"),
						set.getString("conclusion"),set.getString("customername"),set.getString("selltime"),
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
	public void  updateSellmain(Sellmain sm,Item it)
	{
		String sql="update sellmain set id=?,varietynumber=?, money=?," 
				 +"conclusion=?,customername=?,selltime=?,manage=?,brokerage=?,accountmethod=? where id=?"
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
				ps.setString(6, sm.getSelltime());
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
	public void deleteSellmain(Item it)
	{
		String sql="delete from sellmain where id=?;";
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
