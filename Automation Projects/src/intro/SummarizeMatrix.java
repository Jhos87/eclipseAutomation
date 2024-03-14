package intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import HelperResources.ConfigReader;

public class SummarizeMatrix extends ConfigReader {

	@SuppressWarnings("deprecation")
	@Test
	public static void testEight() {
		// TODO Auto-generated method

		Properties prop = loadFile();
		System.setProperty("webdriver.firefox.driver", prop.getProperty("driver.ff"));
		
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
		WebDriver driver = new FirefoxDriver(options);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url.summarize"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		scrollDown(driver);
		
		List<WebElement> we = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum = summarize(we);
		
		System.out.println("Total:");
		System.out.println(sum);
		int parseInt = getPageTotal(driver);
		System.out.println(parseInt+" == " + sum );
		
		driver.quit();
	}

	private static int getPageTotal(WebDriver driver) {
		String findElement = driver.findElement(By.cssSelector(".totalAmount")).getText();
		String[] splits = findElement.split(":");
		
		int parseInt = Integer.parseInt(splits[1].trim());
		return parseInt;
	}

	private static int summarize(List<WebElement> we) {
		int summary = 0;
		for(int i=0; i< we.size(); i++) 
		{
			String value = we.get(i).getText();
			System.out.println(value);
			summary = summary + Integer.parseInt(value);
		}
		return summary;
	}

	private static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500);");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	}

}
