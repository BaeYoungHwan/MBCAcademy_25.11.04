package com.mbc.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.HelloDao;
import com.mbc.pro.dto.MemberDto;

@Service
public class HelloServiceImpl implements HelloService{
	// Dao와 대화
	@Autowired
	HelloDao dao;

	@Override
	public List<MemberDto> allmember() {
		return dao.allmember();
	}
	
	
}





