package cls;

import single.SingletonClass;

public class YouClass {
	private int bbb = 123;
	
	// getter
//	public int getBbb() {
//		return bbb;
//	}
	
	public void func() {
		SingletonClass sc = SingletonClass.getInstance();
		sc.temp = bbb;
	}
}


