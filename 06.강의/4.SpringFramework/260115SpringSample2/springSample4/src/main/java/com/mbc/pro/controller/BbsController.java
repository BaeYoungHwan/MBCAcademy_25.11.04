package com.mbc.pro.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbc.pro.dto.BbsComment;
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
		System.out.println("BbsController bbsdetail " + new Date());
		
		BbsDto dto = service.getBbs(seq);
		model.addAttribute("dto", dto);
		
		return "bbs/bbsdetail";
	}
	
	@GetMapping("bbsupdate.do")
	public String bbsupdate(int seq, Model model) {
		System.out.println("BbsController bbsupdate " + new Date());
		
		BbsDto dto = service.getBbs(seq);
		model.addAttribute("dto", dto);
		
		return "bbs/bbsupdate";
	}
	
	@PostMapping("bbsupdateAf.do")
	public String bbsupdateAf(BbsDto dto, Model model) {
		System.out.println("BbsController bbsupdateAf " + new Date());
		
		boolean isS = service.bbsupdate(dto);
		String bbsupdateMsg = "UPDATE_SUCCESS";
		if(!isS) {
			bbsupdateMsg = "UPDATE_FAIL";
		}
		model.addAttribute("bbsupdateMsg", bbsupdateMsg);
		model.addAttribute("seq", dto.getSeq());
		
		return "message";		
	}
	
	@GetMapping("bbsdelete.do")
	public String bbsdelete(int seq, Model model) {
		System.out.println("BbsController bbsdelete " + new Date());
		
		boolean isS = service.bbsdelete(seq);
		String bbsdeleteMsg = "DELETE_SUCCESS";
		if(!isS) {
			bbsdeleteMsg = "DELETE_FAIL";
		}
		model.addAttribute("bbsdeleteMsg", bbsdeleteMsg);
		
		return "message";
	}
	
	@GetMapping("answer.do")
	public String answer(int seq, Model model) {
		System.out.println("BbsController answer " + new Date());
		
		BbsDto dto = service.getBbs(seq);
		model.addAttribute("dto", dto);
		
		return "bbs/answer";
	}
	
	@PostMapping("answerAf.do")
	public String answer(BbsDto dto, Model model) {
		System.out.println("BbsController answerAf " + new Date());
		
		boolean isS = service.answer(dto);
		String answerMsg = "ANSWER_SUCCESS";
		if(!isS) {
			answerMsg = "ANSWER_FAIL";
		}
		model.addAttribute("answerMsg", answerMsg);
		
		return "message";		
	}
	
	@PostMapping("bbscommentWriteAf.do")
	public String bbscommentWriteAf(BbsComment com) {
		System.out.println("BbsController bbscommentWriteAf " + new Date());
		
		boolean isS = service.commentWrite(com);
		if(!isS) {
			System.out.println("추가되지 않았습니다");
		}
		
		return "redirect:/bbsdetail.do?seq=" + com.getBbsseq();
	}
	
	@ResponseBody
	@GetMapping("commentList.do")
	public List<BbsComment> commentList(int bbsseq){
		System.out.println("BbsController commentList " + new Date());
		
		return service.commentList(bbsseq);		
	}
	
}







