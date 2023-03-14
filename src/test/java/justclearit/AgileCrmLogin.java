package justclearit;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AgileCrmLogin {
	public WebDriver driver;
	public By username = By.name("email");
	public By password = By.name("password");
	public By signIn = By.xpath("//input[@type='submit']");
	public By forgotPassword = By.xpath("//a[2]");
	public By logout = By.xpath("(//div[@class='preference-menu']//div)[12]/div/a");

	public By profile = By.xpath("(//li[@id='fat-menu'])[1]");
	public By errorMsg = By.xpath("(//div[@id='openid_btns']//div)[14]");
	public By errorMsg2 = By.xpath("(//div[@id='app']//div)[19]");

	String errorMsgData;

	@BeforeMethod
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://ushatesting.agilecrm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// driver.findElement(username).getAttribute("validationMessage");

	}

	public void login(String usernm, String pwd) {
		driver.findElement(username).sendKeys(usernm);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
	}

	public void logout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(profile))).click();
		driver.findElement(logout).click();
	}

	@Test(dataProvider = "loginData")
	public void verifyLogin(String usernm, String pwd, boolean valid) {
		login(usernm, pwd);
		if (valid) {
			if (driver.findElement(profile).isDisplayed()) {
				System.out.println("User logged in to application successfully...!!!");
			}
			logout();
		} else {
			verify(usernm, pwd);

		}

	}

	public void verify(String usernm, String pwd) {
		try {
			if ((usernm.isEmpty() || pwd.isEmpty())) {

				if (usernm.isEmpty())
					errorMsgData = driver.findElement(username).getAttribute("validationMessage");
				else if (pwd.isEmpty())
					errorMsgData = driver.findElement(password).getAttribute("validationMessage");
				System.out.println(errorMsgData);
			} else {
				
				if (!usernm.contains("@")) {
					errorMsgData = driver.findElement(username).getAttribute("validationMessage");
					System.out.println(errorMsgData);
				} else {
					if(usernm.contains("%")) {
						errorMsgData = driver.findElement(username).getAttribute("validationMessage");
						System.out.println(errorMsgData);
					}
					else if (driver.findElement(errorMsg).isDisplayed()) {
						System.out.println(driver.findElement(errorMsg).getText());
					} else if (driver.findElement(errorMsg2).isDisplayed()) {
						System.out.println(driver.findElement(errorMsg).getText());
					}
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element is not found..." + "\n");

		}
	}

	@DataProvider
	public Object[][] loginData() {

		return new Object[][] { { "usha.2310@yopmail.com", "CGPYWLPE", true }, 
			{ "usha.2310@yopmail.com", "", false },
				{ "usha.2310@yopmail.com", "cnjhsdhsdgdd1123", false },
				{ "abc123", "", false },
				{ "", "abc123", false },
				{ "", "", false },
				{ "12345", "2113", false },
				{ "@$^&%", "%#%^^^", false } };

	}

}
