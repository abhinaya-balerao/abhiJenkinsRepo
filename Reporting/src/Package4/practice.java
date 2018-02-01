package Package4;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class practice {
	
	public WebDriver driver;

  @Test
  public void f() {
	  
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\Desktop\\abhi\\Jar files\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	
	  driver.get("http://www.google.com");
	  String Title= driver.getTitle();
	  
	  System.out.println("Title of page is:"+Title);
	  
      SoftAssert assert1= new SoftAssert();
	 
	   assert1.assertTrue(Title.contains("Apple"));
	   System.out.println("Test is a fail");
	   driver.close();
	   
	   //Its Important to put the assertall at the end of the code only then it will help to execute the rest of the steps 
	   //even if the assertion fails, it will continue and test case will fail.
	   
	   assert1.assertAll();

}
}