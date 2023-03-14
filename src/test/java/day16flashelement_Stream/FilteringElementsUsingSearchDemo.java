//package day16flashelement_Stream;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class FilteringElementsUsingSearchDemo {
//	@Test
//	public void verifySortedElements() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("D");
//		
//		List<WebElement> low=driver.findElements(By.xpath("//ul[@class='oxd-main-menu']//li/a//span"));
//		List<WebElement> sortedList=low.stream().filter(s->s.getText().toUpperCase().contains("D")).collect(Collectors.toList());
//		System.out.println("Size of List 1 : "+low.size()+" and List 2 : "+sortedList.size());
//		Assert.assertEquals(low.size(), sortedList.size(),"Both list are not matching");
//		
//	}
//}
