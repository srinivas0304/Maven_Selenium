package assertions_Concept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import extentLibrary.Extent_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion_Concept 
{
	WebDriver driver;
	@Test
	public void verifyTitle() 
	{
		String expectedTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		String actualTitle=driver.getTitle();
		
		//To verify whether the expected title and actual title are same
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		Extent_Utility.extentReport(driver, "AssertionReport");
	}
}
