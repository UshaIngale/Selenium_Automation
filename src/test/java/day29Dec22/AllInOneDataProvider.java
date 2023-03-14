package day29Dec22;

import org.testng.annotations.DataProvider;

public class AllInOneDataProvider {
	@DataProvider(name = "getData1")
	public Object[][] getData1() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Virat";
		data[0][1] = "ViratPwd1";

		data[1][0] = "Rohit";
		data[1][1] = "RohitPwd2";

		return data;
	}

	@DataProvider(name = "getData2")
	public Object[][] getData2() {
		Object[][] data = new Object[3][3];
		data[0][0] = "Surya";
		data[0][1] = "SuryaPwd1";
		data[0][2] = 1000;

		data[1][0] = "Shikhar";
		data[1][1] = "ShikharPwd2";
		data[1][2] = 2000;

		data[2][0] = "Dhoni";
		data[2][1] = "DhoniPwd2";
		data[2][2] = 3000;

		return data;
	}

}
