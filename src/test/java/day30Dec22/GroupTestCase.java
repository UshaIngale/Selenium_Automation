package day30Dec22;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTestCase {
	@Test(groups= {"Cars", "Vehicles"})
	public void TestAudi()
	{
		System.out.println("Cars: TestAudi  browser:");
	}

	@Test(groups= {"Cars"})
	public void TestCamry()
	{
		System.out.println("Cars: TestCamry");
		Assert.fail();
	}
	@Test(groups= {"Cars","Vehicles"})
	public void TestHonda()
	{
		System.out.println("Cars: TestHonda");
	}
	
	@Test(groups= {"Bikes"})   //, dependsOnGroups= {"Cars"})
	public void TestYamah()
	{
			System.out.println("Bikes: Test Yamah");
	}
	
	@Test(groups= {"Bikes","Suzuki"})
	public void TestSuzuki()
	{
		System.out.println("Bikes: TestSuzuki");
	}
}

