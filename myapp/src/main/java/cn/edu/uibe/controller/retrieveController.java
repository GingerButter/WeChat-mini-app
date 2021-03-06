package cn.edu.uibe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.uibe.domain.checkinKey;
import cn.edu.uibe.domain.checkoutKey;
import cn.edu.uibe.service.checkinService;
import cn.edu.uibe.service.checkoutService;

@Controller
public class retrieveController {
	
	@Autowired 
    checkinService inSer;
	@Autowired
	checkoutService outSer;
	
	@RequestMapping("/retrieve")
	@ResponseBody
	String[] retrieveRecord(@RequestParam(defaultValue="") String id,
			@RequestParam(defaultValue="") String inputTime) {
		String[] ret = new String[4];
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat stime = new SimpleDateFormat("yyyy-MM-dd");
		String[] tt = inputTime.split("-");
		Date newDate = new Date(Integer.parseInt(tt[0])-1900,Integer.parseInt(tt[1])-1,Integer.parseInt(tt[2]));
		java.sql.Date dayDateSql = new java.sql.Date(Integer.parseInt(tt[0])-1900,Integer.parseInt(tt[1])-1,Integer.parseInt(tt[2]));
		System.out.println(newDate);
		checkinKey inKey = new checkinKey();
		inKey.setCheckindate(dayDateSql);
		inKey.setId(Long.parseLong(id));
		checkoutKey outKey = new checkoutKey();
		outKey.setCheckoutdate(dayDateSql);
		outKey.setId(Long.parseLong(id));
		Date intime = inSer.retCheckinTime(inKey);
		Date outtime = outSer.retCheckoutTime(outKey);
		System.out.println(intime.toString());
		ret[0] = time.format(intime);
		ret[2] = time.format(outtime);
		if (inSer.isLate(intime)) ret[1] = "迟到";
		else ret[1] = "正常";
		if (outSer.isLate(outtime)) ret[3] = "加班";
		else ret[3] = "正常";
		System.out.println("自此都已完成");

		return ret;
	}

}
