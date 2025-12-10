import jdbc.JdbcConnect;

public class main {

	public static void main(String[] args) {
		
		//Jdbc를 클래스 객체생성
		JdbcConnect jdbc = new JdbcConnect();

		jdbc.getConncetion();
		
		// insert 함수
		String id = "abc";
		String name = "홍길동";
		int age = 24;
		String table = "member";
		
		int count = jdbc.insert(id, name, age);
		if (count > 0) {
			
			System.out.println("추가되었습니다.");
			
		}else {
			System.out.println("추가되지 않았습니다.");
		}
		

		// update 함수
		int countU = jdbc.update_age(table, 36);
		if (countU > 0) {
			
			System.out.println("수정되었습니다.");
			
		}else {
			System.out.println("수정되지 않았습니다.");
		}
		
		// delete 함수
		int countD = jdbc.delete(table, id);
		if (countD > 0) {
			
			System.out.println("삭제되었습니다.");
			
		}else {
			System.out.println("삭제되지 않았습니다.");
		}
	}
}
