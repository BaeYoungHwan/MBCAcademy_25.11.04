package com.mbc.pro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mbc.pro.dto.MemberDto;

@Repository
public class HelloDaoImpl implements HelloDao {
	// Database와 대화
	@Autowired
	SqlSession session;		// DI
	
	String namespace = "Member.";

	@Override
	public List<MemberDto> allmember() {		
		//                                        "Member.allmember"  
		List<MemberDto> list = session.selectList(namespace + "allmember");		
		return list;
	}	
	
}







