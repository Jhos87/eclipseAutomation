package intro;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import HelperResources.ConfigReader;

public class FlightPicker extends ConfigReader{

	@SuppressWarnings("deprecation")
	@Test
	public static void testThree() {
		// TODO Auto-generated method stub

		Properties prop = loadFile();
		System.setProperty("webdriver.firefox.driver", prop.getProperty("driver.ff"));
		
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
		WebDriver driver = new FirefoxDriver(options);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url.flightPicker"));

		introduceOrigin(driver);
		introduceDestination(driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		includeAdults(driver,3);

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

	private static void includeAdults(WebDriver driver, int j) {
		
		driver.findElement(By.xpath("//a[contains(@class, 'ui-state-default ui-state-highlight')]")).click();

		driver.findElement(By.id("divpaxinfo")).click();		
		
		for (int i = 0; i < j; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

	private static void introduceDestination(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@text='Bangkok (BKK)']")).click();
	}

	private static void introduceOrigin(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@text='Chennai (MAA)']")).click();
	}

}
