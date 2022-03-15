package htmlunitDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlUnitDriverConcept 
{
	@Test
	
	public void html()
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		
		driver=new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Title of the page before login: "+driver.getTitle());
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123",Keys.ENTER);
		
		System.out.println("Title of the page after login: "+driver.getTitle());
		
		
	}
}
