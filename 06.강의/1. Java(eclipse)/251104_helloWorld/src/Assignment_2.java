import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Assignment_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 과제 5 두 수를 입력 받고 사칙연산과 %연산까지 결과가 출력되도록 작성하라.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int number_1, number_2;
  		System.out.print("첫번째 숫자 = ");
  		number_1 = sc.nextInt();
  		System.out.print("두번째 숫자 = ");
  		number_2 = sc.nextInt();
  		
  		System.out.printf("첫번째 숫자는 : %d 두번째 숫자는 :  %d\n",  number_1, number_2);
  		System.out.printf("더한값은 %d\t 나머지값은 %d \n",  number_1 + number_2, number_1 % number_2);
  		
  		
  		
  		// 과제 6 단위 환산 프로그램을 작성하시오.
  		double meter;
  		System.out.print("M 입력 = ");
  		meter = sc.nextDouble();
  		
  		System.out.printf("inch로 표기하면 : %finch \nyard로 표기하면 : %fyard \nmile로 표기하면 : %fmile\n",  meter*39.370079, meter*1.093613, meter*0.000621);
  		
  		// 과제 7 변수 x, y, z를 입력 받고 (x-y)/(z-y) 연산을 출력하는 프로그램을 착성하시오
  		double x,y,z;
  		System.out.print("x 입력 = ");
  		x = sc.nextDouble();
  		System.out.print("y 입력 = ");
  		y = sc.nextDouble();
  		System.out.print("z 입력 = ");
  		z = sc.nextDouble();
  		System.out.printf("(x-y)/(z-y)의 값은 : %f 입니다.", (x-y)/(z-y)); 		  		
  		
	}

}
