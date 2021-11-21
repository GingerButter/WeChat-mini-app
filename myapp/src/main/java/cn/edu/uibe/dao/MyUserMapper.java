package cn.edu.uibe.dao;

import java.util.List;

import cn.edu.uibe.domain.MyUser;

public interface MyUserMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(MyUser record);

    int insertSelective(MyUser record);

    MyUser selectByPrimaryKey(Long id);
    
    List<MyUser> selectMyUsers();

    int updateByPrimaryKeySelective(MyUser record);

    int updateByPrimaryKey(MyUser record);
}