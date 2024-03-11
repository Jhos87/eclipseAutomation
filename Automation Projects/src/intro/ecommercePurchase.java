package intro;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ecommercePurchase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\Jhos\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exec");
		
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		login(driver,w);
		
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		addToCart(driver);
		
		driver.findElement(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")).click();
	}

	private static void addToCart(WebDriver driver) {
		List<WebElement> we = driver.findElements(By.xpath("//div[@class='card-body']"));
		
		System.out.println(we.size());
		
		for (int i=0;i<we.size();i++) 
		{
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}
	}

	private static void login(WebDriver driver, WebDriverWait w) {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class=\"checkmark\"])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-body']")));
		driver.findElement(By.id("okayBtn")).click();
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[class='modal-body']"))));
		driver.findElement(By.xpath("//select")).sendKeys("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
	}

}
