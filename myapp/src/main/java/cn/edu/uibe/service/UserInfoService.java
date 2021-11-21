package cn.edu.uibe.service;

import java.util.List;

import cn.edu.uibe.domain.UserInfo;

public interface UserInfoService {
	
	List<UserInfo> getAllUsers();
	
	int insertUserInfo(UserInfo userInfo);

}
