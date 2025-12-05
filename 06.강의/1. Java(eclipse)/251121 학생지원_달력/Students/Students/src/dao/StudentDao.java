package dao;

import java.util.Scanner;

import dto.StudentDto;
import file.FileProc;

public class StudentDao {
	Scanner sc = new Scanner(System.in);

	private StudentDto students[]; /* = {
			new StudentDto("홍길동", 24, 172.1, "서울시"),
			new StudentDto("성춘향", 16, 159.3, "남원시"),
			new StudentDto("임꺽정", 26, 184.4, "강릉시"),
			new StudentDto("사민", 27, 168.2, "부산시"),
			new StudentDto("홍길동", 23, 166.8, "광주시"),
			new StudentDto("선우대형", 22, 177.9, "대구시"),
			new StudentDto("성춘향", 14, 168.3, "대전시"),
	};*/
	
	private int count;
	private FileProc fp;
	
	public StudentDao() {
		students = new StudentDto[10]; // 배열만 할당
				
//		for (int i = 0; i < students.length; i++) {
//			students[i] = new StudentDto();
//		}
		
		count = 0;
		fp = new FileProc("students");
	}
	
	public void insert() {
		System.out.print("이름 >> ");
		String name = sc.next();
		
		System.out.print("나이 >> ");
		int age = sc.nextInt();
		
		System.out.print("신장 >> ");
		double height = sc.nextDouble();
		
		System.out.print("주소 >> ");
		String address = sc.next();
		
		students[count] = new StudentDto(name, age, height, address);
		count++;
	}
	
	public void delete() {
		System.out.print("삭제할 이름 >> ");
		String name = sc.next();
		
		int index = search(name);
		if(index == -1) {
			System.out.println("학생정보를 찾을 수 없습니다");
			return;
		}
		
		String delName = students[index].getName();
		students[index] = null;
		System.out.println(delName + "학생의 정보를 삭제하였습니다");
	}
	
	public void select() {
		System.out.print("검색할 이름 >> ");
		String name = sc.next();
		
		int count = nameCount(name);
		
		if(count == 0) {
			System.out.println("학생명단에 없습니다");
			return;		// 함수에서 break 역활
		}
		
		StudentDto findStudent[] = new StudentDto[count];		
		int len = 0;
		for(int i = 0;i < students.length; i++) {
			if(students[i] != null && name.equals(students[i].getName())) {
				findStudent[len] = students[i];
				len++;
			}			
		}
		
		// 학생정보 출력	
		System.out.println("학생정보입니다");
		for (int i = 0; i < findStudent.length; i++) {
			System.out.println(findStudent[i].toString());
		}		
	}
	
	public void update() {
		System.out.print("수정할 이름 >> ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("학생정보를 찾을 수 없습니다");
			return;
		}
		
		System.out.print("수정할 주소 >> ");
		String address = sc.next();
		
		students[index].setAddress(address);
		System.out.println(students[index].getName() + "학생의 주소를 변경하였습니다");
	}
	
	public void allprint() {
		for (StudentDto st : students) {
			if(st != null) {
				System.out.println(st.toString());
			}
		}
	}	
	
	public int search(String name) {		
		int index = -1;
		for (int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				if(name.equals(students[i].getName())) {
					index = i;
					break;
				}
			}
		}		
		return index;
	}
	
	public int nameCount(String name) {
		int count = 0;
		for(int i = 0;i < students.length; i++) {
			if(students[i] != null) {
				if(name.equals(students[i].getName())) {
					count++;
				}
			}			
		}
		return count;
	}
	
	public void save() {
		// 홍길동-24-172.1-서울시
//		for (int i = 0; i < students.length; i++) {
//			System.out.println(students[i].toString2());
//		}
		
		int count = 0;
		for (StudentDto s : students) {
			if(s != null) {
				count++;
			}			
		}		
				 
		String arr[] = new String[count];
		int len = 0;
		for (int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				arr[len] = students[i].toString2();
				len++;
			}
		}
		
		fp.fileSave(arr);
	}
	
	public void load() {
		
		String arr[] = fp.fileLoad();
		
//		for (String s : arr) {
//			System.out.println(s);
//		}
		
		for (int i = 0; i < arr.length; i++) {
			String student[] = arr[i].split("-");  // 홍길동-24-172.1-서울시
			
			students[i] = new StudentDto(student[0], 
										Integer.parseInt(student[1]), 
										Double.parseDouble(student[2]), 
										student[3]);	
		}
		System.out.println("데이터를 로드하였습니다");		
	}
}














