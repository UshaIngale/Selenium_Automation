package day7Dec22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryListDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.findElement(By.id("justAnInputBox")).click();
		
		List<WebElement> ListWebElements = driver.findElements(By.xpath("(//div[@class=\"comboTreeDropDownContainer\"])[1]//ul[1]//li//span[contains(@class,\"comboTreeItemTitle\")]"));
		int cnt=1;
		for(int i=0;i<ListWebElements.size();i++)
		{
			System.out.println((cnt++)+" : "+ListWebElements.get(i).getText());
		}
		Thread.sleep(4000l);
		driver.quit();
		}
		
	}

