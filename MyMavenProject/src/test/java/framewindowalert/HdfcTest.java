package framewindowalert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HdfcTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hdfcbank.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		/*try{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("vizury-notification-template")));
			driver.switchTo().frame("vizury-notification-template");
			driver.findElement(By.id("div-close")).click();
		}catch(Exception e){
			System.out.println("Ad has not been shown");
		}*/
		
		driver.findElement(By.className("searchbox")).sendKeys("Loan");
	    wait.until(ExpectedConditions.elementToBeClickable(By.className("sf-searchicon")));
		driver.findElement(By.className("sf-searchicon")).click();

	}

}
