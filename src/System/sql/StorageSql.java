package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Item;
import System.datemodel.Storage;
import System.sql.JdbcConnection;
public class StorageSql {
	Connection con=null;
	public void insertStorage(Storage st)
	{
		con=JdbcConnection.getConnection();
		String sql="insert into storage(id,productname,shorttname,productaddress,"
				+ "unit,standard,packing,price,number) values(?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,st.getId());
			ps.setString(2, st.getProductname());
			ps.setString(3, st.getShorttname());
			ps.setString(4, st.getProductAddress());
			ps.setString(5, st.getUnit());
			ps.setString(6, st.getStandard());
			ps.setString(7, st.getPacking());
			ps.setDouble(8, st.getPrice());
			ps.setInt(9, st.getNumber());
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
	public List<Storage> selectStorage()
	{
		con=JdbcConnection.getConnection();
		String sql="select * from storage;";
		List<Storage> list=new ArrayList<Storage>();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Storage st=new Storage(set.getString("id"),set.getString("productname"),set.getString("shorttname"),
						set.getString("productaddress"),set.getString("unit"),set.getString("standard"),
						set.getString("packing"),set.getDouble("price"),set.getInt("number"));
				
				list.add(st);
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
	public void updateStorage(Storage st,Item it)
	{
		con=JdbcConnection.getConnection();
		String sql="update  storage set id=?,productname=?,shorttname=?,productaddress=?,"
				+ "unit=?,standard=?,packing=?,price=?,number=? where id=?;";
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,st.getId());
			ps.setString(2, st.getProductname());
			ps.setString(3, st.getShorttname());
			ps.setString(4, st.getProductAddress());
			ps.setString(5, st.getUnit());
			ps.setString(6, st.getStandard());
			ps.setString(7, st.getPacking());
			ps.setDouble(8, st.getPrice());
			ps.setInt(9, st.getNumber());
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
public void deleteStorage(Item it)
{
	con=JdbcConnection.getConnection();
	String sql="delete from storage where id=?;";
	PreparedStatement ps=null;
	try
	{
		ps=con.prepareStatement(sql);
		ps.setString(1,it.getId());
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
public void updateprice(Double price,Item it)
{
	con=JdbcConnection.getConnection();
	String sql="update  storage set price="+price+" where id=?;";
	PreparedStatement ps=null;
	try
	{
		ps=con.prepareStatement(sql);
		ps.setString(1,it.getId());
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
