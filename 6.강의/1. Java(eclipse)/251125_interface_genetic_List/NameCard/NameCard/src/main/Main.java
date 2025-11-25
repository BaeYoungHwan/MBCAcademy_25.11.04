package main;

import cls.NameCard;
import cls.PrintNameCard;
import cls.PrintNamePhoneCard;

public class Main {
	public static void main(String[] args) {
		
		NameCard ncard = new NameCard("홍길동", "123-4567", "hgd@naver.com");
		
		ncard.setpNameCard(new PrintNameCard());
		ncard.print();
		
		ncard.setpNamePhoneCard(new PrintNamePhoneCard());
		ncard.printPhone();
				
	}
}




