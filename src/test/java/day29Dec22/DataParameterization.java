package day29Dec22;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataParameterization {
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test #1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test #1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method #1");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method #1");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class #1");
	}

	@AfterMethod
	public void afterClass() {
		System.out.println("after Class #1");
	}

	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("before Suite #1");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite #1");
	}

	@Test(dataProvider = "getData1", dataProviderClass = AllInOneDataProvider.class)
	public void test1(String username, String pwd) {
		System.out.println("-----------------------------");
		System.out.println(username + " :: " + pwd);
		System.out.println("-----------------------------");
	}

	@Test(dataProvider = "getData2", dataProviderClass = AllInOneDataProvider.class)
	public void test2(String username, String pwd, int Salary) {
		System.out.println("-----------------------------");
		System.out.println(username + " :: " + pwd + " :: " + Salary);
		System.out.println("-----------------------------");
	}
}
