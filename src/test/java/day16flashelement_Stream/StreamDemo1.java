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
//public class StreamDemo1 {
//	@Test
//	public void verifyDataWithStream() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//		driver.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[1]")).click();
//		driver.findElement(By.xpath("(//div[@class='oxd-table-header-sort'])[3]")).click();
//		
//		driver.findElement(By.xpath("(//li[@class='oxd-table-header-sort-dropdown-item'])[5]/span")).click();
//		
//		List<WebElement> low=driver.findElements(By.xpath("//div[@class='oxd-table-body']/div/div/div[4]"));
//		
//		List<String> employeeName=low.stream().map(s->s.getText()).collect(Collectors.toList());
//		
//		List<String> empNameSorted=employeeName.stream().sorted().collect(Collectors.toList());
////		System.out.println("Expected list By Application Ascending Sort: ");
////		for(String s:employeeName) {
////			System.out.println(s);
////		}
////		System.out.println("-------------------------------------------------------------------");
////		System.out.println("Expected list By Java Ascending Sort: ");
////		for(String str:empNameSorted) {
////			System.out.println(str);
////		}
//		
//		Assert.assertEquals(employeeName, empNameSorted,"List are not equal");
//		
//	}
//
//}
