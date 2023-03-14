package day28nov22;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000l));
		
		System.out.println("Title => "+driver.getTitle());
		Thread.sleep(4000l);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(4000l);
		js.executeScript("window.scrollBy(0,-10000)", "");
		Thread.sleep(4000l);
		driver.quit();
	}

}
