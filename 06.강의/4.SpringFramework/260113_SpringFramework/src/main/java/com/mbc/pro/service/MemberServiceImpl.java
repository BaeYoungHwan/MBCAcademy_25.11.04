package com.mbc.pro.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.MemberDao;
import com.mbc.pro.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;

	@Override
	public boolean idcheck(String id) {	
		int count = dao.idcheck(id);		
		return count>0?false:true;
	}
	@Override
	public boolean addmember(MemberDto dto) {
		int count = dao.addmember(dto);
		return count>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto dto) {		
		return dao.login(dto);
	}	
	
}

