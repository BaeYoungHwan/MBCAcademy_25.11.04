package com.mbc.projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mbc.project.db.DBClose;
import com.mbc.project.db.DBConnection;
import com.mbc.projet.dto.ProjectDTO;

public class ProjectDAO {
	
	private static ProjectDAO dao = null;
	
	private ProjectDAO() {
		DBConnection.initConnection();
	}
	
	public static ProjectDAO geInstance() {
		
		if( dao == null) {
			dao = new ProjectDAO();
		}
		
		return dao;
	}
	public List<ProjectDTO> getList() {
		
		String sql = "select product_no, product_name, product_price, product_memo from product";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<ProjectDTO> list = new ArrayList<ProjectDTO>();
		
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				int productNo = rs.getInt("product_no");
				String productName = rs.getString("product_name");
				int productPrice = rs.getInt("product_price");
				String productMemo = rs.getString("product_memo");
				
				list.add(new ProjectDTO(productNo, productName, productPrice, productMemo));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
		
	}
}
