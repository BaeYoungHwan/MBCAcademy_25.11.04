package inter;

public class HeClass implements MyInterface, YouInterface {

	@Override
	public void func() {
		System.out.println("HeClass func()");
	}

	@Override
	public void method() {
		System.out.println("HeClass method()");
	}
}
