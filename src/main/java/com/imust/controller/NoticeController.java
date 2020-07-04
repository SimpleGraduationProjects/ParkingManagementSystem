package com.imust.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imust.entity.Notice;
import com.imust.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	
	
	@RequestMapping("/notice-detail")
	public String showNotice(@RequestParam("id") int id,Model model){
		Notice notice = noticeService.getById(id);
		model.addAttribute("notice",notice);
		return "notice-detail";
	}
	
	
}
