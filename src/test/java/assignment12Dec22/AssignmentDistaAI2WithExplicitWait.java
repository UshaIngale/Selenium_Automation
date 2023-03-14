package assignment12Dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentDistaAI2WithExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.dista.ai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		Actions actions = new Actions(driver);
		WebElement product = driver.findElement(By.xpath("(//ul[@id='menu-main-menu'])[1]/li/a"));
		System.out.println(product.getText());
		actions.moveToElement(product).perform();

		WebElement distaFood = driver.findElement(By.xpath("(//li[@id='nav-menu-item-943']//h3)[5]/a"));
		String url = distaFood.getAttribute("href");
		System.out.println(url);
		distaFood.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[1]/span)[2]"),"1500"));
		wait.until(ExpectedConditions.textToBe(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[1]/span)[2]"),"1500"));
		WebElement stores = driver.findElement(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[1]/span)[2]"));
		if((stores.getText()).equals("1500"))
			System.out.println("Stores value = " +stores.getText() );
		else
			System.out.println("Stores value = " +stores.getText() );
		
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[2]/span)[2]"),"50"));
		wait.until(ExpectedConditions.textToBe(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[2]/span)[2]"),"50"));
		WebElement customers = driver.findElement(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[2]/span)[2]"));
		if((customers.getText()).equals("50"))
		System.out.println("Customers value = " + customers.getText());
		else
			System.out.println("Customers value = " + customers.getText());
		
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[3]/span)[2]"),"99.9"));
		wait.until(ExpectedConditions.textToBe(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[3]/span)[2]"),"99.9"));
		WebElement upTime = driver.findElement(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[3]/span)[2]"));
		if((upTime.getText()).equals("99.9"))
		System.out.println("UpTime value = " + upTime.getText());
		else
			System.out.println("UpTime value = " + upTime.getText());	
		
		Thread.sleep(4000l);
		driver.quit();
	}
	
}
