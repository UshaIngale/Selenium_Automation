package assignment25Dec22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookCreateNewAcc {

	public static WebDriver driver = null;
	public static WebElement element = null;
	// Locators
	public static final By btnCreateNewAcc = By.cssSelector("a[data-testid='open-registration-form-button']");
	public static final By txtFirstname = By.name("firstname");
	public static final By txtLastname = By.name("lastname");
	public static final By txtEmailOrMobileNo = By.name("reg_email__");
	public static final By txtReEnterEmail = By.name("reg_email_confirmation__");
	public static final By txtPassword = By.id("password_step_input");
	public static final By selectDayFromList = By.id("day");
	public static final By selectMonthFromList = By.id("month");
	public static final By SelectYearFromList = By.id("year");
	public static final By radioBtnGenderFemale = By.xpath("(//input[@name='sex'])[1]");
	public static final By radioBtnGenderMale = By.xpath("(//input[@name='sex'])[2]");
	public static final By radioBtnGenderCustom = By.xpath("(//input[@name='sex'])[3]");
	public static final By selectCustomPreferredPronoun = By.name("preferred_pronoun");
	public static final By preferredPronounFirst = By.xpath("(//select[@name='preferred_pronoun']/option)[2]");
	public static final By preferredPronounSecond = By.xpath("(//select[@name='preferred_pronoun']/option)[2]");
	public static final By preferredPronounThird = By.xpath("(//select[@name='preferred_pronoun']/option)[2]");
	public static final By btnSignUp = By.name("websubmit");

	public static String browser = "chrome";// valid browser names are "chrome","firefox","edge".
	public static String url = "https://www.facebook.com";
	public static int timeout = 4;

	// Input data
	public static String firstname = "Shivansh";
	public static String lastname = "Garad";
	public static String emailOrMobileNo = "shiv.garad1703@gmail.com";
	public static String password = "usha&shiv22";
	public static String birthDay = "23";
	public static String birthMonth = "Oct";
	public static String birthYear = "1996";
	public static String gender = "Female";
	public static int preferredPronounOptionNo = 1;

	public static String destFile = System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg\\error";
	public static File sourceFile;

	public static void main(String[] args) throws IOException {
		try {
			launchBrowser(browser, url);
			sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			clickOnElement(getElement(btnCreateNewAcc));
			typeInfo(txtFirstname, firstname);
			typeInfo(txtLastname, lastname);
			typeInfo(txtEmailOrMobileNo, emailOrMobileNo);
			typeInfo(txtPassword, password);
			boolean reEnterEmail = driver.findElement(txtReEnterEmail).isDisplayed();
			if (reEnterEmail)
				driver.findElement(txtReEnterEmail).sendKeys(emailOrMobileNo);
			selectFromDropDown(selectDayFromList, birthDay);
			selectFromDropDown(selectMonthFromList, birthMonth);
			selectFromDropDown(SelectYearFromList, birthYear);
			selectGender(radioBtnGenderFemale, gender);
			clickOnElement(getElement(btnSignUp));
			System.out.println("Test Case Passed Successfully..............!!!");
		} catch (Exception e) {
			captureScreenshot(sourceFile, destFile);
		}

	}

	public static void launchBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser " + browserName);
			throw new RuntimeException("Invalid Browser " + browserName);
		}
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		System.out.println(browserName + " browser launched");
	}

	public static WebElement getElement(By locatorOfWebElement) throws IOException {

		try {
			element = driver.findElement(locatorOfWebElement);
		} catch (Exception e) {
			captureScreenshot(sourceFile, destFile);
			System.out.println("Exception -> Element not found");
		}
		return element;
	}

	public static void clickOnElement(WebElement element) throws IOException {
		try {
			element.click();
			if (element.getAttribute("value").equals("-1")) {
				selectPreferredPronoun(preferredPronounOptionNo);

			}

		} catch (Exception e) {
			captureScreenshot(sourceFile, destFile);
			System.out.println("Click on " + (element.getText()) + " is not done.");
		}
	}

	public static void typeInfo(By locator, String text) throws IOException {
		try {
			element = getElement(locator);
			element.sendKeys(text);
		} catch (Exception e) {
			captureScreenshot(sourceFile, destFile);

		}
	}

	public static void selectFromDropDown(By locator, String info) throws IOException {
		WebElement list = getElement(locator);
		System.out.println(list.getAttribute("id"));
		list.click();
		if (list.getAttribute("id").equals("day")) {

			List<WebElement> elements = driver.findElements(By.xpath("//select[@id='day']/option"));
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getText().equals(info)) {
					elements.get(i).click();
					System.out.println(elements.get(i).getText());
					break;
				}
			}
		}

		if (list.getAttribute("id").equals("month")) {

			List<WebElement> elements = driver.findElements(By.xpath("//select[@id='month']/option"));
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getText().equals(info)) {
					elements.get(i).click();
					System.out.println(elements.get(i).getText());
					break;
				}
			}
		}
		if (list.getAttribute("id").equals("year")) {

			List<WebElement> elements = driver.findElements(By.xpath("//select[@id='year']/option"));
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getText().equals(info)) {
					elements.get(i).click();
					System.out.println(elements.get(i).getText());
					break;
				}
			}
		}

	}

	public static void selectPreferredPronoun(int num) throws IOException {
		try {
			if (num == 1) {
				getElement(preferredPronounFirst).click();
			} else if (num == 2) {
				getElement(preferredPronounSecond).click();
			} else if (num == 3) {
				getElement(preferredPronounThird).click();
			}
		} catch (Exception e) {
			captureScreenshot(sourceFile, destFile);
		}
	}

	public static void selectGender(By locator, String gender) throws IOException {
		try {
			if (gender.equalsIgnoreCase("Female")) {

				getElement(locator).click();
			} else if (gender.equalsIgnoreCase("Male")) {
				getElement(locator).click();
			} else {
				if (gender.equalsIgnoreCase("Custom")) {
					clickOnElement(getElement(radioBtnGenderCustom));
				}
				else
					throw new RuntimeException("Invalid gender " + gender);
				System.out.println("Gender : "+gender);
			}
		} catch (Exception e) {
			captureScreenshot(sourceFile, destFile);
		}
	}

	public static void captureScreenshot(File source, String destFile) throws IOException {
		Date dt = new Date();
		destFile = destFile + "_" + dt.toString().replaceAll(" ", "_").replaceAll(":", "_") + ".png";
		FileUtils.copyFile(source, new File(destFile));
	}

}
