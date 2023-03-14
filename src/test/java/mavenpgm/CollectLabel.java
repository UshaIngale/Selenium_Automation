package mavenpgm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CollectLabel {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://courses.letskodeit.com/practice");
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		List<WebElement> loe = driver.findElements(By.xpath("//fieldset/legend"));
		System.out.println(loe.size());
		int cnt = 1;
		for (WebElement we : loe) {
			System.out.println((cnt++) + " = " + we.getText());
		}

		driver.quit();
	}

}
