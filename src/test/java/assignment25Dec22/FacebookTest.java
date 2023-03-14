package assignment25Dec22;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class FacebookTest extends FacebookCreateNewAcc {
	@Test 
	public void VerifyFacebookAccountCreation() throws IOException {
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

}
