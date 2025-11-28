package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AddressDto;
import file.FileProc;

public class AddressDaoImpl implements AddressDao {
	
	Scanner sc = new Scanner(System.in);
	
	private List<AddressDto> list;
	private FileProc fp;
	
	public AddressDaoImpl() {
	/*	list = new ArrayList<AddressDto>();
		list.add(new AddressDto("홍길동", 24, "1234", "서울시", "동창생"));
		list.add(new AddressDto("성춘향", 15, "3456", "남원시", "학교후배"));
		list.add(new AddressDto("임꺽정", 26, "4567", "강릉시", "학교선배"));*/
		
		fp = new FileProc("humans");
		load();
	}	
	
	// CRUD			
	@Override
	public void insert() {
		// 이름
		System.out.print("이름 >> ");
		String name = sc.next();
		
		// 나이
		System.out.print("나이 >> ");
		int age = sc.nextInt();
		
		// 전화번호
		System.out.print("전화번호 >> ");
		String phone = sc.next();
		
		// 주소
		System.out.print("주소 >> ");
		String address = sc.next();
				
		// 메모(메모입력은 Scanner 를 사용하지 않는다)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("메모 >> ");
		String memo = "";
		try {
			memo = br.readLine();		
			
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		
		AddressDto dto = new AddressDto(name, age, phone, address, memo);		
		list.add(dto);		
		
		System.out.println("주소록에 추가되었습니다");		
	}

	@Override
	public void delete() {
		// 입력
		System.out.print("삭제할 이름 >> ");
		String name = sc.next();
		
		// 검색
		AddressDto dto = search(name);		
		if(dto == null) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}	
		
		// 삭제
		list.remove(dto);		
		System.out.println("정상적으로 삭제되었습니다");				
	}

	// 이름, 메모, (전화번호) 
	@Override
	public void select() {
		// 메모입력
		System.out.print("메모의 단어를 검색 >> ");
		String memo = sc.next();
		
		// 해당되는 사람은 모두 출력
		// "교회에서 만난 친구" -> 교회, 친구
		
	//	String str = "교회에서 만난 친구";
	//	System.out.println(str.contains("교회"));
		
		// 찾은 데이터를 추가할 list
		List<AddressDto> findList = new ArrayList<AddressDto>();
		for (AddressDto dto : list) {
			if(dto.getMemo().contains(memo)) { // memo안에 문자열을 포함하고 있는 경우
				findList.add(dto);
			}
		}
		
		if(findList.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다");
			return;
		}
		
		System.out.println("검색된 정보는 다음과 같습니다");
		for (AddressDto dto : findList) {
			System.out.println(dto.toString());
		}		
		
	}
	
	@Override
	public void update() {
		// 입력
		System.out.print("수정할 데이터의 이름 >> ");
		String name = sc.next();
		
		AddressDto dto = search(name);
		
		if(dto == null) {
			System.out.println("데이터 없습니다");
		}
		
		// 주소, 전화번호
		System.out.print("주소 >> ");
		String address = sc.next();
		
		dto.setAddress(address);
		System.out.println("데이터를 수정하였습니다");
	}
	
	public AddressDto search(String name) {
		AddressDto dto = null;		
		for (AddressDto address : list) {
			if(name.equals(address.getName())) {
				dto = address;
				break;
			}
		}
		return dto;
	}
		
	@Override
	public void all() {		
		for (AddressDto dto : list) {
			System.out.println(dto.toString());
		}			
	}

	// Data save/load
	@Override
	public void save() {		
		fp.fileSave(list);
	}
	@Override
	public void load() {		
		list = fp.fileLoad();
	}
	
}
