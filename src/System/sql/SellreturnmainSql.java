package System.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import System.datemodel.Item;
import System.datemodel.Sellreturnmain;

public class SellreturnmainSql {
	private Connection con=null;
	public void insertSellreturnmain(Sellreturnmain sm)
	{
		String sql="insert into sellreturnmain(id,varietynumber, money," 
			 +"conclusion,customername,sellreturntime,manage,brokerage,accountmethod)"
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
			ps.setString(6, sm.getSellreturntime());
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
	public List<Sellreturnmain> selectSellreturnmain()
	{
		String sql="select * from sellreturnmain;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		List<Sellreturnmain> list=new ArrayList<Sellreturnmain>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Sellreturnmain sm=new Sellreturnmain(set.getString("id"),set.getString("varietynumber"),set.getString("money"),
						set.getString("conclusion"),set.getString("customername"),set.getString("sellreturntime"),
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
	public void  updateSellreturnmain(Sellreturnmain sm,Item it)
	{
		String sql="update sellreturnmain set id=?,varietynumber=?, money=?," 
				 +"conclusion=?,customername=?,sellreturntime=?,manage=?,brokerage=?,accountmethod=? where id=?"
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
				ps.setString(6, sm.getSellreturntime());
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
	public void deleteSellreturnmain(Item it)
	{
		String sql="delete from sellreturnmain where id=?;";
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
