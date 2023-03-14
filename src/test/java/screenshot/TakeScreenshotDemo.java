package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.codeGreen.com");
		
		TakesScreenshot ts=((TakesScreenshot)driver);
		File screenshotFile=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("src/test/resources/ScreenshotPkg/SampleScreenshot.png"));
		
		driver.close();
		
	}

}
