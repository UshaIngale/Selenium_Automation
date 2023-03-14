package day26TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGDemoWithHelpingAttribute {

	@Test(priority = -1, enabled = false)
	public void registration() {
		System.out.println("This is registration method of Facebook");
	}

	@Test(priority = 0, description = "Verify login functionality.........!", timeOut = 3000)
	public void login() throws InterruptedException {
		System.out.println("This is login method of Faceebook");
		Thread.sleep(3000l);
	}

	@Test(priority = 1,dependsOnMethods= {"login"},alwaysRun=true)
	public void logout() {
		System.out.println("This is logout method of Faceebook");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This will executed prior/before every method/Test Case/Test Script");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This will executed after every method/Test Case/Test Script");
		System.out.println("-------------------------------------------------------------------");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This will executed before Test Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This will executed after Test Class");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This will executed before entire Test Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This will executed after entire Test Suite");
	}
}
