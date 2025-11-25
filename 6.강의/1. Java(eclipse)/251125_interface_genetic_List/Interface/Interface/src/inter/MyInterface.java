package inter;

public interface MyInterface {

//	private int number;		// 변수선언 불가!
	
	int number = 10;			// 가능!
	final String name = "홍길동";
	
//	public void name() {	// 메소드선언 불가!		
//	}
	
	void method();	// 추상 메소드
}




