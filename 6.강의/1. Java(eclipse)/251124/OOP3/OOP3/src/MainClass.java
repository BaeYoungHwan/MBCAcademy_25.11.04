import cls.ChildClass;

public class MainClass {
	public static void main(String[] args) {
		/*
			OOP의 3대요소
			캡슐화(은닉성): 외부로부터 접근성을 설정
						 private/public
						 
			상속성(inheritance): 부모 클래스의 모든 기능을 상속
			 			 variable(변수) method(함수) -> 상속	
			 			 
			다형성(polymorphism): 상속 후에 여러가지 형태의 자식 클래스가 구성되는 것을 의미한다
			
			this: (생성된)객체의 주소			
			super: 부모 클래스의 객체를 가리키는 주소
			
			형식:
					class 부모클래스{
						부모변수
						부모메소드
					}
					
					class 자식클래스 extends 부모클래스{
						(부모변수)
						(부모메소드)
					
						자식변수
						자식메소드
					}
					
					protected: 외부접근차단. 자식클래스내에서는 접근허용 
			
		*/
		
		ChildClass cc = new ChildClass();
		
		cc.name = "홍길동";
		cc.parentMethod();
		
		// cc.height = 172.1;
		
	}
}




