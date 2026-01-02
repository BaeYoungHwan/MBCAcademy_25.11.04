package com.mbc.mvc.one.dao;

import com.mbc.mvc.one.db.DBConnection;

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
			
			//String sql = 
			
			return 0;
		}
}
