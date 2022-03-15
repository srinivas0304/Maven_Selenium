package assertions_Concept;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions_Conce 
{
	@Test
	public void testFacebook() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("ratnaglobal",Keys.ENTER);
		
		Thread.sleep(4000);
		
		//softassert class
		
		SoftAssert softAssert=new SoftAssert();
	          
		//Title assertion
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Log in to Facebook";
		softAssert.assertEquals(actualTitle, expectedTitle,"Title is mismatched");
		
		//URL assertion
		
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.facebook.com/";
		softAssert.assertNotEquals(actualUrl, expectedUrl, "URL is mismatched");
		
		//Text asseriom
		
		String actualText=driver.findElement(By.id("email")).getAttribute("value");
		String expectedText= "";
		softAssert.assertEquals(actualText, expectedText,"Username text is mismatched");
		
		//Border assertion
		
		String actualBorder=driver.findElement(By.id("email")).getCssValue("border");
		String expectedBorder="1px solid rgb(240, 40, 73)";//1px solid #f02849
		softAssert.assertEquals(actualBorder, expectedBorder,"Username border is mismatch");
		
		//errormessage assertion
		
		String actualErrorMessage=driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		String expectedErrorMessage="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage,"Username error message is mismatched");
		System.out.println(driver.getTitle());
		
		driver.quit();
		softAssert.assertAll();
		
	}
}
