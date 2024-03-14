package intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SummarizeColumnsRows {

	public static void main(String[] args) {
		// TODO Auto-generated method

		System.setProperty("webdriver.firefox.driver", "C:\\Users\\Jhos\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exec");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display td:nth-child(1)"));
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
		List<WebElement> secondRow = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));
		
		System.out.println("rows: " + rows.size());
		System.out.println("columns: " + columns.size());
		
		iterateSecondRow(secondRow);
		
		driver.quit();
	}

	private static void iterateSecondRow(List<WebElement> secondRow) {
		for(int j=0;j<secondRow.size();j++)
		{
			System.out.print(secondRow.get(j).getText()+" ");			
		}
	}

	private static void scrollPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500);");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
