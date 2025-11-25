package main;

import cls.Circle;
import cls.Shape;

public class Main {
	public static void main(String[] args) {
		/*
			abstract class : 추상 클래스
							추상메소드를 하나이상 포함하고 있는 클래스
							
			abstract method : 추상 함수
							(처리)내용은 없고 prototype만 설정되어 있는 함수 

		*/
		
	//	AbstractClass ac = new AbstractClass();
		
		// 1.
		MyClass cls = new MyClass();
		cls.method();
		cls.abstractMethod();
		
		// 2.
		AbstractClass ac = new AbstractClass() {			
			@Override
			public void abstractMethod() {				
				System.out.println("AbstractClass abstractMethod()");
			}
		};
		ac.method();
		ac.abstractMethod();
		
		// 3.
		AbstractClass acls = new MyClass();
		acls.method();
		acls.abstractMethod();
		
		
		// 1.
		Circle cir = new Circle(5, 10, 20);
		System.out.println("원의 넓이: " + cir.calArea() );
		
		// 2.
		Shape rect = new Shape(10, 20) {			
			@Override
			public double calArea() {				
				return (x * y);
			}
		};
		
		System.out.println(rect.calArea());
		
		// 3.
		
		
	}
	
//	static int method(String str, char c) {		
//	}
}

abstract class AbstractClass{
	private String name;
	
	public void method() {		
		System.out.println("AbstractClass method()");
	}
	
	public abstract void abstractMethod();	// 추상메소드	
}

class MyClass extends AbstractClass{

	@Override
	public void abstractMethod() {
		System.out.println("MyClass abstractMethod()");		
	}
}






