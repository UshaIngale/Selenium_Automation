package day2Dec22;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
		
		WebElement fullname=driver.findElement(By.id("userName"));
		fullname.sendKeys("Usha Ingale");
		
		WebElement email=driver.findElement(By.id("userEmail"));
		email.sendKeys("ingaleusha2310@gmail.com");
		
		WebElement currentAddress=driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Kothrud, Pune");
		
		String k=Keys.chord(Keys.CONTROL,"A");
		currentAddress.sendKeys(k);
		
		k=Keys.chord(Keys.CONTROL,"C");
		currentAddress.sendKeys(k);
		
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
		permanentAddress.clear();
		k=Keys.chord(Keys.CONTROL,"V");
		permanentAddress.sendKeys(k);
		
		Thread.sleep(4000l);
		driver.quit();
		
	}

}
