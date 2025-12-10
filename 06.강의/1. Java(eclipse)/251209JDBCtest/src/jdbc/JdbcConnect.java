package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnect {
	
	public JdbcConnect(){

		// Driver가 존재하는지 확인
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Connection getConncetion() {
		
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
	
	public int insert(String id, String name, int age) {
		
		//Query
		//String sql = "insert into member(id, name, age, joindate)"
		//		+ "   values(" + id + "," + name + "," + age +"," + "now());";
		
		String sql = " 	insert into member(id, name, age, joindate) "
				+ "		values('" + id + "','" + name + "'," + age + ", now()) "; 
		
		//connection
		Connection connectData = getConncetion();
		//상태
		PreparedStatement statmentData = null;
		//추가 체크
		int count = 0;
		
		try {
			statmentData = connectData.prepareStatement(sql);
			
			count = statmentData.executeUpdate(); // 실세 실행 부분
			
			System.out.println("성공적으로 추가 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				
			try {
				if(connectData != null) {
					connectData.close();
				}
				if(statmentData != null) {
					statmentData.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return count;
	}
public int delete(String table, String id) {
		
		//Query
		String sql = "delete from " + table +" where id = '"+id+"';"; 
		
		//connection
		Connection connectData = getConncetion();
		//상태
		PreparedStatement statmentData = null;
		//추가 체크
		int countD = 0;
		
		try {
			statmentData = connectData.prepareStatement(sql);
			
			countD = statmentData.executeUpdate(); // 실세 실행 부분
			
			System.out.println("성공적으로 삭제 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				
			try {
				if(connectData != null) {
					connectData.close();
				}
				if(statmentData != null) {
					statmentData.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return countD;
	}
public int update_age(String table, int age) {
	
	//Query
	String sql = "update "+table+" set age ="+age+";" ;
	
	//connection
	Connection connectData = getConncetion();
	//상태
	PreparedStatement statmentData = null;
	//추가 체크
	int countU = 0;
	
	try {
		statmentData = connectData.prepareStatement(sql);
		
		countU = statmentData.executeUpdate(); // 실세 실행 부분
		
		System.out.println("성공적으로 삭제 되었습니다.");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		
			
		try {
			if(connectData != null) {
				connectData.close();
			}
			if(statmentData != null) {
				statmentData.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	return countU;
}
}
