//
//  package day22dec22;
//  
//  import java.time.Duration;
//  
//  import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
//  org.openqa.selenium.WebElement; import
//  org.openqa.selenium.chrome.ChromeDriver;
//  
//  import io.github.bonigarcia.wdm.WebDriverManager;
//  
//  public class FriendlyLocatorsDemo {
//  
//  public static void main(String[] args) {
//  WebDriverManager.chromedriver().setup(); WebDriver driver = new
//  ChromeDriver(); driver.get("https://courses.letskodeit.com/practice");
//  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//  
//  WebElement element = driver.findElement(By.id("opentab"));
//  
//  WebElement ele =
//  driver.findElement(with(By.tagName("legend")).toLeftOf(element));
//  System.out.println("toLeftOf legend: " + ele.getText());
//  
//  ele = driver.findElement( with(By.tagName("legend")).above(element));
//  System.out.println("Above legend: " + ele.getText());
//  
//  
//  ele = driver.findElement( with(By.tagName("legend")).near(element));
//  System.out.println("near legend: " + ele.getText());
//  
//  ele = driver.findElement( with(By.tagName("legend")).below(element));
//  System.out.println("below legend: " + ele.getText());
//  
//  ele = driver.findElement( with(By.tagName("legend")).toRightOf(element));
//  System.out.println("toRightOf legend: " + ele.getText());
//  
//  ele = driver.findElement( with(By.tagName("option")).toRightOf(element));
//  System.out.println("toRightOf option: " + ele.getText());
//  
//  
//  
//  //webTable friendly locators WebElement element2 =
//  driver.findElement(By.xpath("//*[@id='product']/tbody/tr[3]/td[3]"));
//  System.out.println("element2.getText() =>" + element2.getText()); //30 ele =
//  driver.findElement(with(By.tagName("td")).near(element2));
//  System.out.println("near text: " + ele.getText());
//  
//  element2 =
//  driver.findElement(By.xpath("//*[@id='product']/tbody/tr[4]/td[3]")); ele =
//  driver.findElement(with(By.tagName("td")).near(element2)); // 25
//  System.out.println("25 near text: " + ele.getText()); //30
//  
//  
//  }
//  
//  }
// 