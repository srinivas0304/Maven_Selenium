package crossBrowsing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp_Browser 
	{
		 static WebDriver driver;
		 @Parameters("browser")
		
		@BeforeMethod
		public void setup(String browser) throws Exception
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
		}
			
			@Test
			public void amazon() throws Exception
			{
			
			ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/amazon.html");
			
			ExtentReports extent=new ExtentReports();
			
			extent.attachReporter(reporter);
			
			ExtentTest logger=extent.createTest("amazon");
			
			logger.log(Status.INFO, "to amazon testcase");
			
			logger.log(Status.PASS, "test case pass");
				
			driver.get("https://www.amazon.in/");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nokia",Keys.ENTER);
			Thread.sleep(1000);
			List<WebElement> ele=driver.findElements(By.xpath("//span[contains(text(),'Nokia')]"));
			Thread.sleep(1000);
			List<WebElement> ele1=driver.findElements(By.xpath("//span[contains(text(),'Nokia')]/../../../..//div//div//div//div//div//a"));

			for(int i=0;i<ele.size()-1;i++)
			{
			System.out.println(ele.get(i).getText()+": "+ele1.get(i).getText());
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}
			
			@Test
			public void coronavirus()
			{
				driver.get("https://www.worldometers.info/coronavirus");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String s=driver.findElement(By.xpath("//h1[text()='Coronavirus Cases:']/..//div")).getText();
				System.out.println("Coronavirus Cases: "+s);
				String s1=driver.findElement(By.xpath("//h1[text()='Recovered:']/..//div")).getText();
				System.out.println("Recovered: "+s1);
			}
			
			@SuppressWarnings("deprecation")
			@Test
			public void openHrm() throws Exception
			{
				driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("txtUsername")).sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
				driver.findElement(By.xpath("//b[text()='PIM']")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("empsearch_employee_name_empName")).clear();
				WebDriverWait wait=new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("empsearch_employee_name_empName")));
				driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Srinivas");
				driver.findElement(By.id("empsearch_id")).clear();
				driver.findElement(By.id("empsearch_id")).sendKeys("emp001");
				
				WebElement ele=driver.findElement(By.id("empsearch_employee_status"));
				Select s1=new Select(ele);
				s1.selectByVisibleText("Full-Time Permanent");
				WebElement ele1=driver.findElement(By.id("empsearch_termination"));
				Select s=new Select(ele1);
				s.selectByIndex(1);
				
				driver.findElement(By.id("empsearch_supervisor_name")).sendKeys("Robin");
				
				WebElement ele2=driver.findElement(By.id("empsearch_job_title"));
				Select s2=new Select(ele2);
				s2.selectByValue("9");
				
				WebElement ele3=driver.findElement(By.id("empsearch_sub_unit"));
				Select s3=new Select(ele3);
				s3.selectByVisibleText("  Quality Assurance");
				
				Thread.sleep(1000);
				driver.findElement(By.id("searchBtn")).click();
			}
			
			@Test
			
			public void scrollBy()
			{
				driver.get("https://www.google.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				WebElement ele=driver.findElement(By.name("q"));
				ele.sendKeys("Rohit Sharma");
				ele.submit();
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,200);");
			}
			
			@AfterMethod
			
			public void close()
			{
				driver.close();
			}
			
	}

