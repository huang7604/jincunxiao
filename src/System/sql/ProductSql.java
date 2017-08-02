package System.sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import System.datemodel.Item;
import System.datemodel.Product;
import System.sql.JdbcConnection;
public class ProductSql {
	private Connection con=null;
	public int insertProduct(Product pt)
	{
		String sql="insert into product(id,name,shortname,productaddress,unit,supple,"
				+ "introdution,promission_id,number,standard,packing) values(?,?,?,?,?,?,?,?,?,?,?);";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		int i=0;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,pt.getId());
			ps.setString(2, pt.getName());
			ps.setString(3, pt.getShorttname());
			ps.setString(4, pt.getProductAddress());
			ps.setString(5, pt.getUnit());
			ps.setString(6, pt.getSupple());
			ps.setString(7, pt.getIntrodution());
			ps.setString(8, pt.getPromission_id());
			ps.setString(9, pt.getNumber());
			ps.setString(10,pt.getStandard());
			ps.setString(11, pt.getPacking());
			i=ps.executeUpdate();
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
		return i;
	}
	public ResultSet SelectProduct(String sql)
	{
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement(sql);
			ResultSet set=ps.executeQuery();
			
			return set;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public int updateProduct(Product pt,Item it)
	{
		String sql="update product set id=?,name=?,shortname=?,productaddress=?,unit=?,supple=?,"
				+ "introdution=?,promission_id=?,number=?,standard=?,packing=? where id=?;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		int i=0;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,pt.getId());
			ps.setString(2, pt.getName());
			ps.setString(3, pt.getShorttname());
			ps.setString(4, pt.getProductAddress());
			ps.setString(5, pt.getUnit());
			ps.setString(6, pt.getSupple());
			ps.setString(7, pt.getIntrodution());
			ps.setString(8, pt.getPromission_id());
			ps.setString(9, pt.getNumber());
			ps.setString(10,pt.getStandard());
			ps.setString(11, pt.getPacking());
			ps.setString(12,it.getId());
			i=ps.executeUpdate();
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
		return i;
	}
	public int deleteProduct(Item it)
	{
		String sql="delete from product where id=?;";
		con=JdbcConnection.getConnection();
		PreparedStatement ps=null;
		int i=0;
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
		return i;
	}
}
