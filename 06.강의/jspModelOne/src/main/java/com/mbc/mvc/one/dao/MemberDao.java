package com.mbc.mvc.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mbc.mvc.one.db.DBClose;
import com.mbc.mvc.one.db.DBConnection;
import com.mbc.mvc.one.dto.MemberDto;

public class MemberDao {

		private static MemberDao dao = null;
		
		private MemberDao() {
			DBConnection.initConnection();
		}
		
		public static MemberDao getInstance() {
			if(dao == null) {
				dao = new MemberDao();
			}
			return dao;			
		}
		
		// id check
		
		// member insert
		
		// log-in
		public int idcheck(String id) {
			
			String sql = " 	select count(*) "
					+ "		from member "
					+ "		where id = ? ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			int count = 0;
			
			try {
				conn = DBConnection.getConnection();
				System.out.println("idcheck 1/3 success");
					
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				System.out.println("idcheck 2/3 success");
				
				rs = psmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt(1);
				}		
				System.out.println("idcheck 3/3 success");
				
			} catch (SQLException e) {
				System.out.println("idcheck fail");
				e.printStackTrace();
			} finally {
				DBClose.close(psmt, conn, rs);
			}
					
			return count;
		}	
		
		// member insert
		public int addMemeber(MemberDto dto) {
			
			// Query
			String sql = "insert into Member(id, pw, name, email, auth) values(?,?,?,?,3)";
			
			// DB연결 및 SQL 변수 선언
			Connection conn = null;
			PreparedStatement psmt = null;
			
			// 결과값을 위한 변수
			int count = 0;
			
			try {
				
				conn = DBConnection.getConnection();
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getPw());
				psmt.setString(3, dto.getName());
				psmt.setString(4, dto.getEmail());
				
				count = psmt.executeUpdate();
				
				System.out.println("insert success");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBClose.close(psmt, conn, null);
			}
			
			
			return count;
		}
		public int idmatch(String id, String pw) {
			
			String sql = " 	select count(*) "
					+ "		from member "
					+ "		where id = ? and pw = ?";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			int count = 0;
			
			try {
				conn = DBConnection.getConnection();
				System.out.println("idcheck 1/3 success");
					
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);
				System.out.println("idcheck 2/3 success");
				
				rs = psmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt(1);
				}		
				System.out.println("idcheck 3/3 success");
				
			} catch (SQLException e) {
				System.out.println("idmatch fail");
				e.printStackTrace();
			} finally {
				DBClose.close(psmt, conn, rs);
			}
					
			return count;
		}
			
}

