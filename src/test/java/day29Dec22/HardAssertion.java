package day29Dec22;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HardAssertion {
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test #2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test #2");
	}

	@Test
	public void test1() {
		int a = 100, b = 100;
		Assert.assertTrue(a == b, "Value of a " + a + " is not euqal to value of b " + b);

		int x = 100, y = 100;
		Assert.assertFalse(x != y, "Value of x " + x + " is euqal to value of y " + y);

		int act = 100, exp = 100;
		Assert.assertEquals(act, exp, "both values are not same !!!");

		int act1 = 100, exp1 = 200;
		Assert.assertNotEquals(act1, exp1, "both values are same !!!");

	}
}
