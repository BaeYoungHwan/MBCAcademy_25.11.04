package Dice;

import java.util.Scanner;

public class Assignment12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DiceRand dr = new DiceRand();
		DiceGame dg = new DiceGame();
		Scanner sc = new Scanner(System.in);
		System.out.println("보유하신 코인을 입력해 주세요 :");
		dg.ownCoin = sc.nextInt();
		boolean gameContinue = true;
		
		while (dg.ownCoin > 0 && gameContinue ){
			int matchSum;
			int betCoin;
			int resultCoin;
			String yn;
			int roll;
			
			//얼마를 배팅하시겠습니까?
			System.out.print("얼마를 배팅하시겠습니까? :");
			betCoin = sc.nextInt();
			
			//어디에 배팅하시겠습니까? 
			System.out.print("어디에 배팅하시겠습니까?  :");
			matchSum = sc.nextInt();
			dg.ownCoin = dg.ownCoin - betCoin;
			
			//코인을 과하게 입력하거나 0 밑으로 내려갈시
			if (dg.ownCoin < 0) {
				
				System.out.println("코인이 부족합니다 당장 꺼져주세요 : )");
				break;
			}
			roll = dr.RollDice();
			resultCoin = dg.dice_Game(matchSum,roll,betCoin);
			
			if (resultCoin != 0){
				System.out.println("축 축 축 ! 당첨");
			}
			else {
				System.out.println("다시 한번 시도해 보아요!");
			}
			
			dg.ownCoin = dg.ownCoin + resultCoin;
//			
//			System.out.println("계속 하시겠습니까 ? (Y/N) 정보보기 : w");
//			yn = sc.next();
//			if (yn.equals("n") || yn.equals("N")) {
//				gameContinue = false;
//			}else if (yn.equals("w") || yn.equals("W")) {
//					
//				System.out.println("현재 소유한 코인의 수는 " + dg.ownCoin + "입니다.");
//				
//			}
			
			while (true){
				System.out.println("주사위 수 : D 정보보기 : W 나가기 : N : 계속하기 : Y");
				yn = sc.next();
				if (yn.equals("n") || yn.equals("N")) {
					gameContinue = false;
					break;
				}else if (yn.equals("w") || yn.equals("W")) {	
					System.out.println("현재 소유한 코인의 수는 " + dg.ownCoin + "입니다.");
				}else if (yn.equals("d") || yn.equals("D")) {	
					dr.CheckDice();
				}else if (yn.equals("y") || yn.equals("Y")) {	
					gameContinue = true;
					break;
			
				}
			}

		}
	}
}
