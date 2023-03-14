package day2Dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlinkElementDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
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
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 5px dashed red;');", firstName);
		
		firstName.sendKeys("Usha"); Thread.sleep(2000l);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid grey;');", firstName);

	 	WebElement lastName = driver.findElement(By.name("lastname"));
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 5px dotted red;');", lastName);
	 	lastName.sendKeys("Ingale");Thread.sleep(2000l);
	 	js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid grey;');", lastName);
		
		
		WebElement txtEmail = driver.findElement(By.name("reg_email__"));
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 5px solid red;');", txtEmail);
		txtEmail.sendKeys("ingaleusha2310@gmail.com");Thread.sleep(3000l);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid grey;');", txtEmail);

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

}
