package initial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserLauch {
	
	@Test
	public void chromeLaunch(){
		System.setProperty("webdriver.chrome.driver", "binaries/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("http://www.seleniumhq.org/");
		driver.close();
	}
	
}
