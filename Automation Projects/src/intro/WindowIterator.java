package intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import HelperResources.ConfigReader;

public class WindowIterator extends ConfigReader{

	@Test
	public static void testNine() {
		// TODO Auto-generated method

		Properties prop = loadFile();
		System.setProperty("webdriver.firefox.driver", prop.getProperty("driver.ff"));
		
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url.windowIterator"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
