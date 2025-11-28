package single;

public class SingletonClass {
	
	private static SingletonClass sc = null;
	public int temp;	

	private SingletonClass() {
	}
	
	public static SingletonClass getInstance() {
		if(sc == null) {
			sc = new SingletonClass();
		}
		return sc;
	}
}




