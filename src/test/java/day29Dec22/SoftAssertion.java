package day29Dec22;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
	public void test1()
	{
		
		SoftAssert sa = new SoftAssert();
		
 		int a = 100, b = 100;
 		sa.assertTrue( a!=b, "Value of a " +  a + " is not euqal to value of b " +  b);
	
 		int x = 100, y = 100;
 		sa.assertFalse(x==y, "Value of x " +  x + " is euqal to value of y " +  y);
	
 	    int act = 100, exp= 200;
 	    sa.assertEquals(act, exp, "both values are not same !!!");
	    
	    int act1 = 100, exp1= 100;
	    sa.assertNotEquals(act1, exp1, "both values are same !!!");

	    String str1 = "Solapur";
	    String str2 = "Solapur1";
	    sa.assertEquals(str1, str2, "both cities are different");
	    
	    sa.assertEquals(str1.equals(str2), "both cities are different");
	        
	    sa.assertAll();
}
}