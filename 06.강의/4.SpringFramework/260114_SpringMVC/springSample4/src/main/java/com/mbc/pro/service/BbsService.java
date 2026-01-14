package com.mbc.pro.service;

import java.util.List;

import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.Bbsparam;

public interface BbsService {

	List<BbsDto> bbslist(Bbsparam param);
	int getAllBbs(Bbsparam param);	
	boolean bbswrite(BbsDto dto);
	
	BbsDto getBbs(int seq);
}
