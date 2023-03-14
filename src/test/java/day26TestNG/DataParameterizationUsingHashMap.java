package day26TestNG;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParameterizationUsingHashMap {
	
	@Test(dataProvider="getData")
	public void login(Map<String,String> m) {
		System.out.println("Username : "+m.get("username")+"\nPassword : "+m.get("password")+"\n");
	}
	@DataProvider
	public Object[] getData() {
		Object[] data=new Object[4];
		Map<String,String> map1=new HashMap<String, String>();
		map1.put("username", "Usha");
		map1.put("password", "Usha2310");
		data[0]=map1;
		Map<String,String> map2=new HashMap<String, String>();
		map2.put("username", "Pooja");
		map2.put("password", "Pooja123");
		data[1]=map2;
		Map<String,String> map3=new HashMap<String, String>();
		map3.put("username", "Sneha");
		map3.put("password", "Sneha123");
		data[2]=map3;
		Map<String,String> map4=new HashMap<String, String>();
		map4.put("username", "Jyoti");
		map4.put("password", "Jyoti123");
		data[3]=map4;
		
		return data;
	}

}
