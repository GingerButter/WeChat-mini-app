package cn.edu.uibe.service;

import java.util.Date;

import cn.edu.uibe.dao.checkinMapper;
import cn.edu.uibe.domain.checkin;
import cn.edu.uibe.domain.checkinKey;

public interface checkinService {
	
	int insertCheckin(checkin c);
	
	Date retCheckinTime(checkinKey k);
	
	String timeToString(Date d);
	
	boolean isLate(Date d);

}

