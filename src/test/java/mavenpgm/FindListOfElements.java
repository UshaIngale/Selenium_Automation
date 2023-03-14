package mavenpgm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindListOfElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		WebElement box=driver.findElement(By.xpath("//ul[@class='flinklist clearfix']"));
		List<WebElement> listofWebElement=box.findElements(By.xpath("li/a"));
		
		System.out.println(listofWebElement.size());
		int cnt=1;
		for(WebElement we:listofWebElement)
		{
			System.out.println((cnt++)+" = "+we.getAttribute("title"));
		}
		
		
		driver.close();
		
		
	}

}
