import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;	//library, module - 외부파일

public class MainClass {
											//예외처리
	public static void main(String[] args) throws IOException  {
		// 출력 함수 print
		System.out.print("hello world'");
		
		// 변수 선언
		String str;
		int i;
		char cc;
		boolean a, b;
		double d ;
		a = false;
		b = true;
  		
		
		// 입력함수 Scanner
		Scanner sc = new Scanner(System.in);
  		
		
		// 입력함수 사용예제
//		System.out.print("b = ");
//		b = sc.hasNextBoolean();
//  		System.out.println("b:" + b);
		
  		
//		System.out.print("number = ");
//		i = sc.nextInt();
//  		System.out.println("number:" + i);
//  		
  		
//  		System.out.print("float = ");
//		d = sc.nextDouble();
//  		System.out.println("float:" + d);
  		

//  		System.out.print("String = ");
//  		str = sc.next();		//띄어쓰기사용 불가
//		str = sc.nextLine();	//띄어쓰기사용 가능
//  		System.out.println("String:" + str);
  		
		// Buffer : 저장공간
//  		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//  		String address;
//  		System.out.print("주소 = ");
//  		address =  br.readLine();
//  		System.out.println("주소 : " + address);
//  		sc.close();
//  		
//  		byte by = 122;
//  		
  		
  		System.out.println(Math.random() * 10);
  		
  			
	} 

}

// JAVA 17 install 
// https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html 

// Eclipse install
// https://www.eclipse.org/downloads/packages/




/*	
	\n 줄바꾸기
	\b 백스페이스
	\t 탭키 줄맞춤
	\\ "\" 출력하기
	\"   " " " 출력하기
*/


	
	
