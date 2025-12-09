import jdbc.JdbcConnect;

public class main {

	public static void main(String[] args) {
		
		//Jdbc를 클래스 객체생성
		JdbcConnect jdbc = new JdbcConnect();

		jdbc.getConncetion();
		
	}

}
