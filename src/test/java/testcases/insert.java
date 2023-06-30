package testcases;

import java.sql.*;

public class insert extends ConnectWB
{
	public void insertData() throws Exception
	{
		connectToWB("C:\\Users\\Dipak\\OneDrive\\Desktop\\Priya\\excel\\dipak.xlsx");
		
		Statement stm = con.createStatement();
		
		stm.executeUpdate("insert into Sheet1(fname,lname,age) values ('priya','pendu',22)");
		stm.executeUpdate("insert into Sheet1(fname,lname,age) values ('dipak','ghige',25)");
		
		con.commit();
		con.close();
		
		System.out.println("recorde inserted..");
	}

	public static void main(String[] args) throws Exception
	{
		insert i = new insert();
		i.insertData();

	}

}
