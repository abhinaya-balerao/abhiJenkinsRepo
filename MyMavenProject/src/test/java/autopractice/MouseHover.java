package autopractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com");
		Actions action = new Actions(driver);
		
		WebElement element = driver.findElement(By.linkText("Women"));
		action.moveToElement(element).perform();
		
		

	}

}
