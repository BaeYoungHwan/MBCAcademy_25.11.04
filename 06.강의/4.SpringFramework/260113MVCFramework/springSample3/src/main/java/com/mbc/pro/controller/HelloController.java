package com.mbc.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mbc.pro.dto.MemberDto;
import com.mbc.pro.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	HelloService service;

	@GetMapping("hello.do")
	public String hello(Model model) {
		System.out.println("HelloController hello()");
		
		List<MemberDto> list = service.allmember();
		
		// 짐싸!
		model.addAttribute("list", list);
		
		return "Hello";
	}
}




