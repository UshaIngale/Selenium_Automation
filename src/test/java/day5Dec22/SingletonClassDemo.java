package day5Dec22;

public class SingletonClassDemo {

	private static SingletonClassDemo obj=null;
	
	private SingletonClassDemo()
	{
	
	}
	public static SingletonClassDemo getInstance()
	{
		if(obj==null)
		{
		 obj=new SingletonClassDemo();
		 return obj;
		}
		else
		{
			return obj;
		}
	
	}

}
