package com.mbc.pro.controller;

import java.net.http.HttpRequest;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbc.pro.dto.MemberDto;
import com.mbc.pro.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("login.do")
	public String login() {
		System.out.println("MemberController login " + new Date());		
		return "login";		
	}
	
	@GetMapping("regi.do")
	public String regi() {
		System.out.println("MemberController regi " + new Date());		
		return "regi";
	}
	
	@ResponseBody
	@PostMapping("idcheck.do")
	public String idcheck(String id) {
		System.out.println("MemberController idcheck " + new Date());
		System.out.println("id:" + id);
		
		boolean isS = service.idcheck(id);
		String msg = "YES";
		if(!isS) {
			msg = "NO";
		}
		
		return msg;
	}
	
	@PostMapping("regiAf.do")
	public String regiAf(MemberDto dto, Model model) {
		System.out.println("MemberController regiAf " + new Date());
		
		boolean isS = service.addmember(dto);
		String message = "MEMBER_YES";
		if(!isS) {
			message = "MEMBER_NO";
		}
		
		model.addAttribute("message", message);
		return "message";		
	}	
	
	@PostMapping("loginAf.do")
	public String loginAf(MemberDto dto, Model model, HttpServletRequest request) {
		System.out.println("MemberController loginAf " + new Date());
		
		MemberDto mem = service.login(dto);
		String loginMsg = "LOGIN_FAIL";
		if(mem != null) {
		//	request.getSession().setMaxInactiveInterval(2 * 60 * 60);
			request.getSession().setAttribute("login", mem);
			loginMsg = "LOGIN_SUCCESS";
		}
		
		model.addAttribute("loginMsg", loginMsg);
		return "message";
	}
}










