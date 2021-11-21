
package cn.edu.uibe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.uibe.dao.MyUserMapper;
import cn.edu.uibe.domain.MyUser;
import cn.edu.uibe.service.MyUserService;

@Service
public class MyUserServiceImpl implements MyUserService{
	
	@Autowired
	MyUserMapper myUserMapper;

	@Override
	public List<MyUser> getAllUsers() {
		return myUserMapper.selectMyUsers();
	}

	@Override
	public int insertMyUser(MyUser user) {
		return myUserMapper.insert(user);
	}

}
