package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDTO;
import file.FileProc;
import single.Singleton;


public class AccountDAOImpl implements AccountDAO{
	
	Scanner sc = new Scanner(System.in);
	
	// fileClass를 사용하기 위한 변수선언
	private FileProc fp;
	
	public AccountDAOImpl() {
			
			//파일 가져오기 혹은 생성하기
			fp = new FileProc("Account");
			load();
	}
	
	// 추가
	@Override
	public void insert() {
		
		// 제목
		System.out.print("제목 >> ");
		String title = sc.next();
		
		// 수입지출
		System.out.print("수입/지출 >> ");
		int income = sc.nextInt();
		
		// 날짜
		System.out.print("날짜 >> ");
		System.out.println("ex 251128");
		String date = sc.next();
				
		// 메모(메모입력은 Scanner 를 사용하지 않는다)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("메모 >> ");
		String memo = "";
		try {
			memo = br.readLine();		
			
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		
		// 변함없는 값을 위한 singleton 객체 생성
		Singleton s = Singleton.getInstance();
		
		// 전체 데이터 합쳐서 DTO 객체생성후 집어넣기
		AccountDTO dto = new AccountDTO(title, income,s.Amount+income, date, memo);
		
		s.list.add(dto);	
		
		// 현재금액 업데이트 해주기
		s.Amount = s.Amount+income;
		
		System.out.println("가계부 정보가 추가되었습니다");	
		
	}
	
	//삭제하는 데이터
	@Override
	public void delete() {

		System.out.print("삭제할 제목 >> ");
		String title = sc.next();
		
		// 검색
		AccountDTO dto = search(title);		
		if(dto == null) {
			System.out.println("데이터를 찾을 수 없습니다");
			return;
		}	
		
		// 삭제
		Singleton s = Singleton.getInstance();
		s.list.remove(dto);		
		System.out.println("정상적으로 삭제되었습니다");
		
	}

	// 이름, 메모, 날짜
	@Override
	public void select() {
		
		System.out.println("1.제목으로 검색");
		System.out.println("2.날짜로 검색");
		System.out.println("3.월별결산");
		System.out.println("4.기간별 결산");
		System.out.println("번호를 입력 >> ");
		int number = sc.nextInt();
		
		//제목으로 검색
		if(number == 1) {
			// 제목입력
			System.out.print("제목의 단어를 검색 >> ");
			String title = sc.next();
			
			// 해당되는 제목 모두 출력
			// 찾은 데이터를 추가할 list
			List<AccountDTO> findList = new ArrayList<AccountDTO>();
			Singleton s = Singleton.getInstance();
			for (AccountDTO dto : s.list) {
				if(dto.getTitle().contains(title)) { // title안에 문자열을 포함하고 있는 경우
					findList.add(dto);
				}
			}
			
			if(findList.isEmpty()) {
				System.out.println("데이터가 존재하지 않습니다");
				return;
			}
			
			System.out.println("검색된 정보는 다음과 같습니다");
			for (AccountDTO dto : findList) {
				System.out.println(dto.toString());
			}
		}
		//날짜로 검색
		else if (number == 2) {
			System.out.print("날짜로 검색(251128)>> ");
			String date = sc.next();
			
			List<AccountDTO> findList = new ArrayList<AccountDTO>();
			Singleton s = Singleton.getInstance();
			
			for (AccountDTO dto : s.list) {
				if(dto.getDate().equals(date)) { // title안에 문자열을 포함하고 있는 경우
					findList.add(dto);
				}
			}
			if(findList.isEmpty()) {
				System.out.println("데이터가 존재하지 않습니다");
				return;
			}
			
			System.out.println("검색된 정보는 다음과 같습니다");
			for (AccountDTO dto : findList) {
				System.out.println(dto.toString());
			}
		}
		// 월별결산
		else if (number == 3) {
			System.out.print("월별결산 몇월인지 알려주세요");
			String date = sc.next();
			int sumX = 0; // 월간 합계를 구하기 위한 변수
			
			List<AccountDTO> findList = new ArrayList<AccountDTO>();
			Singleton s = Singleton.getInstance();
			
			for (AccountDTO dto : s.list) {
				 String mm = dto.getDate().substring(2,4);
				 if (mm.equals(date)) {
					 findList.add(dto);
					 sumX = sumX + dto.getIncome();
				 }
				
			}
			if(findList.isEmpty()) {
				System.out.println("데이터가 존재하지 않습니다");
				return;
			}
			
			System.out.println("검색된 정보는 다음과 같습니다");
			for (AccountDTO dto : findList) {
				System.out.println(dto.toString());
			}
			System.out.println("월간 총 합계는 " + sumX + "원 입니다.");
		}
		//기간별 결산
		else if (number == 4) {
			
			int sumX = 0; // 월간 합계를 구하기 위한 변수
			
			//기간별이기때문에 사이값을 구해야함
			System.out.println("기간별결산 시작일 입력>> ");
			System.out.println("ex 251128");
			String dateStart = sc.next();
			
			System.out.println("기간별결산 종료일 입력>> ");
			System.out.println("ex 251225");
			String dateEnd = sc.next();
			
			
			List<AccountDTO> findList = new ArrayList<AccountDTO>();
			Singleton s = Singleton.getInstance();
			
			int dateStartInt = Integer.parseInt(dateStart);
			int dateEndInt = Integer.parseInt(dateEnd);
			
			for (AccountDTO dto : s.list) {
				int dateInt	= Integer.parseInt(dto.getDate());						
				if (dateStartInt <= dateInt && dateInt <= dateEndInt) {
					findList.add(dto);
					sumX = sumX + dto.getIncome();
				}
				
			}
			
			if(findList.isEmpty()) {
				System.out.println("데이터가 존재하지 않습니다");
				return;
			}
			
			System.out.println("검색된 정보는 다음과 같습니다");
			for (AccountDTO dto : findList) {
				System.out.println(dto.toString());
			}
			
			System.out.println("월간 총 합계는 " + sumX + "원 입니다.");
		}
		
	}
	//업데이트
	@Override
	public void update() {
		// 입력
		System.out.print("수정할 데이터의 제목 >> ");
		String title = sc.next();
		
		AccountDTO dto = search(title);
		
		if(dto == null) {
			System.out.println("데이터 없습니다");
		}
		
		// 주소, 전화번호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("메모 입력>> ");
		String memo = "";
		try {
			memo = br.readLine();		
			
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		
		dto.setMemo(memo);
		
		System.out.println("데이터를 수정하였습니다");
		
	}

	//검색(날짜,제목,월별,기간별)
	public AccountDTO search(String title) {
		AccountDTO dto = null;	
		Singleton st = Singleton.getInstance();
		for (AccountDTO stData : st.list) {
			if(title.equals(stData.getTitle())) {
				dto = stData;
				break;
			}
		}
		return dto;
	}
	
	
	
	@Override
	public void save() {
		fp.fileSave();
	}

	@Override
	public void load() {
		fp.fileLoad();		
	}

	@Override
	public void all() {
		Singleton s = Singleton.getInstance();
		for (AccountDTO dto : s.list) {
			System.out.println(dto.toString());
		}			
		
	}	
	
	
	
}



