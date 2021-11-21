package cn.edu.uibe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.uibe.dao.UserInfoMapper;
import cn.edu.uibe.domain.UserInfo;
import cn.edu.uibe.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public List<UserInfo> getAllUsers() {
		return userInfoMapper.selectAllUsers();
	}

	@Override
	@Transactional
	public int insertUserInfo(UserInfo userInfo) {	
		return userInfoMapper.insert(userInfo);
	}

}
