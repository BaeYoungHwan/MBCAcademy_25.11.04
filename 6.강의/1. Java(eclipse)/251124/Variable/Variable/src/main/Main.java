package main;

import java.util.Calendar;

public class Main {
	public static void main(String[] args) {
		/*
			local variable : 지역변수	-> stack
			parameter variable : 매개변수 -> stack
			member variable : (class)멤버변수 -> heap
			
			static variable	: global(전역) 변수 -> static(정적) <> dynamic	
			static method
		*/	
		int number;	// <- local variable
		
		//MyClass cls = new MyClass();
		//cls.number = 1;
		
		// MyClass.stNumber = 10;
		/*
		MyClass cls = new MyClass();
		
		cls.func();
		cls.func();
		cls.func();
		
		MyClass my = new MyClass();
		
		my.func();
		my.func();
		*/
		
		MyClass.getInstance();
		
		Engine engine = Engine.getInstance();
		
		Calendar cal = Calendar.getInstance();
	}
}

class MyClass{
	
	int number = 0;		// 멤버변수
	static int stNumber = 0;	// static 변수 == class 변수
	
	public void method(int n, String s) {	// <- 매개변수, 인수, 인자
		int number;	// <- local variable		
		number = 12;		
	}	
	
	public void func() {
		int local = 0;
		
		local++;
		number++;
		stNumber++;
		
		System.out.println("local:" + local);
		System.out.println("number:" + number);
		System.out.println("stNumber:" + stNumber);
	}
	
	public static void getInstance() {
		System.out.println("MyClass static getInstance");
		
		// number = 1;		
		// this, super	
		
		stNumber = 10;
	}	
}

class Engine{
	
	public Engine() {
	}	
	public void method() {		
	}
	public void func() {		
	}	
	public static Engine getInstance() {
		
		Engine e = new Engine();
		e.method();
		e.func();
		
		return e;
	}
	
}











