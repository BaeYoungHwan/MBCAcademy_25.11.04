package main;

public class Main {
	public static void main(String[] args) {
		
		// final : 제약
		//         변수, 메소드, 클래스
		
		// 변수 -> 상수
		final int NUMBER = 100;	// #define  == const
		int num = NUMBER;
		
		// NUMBER = 20;		
		int array[] = new int[NUMBER];
		
		final int MAX = 100;
		final int MIN = 0;
		int count = 25;		
		// MAX = 1;
				
		if(count >= MIN && count <= MAX) {			
		}
		
	}
}

// 상속금지!
/*final*/ class Base{
		
	// Over Ride 금지!
	public /*final*/ void method() {
		
	}
}

class Grant extends Base{
	
	public void method(int num) {	// Over Ride
		
	}
}







