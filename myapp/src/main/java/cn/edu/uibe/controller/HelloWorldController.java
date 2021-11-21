package cn.edu.uibe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public ModelAndView hello(@RequestParam(value="uname",defaultValue="TongQiang") String userName) {
		Map<String,Object> model = new HashMap<>();
		model.put("userName", userName);
		return new ModelAndView("hello", model);
		
	}

}
