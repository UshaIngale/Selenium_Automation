package day6Dec22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String url = "https://courses.letskodeit.com/practice";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
		
		String destFile=System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenshotPkg\\error";
		File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		captureScreenshot(sourceFile,destFile);
		
		
		String url1 = "https://haquemousume.medium.com/how-to-run-postman-requests-tests-from-command-line-newman-f012afb06564";
		driver.get(url1);
		captureScreenshot(sourceFile,destFile);
		driver.quit();
	}
	
	static void captureScreenshot(File source,String destFile) throws IOException
	{
		Date dt=new Date();
		destFile=destFile+"_"+dt.toString().replaceAll(" ", "_").replaceAll(":", "_")+".png";
		FileUtils.copyFile(source, new File(destFile));
	}
}
