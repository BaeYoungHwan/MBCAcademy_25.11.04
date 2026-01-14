package com.mbc.pro.dao;

import java.util.List;

import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.Bbsparam;

public interface BbsDao {
	
	List<BbsDto> bbslist(Bbsparam param);	
	int getAllBbs(Bbsparam param);			// 글의 총수	
	int bbswrite(BbsDto dto);
	
	BbsDto getBbs(int seq);
}
