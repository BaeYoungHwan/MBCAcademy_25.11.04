package main;

import cls.NameCard;
import cls.PrintNameCard;
import cls.PrintNamePhoneCard;

public class Main {
	public static void main(String[] args) {
		
		NameCard ncard = new NameCard("성춘향", "234-5678", "sch@nate.com");
		
		ncard.setPrintNameInter(new PrintNamePhoneCard());
		ncard.print();

		
	}
}
