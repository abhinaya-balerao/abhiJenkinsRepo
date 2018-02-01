package Package4;

import java.io.File;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	
	@Test
     public static String captureScreenshot(WebDriver driver, String ScreenshotName) {
		
		try{

		File screenShot=((TakesScreenshot) driver)
	    		.getScreenshotAs(OutputType.FILE);
	    
	   
	    	String screenLocation="C:\\screenShots\\"+ScreenshotName+".png";
	    	
	    	File Destination=new File(screenLocation);
	    	
	    	FileUtils.copyFile(screenShot, Destination);
	    	
	    	return screenLocation;
	    }catch(Exception e){
	    	System.out.println("Exception is"+e.getMessage());
	    	return e.getMessage();
	    }
	    }
}
		
		
		
		
		
		
		
		

	


