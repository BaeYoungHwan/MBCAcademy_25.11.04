package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.DBClose;
import database.DBConnection;
import dto.AddressBookDTO;

public class AddressBookImpl implements AddressBookDAO{
	Scanner sc = new Scanner(System.in);
	
	public AddressBookImpl() {
		DBConnection.initConnection();
	}

	//정보를 추가 하기 위한 insert
	public void insert() {
		
		System.out.println("1.이름을 입력해주세요");
		String inputName = sc.next();
		System.out.println("2.나이를 입력해주세요");
		int inputAge = sc.nextInt();
		System.out.println("3.전화번소를 입력해주세요");
		String inputPhone = sc.next();
		System.out.println("4.주소를 입력해주세요");
		String inputAddress = sc.next();
		System.out.println("5.메모를 입력해주세요");
		String inputMemo = sc.next();
		
		int resultC = this.insert(inputName, inputAge, inputPhone, inputAddress, inputMemo);
		if(resultC > 0) {
			System.out.println("정상처리 되었습니다.");
		}else {
			System.out.println("추가 되지 않았습니다.");
		}
	}
	public int insert(String name, int age, String phone, String address, String memo) {
		// Query
		String sql = "insert into AddressBook(name, age, phone, address, memo) values(?,?,?,?,?)";
		
		// DB연결 및 SQL 변수 선언
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 결과값을 위한 변수
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, age);
			psmt.setString(3, phone);
			psmt.setString(4, address);
			psmt.setString(5, memo);
			
			count = psmt.executeUpdate();
			
			System.out.println("insert success");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count;
		
	}
	
	public void delete(){
		
	System.out.println("삭제하실 id를 알고 계십니까?(y/n)");
	String chose = sc.next();
	if (chose.equals("y") || chose.equals("Y")){
		System.out.println("id를 입력해주세요");
		int deleteID = sc.nextInt();
		int countD = this.delete(deleteID);
		
		if (countD > 0) {
			System.out.println("정상처리 되었습니다.");
		}else {
			System.out.println("처리가 되지 않았습니다.");
		}
		
	}
	else if (chose.equals("n") || chose.equals("N")){
		this.selectALL();
		return;
	}
	}
	//삭제하기 위한 함수
	public int delete(int id) {
		String sql = "delete from AddressBook where id = ?;";
		// DB연결 및 SQL 변수 선언
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 결과값을 위한 변수
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			
			count = psmt.executeUpdate();
			
			System.out.println("delete success");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count;
	}
	
	public void update(){
		
		System.out.println("수정하실 id를 알고 계십니까?(y/n)");
		String chose = sc.next();
		if (chose.equals("y") || chose.equals("Y")){
			System.out.println("id를 입력해주세요");
			int updateID = sc.nextInt();
			System.out.println("수정하실 칼럼을 선택해주세요 : 1.name 2.age 3.Address 4.memo");
			int number = sc.nextInt();
			System.out.println("변경할 값을 입력해주세요");
			String value = sc.next();

			int countU = this.update(number,updateID, value);
			
			if (countU > 0) {
				System.out.println("정상처리 되었습니다.");
			}else {
				System.out.println("처리가 되지 않았습니다.");
			}
			
		}
		else if (chose.equals("n") || chose.equals("N")){
			this.selectALL();
			return;
		}
	}
	// 수정하기 위한 함수
	public int update(int number, int updateID, String value) {
		// 어떤 값을 바꿀것인지 나타내는 값
		String sql="";
		switch (number) {
			case 1: {
				// 이름변경
				sql = "update AddressBook set name = ? where id = ?;";
				break;
				
			}
			case 2: {
				// 나이변경
				sql = "update AddressBook set age = ? where id = ?;";
				break;
			
			}
			case 3: {
				//주소변경
				sql = "update AddressBook set address = ? where id = ?;";
				break;
				
			}
			case 4: {
				//메모변경
				sql = "update AddressBook set memo = ? where id = ?;";
				break;
				
			}
		}
		// DB연결 및 SQL 변수 선언
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 결과값을 위한 변수
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			if(number == 2) {
				psmt.setInt(1,Integer.parseInt(value));
			}
			else {
				psmt.setString(1,value);
			}
			
			psmt.setInt(2,updateID);
			
			count = psmt.executeUpdate();
			
			if(count >0) {
				System.out.println("update success");
			}
			else {
				System.out.println("update fail");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count;
	}
	
	// 모두 검색하는 함수
	public void selectALL() {
		
		String sql = "select id, name, age, address, memo from AddressBook ;";
		
		Connection conn = null;			// DB관련
		PreparedStatement psmt = null;	// Qurey 관련
		
		ResultSet rs = null;			// 결과값 관련
		AddressBookDTO dto = null;
		
		List<AddressBookDTO> list = new ArrayList<AddressBookDTO>();
		
		try {
			
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String result_id = rs.getString("id");
				String result_name = rs.getString("name");
				int result_age = rs.getInt("age");
				String result_address = rs.getString("address");
				String result_memo = rs.getString("memo");
				
				list.add(new AddressBookDTO(result_id, result_name, result_age, result_name, result_address, result_memo));
				
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
			
		}
		
		for (AddressBookDTO addressBookDTO : list) {
			System.out.println(addressBookDTO.toString());
		}
		
	}
	
	// 검색하는 함수
	public void search() {
		System.out.println("무엇으로 검색하시겠습니까?");
		System.out.println("1.이름 2.나이 3.주소 4.메모");
		System.out.print("번호를 입력 >> ");
		int number = sc.nextInt();
		
		System.out.println("검색하실 값을 입력해주세요");
		String value = sc.next();
		
		AddressBookDTO listDTO = this.search(number, value);
		
		System.out.println(listDTO.toString());
	}
	// 1개의 데이터만 산출 	-> 1개의 DTO 
	public AddressBookDTO search(int number, String value) {
		
		String sql = "";
		switch (number) {
		case 1: {
			sql = "select id, name, age, address, memo from AddressBook where name = ?;";
			break;
		}
		case 2:{
			sql = "select id, name, age, address, memo from AddressBook where age = ?;";
			break;
		}
		case 3:{
			sql = "select id, name, age, address, memo from AddressBook where address like ?;";
			break;
		}
		case 4:{
			sql = "select id, name, age, address, memo from AddressBook where memo like ?;";
			break;
		}
		}
		
		Connection conn = null;			// DB관련
		PreparedStatement psmt = null;	// Qurey 관련
		ResultSet rs = null;	
		
		AddressBookDTO dto = new AddressBookDTO();
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			if (number == 4 || number == 3) {
				psmt.setString(1, "%"+value+"%");
			}else if(number == 1) {
				psmt.setString(1, value);
			}
			else if(number == 2){
				psmt.setInt(1, Integer.parseInt(value));
			}
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				String result_id = rs.getString("id");
				String result_name = rs.getString("name");
				int result_age = rs.getInt("age");
				String result_address = rs.getString("address");
				String result_memo = rs.getString("memo");
				
				dto = new AddressBookDTO(result_id, result_name, result_age, result_name, result_address, result_memo);
			}
			
			System.out.println("정상 실행 되었슴돠");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
		
	}
	
	
	
}
