package com.mbc.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.BbsDao;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao dao;
	
}
