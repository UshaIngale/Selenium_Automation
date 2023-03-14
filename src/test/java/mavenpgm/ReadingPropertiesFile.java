package mavenpgm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingPropertiesFile {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		Properties prop = null;
		String rootFolder = System.getProperty("user.dir");
		System.out.println(rootFolder);
		try {
			FileInputStream fis = new FileInputStream(rootFolder + "/src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}

		String URL = prop.getProperty("url");
		System.out.println("URL : " + URL);

		String br = prop.getProperty("browser");
		System.out.println("Browser : " + br);
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser " + br);
			throw new RuntimeException("Invalid Browser");
		}

		driver.get(URL);
		System.out.println("driver.getTitle() = " + driver.getTitle());
		Thread.sleep(4000l);
		driver.close();

	}
}
