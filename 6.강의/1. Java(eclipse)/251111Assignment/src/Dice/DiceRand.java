package Dice;


public class DiceRand {
	
	int numberDice;
	int randDice;
	
	int RollDice() {
		
		numberDice = 1 + (int)(Math.random()*6);
		randDice = ((int)Math.random()*6) + 1;
		
		return numberDice+randDice;
	}
	void CheckDice() {
		
		System.out.println("두 주사위 수는 : " + numberDice +"," + randDice +  "입니다" );
		
	}
}
