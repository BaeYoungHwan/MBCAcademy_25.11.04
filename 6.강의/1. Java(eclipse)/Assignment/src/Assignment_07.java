import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Assignment_07 {
	public static void main(String[] args) throws IOException {
		
		
		
		// 가위, 바위, 보 게임을 작성하시오.
		// 컴퓨터는 Random(0, 1, 2)으로 수를 할당합니다.
			
		int randNum;
		int choiceNum;
		boolean conti = true;
		int[] resultList = {0, 0, 0};
		Scanner sc = new Scanner(System.in);
		
		while(conti) {
			randNum = (int)(Math.random()*3);
			String lastChar = "";
			
			System.out.println("가위(0), 바위(1), 보(2) 를 입력 >> ");
			choiceNum = sc.nextInt();
			
			if (choiceNum == randNum) {
				
				System.out.println("당신은 비겼습니다.");
				resultList[1] = resultList[1] + 1;  
				
			}
			else {
				// 가위를 선택 했을 경우의 승패
				if(choiceNum == 0) {
					
					if(randNum == 2) {
						
						System.out.println("당신이 이겼습니다.");
						resultList[0] = resultList[0] + 1;  
						
						
					}
					else {
						
						System.out.println("당신은 졌습니다.");
						resultList[2] = resultList[2] + 1;  
						
					}
					
				}
				// 바위를 선택 했을 경우의 승패
				else if(choiceNum == 1) {
					
					if(randNum == 0) {
						
						System.out.println("당신이 이겼습니다.");
						resultList[0] = resultList[0] + 1;  
						
						
					}
					else {
						
						System.out.println("당신은 졌습니다.");
						resultList[2] = resultList[2] + 1;  
						
					}
					
				}
				
				// 보를 선택 했을 경우의 승패
				else if(choiceNum == 2) {
					
					if(randNum == 1) {
						
						System.out.println("당신이 이겼습니다.");
						resultList[0] = resultList[0] + 1;  
						
						
					}
					else {
						
						System.out.println("당신은 졌습니다.");
						resultList[2] = resultList[2] + 1;  
						
					}
					
				}
				else {
					System.out.println("잘못된 선택 입니다.");
				}
				
			}
			
			// .equals()를 사용 해야지 정확한 조건문이 됨. ==으로는 타지질 않음.
			
			while(!lastChar.equals("Y") && !lastChar.equals("N")) {
				
				System.out.println("재승부(Y), 나가기(N), 전적검색(W)");
				lastChar = sc.next();
				System.out.println(lastChar);
				if(lastChar.equals("Y")) {
					
					conti = true;
					
				}
				else if(lastChar.equals("N")) {
					
					conti = false;
					
				}				else if(lastChar.equals("W")) {
					System.out.println("당신은" +resultList[0] +"승" +resultList[1] +"무"+resultList[2]+"패입니다.");
				}
				else {
					
					System.out.println("잘못된 명령어 입니다. 다시 입력해 주세요");
					
				}
				
			}
		}
		
		

		//5명의 학생의 국어, 수학, 영어를 입력 받고
		//평균 점수가 80점 이상이면 합격 60점 이하면 불합격이라고 출력하는 프로그램을 작성하라
		//유저로부터 입력 받은 (이름, 국어, 영어, 수학)들의 합계와 평균을 구하는 프로그램을 작성하라.
		
		
		String	studentSC;
		String[][] stundetList = new String [5][6];
		int sum;
		String[]maxStudent = {"0", "0"};
		String[]minStudent = {"0", "100"};
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
		
			sum = 0;
			System.out.println("학생의 이름 국어 영어 수학 점수를 입력해주세요 ex) 홍길동 95 100 60");
			studentSC= bf.readLine();
			
			for(int j = 0; j <6; j++) {
				
				if(j == 0) {
					stundetList[i][j] = studentSC.split(" ")[j];
				}
				else if(j < 4) {
					stundetList[i][j] = studentSC.split(" ")[j];
					sum = Integer.parseInt(studentSC.split(" ")[j]) + sum;
				}
				else if(j == 4) {
					stundetList[i][j] = Integer.toString(sum);
				}
				else {
					
					stundetList[i][j] =  Integer.toString(Integer.parseInt(stundetList[i][j-1]) / 3);
					
				}
				
			}
			
		
		}
		
		for(int k = 0; k < stundetList.length; k++) {
			
			if (Integer.parseInt(stundetList[k][5]) >= 80) {
				
				System.out.println(stundetList[k][0] + "학생은 " + stundetList[k][5] + "점으로 합격 입니다." + "총점은 " + stundetList[k][4] +"입니다");
			
			}
			else if (Integer.parseInt(stundetList[k][5]) <= 60) {
				
				System.out.println(stundetList[k][0] + "학생은 " + stundetList[k][5] + "점으로 불합격 입니다."  + "총점은 " + stundetList[k][4] +"입니다");
			
			}
			
		}
		
		
		for(String[]student : stundetList) {
			
			if (Integer.parseInt(student[5]) < Integer.parseInt(minStudent[1])) {
				
				minStudent[0] = student[0];
				minStudent[1] = student[5];
				
			}
			else if (Integer.parseInt(student[5]) > Integer.parseInt(maxStudent[1])){
				
				maxStudent[0] = student[0];
				maxStudent[1] = student[5];
				
				
			}
		}
		
		System.out.println("최고점수를 받은 학생이름은 " + maxStudent[0] +"점수는 "+maxStudent[1]+"입니다");
		System.out.println("최저점수를 받은 학생이름은 " + minStudent[0] +"점수는 "+minStudent[1]+"입니다");
		
	}
}

