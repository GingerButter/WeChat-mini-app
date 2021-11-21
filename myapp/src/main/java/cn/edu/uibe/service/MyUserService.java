package cn.edu.uibe.service;

import java.util.List;

import cn.edu.uibe.domain.MyUser;

public interface MyUserService {
	
	List<MyUser> getAllUsers();
	
	int insertMyUser(MyUser user);

}
