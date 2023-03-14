package day6Dec22;

import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		
		Date dt=new Date();
		System.out.println(dt.toString().replace(" ", "_").replace(":", "_"));
	}

}
