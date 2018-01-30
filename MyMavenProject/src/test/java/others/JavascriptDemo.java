package others;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.get("https://www.amazon.in/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement connectEle = driver.findElement(By.xpath("//*[text()='Connect with Us']"));
		js.executeScript("arguments[0].scrollIntoView(true)", connectEle);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Shop from different categories')]")));
		//Thread.sleep(3000);
		//driver.switchTo().defaultContent();
		WebElement custServiceLink = driver.findElement(By.xpath("//*[contains(text(),'Shop from different categories')]"));
		
		js.executeScript("arguments[0].scrollIntoView(false)", custServiceLink);
		//custServiceLink.click();
		
	}

}
