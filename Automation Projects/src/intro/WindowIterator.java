package intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method

		System.setProperty("webdriver.firefox.driver", "C:\\Users\\Jhos\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exec");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		driver.switchTo().window(childId);

		System.out.println(driver.findElement(By.xpath("//div[@class=\"example\"]")).getText());

		driver.switchTo().window(parentId);

		System.out.println(driver.findElement(By.xpath("//div[@class=\"example\"]//h3[1]")).getText());

	}

}
