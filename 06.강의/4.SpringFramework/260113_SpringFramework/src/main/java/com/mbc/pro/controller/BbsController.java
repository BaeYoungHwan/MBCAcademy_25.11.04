package com.mbc.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mbc.pro.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	BbsService service;
	
	
}
