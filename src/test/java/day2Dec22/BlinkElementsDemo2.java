package day2Dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlinkElementsDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@class='_6ltg'][2]/a")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement firstName=driver.findElement(By.name("firstname"));
		highlight(js, firstName);
		firstName.sendKeys("Usha"); Thread.sleep(2000l);
		

	 	WebElement lastName = driver.findElement(By.name("lastname"));
	 	highlight(js, lastName);
	 	lastName.sendKeys("Ingale");Thread.sleep(2000l);
	 	
		
		
		WebElement txtEmail = driver.findElement(By.name("reg_email__"));
		highlight(js, txtEmail);
		txtEmail.sendKeys("ingaleusha2310@gmail.com");
		
		String val= driver.findElement(By.name("firstname")).getAttribute("value");
		System.out.println("value: " + val);

		String txt = driver.findElement(By.name("firstname")).getText();
		System.out.println("txt: " + txt); //will not have any value

		
		System.out.println(firstName.getCssValue("background-color"));
		System.out.println(lastName.getCssValue("background-color"));
		System.out.println(txtEmail.getCssValue("background-color"));
		
		Thread.sleep(4000l);
		driver.quit();


			}
	static void highlight(JavascriptExecutor js, WebElement element)
	{
		for(int i=0;i<=100;i++)
		{
			if (i%2==0)
				js.executeScript("arguments[0].style.backgroundColor='red'",element);
			else
				js.executeScript("arguments[0].style.backgroundColor='white'",element);
		}
		js.executeScript("arguments[0].style.backgroundColor='white'",element);

	}


}
