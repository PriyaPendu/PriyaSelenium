package testcases;

import java.sql.*;
public class Select extends ConnectWB
{
	public void selectData() throws Exception
	{
		connectToWB("C:\\Users\\Dipak\\OneDrive\\Desktop\\Priya\\excel\\dipak.xlsx");
		
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("select* from sheet1");
		
		while (rs.next());
		{
			String fname = rs.getString(1);
			String lname = rs.getString(2);
			int age = rs.getInt(3);
			
			System.out.println("fname"+fname+"lname"+lname+"age"+age);
			
		}
		
		
	}

	public static void main(String[] args) throws Exception 
	{
		Select s = new Select();
		s.selectData();

	}

}
