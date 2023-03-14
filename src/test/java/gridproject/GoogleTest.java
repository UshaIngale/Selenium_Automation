package gridproject;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	@Test
	public void GTest() throws MalformedURLException //throws MalformedURLException
	{
		 DesiredCapabilities dc = new DesiredCapabilities();
		 dc.setBrowserName("firefox");
		 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.31.133:6669"),dc);

//		 WebDriverManager.chromedriver().setup();
//		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.google.com");
		 System.out.println("Google title : "+ driver.getTitle());
		 driver.quit();
	 }

}
