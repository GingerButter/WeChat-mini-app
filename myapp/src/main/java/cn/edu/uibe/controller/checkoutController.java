package cn.edu.uibe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import cn.edu.uibe.domain.MyResult;
import cn.edu.uibe.domain.checkout;
import cn.edu.uibe.service.checkoutService;

@Controller
public class checkoutController {
	@Autowired 
    checkoutService chSer;
	
	@RequestMapping("/checkout/insert")
	public @ResponseBody MyResult checkin(@RequestParam(defaultValue = "") String id) {
		
		Date d = new Date();
		//Date t = new Date(date.format(d));
		checkout c = new checkout();
		c.setId(Long.parseLong(id));
		c.setCheckoutdate(d);
		c.setCheckouttime(d);
		chSer.insertCheckout(c);
		
		
		return new MyResult("success");
		
	}
}
