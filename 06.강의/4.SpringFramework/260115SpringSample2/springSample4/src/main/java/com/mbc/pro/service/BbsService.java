package com.mbc.pro.service;

import java.util.List;

import com.mbc.pro.dto.BbsComment;
import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.Bbsparam;

public interface BbsService {

	List<BbsDto> bbslist(Bbsparam param);
	int getAllBbs(Bbsparam param);	
	boolean bbswrite(BbsDto dto);	
	BbsDto getBbs(int seq);
	
	boolean bbsupdate(BbsDto dto);
	boolean bbsdelete(int seq);
	
	boolean answer(BbsDto bto);
	
	boolean commentWrite(BbsComment com);
	List<BbsComment> commentList(int bbsseq);
}



