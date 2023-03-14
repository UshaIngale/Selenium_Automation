package day30Dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetEnteredValueFromTextField {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test
	public void getTextValue() {
		WebElement element=driver.findElement(By.name("enter-name"));
		element.sendKeys("Usha");
		String name=element.getAttribute("value");
		System.out.println("Name : "+name);
		
	}
}
