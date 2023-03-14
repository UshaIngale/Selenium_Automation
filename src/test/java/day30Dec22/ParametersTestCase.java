package day30Dec22;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestCase {
	@Test
	@Parameters({"browser","env"})
	public void TestAudi(String browserName, String envName)
	{
		System.out.println("Cars: TestAudi  browser:" + browserName  + "  Env name:"+ envName);
	}

	@Test 
	public void TestCamry()
	{
		System.out.println("Cars: TestCamry");
		Assert.fail();
	}
	@Test 
	public void TestHonda()
	{
		System.out.println("Cars: TestHonda");
	}
	
	@Parameters({"responseCodes"})
	@Test 
	public void TestYamah(String responseCodes)
	{
		String[] resCode = responseCodes.split(",");
		for(String s: resCode)
			System.out.println("Bikes: Test Yamah  ResponseCode:"+ s);
	}
	
	@Test
	public void TestSuzuki()
	{
		System.out.println("Bikes: TestSuzuki");
	}
}
