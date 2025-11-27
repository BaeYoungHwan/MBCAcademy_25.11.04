package main;

import java.util.Scanner;

import dao.AddressDao;
import dao.AddressDaoImpl;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// menu
		AddressDao dao = new AddressDaoImpl();
		boolean out = false;
		
		while(true) {
			// menu 구성
			System.out.println("menu -------------------");
			System.out.println("1.주소록추가");
			System.out.println("2.주소록삭제");
			System.out.println("3.주소록검색");
			System.out.println("4.주소록수정");
			System.out.println("5.주소록저장");
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






