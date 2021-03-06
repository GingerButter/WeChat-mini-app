package cn.edu.uibe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.text.SimpleDateFormat;

import cn.edu.uibe.domain.MyResult;
import cn.edu.uibe.domain.checkin;
import cn.edu.uibe.domain.checkinKey;
import cn.edu.uibe.service.checkinService;

@Controller
public class checkinController {
	
	@Autowired 
    checkinService chSer;
	
	@RequestMapping("/checkin/insert")
	public @ResponseBody MyResult checkin(@RequestParam(defaultValue = "") String id) {
		
		Date d = new Date();
		//Date t = new Date(date.format(d));
		checkin c = new checkin();
		c.setId(Long.parseLong(id));
		c.setCheckindate(d);
		c.setCheckintime(d);
		chSer.insertCheckin(c);
		
		System.out.println("GOGO");
		
		return new MyResult("success");
		
	}
	
	
}
