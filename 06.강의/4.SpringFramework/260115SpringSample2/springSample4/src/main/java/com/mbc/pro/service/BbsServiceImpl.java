package com.mbc.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.BbsDao;
import com.mbc.pro.dto.BbsComment;
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

	@Override
	public boolean bbsupdate(BbsDto dto) {		
		int count = dao.bbsupdate(dto);
		return count>0?true:false;
	}

	@Override
	public boolean bbsdelete(int seq) {
		int count = dao.bbsdelete(seq);
		return count>0;
	}

	@Override
	public boolean answer(BbsDto dto) {
		dao.BbsAnswerUpdate(dto);		
		return dao.BbsAnswerInsert(dto) > 0;
	}

	@Override
	public boolean commentWrite(BbsComment com) {
		int count = dao.commentWrite(com);		
		return count>0;
	}

	@Override
	public List<BbsComment> commentList(int bbsseq) {		
		return dao.commentList(bbsseq);
	}		
	
}
