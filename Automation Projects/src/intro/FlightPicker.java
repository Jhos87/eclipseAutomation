package intro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightPicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.firefox.driver",
				"C:\\Users\\Jhos\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exec");

		WebDriver driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		introduceOrigin(driver);
		introduceDestination(driver);

		Thread.sleep(2000);

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
