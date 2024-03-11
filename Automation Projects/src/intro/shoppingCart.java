package intro;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class shoppingCart {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.firefox.driver", "C:\\Users\\Jhos\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exec");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> we = driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
		String[] things = {"Cucumber - 1 Kg","Brocolli - 1 Kg","Beetroot - 1 Kg"};
		List listThings = Arrays.asList(things);
		
		addItems(driver, we, listThings);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.className("promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
	}

	private static void addItems(WebDriver driver, List<WebElement> we, List listThings) {
		for(int i=0;i<we.size();i++) 
		{
				String productName = we.get(i).getText();
				
				if(listThings.contains(productName)) 
				{
					WebElement webElements = driver.findElements(By.xpath("//div[@class=\"product-action\"]")).get(i);
					webElements.click();
				}
			 
				
		}
	}

}
