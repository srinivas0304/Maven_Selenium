package crossBrowsing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case 
{
	
	static WebDriver driver;
	@Test
	public void amazon() throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		Thread.sleep(1000);
		driver.get("https://www.geeksforgeeks.org/");	
	}
}
