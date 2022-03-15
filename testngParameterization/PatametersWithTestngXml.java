package testngParameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatametersWithTestngXml 
{
	WebDriver driver;
	@Test
	@Parameters("searchKey")
	public void parametersTestngWithXml(@Optional("Abc") String searchKey) 
	{
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys(searchKey);
		ele.submit();
		
		
		try
		{
			System.out.println("Verifying the value: " + ele.getAttribute("value") + " ::" + "value given by user: " + searchKey);
			Assert.assertTrue(ele.getAttribute("value").equalsIgnoreCase(searchKey));
		}
		catch(org.openqa.selenium.StaleElementReferenceException e)
		{
			System.out.println("Verifying the value: " + ele.getAttribute("value") + " ::" + "value given by user: " + searchKey);
			Assert.assertTrue(ele.getAttribute("value").equalsIgnoreCase(searchKey));
		}
	}
}
