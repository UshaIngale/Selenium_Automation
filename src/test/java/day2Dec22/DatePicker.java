package day2Dec22;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250);", "");
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		LocalDate todayDate =LocalDate.now();
		System.out.println(todayDate);
		int todayYear=todayDate.getYear();
		int todayMonth=todayDate.getMonthValue();
		//int todayDay=todayDate.getDayOfMonth();
		LocalDate targetDate =LocalDate.of(2020,10,23);
		System.out.println(targetDate);
		int targetYear=targetDate.getYear();
		int targetMonth=targetDate.getMonthValue();
		int targetDay=targetDate.getDayOfMonth();
		boolean increament=true;
		int monthDiff=0,monthDiff1=0;
		if(targetDate.isAfter(todayDate))
		{
			if(targetYear>todayYear)
			{
				int diffmonths=(targetYear-todayYear-1)*12;
				System.out.println(diffmonths);
				monthDiff=12-todayMonth;
				monthDiff1=targetMonth-0;
				monthDiff=monthDiff+monthDiff1+diffmonths;
				increament=true;
			}
			else if(targetYear==todayYear)
			{
				if(targetMonth>todayMonth)
				{
					monthDiff=targetMonth-todayMonth;
					increament=true;
				}
				else
				{
					monthDiff=todayMonth-targetMonth;
					increament=false;
				}
			}
		}
		else if(targetDate.isBefore(todayDate))
		{
			if(targetYear<todayYear)
			{
				int diffmonths=(todayYear-targetYear-1)*12;
				System.out.println(diffmonths);
				monthDiff=12-targetMonth;
				monthDiff1=todayMonth-0;
				monthDiff=monthDiff+monthDiff1+diffmonths;
				increament=false;
			}
			else if(targetYear==todayYear)
			{
				if(targetMonth>todayMonth)
				{
					monthDiff=targetMonth-todayMonth;
					increament=true;
				}
				else
				{
					monthDiff=todayMonth-targetMonth;
					increament=false;
				}
			}
		}
		else if(targetDate.isEqual(todayDate))
		{
			if(targetMonth>todayMonth)
			{
				monthDiff=targetMonth-todayMonth;
				increament=true;
			}
			else
			{
				monthDiff=todayMonth-targetMonth;
				increament=false;
			}
		}
		System.out.println("Month Diff : "+monthDiff+" Increament : "+increament);
		for(int counter=0;counter<monthDiff;counter++)
		{
			WebElement incrementElement=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div//a[2]/span"));
			WebElement decrementElement=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div//a[1]/span"));
			if(increament)
			{
				incrementElement.click();
				Thread.sleep(1000l);
			}
			else
			{
				decrementElement.click();
				Thread.sleep(1000l);
			}
		}
		System.out.println(String.valueOf(targetDay));
		driver.findElement(By.linkText(String.valueOf(targetDay))).click();
		
		Thread.sleep(4000l);
		driver.quit();
}
}
