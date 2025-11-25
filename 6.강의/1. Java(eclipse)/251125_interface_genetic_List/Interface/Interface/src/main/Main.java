package main;

import inter.HeClass;
import inter.MyClass;
import inter.MyInterface;
import inter.YouInterface;

public class Main {
	public static void main(String[] args) {		
		/*
		abstract class : abstract method + method + variable
						다중 상속이 불가능
		
		interface : abstract method 로만 구성되어 있다 
					(prototype 으로 선언되어 있는 메소드로만 구성)
					다중 상속이 가능
					빠르게 클래스 설계 또는 구성을 파악이 가능
					확장성에서 우수
					기본 접근자는 public 이다
		 */
		
		// MyInterface myinter = new MyInterface();
		// interface 만으로는 객체를 생성할 수 없다
		
		// 1.
		MyClass my = new MyClass();
		my.method();
		
		// 2.
		MyInterface myInter = new MyInterface() {			
			@Override
			public void method() {
				System.out.println("MyInterface method()");
			}
		};
		myInter.method();
		
		// 3.
		MyInterface inter = new MyClass();
		inter.method();
		
		
		HeClass hc = new HeClass();
		hc.method();
		hc.func();
		
//		MyInterface myi = new HeClass();
//		myi.method();
		
//		YouInterface youi = (YouInterface)myi;
//		youi.func();
		
		Object obj = new HeClass();
		
		((MyInterface)obj).method();
		
		
	}
}
/*
class A{
	
}
class B{
	
}
class C extends A, B{	// 다중상속은 안됨!
	
}
*/


