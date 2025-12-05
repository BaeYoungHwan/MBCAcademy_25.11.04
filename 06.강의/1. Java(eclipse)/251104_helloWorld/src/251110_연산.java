import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		/*
		  	편의점
		  	입력 > 지불해야 될 금액
		  		3230원
		  	입력 > 자신이 지불한 금액 
		  		10000원
		  		
		  		10000 - 3230 -> 6770
		  		
		  		 거스름돈:
		  		 5000원권 ?장
		  		 1000원권 ?장
		  		 500원	?개
		  		 100원	?개
		  		 50원	?개
		  		 10원	?개	
		 */
		
		// 선언부
		Scanner sc = new Scanner(System.in);
		
		int price;			// 지불해야 될 금액
		int myMoney;		// 자신이 지불한 금액 
		int changeMoney;	// 거스름돈
		
		//price = 3230;
		//myMoney = 10000;
		
		// 입력
		System.out.print("지불하실 금액 = ");
		price = sc.nextInt();
		
		System.out.print("지불한 금액 = ");
		myMoney = sc.nextInt();
				
		// 연산		
		changeMoney = myMoney - price;	// 거스름돈
		
		// 5000
		int m5000 = changeMoney / 5000;	
		
		// 1000
		int m1000 = (changeMoney % 5000) / 1000;	// 6770 % 5000 -> 1770
		
		// 500
		int m500 = (changeMoney % 1000) / 500;
		
		// 100
		int m100 = (changeMoney % 500) / 100;
		
		// 50
		int m50 = (changeMoney % 100) / 50;
		
		// 10
		int m10 = (changeMoney % 50) / 10;
		
		// 결과출력
		System.out.println("총 거스름돈:" + changeMoney);
		System.out.println("5000원권: " + m5000 + " 장");
		System.out.println("1000원권: " + m1000 + " 장");
		System.out.println("500원권: " + m500 + " 개");
		System.out.println("100원권: " + m100 + " 개");
		System.out.println("50원권: " + m50 + " 개");
		System.out.println("10원권: " + m10 + " 개");
		

	}

}







