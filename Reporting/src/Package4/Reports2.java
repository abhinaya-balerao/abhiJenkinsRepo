package Package4;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Reports2 {

	//Creating two classes globally
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	
	public void startTest(){
		
	//Setting the path for report and true statement will overwrite the current report in STMExtentReport folder 
	extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
	//extent=new ExtentReports("C:\\Reports\\ReportExample2.html");
	extent.addSystemInfo("Host Name", "Software testing material")
	.addSystemInfo("Environment", "Automation Testing")
	.addSystemInfo("Username", "abhi");
	
	extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

	}

	@Test
	public void passTest(){
		
		//name of the test which is passing
	logger=	extent.startTest("passTest");
	Assert.assertTrue(true);
	//to generate log when the test case is passed
	logger.log(LogStatus.PASS, "Test case passed in passTest");
	}
	
	@Test
	public void failTest(){
		logger=	extent.startTest("failTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "Test case failed in the failTest");
	}
	
	@Test
	public void skipTest(){
		logger=	extent.startTest("skipTest");
	throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	
	public void getResult(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
		
		logger.log(LogStatus.FAIL, "Test case failed is"+result.getName());
		logger.log(LogStatus.FAIL, "Test case failed is"+result.getThrowable());
		}else if (result.getStatus()==ITestResult.SKIP){
		
			logger.log(LogStatus.SKIP, "Test case failed is"+result.getName());
		}
		//It end the current rest and creates Html report
		extent.endTest(logger);
	}
	
	
	@AfterTest
	
	public void endReport(){
	 //it updates the test information to your	report
	extent.flush();
	//To close all the operations and this step should be called at the end
	//if any of your test ends abruptly causing any sideeffects
	extent.close();	
		
	}
	

}
	
	

