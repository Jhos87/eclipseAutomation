package intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Iframes {

	public static void main(String[] args) {
		// TODO Auto-generated method

		System.setProperty("webdriver.firefox.driver", "C:\\Users\\Jhos\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exec");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://jqueryui.com/droppable/");

		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame(0);
		
		Actions a = new Actions(driver);

		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
	}

}
