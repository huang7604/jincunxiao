package System.sql;

public class text {
public static void main(String[] args)
{
	String str="cys0001";
	String id=str.substring(3);
	Integer i=(Integer.parseInt(id)+1);
	if(i<10)
	{
		id="cys000"+i;
	}
	else if(i<100)
	{
		id="cys00"+i;
	}
	else if(i<1000)
	{
		id="cys0"+i;
	}
	else 
	{
		id="cys"+i;
	}
	System.out.println(id);
}
}
