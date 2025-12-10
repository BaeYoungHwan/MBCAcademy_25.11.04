package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void initConnection() {
		
		// Driver가 존재하는지 확인
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection connectData = null;
		
		try {
			connectData = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("PostgreSQL Connection Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connectData;
	}
	

}