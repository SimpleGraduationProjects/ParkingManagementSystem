package com.imust.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imust.entity.Users;
import com.imust.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//登陆
	@RequestMapping("/login")
	public String login(@ModelAttribute("users") Users users,HttpSession session,Model model) {
		
		Users user = userService.login(users);
		if(user!=null) {
			if(user.getStauts()==0) {
				session.setAttribute("LogUser", user);
				return "redirect:/index";
			}else {
				model.addAttribute("msg", "该用户已被停用");
			}
		}else {
			model.addAttribute("msg", "用户名或密码错误");
		}
		return "join";
	}
	//查看个人信息
	@RequestMapping("/user-show")
	public String getById(@RequestParam("id")int id,Model model) {
		Users userinfo = userService.getUserById(id);
		model.addAttribute("userinfo",userinfo);
		return "user-show";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LogUser");
		return "/join";
	}
	//注册用户
	@RequestMapping("/user-save")
	public String saveUser(@ModelAttribute("users") Users users){
		if(userService.addUser(users)) {
			return "register-ok";
		}
		return "404";
	}
	
	//修改用户手机和邮箱
	@RequestMapping("/update-user")
	public String userUpdate(@ModelAttribute("users") Users user,Model model){
		userService.updateUser(user);
		Users userinfo = userService.getUserById(user.getId());
		model.addAttribute("userinfo",userinfo);
		return "user-show";
	}
	//修改密码页
	@RequestMapping("/password")
	public String password() {
		return "password";
	}
	//修改密码
	@RequestMapping("/updatePwd")
	public String updatePwd(Model model,@RequestParam("id") int id,@RequestParam("newpassword") String newpassword,@RequestParam("oldpassword") String oldpassword) {
		Users userinfo = userService.getUserById(id);
		if(oldpassword.equals(userinfo.getPassword())) {
			userinfo.setPassword(newpassword);
			if(userService.updateUserPwd(userinfo)) {
				return "redirect:/user/logout";
			}
		}else {
			model.addAttribute("usermsg","原密码错误");
		}
		return "password";
	}
}
