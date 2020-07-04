package com.imust.controller;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imust.entity.Notice;
import com.imust.service.NoticeService;

@Controller
public class IndexController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/404")
	public String error() {
		return "404";
	}
	@RequestMapping("/index")
	public String index(Model model) {
		List<Notice> noticeList = noticeService.getAll();
		model.addAttribute("noticeList",noticeList);
		return "index";
	}
	
	@RequestMapping("/admin-index")
	public String index2(Model model) {
		return "admin/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request,Model model) {
		String localAddr = request.getLocalAddr();    //取得服务器IP     
		int localPort = request.getLocalPort();    //取得服务器端口
		String localName = request.getLocalName();    //取得服务器名称
		String serverName = request.getServerName(); //服务器域名
		Properties props=System.getProperties(); //系统属性
		String javaVersion = props.getProperty("java.version");//操作系统的版本
		String osName = props.getProperty("os.name");//操作系统的名称
		model.addAttribute("localAddr",localAddr);
		model.addAttribute("localPort",localPort);
		model.addAttribute("localName",localName);
		model.addAttribute("serverName",serverName);
		model.addAttribute("osName",osName);
		model.addAttribute("javaVersion",javaVersion);
		return "admin/welcome";
	}
}
