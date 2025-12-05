package Dice;

public class DiceGame {
	int ownCoin;
	
	//주사위 굴린후 결과겂을 입력받아 코인 배분
	public int dice_Game(int matchSum ,int diceSum, int coin ) {
			
		if(matchSum == diceSum){
			if (diceSum == 3 ||diceSum== 11) {
				coin = coin*18;
			}
			else if (diceSum == 4 ||diceSum== 10) {
				coin = coin*12;
			}
			else if (diceSum == 5 ||diceSum== 9) {
				coin = coin*9;
			}
			else if (diceSum == 8 ||diceSum== 6) {
				coin = coin*7;
			}
			else if (diceSum == 7) {
				coin = coin*6;
			}else {
				coin = 0;
				System.out.println("다시 시도해주세요.");
			}
		}
		else {
			coin = 0;
			System.out.println("다시 시도해주세요.");
		}
		
		System.out.println("두 주사위의 합은 " + diceSum + "입니다.");
		return coin;
	}
	
}
