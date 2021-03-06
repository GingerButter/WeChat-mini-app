package cn.edu.uibe.dao;

import java.util.Date;

import cn.edu.uibe.domain.employee;

public interface employeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(employee record);

    int insertSelective(employee record);

    employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(employee record);

    int updateByPrimaryKey(employee record);
    
}