package com.mbc.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.BbsDao;
import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.Bbsparam;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(Bbsparam param) {
		return dao.bbslist(param);
	}

	@Override
	public int getAllBbs(Bbsparam param) {		
		return dao.getAllBbs(param);
	}

	@Override
	public boolean bbswrite(BbsDto dto) {
		int count = dao.bbswrite(dto);
		return count>0;
	}

	@Override
	public BbsDto getBbs(int seq) {		
		return dao.getBbs(seq);
	}	
	
	
}
