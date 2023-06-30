package testcases;

import core.Page;
import java.sql.*;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
public class ResolutionTest extends Page

{
	public void test()throws Exception
	{
		makeWBConnection ("C:\\Users\\Dipak\\OneDrive\\Desktop\\Priya\\excel\\responsive1.xlsx");
		
		Statement stm = con.createStatement();
				
		ResultSet rs = stm.executeQuery("select * from sheet1");
		
		while (rs.next());
		{
			String brow = rs.getString(1);
			String url = rs.getString(2);
			String reso = rs.getString(3);
			//break resolution
			StringTokenizer str = new StringTokenizer(reso,",");
			int resow = Integer.parseInt(str.nextToken().trim());
			int resoh = Integer.parseInt(str.nextToken().trim());
			String expw = rs.getString(4);
			String exph = rs.getString(5);
			
			openBrowser(brow,url);
			driver.manage().window().setSize(new Dimension(resow,resoh));
			
			WebElement img = driver.findElement(By.xpath("//*[@id=\"band\"]/div/div[1]/img"));
			
			String actualw = img.getCssValue("width");
			String actualh = img.getCssValue("height");
			
			if(expw.equals(actualw) && exph.equals(actualh))
			{
				//pass
				stm.executeUpdate("insert into Sheet2(resolution,expected,actual,status) values('"+reso+"','"+expw+" x "+exph+"','"+actualw+" x "+actualh+"','PASS')");
				con.commit();
				con.close();
				//reopen the connection
				makeWBConnection("C:\\\\Users\\\\Dipak\\\\OneDrive\\\\Desktop\\\\Priya\\\\excel\\\\responsive1.xlsx");
				stm=con.createStatement();
				
			}
			else
			{
				//fail
				stm.executeUpdate("insert into Sheet2(resolution,expected,actual,status) values('"+reso+"','"+expw+" x "+exph+"','"+actualw+" x "+actualh+"','PASS')");
				con.commit();
				con.close();
				//reopen the connection
				makeWBConnection("C:\\\\Users\\\\Dipak\\\\OneDrive\\\\Desktop\\\\Priya\\\\excel\\\\responsive1.xlsx");
				stm=con.createStatement();
				
			}
		}
	}

	public static void main(String[] args)throws Exception 
	{
	
		ResolutionTest r = new ResolutionTest();
		r.test();

	}

}
