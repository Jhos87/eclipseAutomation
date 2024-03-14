package intro;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import HelperResources.ConfigReader;

public class ShoppingCart extends ConfigReader{
	
	@SuppressWarnings("deprecation")
	@Test
	public static void testSix() {
		// TODO Auto-generated method stub

		Properties prop = loadFile();
		System.setProperty("webdriver.firefox.driver", prop.getProperty("driver.ff"));
		
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
		WebDriver driver = new FirefoxDriver(options);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url.shoppingCart"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
