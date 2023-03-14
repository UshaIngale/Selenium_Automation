package day28nov22;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragOperation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println("Title = "+driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id='sidebar']/aside[1]/ul/li[3]/a")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(5000l);
		
		driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(0);
		
		WebElement from = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		
		Actions dragop = new Actions(driver);
		dragop.dragAndDropBy(from, 250,200).perform();
		//dragop.clickAndHold(from).moveByOffset(200, 200).build().perform();
		//action.clickAndHold(resizableLink).moveByOffset(200, 200).release().build().perform();

		Thread.sleep(5000l);
		driver.quit();

	}

}
