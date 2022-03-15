package testngParameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import exceldataLibrary.ExcelDataConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersWithTestngXml2 
{
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void setUp(String browserName,String url)
	{
		if(browserName.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("internetExplorer"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
	}
	
		@Test
		public void login(String userName, String password)
		{
			
			
			
			driver.findElement(By.id("txtUsername")).sendKeys(userName);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			driver.findElement(By.name("Submit")).click();
		}
		
		@DataProvider(name="orange")
		public Object[][] passData()
		{
			ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\addla\\RatnaGlobal_Selenium\\DataDriven_Testing\\TestData\\InputData.xlsx");
			int rows=config.getRowCount(0);
			
			Object[][] data=new Object[rows][2];
			
			for(int i=0;i<rows;i++)
			{
				data[i][0]=config.getData(0, i, 0);
				data[i][1]=config.getData(0, i, 1);
			}
			return data;
		}
		
}
		

