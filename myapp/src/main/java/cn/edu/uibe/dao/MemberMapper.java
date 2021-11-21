package cn.edu.uibe.dao;

import cn.edu.uibe.domain.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long id);
    
    Member selectByPhone(String phone);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}