package mavenpgm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindListOfLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> loe=getLinks(By.xpath("//ul[@class='flinklist clearfix']/li/a"),driver);
		printLinks(loe);
		driver.quit();
		}
	static List<WebElement>getLinks(By Locator,WebDriver driver)
	{
		return driver.findElements(Locator);
	}
	static void printLinks(List<WebElement> loe)
	{
		int cnt=1;
		for(WebElement we:loe)
		{
			System.out.println((cnt++)+" = "+we.getAttribute("title"));
		}
	}
	}

