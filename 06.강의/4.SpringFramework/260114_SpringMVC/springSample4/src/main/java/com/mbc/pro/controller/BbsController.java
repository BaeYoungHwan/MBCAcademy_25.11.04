package com.mbc.pro.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.Bbsparam;
import com.mbc.pro.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	BbsService service;
	
	@GetMapping("bbslist.do")
	public String bbslist(Model model, Bbsparam param) {
		System.out.println("BbsController bbslist " + new Date());
		
		// 글목록
		List<BbsDto> list = service.bbslist(param);
		
		// 글의 총수
		int count = service.getAllBbs(param);
		
		// 페이지 수(계산) 26 -> 3
		int pageBbs = count / 10;
		if((count % 10) > 0) {
			pageBbs = pageBbs + 1;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pageBbs", pageBbs);
		model.addAttribute("param", param);
		
		return "bbs/bbslist";
	}	
	
	@GetMapping("bbswrite.do")
	public String bbswrite() {
		System.out.println("BbsController bbswrite " + new Date());
		return "bbs/bbswrite";
	}
	
	@PostMapping("bbswriteAf.do")
	public String bbswriteAf(BbsDto dto, Model model) {
		System.out.println("BbsController bbswriteAf " + new Date());
		
		boolean isS = service.bbswrite(dto);
		String bbswriteMsg = "BBSWRITE_SUCCESS";
		if(isS == false) {
			bbswriteMsg = "BBSWRITE_FAIL";
		}
		model.addAttribute("bbswriteMsg", bbswriteMsg);
		
		return "message";
	}
	
	@GetMapping("bbsdetail.do")
	public String bbsdetail(int seq, Model model) {
		System.out.println("BbsController bbswriteAf " + new Date());
		
		BbsDto dto = service.getBbs(seq);
		model.addAttribute("dto", dto);
		
		return "bbs/bbsdetail";
	}
	
}







