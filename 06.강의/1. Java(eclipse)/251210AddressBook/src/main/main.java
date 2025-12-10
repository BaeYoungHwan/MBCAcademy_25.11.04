package main;

import java.util.Scanner;

import dao.AddressBookDAO;
import dao.AddressBookImpl;
import dto.AddressBookDTO;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AddressBookDAO dao = new AddressBookImpl();
		boolean out = true;
		
		while(out){
			
			System.out.println("menu -------------------");
			System.out.println("1.주소록추가");
			System.out.println("2.주소록검색");
			System.out.println("3.주소록삭제");
			System.out.println("4.주소록수정");
			System.out.println("5.모두출력");
			System.out.println("6.종료");

			// 입력
			System.out.print("번호를 입력 >> ");
			int num = sc.nextInt();
			
			// 조건분기
			switch(num) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.search();
					break;
				case 3:
					dao.delete();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.selectALL();
					break;
				case 6:
					out = false;
					System.out.println(">> 프로그램 종료");
					break;

			}
		}		
	}
}
