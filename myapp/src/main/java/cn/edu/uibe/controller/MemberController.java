package cn.edu.uibe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.uibe.domain.Detail;
import cn.edu.uibe.domain.Member;
import cn.edu.uibe.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping("/api/member")
	@ResponseBody
	public Member apiMember(@RequestParam(defaultValue="") String uid,
			@RequestParam(defaultValue="") String phone) {
		Member member;
		if(!StringUtils.isBlank(uid)){
			member = memberService.selectMemberById(uid);
		}else {
			member = memberService.getMemberByPhone(phone);
		}
		return member;	
	}
	
	@RequestMapping("/member")
	public ModelAndView member(@RequestParam(defaultValue="") String uid,
			@RequestParam(defaultValue="") String phone) {
		Member member;
		if(!StringUtils.isBlank(uid)){
			member = memberService.selectMemberById(uid);
		}else {
			member = memberService.getMemberByPhone(phone);
		}
		return new ModelAndView("member", "member", member);	
	}
	
	
	
	@RequestMapping("/charge")
	public ModelAndView charge(@RequestParam String uid) {
		Member member = memberService.selectMemberById(uid);
		return new ModelAndView("charge", "member", member);
	}
	
	@RequestMapping("/do_charge")
	public ModelAndView doCharge(@RequestParam String uid,//用户ID
			@RequestParam String amount, //充值金额
			@RequestParam String comment) { //交易备注
		
		boolean success = memberService.charge(uid, amount, comment);
		if(success) {
			return new ModelAndView("do_charge", "uid", uid);
		}else {
			return new ModelAndView("error","message","充值失败!");
		}
		
	}
	
	@RequestMapping("/consume") //进入消费页面
	public ModelAndView consume(@RequestParam String uid) {
		Member member = memberService.selectMemberById(uid);
		return new ModelAndView("consume", "member", member);
	}
	
	@RequestMapping("/do_consume")
	public ModelAndView doConsume(@RequestParam String uid,//用户ID
			@RequestParam String amount, //消费金额
			@RequestParam String comment) { //交易备注
		
		String result = memberService.consume(uid, amount, comment);
		if("success".equals(result)) {
			return new ModelAndView("do_consume", "uid", uid);
		}else {
			return new ModelAndView("error","message", result);
		}
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam String uid) {
		Member member = memberService.selectMemberById(uid);
		List<Detail> detailList = memberService.getDetailsByMemberId(uid);
		Map<String,Object> model = new HashMap<>();
		model.put("member", member);
		model.put("details", detailList);
		
		return new ModelAndView("detail", model);
	}

}
