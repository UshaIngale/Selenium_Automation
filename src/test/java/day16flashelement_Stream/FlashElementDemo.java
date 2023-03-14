package day16flashelement_Stream;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlashElementDemo {

	@Test
	public void flashElementTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[2]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("AAAA");
		driver.findElement(By.name("middleName")).sendKeys("BBBB");
		driver.findElement(By.name("lastName")).sendKeys("CCCC");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//We have to pause dom execution to locate flash element.
		String flashMsg=driver.findElement(By.xpath("//div[@class='oxd-toast-start']//p[2]")).getText();
		System.out.println("Flash Message : "+flashMsg);
		Assert.assertEquals("Successfully Saved", flashMsg);
		driver.close();
	}
}
