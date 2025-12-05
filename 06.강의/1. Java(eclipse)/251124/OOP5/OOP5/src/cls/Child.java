package cls;

public class Child extends Parent{

	@Override	// <--- annotation(지시어)
	public void method() {		// OverRide method 
		//super.method();
		System.out.println("Child method()");
	}
	/*
	public void method() {
		System.out.println("Child method()");
	}*/
	
	
	
}
