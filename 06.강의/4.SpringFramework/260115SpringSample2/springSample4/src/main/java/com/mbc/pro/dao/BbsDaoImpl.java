package com.mbc.pro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mbc.pro.dto.BbsComment;
import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.Bbsparam;

@Repository
public class BbsDaoImpl implements BbsDao{

	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> bbslist(Bbsparam param) {		
		return session.selectList(ns + "bbslist", param);
	}

	@Override
	public int getAllBbs(Bbsparam param) {		
		return session.selectOne(ns + "getAllBbs", param);
	}

	@Override
	public int bbswrite(BbsDto dto) {		
		return session.insert(ns + "bbswrite", dto);
	}

	@Override
	public BbsDto getBbs(int seq) {		
		return session.selectOne(ns + "getBbs", seq);
	}

	@Override
	public int bbsupdate(BbsDto dto) {		
		return session.update(ns + "bbsupdate", dto);
	}

	@Override
	public int bbsdelete(int seq) {		
		return session.update(ns + "bbsdelete", seq);
	}

	@Override
	public int BbsAnswerUpdate(BbsDto dto) {		
		return session.update(ns + "BbsAnswerUpdate", dto);
	}

	@Override
	public int BbsAnswerInsert(BbsDto dto) {		
		return session.insert(ns + "BbsAnswerInsert", dto);
	}

	@Override
	public int commentWrite(BbsComment com) {		
		return session.insert(ns + "commentWrite", com);
	}
	@Override
	public List<BbsComment> commentList(int bbsseq) {		
		return session.selectList(ns + "commentList", bbsseq);
	}	
	
	
}





