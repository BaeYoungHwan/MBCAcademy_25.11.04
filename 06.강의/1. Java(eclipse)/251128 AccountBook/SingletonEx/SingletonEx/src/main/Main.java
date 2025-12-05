package main;

import cls.MyClass;
import cls.YouClass;
import single.SingletonClass;

public class Main {
	public static void main(String[] args) {
		
		MyClass mycls = new MyClass();
		YouClass youcls = new YouClass();
		
	//	int bbb = youcls.getBbb();
	//	mycls.setAaa(bbb);
		
	//	SingletonClass sc = new SingletonClass();
		
		/*
		SingletonClass sc = SingletonClass.getInstance();
		System.out.println(sc);
		
		SingletonClass sc1 = SingletonClass.getInstance();
		System.out.println(sc1);
		
		SingletonClass sc2 = SingletonClass.getInstance();
		System.out.println(sc2);
		*/
		
		youcls.func();
		mycls.method();
	}
}





