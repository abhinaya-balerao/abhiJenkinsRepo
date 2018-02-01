package Package4;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {
	
	ExtentReports report;
	ExtentTest logger;
 WebDriver driver;
	
	
  @Test
  public void VerifyTitle() {
	  
	  report= new ExtentReports("C:\\Reports\\Reportgoogle.html");
	  
	  logger= report.startTest("VerifyTitle");
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Desktop\\abhi\\Jar files\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  logger.log(LogStatus.INFO, "Starting URL");
	  driver.get("http://www.google.com");
	  
	  String Title= driver.getTitle();
	  
	 try{ 
		 Assert.assertTrue(Title.contains("apple"));
	 
	 }catch(Exception e){
		 System.out.println("Exception in Assert is:"+e);
	 }
	  logger.log(LogStatus.PASS, "Title verified");
  }
  
 

@AfterMethod
  
  public void tearDown(ITestResult result){
  
  if(result.getStatus() ==ITestResult.FAILURE){
	  
	  String screenshot_path=Utility.captureScreenshot(driver, result.getName());
	  
	String Image=logger.addScreenCapture(screenshot_path);
	  
	  logger.log(LogStatus.FAIL, "Title Verification",Image);
  }
	  report.endTest(logger);
  report.flush();
  
  driver.get("C:\\Reports\\Reportgoogle.html");
  
  }
  
   
}
