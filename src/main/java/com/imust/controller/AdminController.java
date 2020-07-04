package com.imust.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imust.entity.Admin;
import com.imust.entity.Park;
import com.imust.entity.Message;
import com.imust.entity.Notice;
import com.imust.entity.Order;
import com.imust.entity.Users;
import com.imust.service.AdminService;
import com.imust.service.ParkService;
import com.imust.service.MessageService;
import com.imust.service.NoticeService;
import com.imust.service.OrderService;
import com.imust.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private ParkService parkService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("admin") Admin admin,HttpSession session,Model model) {
		
		admin = adminService.login(admin);
		if(admin!=null) {
			session.setAttribute("LogAdmin", admin);
			return "admin/index";
		}else {
			model.addAttribute("msg", "用户名或密码错误");
			return "admin/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LogAdmin");
		return "admin/login";
	}
	
	//获取管理员列表
	@RequestMapping("/admin-list")
	public String getAllAdmin(Model model) {
		List<Admin> adminList = adminService.getAllAdmin();
		model.addAttribute("adminList",adminList);
		model.addAttribute("adminNum",adminList.size());
		return "admin/admin-list";
	}
	
	@RequestMapping("/findAdminByName")
	public String getByName(@RequestParam("nameTmp")String name,Model model) {
		List<Admin> adminList = adminService.getAdminByName(name);
		model.addAttribute("adminList",adminList);
		model.addAttribute("adminNum",adminList.size());
		model.addAttribute("nameTmp",name);
		return "admin/admin-list";
	}
	
	@RequestMapping("/admin-add")
	public String addAdmin(){
		return "admin/admin-add";
	}

	@ResponseBody
	@RequestMapping("/admin-save")
	public Map<String,String> saveAdmin(@ModelAttribute("admin") Admin admin){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(adminService.addAdmin(admin)) {
			map.put("res", "0");
		}
		return map;
	}
	
	//删除管理员账号用过Id
	@ResponseBody
	@RequestMapping("/delAdmin")
	public Map<String,String> delAdmin(@RequestParam("adminId") int id){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(adminService.delAdmin(id)) {
			map.put("res", "0");
		}
		return map;
	}
	
	@RequestMapping("/change-info")
	public String editAdmin(@RequestParam("adminId") int id,Model model){
		Admin admin = adminService.getAdminById(id);
		model.addAttribute("admin",admin);
		return "admin/change-info";
	}
	@ResponseBody
	@RequestMapping("/updateAdmin")
	public Map<String,String> updateAdmin(Admin admin){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(adminService.updateAdmin(admin)) {
			map.put("res", "0");
		}
		return map;
	}	
	
////////////////////////////////////关于车位开始
	//获取列表
	@RequestMapping("/car-list")
	public String getAllCar(Model model) {
		List<Park> carList = parkService.getAll();
		model.addAttribute("carList",carList);
		model.addAttribute("carNum",carList.size());
		return "car/car-list";
	}
	
	@RequestMapping("/findCarByKey")
	public String findCarByKey(@RequestParam("keyTmp")String key,Model model) {
		List<Park> carList = parkService.getByKey(key);
		model.addAttribute("carList",carList);
		model.addAttribute("carNum",carList.size());
		model.addAttribute("keyTmp",key);
		return "car/car-list";
	}
	@RequestMapping("/car-edit")
	public String editCar(@RequestParam("carId") int id,Model model){
		Park car = parkService.getById(id);
		model.addAttribute("car",car);
		return "car/car-edit";
	}
	
	@ResponseBody
	@RequestMapping("/car-update")
	public Map<String,String> saveMessage(@ModelAttribute("car") Park car){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(parkService.updateCar(car)) {
			map.put("res", "0");
		}
		return map;
	}
	
	//删除
	@ResponseBody
	@RequestMapping("/delCar")
	public Map<String,String> delCar(@RequestParam("carId") int id){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(parkService.delCar(id)) {
			map.put("res", "0");
		}
		return map;
	}
	//跳转添加页
	@RequestMapping("/car-add")
	public String addCar(){
		return "car/car-add";
	}
	//添加车次
	@ResponseBody
	@RequestMapping("/car-save")
	public Map<String,String> carSave(@ModelAttribute("car") Park car){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(parkService.addCar(car)) {
			map.put("res", "0");
		}
		return map;
	}
	
//////////////////////关于车位结束
	
//////////////////////关于公告开始
	
	//获取公告列表
	@RequestMapping("/notice-list")
	public String getAllNotice(Model model) {
		List<Notice> noticeList = noticeService.getAll();
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("noticeNum",noticeList.size());
		return "notice/notice-list";
	}
	
	@RequestMapping("/findNoticeByTitle")
	public String findNoticeByTitle(@RequestParam("titleTmp")String title,Model model) {
		List<Notice> noticeList = noticeService.getByTitle(title);
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("noticeNum",noticeList.size());
		model.addAttribute("titleTmp",title);
		return "notice/notice-list";
	}
	
	@RequestMapping("/notice-add")
	public String addNotice(){
		return "notice/notice-add";
	}
	
	@ResponseBody
	@RequestMapping("/notice-save")
	public Map<String,String> saveNotice(HttpSession session,@ModelAttribute("notice") Notice notice){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		Admin admin = (Admin)session.getAttribute("LogAdmin");
		notice.setAdmin_id(admin.getId());
		notice.setAdmin_name(admin.getName());
		if(noticeService.addNotice(notice)) {
			map.put("res", "0");
		}
		return map;
	}
	
	
	//删除
	@ResponseBody
	@RequestMapping("/delNotice")
	public Map<String,String> delNotce(@RequestParam("noticeId") int id){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(noticeService.delNotice(id)) {
			map.put("res", "0");
		}
		return map;
	}
	
	@RequestMapping("/notice-edit")
	public String editNotice(@RequestParam("noticeId") int id,Model model){
		Notice notice = noticeService.getById(id);
		model.addAttribute("notice",notice);
		return "notice/notice-edit";
	}
	//修改
	@ResponseBody
	@RequestMapping("/notice-update")
	public Map<String,String> updateNotice(Notice notice){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(noticeService.updateNotice(notice)) {
			map.put("res", "0");
		}
		return map;
	}
	
///////////////////////////////////公告通知结束
	
	
///////////////////////////////////订单管理开始
	//获取列表
	@RequestMapping("/order-list")
	public String getAllOrder(Model model) {
		List<Order> orderList = orderService.getAll();
		model.addAttribute("orderList",orderList);
		model.addAttribute("orderNum",orderList.size());
		return "order/order-list";
	}
	
	@RequestMapping("/findOrderByKey")
	public String findOrderByKey(@RequestParam("keyTmp")String key,Model model) {
		List<Order> orderList = orderService.getByKey(key);
		model.addAttribute("orderList",orderList);
		model.addAttribute("orderNum",orderList.size());
		model.addAttribute("keyTmp",key);
		return "order/order-list";
	}
	
	//删除
	@ResponseBody
	@RequestMapping("/delOrder")
	public Map<String,String> delOrder(@RequestParam("orderId") int id){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(orderService.delOrder(id)) {
			map.put("res", "0");
		}
		return map;
	}
///////////////////////////////////订单管理结束

//////////////////////////////////积分管理开始
	//后台获取积分列
	@RequestMapping("/point-list")
	public String getAllUserPoint(Model model) {
		List<Users> pointList = userService.getAllPoint();
		model.addAttribute("pointList",pointList);
		model.addAttribute("pointNum",pointList.size());
		return "point/point-list";
	}
	//后台获取积分列表模糊查
	@RequestMapping("/findPointByName")
	public String findPointByName(@RequestParam("nameTmp")String name,Model model) {
		List<Users> pointList = userService.getPointByName(name);
		model.addAttribute("pointList",pointList);
		model.addAttribute("pointNum",pointList.size());
		model.addAttribute("nameTmp",name);
		return "point/point-list";
	}
//////////////////////////////////积分管理结束
	
//////////////////////////////////用户管理开始
	//后台模糊查询用户
	@RequestMapping("/findUserByName")
	public String findUserByName(@RequestParam("nameTmp")String name,Model model) {
		List<Users> userList = userService.getByName(name);
		model.addAttribute("userList",userList);
		model.addAttribute("userNum",userList.size());
		model.addAttribute("nameTmp",name);
		return "user/user-list";
	}
	//后台获取用户列表
	@RequestMapping("/user-list")
	public String getAllUser(Model model) {
		List<Users> userList = userService.getAll();
		model.addAttribute("userList",userList);
		model.addAttribute("userNum",userList.size());
		return "user/user-list";
	}
	
	//停用用户账号用过Id
	@ResponseBody
	@RequestMapping("/stopUser")
	public Map<String,String> stopAdmin(@RequestParam("userId") int id){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(userService.updateStautsById(id, 1)) {
			map.put("res", "0");
		}
		return map;
	}
	//启用管理员账号用过Id
	@ResponseBody
	@RequestMapping("/startUser")
	public Map<String,String> startAdmin(@RequestParam("userId") int id){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(userService.updateStautsById(id, 0)) {
			map.put("res", "0");
		}
		return map;
	}
	////////////////////////////////用户管理结束
	
	////////////////////////////////留言管理开始
	
	//获取公告列表
	@RequestMapping("/message-list")
	public String getAllMessage(Model model) {
		List<Message> messageList = messageService.getAll();
		model.addAttribute("messageList",messageList);
		model.addAttribute("messageNum",messageList.size());
		return "message/message-list";
	}
	
	@RequestMapping("/findMessageByContent")
	public String findMessageByContent(@RequestParam("contentTmp")String content,Model model) {
		List<Message> messageList = messageService.getByContent(content);
		model.addAttribute("messageList",messageList);
		model.addAttribute("messageNum",messageList.size());
		model.addAttribute("contentTmp",content);
		return "message/message-list";
	}
	//管理员删除
	@ResponseBody
	@RequestMapping("/delMessage")
	public Map<String,String> delMessage(@RequestParam("messageId") int id){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		if(messageService.delMessage(id)) {
			map.put("res", "0");
		}
		return map;
	}
	
	//跳转留言回复页面
	@RequestMapping("/answer-add")
	public String addMessage(@RequestParam("messageId") int id,Model model){
		model.addAttribute("messageId", id);
		return "message/answer-add";
	}
		
	//回复留言
	@ResponseBody
	@RequestMapping("/answer-save")
	public Map<String,String> answer(HttpSession session,@ModelAttribute("message") Message message){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res", "1");
		Admin admin = (Admin)session.getAttribute("LogAdmin");
		message.setAdmin_id(admin.getId());
		message.setAdmin_name(admin.getName());
		if(messageService.updateMessage(message)) {
			map.put("res", "0");
		}
		return map;
	}
	/////////////////////////////////留言管理结束
}
