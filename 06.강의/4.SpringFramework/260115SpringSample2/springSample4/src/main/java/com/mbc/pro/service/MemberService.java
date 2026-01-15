package com.mbc.pro.service;

import com.mbc.pro.dto.MemberDto;

public interface MemberService {

	boolean idcheck(String id);	
	boolean addmember(MemberDto dto);
	
	MemberDto login(MemberDto dto);
}
