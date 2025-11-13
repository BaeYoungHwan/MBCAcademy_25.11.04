import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Assignment_for {
	public static void main(String[] args) throws IOException {
		// 1 ~ 100 사이의 10개의 수를 입력 받아서
		// 최소 값과 최대 값을 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		
		int numSc;
		int[] numList = new int[10];
		for(int i = 1; i < 11; i++) {
			
			System.out.println(i + "번째 값을 입력해주세요");
			numSc = sc.nextInt();
			numList[i-1] = numSc;
			if (numSc >= 100){
				
				System.out.println("100을 넘기는 숫자는 저장 할 수 없습니다. 다시 시작해주세요.");
				break;
			}
			
		}
		
		Arrays.sort(numList);
		
		System.out.println("최소 값은 : " + numList[0]);
		System.out.println("최대 값은 : " + numList[9]);
		
		
		
		
		//5명의 학생의 국어, 수학, 영어를 입력 받고
		// 평균 점수가 80점 이상이면 합격 60점 이하면 불합격이라고 출력하는 프로그램을 작성하라
		
		
		String	studentSC;
		String[][] stundetList = new String [5][5];
		int sum;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
		
			sum = 0;
			System.out.println("학생의 국어 영어 수학 점수를 입력해주세요 ex) 95 100 60");
			studentSC= bf.readLine();
			
			for(int j = 0; j <5; j++) {
				if(j < 3) {
					stundetList[i][j] = studentSC.split(" ")[j];
					sum = Integer.parseInt(studentSC.split(" ")[j]) + sum;
				}
				else if(j == 3) {
					stundetList[i][j] = Integer.toString(sum);
				}
				else {
					
					stundetList[i][j] =  Integer.toString(Integer.parseInt(stundetList[i][j-1]) / 3);
					
				}
				
			}
			
		
		}
		
		for(int k = 0; k < 5; k++) {
			
			if (Integer.parseInt(stundetList[k][4]) >= 80) {
				
				System.out.println(k+1 + "번째 학생은 " + stundetList[k][4] + "점으로 합격 입니다.");
			
			}
			else if (Integer.parseInt(stundetList[k][4]) <= 60) {
				
				System.out.println(k+1 + "번째 학생은 " + stundetList[k][4] + "점으로 불합격 입니다.");
			
			}
			
		}
	
	
	}
	
	
}
