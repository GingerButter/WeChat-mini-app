package cn.edu.uibe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.uibe.domain.MyResult;
import cn.edu.uibe.domain.MyUser;
import cn.edu.uibe.service.MyUserService;

@RestController
public class MyUserController {
	
	@Autowired
	MyUserService myUserService;
	
	@GetMapping("/allusers")
	public ModelAndView allUsers() {
		List<MyUser> userList = myUserService.getAllUsers();
		return new ModelAndView("all_users","users", userList);
	}
	
	@RequestMapping("/api/newuser") //进入消费页面
	public @ResponseBody MyResult newUser(@RequestParam String uname) {
		MyUser user = new MyUser();
		user.setName(uname);
		myUserService.insertMyUser(user);
		return new MyResult("success");
		
	}

}
