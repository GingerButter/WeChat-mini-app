package cn.edu.uibe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.uibe.dao.employeeMapper;
import cn.edu.uibe.domain.employee;
import cn.edu.uibe.service.employeeService;

@Service
public class employeeServiceImpl implements employeeService{
	
	@Autowired
	employeeMapper empMap;

	@Override
	public int insertemployee(employee emp) {
		return empMap.insert(emp);
	}

	
	

}
