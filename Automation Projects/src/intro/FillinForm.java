package intro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FillinForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\Jhos\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exec");
		
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		populateFields(driver);
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		System.out.print(driver.findElement(By.xpath("(//div[@class='container']//div)[4]")).getText());
		
	}

	private static void populateFields(WebDriver driver) {
		driver.findElement(By.name("name")).sendKeys("Jhoseline");
		driver.findElement(By.name("email")).sendKeys("jhoselinesalazarorozco@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("jhos10");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.xpath("//div[@class='form-group']//select[1]")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("1987-12-31");
	}

}
