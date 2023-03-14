package day29Dec22;

import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvocationCountDemo {
	
	@Test(invocationCount = 10)
	public void test1() {
		Random rnd = new Random();
		int n = 0;
		n = rnd.nextInt(1000);
		System.out.println("Virat_" + n);
	}
}
