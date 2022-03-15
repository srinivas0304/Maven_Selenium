package extentLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_Utility 
{
	public static void extentReport(WebDriver driver, String extentName)
	{
		try
		{
			
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/assertionReport.html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			ExtentTest test = extent.createTest("FirstTestcase");
			
			test.log(Status.INFO, "FirstTestcase");
			test.log(Status.PASS, "FirstTestcase");
			
			extent.flush();
		}
		catch(Exception e)
		{
			System.out.println("Exception while taking screeshot: "+e.getMessage());
		}
		
	
	}
}
