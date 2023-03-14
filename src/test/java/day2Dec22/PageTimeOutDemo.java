package day2Dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageTimeOutDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("https://demoqa.com/text-box");
		
		driver.findElement(By.id("userName")).sendKeys("Usha Ingale");
		driver.findElement(By.id("userEmail")).sendKeys("ingaleusha2310@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Kothrud, Pune");
		
		Thread.sleep(4000l);
		driver.quit();
	}

}
