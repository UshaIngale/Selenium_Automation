package day5Dec22;

public class OtherClassForSingletonClassDemo {

	public static void main(String[] args) {
		
		SingletonClassDemo obj1=SingletonClassDemo.getInstance();
		SingletonClassDemo obj2=SingletonClassDemo.getInstance();
		SingletonClassDemo obj3=SingletonClassDemo.getInstance();
		
		System.out.println("obj1 = "+obj1.hashCode());
		System.out.println("obj2 = "+obj2.hashCode());
		System.out.println("obj3 = "+obj3.hashCode());
	}

}
