package core;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.*;  // jdbc

public class Page 
{
	 // global var
 public WebDriver driver = null;
 public Connection con = null;
 
	public void openBrowser(String browser,String url)
	{
		if(browser.equals("chrome"))
		{
			// register browser driver
	System.setProperty("webdriver.chrome.driver","D:\\browserdrivers\\chromedriver.exe");
						
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		//driver.get(url);
		   // or
		driver.navigate().to(url);  // better
		
		 
		
		// implecit wait
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void makeWBConnection(String wbpath) throws Exception
	{
	Class.forName("com.googlecode.sqlsheet.Driver"); // register driver class
	con = DriverManager.getConnection("jdbc:xls:file:"+wbpath);
	
	}
	
	}
