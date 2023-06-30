package testcases;
import java.sql.*; //jdbc (java database connection)
public class ConnectWB 
{

	Connection con = null;
	public void connectToWB (String wbpath) throws Exception
	{
		Class.forName("com.googlecode.sqlsheet.Driver"); // to register driver
		con = DriverManager.getConnection("jdbc:xls:file:"+wbpath);
		System.out.println("Connected to excel"+wbpath);
		
	}
}
