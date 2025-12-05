import java.util.Scanner;

public class Assignment_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1부터 1000까지의 합을 구하여라
		int num = 0;
		
		for(int i = 0; i < 1001; i++ ) {
			
			num = num + i;
			
			
			
		}
			
		System.out.print(num);
		
		int oddNumb = 0;
		int evenNumb = 0;
		// 1 ~ 100 사이에 짝수의 합과 홀수의 합을 각각 출력하도록 작성하라
		
		for(int i = 0; i < 101; i++ ) {
					
			if(i % 2 == 1){
				
				oddNumb = oddNumb + i;
			}
			else {
				
				evenNumb = evenNumb + i;
				
			}
			
		
					
					
		}
		
		System.out.println("\n짝수의 합은 :" + evenNumb +  " 홀수의 합은 :" + oddNumb +"\n");
		
		
		//하나의 수를 입력 받고 10의 배수로 입력 받은 수는 어느 범위에 있는지 출력되는
		//프로그램을 작성하라.(1 ~ 10, 11 ~ 20, 21 ~ 30 … 91 ~ 100)
			
		int Number;
		Scanner sc = new Scanner(System.in);
		Number = sc.nextInt();
		
		System.out.println( "입력한 수는 " + ((Number/10))*10 + "보다 크고" + ((Number/10)+1)*10 + "보다 작다" );
		
		
		//임의 수를 입력 받고 그 해당하는 수의 구구단을 출력하는 프로그램을 작성하라
		
		
		int guguNumber;
		Scanner sca = new Scanner(System.in);
		guguNumber = sca.nextInt();
		
		
		for(int g = 1; g < 10; g++) {
			
			System.out.println( guguNumber + "*" + g + "=" + guguNumber*g);
			
		}
		
		
		// 구구단을 1단부터 9단까지 출력하는 프로그램을 작성하라.
		
		
		for(int g = 1; g < 10; g++) {
			for(int u = 1; u < 10; u++){	
			System.out.println( g + "*" + u + "=" + u*g);
			}
			
		}
		
		//다음의 모양이 출력 되도록 작성하시오
		
		for(int g = 1; g < 10; g++) {
			
			System.out.println("*****");
		}
		
		//다음의 모양이 출력 되도록 작성하시오
		int count = 1;
		for(int i = 1; i < 6; i++) {
			for(int u = 1; u < 6; u++) {
				if(u == count) {
					
					System.out.println("*");
					
				}
				else if( u < count) {
					
					System.out.print("*");
					
				}
				
			}
		count++;
		}
		count = 1;
		for(int i = 1; i < 5; i++) {
			for(int u = 4; u > 0; u--) {
				if(u == count) {
					
					System.out.println("*");
					
				}
				else if( count< u ) {
					
					System.out.print("*");
					
				}
				
			}
		count++;
		}
	}

}
