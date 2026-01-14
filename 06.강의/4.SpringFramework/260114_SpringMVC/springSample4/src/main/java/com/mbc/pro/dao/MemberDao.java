package com.mbc.pro.dao;

import com.mbc.pro.dto.MemberDto;

public interface MemberDao {

	int idcheck(String id);	
	int addmember(MemberDto dto);
	
	MemberDto login(MemberDto dto);
}
