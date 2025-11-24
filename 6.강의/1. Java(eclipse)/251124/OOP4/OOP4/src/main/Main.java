package main;

import cls.ChildClass;

public class Main {
	public static void main(String[] args) {
		
		ChildClass cc = new ChildClass();
		
		ChildClass ccls = new ChildClass("성춘향");
		
		System.out.println(ccls.getName());
	}
}
