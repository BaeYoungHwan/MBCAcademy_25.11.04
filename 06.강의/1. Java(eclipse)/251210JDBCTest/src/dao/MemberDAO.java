package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBClose;
import database.DBConnection;
import dto.MemberDTO;

public class MemberDAO {

	public MemberDAO() {
		
		DBConnection.initConnection();

	}
	
	public int insert(String id, String name, int age) {
		// Query
		String sql = "insert into member(id, name, age, joindate) values(?,?,?,now())";
		
		// DB연결 및 SQL 변수 선언
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 결과값을 위한 변수
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			
			count = psmt.executeUpdate();
			
			System.out.println("insert success");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count;
		
	}
	
	public int delete(String id) {
		String sql = "delete from member where id = ?;";
		// DB연결 및 SQL 변수 선언
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 결과값을 위한 변수
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			count = psmt.executeUpdate();
			
			System.out.println("delete success");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count;
	}
	public int update(String id, int age) {
		String sql = "update member set age = ? where id = ?;";
		// DB연결 및 SQL 변수 선언
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 결과값을 위한 변수
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(2, id);
			psmt.setInt(1, age);
			
			count = psmt.executeUpdate();
			
			System.out.println("update success");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count;
	}
	
	// 1개의 데이터만 산출 	-> 1개의 DTO 
	public MemberDTO select(String userid) {
		String sql = "select id, name, age, joindate from member where id = ?;";
		
		Connection conn = null;			// DB관련
		PreparedStatement psmt = null;	// Qurey 관련
		
		ResultSet rs = null;			// 결과값 관련
		MemberDTO dto = null;
		
		
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				String result_id = rs.getString("id");
				String result_name = rs.getString("name");
				int result_age = rs.getInt("age");
				String result_joindate = rs.getString("joindate");
				
				dto = new MemberDTO(result_id, result_name, result_age, result_joindate);
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
	
	
	// 다수의 데이터 산출		-> List 
	public List<MemberDTO> selectList() {
		
		String sql = "select id, name, age, joindate from member ;";
		
		Connection conn = null;			// DB관련
		PreparedStatement psmt = null;	// Qurey 관련
		
		ResultSet rs = null;			// 결과값 관련
		MemberDTO dto = null;
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {

				String result_id = rs.getString("id");
				String result_name = rs.getString("name");
				int result_age = rs.getInt("age");
				String result_joindate = rs.getString("joindate");
				
				list.add(new MemberDTO(result_id, result_name, result_age, result_joindate));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
			
		}
		return list;
		
	}
	
}
