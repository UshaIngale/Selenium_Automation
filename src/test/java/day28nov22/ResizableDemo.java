package day28nov22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizableDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.findElement(
				By.xpath("//*[@id='sidebar']/aside[1]/ul/li[3]/a")).click();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(300,300)", "");
		
		WebElement element = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(element);
		
		WebElement resizableLink = 
				driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		
		Actions action = new Actions(driver);
				action.clickAndHold(resizableLink).moveByOffset(200, 200).release().build().perform();
		
		 Thread.sleep(4000l);
		 driver.quit();
	}

}
