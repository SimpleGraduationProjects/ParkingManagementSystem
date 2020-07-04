package com.imust.controller;

import com.imust.entity.Order;
import com.imust.entity.Park;
import com.imust.entity.Users;
import com.imust.service.OrderService;
import com.imust.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ParkService parkService;
	//获取列表
	@RequestMapping("/showOrder")
	public String showOrder(Model model,HttpSession session) {
		Users user = (Users)session.getAttribute("LogUser");
		List<Order> orderList = orderService.getByUserId(user.getId());
        System.out.println(orderList);
        List<Order> list2=new ArrayList<>();
        for(Order order:orderList){
            Date data1=order.getCreateDate();
            Date data2=new Date();
          int num=  getDayCount(data1,data2);
            order.setTotal(order.getPrice()*num);
            list2.add(order);
        }
		model.addAttribute("orderList",list2);
		return "orderList";
	}
	
	//获取列表
	@RequestMapping("/jiesuan")
    @ResponseBody
	public Map<String,String> jiesuanOrder(@RequestParam("id") int id) {
		Order order = orderService.getById(id);
		order.setStatus(1);
		if(orderService.updateOrderStatus(order)) {
			Park park = parkService.getById(order.getPark_id());
			park.setStatus(0);
			parkService.updateCarStatus(park);
		}

        Map<String,String> map = new HashMap<String,String>();
        map.put("res", "0");


		return map;
	}



    //删除
    @RequestMapping("/delOrder")
    public String delOrder(@RequestParam("orderId") int id){
        Map<String,String> map = new HashMap<String,String>();
        map.put("res", "1");
        if(orderService.delOrder(id)) {
            map.put("res", "0");
        }
        return "redirect:/order/showOrder";
    }

    @RequestMapping("/QR_code")
    public String addAdmin(@RequestParam("orderId") int orderId,Model model){
        model.addAttribute("orderId",orderId);
        return "orderListQRCode";
    }


    /**
     * 判断相差几天
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getDayCount(Date beginDate, Date endDate) {
        int count = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        while (calendar.getTime().before(endDate)) {
            count++;
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return count;
    }

}
