package day6Dec22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HeadlessBrowserExecutionDemo {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		Date dt = new Date();
		// System.out.println(dt.toString());
		double start = dt.getTime();
		System.out.println("Start Milli Seconds: " + start);
		// Chrome headless
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		driver = new ChromeDriver(option);

		// Firefox headless
//		  WebDriverManager.firefoxdriver().setup(); 
//		  FirefoxOptions option = new FirefoxOptions(); 
//		  option.setHeadless(true); 
//		  WebDriver driver=new FirefoxDriver(option);

		// Edge
		// WebDriverManager.edgedriver().setup();
		// EdgeOptions option=new EdgeOptions();
		// option.setHeadless(true);
		// WebDriver driver=new EdgeDriver(option);

		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Title is " + driver.getTitle());
		driver.findElement(By.id("opentab")).click();
		Set<String> windIds = driver.getWindowHandles();
		Iterator<String> iter = windIds.iterator();
		String pWindId = iter.next();
		String cWindId = iter.next();

		driver.switchTo().window(cWindId);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("All"));
		captureScreenshot();
		System.out.println("cWind title: " + driver.getTitle());
		driver.switchTo().window(pWindId);
		System.out.println("pWind title: " + driver.getTitle());

		driver.quit();
		Date dt1 = new Date();
		double stop = dt1.getTime();
		System.out.println("End Milli Seconds: " + stop);
		System.out.println("Total Milli Seconds: " + (stop - start));
		double Seconds = (stop - start) / 1000;
		System.out.println("Total Seconds Required to Execute Script = " + Seconds);

	}

	public static void captureScreenshot() throws IOException {
		String destFile = System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg\\error";
		Date dt = new Date();
		destFile = destFile + "_" + dt.toString().replaceAll(" ", "_").replaceAll(":", "_") + ".png";
		
		Screenshot scs = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(scs.getImage(), "jpg",new File(destFile));
	}

}
