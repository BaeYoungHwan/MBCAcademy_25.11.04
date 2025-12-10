package main;

import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;

public class Main {

	public static void main(String[] args) {
		
		// dao 선언
		MemberDAO dao = new MemberDAO();
		
		//insert
		String id = "byh";
		String name = "배영환";
		int age = 30;
		/*
		int count = dao.insert(id, name, age);
		if(count > 0) {
			System.out.println("추가 되었습니다");
		}else {
			System.out.println("추가 안 되었습니다");
		}
		*/
		int countU = dao.update(id, age);
		if(countU > 0) {
			System.out.println("수정 되었습니다");
		}else {
			System.out.println("수정 안 되었습니다");
		}
		/*
		int countD = dao.delete(id);
		if(countD > 0) {
			System.out.println("삭제 되었습니다");
		}
		*/	
		
		String Sid = "cde";
		MemberDTO mem = dao.select(Sid);
		if(mem != null) {
			System.out.println(mem.toString());
		}else {
			System.out.println("데이터를 찾을 수 없습니다.");
		}
	
		List<MemberDTO> listDTO = dao.selectList();
		for (MemberDTO memberDTO : listDTO) {
			System.out.println(memberDTO.toString());
		}
		


	}

}
