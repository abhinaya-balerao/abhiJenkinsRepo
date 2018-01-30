package framewindowalert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html?org/openqa/selenium/WebElement.html");
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='packageFrame']")));
		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		
		String title  = driver.findElement(By.className("title")).getText();
		if(title.equals("Interface Alert")){
			System.out.println("Test case is passed");
		}
		System.out.println("page title is "+driver.getTitle());
	}

}
