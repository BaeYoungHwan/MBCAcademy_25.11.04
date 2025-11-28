package main;

import java.util.Scanner;

import dao.AccountDAO;
import dao.AccountDAOImpl;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//dao 객체 선언하기
		AccountDAO dao = new AccountDAOImpl();
		boolean out = false;
		while(true) {
			// menu 구성
			System.out.println("menu -------------------");
			System.out.println("1.지출정보추가");
			System.out.println("2.지출정보삭제");
			System.out.println("3.지출정보검색");
			System.out.println("4.지출정보수정");
			System.out.println("5.지출정보저장");
			System.out.println("6.종료");
			System.out.println("7.모두출력");
			
			// 입력
			System.out.print("번호를 입력 >> ");
			int number = sc.nextInt();
			
			// 조건분기
			switch(number) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.save();
					break;
				case 6:
					// System.exit(0);		
					out = true;
					break;
				case 7:
					dao.all();
					break;
			}
			
			if(out) {
				System.out.println(">> 프로그램 종료");
				break;
			}
		}		
		
		
		
		
		
		
	}

}
