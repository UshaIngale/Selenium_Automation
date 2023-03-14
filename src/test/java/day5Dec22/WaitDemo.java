package day5Dec22;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	/*	//External Wait --> WebDriverWait
		driver.findElement(By.name("q")).sendKeys("Facebook");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li[1]/div/div[2]/div[1]/span"))).click();
		//driver.findElement().click();
	*/	
		
		//External Wait --> FluentWait
		driver.findElement(By.name("q")).sendKeys("Facebook");
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofMillis(20));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li[1]/div/div[2]/div[1]/span")));
		WebElement txtOptionFirst= driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li[1]/div/div[2]/div[1]/span"));
		String txt=txtOptionFirst.getText();
		System.out.println("TextOptionFirst = "+txt);
		
		
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
