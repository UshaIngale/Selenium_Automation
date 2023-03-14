package day28nov22;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListOfCources {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000l));
		System.out.println("Title => "+driver.getTitle());
		
		WebElement cwind = driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(cwind);
		String lblAllCourses = driver.findElement(By.xpath("//*[@id='zen_all_courses_dynamic']/div[1]/h1")).getText();
		System.out.println(lblAllCourses);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		 //WebElement iframe = driver.findElement(By.tagName("iframe"));
	     //new Actions(driver).scrollToElement(cwind).build().perform();
		//int deltaY = cwind.getRect().y;
       // new Actions(driver).scrollByAmount(0, deltaY).build().perform();
        
		Thread.sleep(5000l);
		
		List<WebElement> courseList = driver.findElements(By.xpath("//h4"));
		System.out.println("courses list size : "+ courseList.size());
		
		//for(int i=0;i<courseList.size();i++)
		//{
			//System.out.println(courseList.get(i).getText());
		//}
		
		ListIterator<WebElement> li=null;
		try {li = courseList.listIterator(courseList.size());
		} catch (Exception e) {e.printStackTrace();
		}
		 while (li.hasPrevious()) {System.out.println(li.previous().getText());
		    }
		    
		Thread.sleep(4000l);
		driver.quit();
}
}
