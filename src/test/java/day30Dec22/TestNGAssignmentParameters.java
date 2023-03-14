package day30Dec22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAssignmentParameters {
	WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "environment", "url", "maximize" })
	public void launchBrowser(String browser, String env, String url, String maximize) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(url);

		if (Boolean.parseBoolean(maximize))
			driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void getTextValue() {
		WebElement element = driver.findElement(By.name("enter-name"));
		element.sendKeys("Usha");
		String name = element.getAttribute("value");
		System.out.println("Name : " + name);

	}
}
