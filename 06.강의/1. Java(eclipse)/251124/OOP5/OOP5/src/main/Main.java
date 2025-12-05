package main;

import cls.Child;
import cls.Parent;
import cls.StudentDto;

public class Main {
	public static void main(String[] args) {
		/*
			Over Ride : 부모클래스에서 상속받은 메소드(기능)를 자식클래스에서 고쳐기입
		*/
		Child cc = new Child();
		cc.method();
		
		StudentDto dto = new StudentDto();
		dto.setName("홍길동");
		dto.setNumber(100);
		System.out.println(dto.toString());
		
		
		Parent par = new Child();
		par.method();
		
		// Parent
		
		// ChildOne
		
		// ChildTwo
		
	}
}





