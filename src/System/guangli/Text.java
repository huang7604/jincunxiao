package System.guangli;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import System.sql.CustomerSql;

public class Text {
public static void main(String[] args)
{
	JPanel p=new SuppleModifyandDelete();
	System.out.print(((SuppleModifyandDelete) p).str());
	ResultSet set=new CustomerSql().SelectCustomer("select max(id) from customer;");
	try
	{
	while(set!=null&&set.next())
	System.out.print(set.getString(1));
	}
	catch(SQLException e1)
	{
		e1.printStackTrace();
	}
	
	
}
}
