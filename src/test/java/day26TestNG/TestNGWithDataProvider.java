package day26TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGWithDataProvider {
	@Test(dataProvider="getData",priority=1)
	public void registration(int id, String name, String designation) {
		System.out.println("Id : "+id+" Name : "+name+" Designation : "+designation);		
	}
	
	@Test(priority=2)
	public void login() {
		System.out.println("Logging in.....................!!!");
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[4][3];
		data[0][0]=100;
		data[0][1]="MS Dhoni";
		data[0][2]="Wicket Keeper";
		data[1][0]=200;
		data[1][1]="Rohit Sharma";
		data[1][2]="Vice Captain";
		data[2][0]=300;
		data[2][1]="Virat Kohli";
		data[2][2]="Captain";
		data[3][0]=400;
		data[3][1]="Shikhar Dhavan";
		data[3][2]="Batsman";
		return data;
	}

}
