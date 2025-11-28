package cls;

import single.SingletonClass;

public class MyClass {
	private int aaa;
	
	// setter
//	public void setAaa(int aaa) {
//		this.aaa = aaa;
//		System.out.println("aaa:" + aaa);
//	}
	
	public void method() {
		SingletonClass sc = SingletonClass.getInstance();
		aaa = sc.temp;
		System.out.println("aaa:" + aaa);
	}
}
