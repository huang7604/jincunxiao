package System.sql;
import java.sql.*;
import java.util.*;

import System.datemodel.Item;
import System.datemodel.Userlist;
public class UserlistSql {
	private Connection con=null;
	public void insertUserlist(Userlist ul)
	{
		String sql="insert into userlist(id,name,username,password,power) values(?,?,?,?,?);";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,ul.getId());
			ps.setString(2, ul.getName());
			ps.setString(3, ul.getUsername());
			ps.setString(4, ul.getPassword());
			ps.setString(5, ul.getPower());
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
	public List<Userlist> SelectUserlist()
	{
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		String sql="select * from userlist;";
		List<Userlist> list=new ArrayList<Userlist>();
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Userlist ul=new Userlist();
				ul.setId(set.getString("id"));
				ul.setName(set.getString("name"));
				ul.setUsername(set.getString("username"));
				ul.setPassword(set.getString("password"));
				ul.setPower(set.getString("power"));
				list.add(ul);
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
	public void updateUserlist(Userlist ul,Item it)
	{
		con=JdbcConnection.getConnection();
		String sql="update userlist set id=?,name=?,username=?,password=?,power=? where id=?;";
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,ul.getId());
			ps.setString(2, ul.getName());
			ps.setString(3, ul.getUsername());
			ps.setString(4, ul.getPassword());
			ps.setString(5, ul.getPower());
			ps.setString(6,it.getId());
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
	public void deleteUserlist(Item it)
	{
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		String sql="delete from userlist where id=?;";
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
