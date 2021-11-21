package cn.edu.uibe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.uibe.domain.MyResult;
import cn.edu.uibe.domain.UserInfo;
import cn.edu.uibe.service.UserInfoService;

@Controller
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@GetMapping("/users")
	public ModelAndView getAllUsers() {
		List<UserInfo> userList = userInfoService.getAllUsers();
		//(String viewName, String modelName, Object modelObject)
		return new ModelAndView("user_info", "users", userList);
	}
	
	@RequestMapping("/api/adduser")
	@ResponseBody
	public MyResult addUser(@RequestParam(value="uname") String userName) {
		UserInfo user = new UserInfo();
		user.setName(userName);
		int count = userInfoService.insertUserInfo(user);
		if(count>0) {
			return new MyResult(0, "success");
		}else {
			return  new MyResult(1, "failed");
		}
	}

}
