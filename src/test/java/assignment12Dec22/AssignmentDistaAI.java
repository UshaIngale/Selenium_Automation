package assignment12Dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentDistaAI {

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
		WebElement stores = driver.findElement(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[1]/span)[2]"));
		String sno=doValidation(stores,"1500");
		System.out.println("Stores value = " + sno);
		
		WebElement customers = driver.findElement(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[2]/span)[2]"));
		String cust=doValidation(customers,"50");
		System.out.println("Customers value = " + cust);		
		
		WebElement upTime = driver.findElement(By.xpath("((//div[@class='elementor-counter-number-wrapper'])[3]/span)[2]"));
		String uptime=doValidation(upTime,"99.9");
		System.out.println("UpTime value = " + cust);		
		
		Thread.sleep(4000l);
		driver.quit();
	}
	static String doValidation(WebElement we,String value)
	{
		String s = we.getText();
		//int i = F.parseInt(s);
		while (!value.equals(s)) {
			s = we.getText();
			//i = Integer.parseInt(s);	
		}
		
		return s;
	}
	
	

}
