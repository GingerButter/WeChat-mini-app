package cn.edu.uibe.dao;

import java.util.Date;

import cn.edu.uibe.domain.checkin;
import cn.edu.uibe.domain.checkinKey;

public interface checkinMapper {
    int deleteByPrimaryKey(checkinKey key);

    int insert(checkin record);

    int insertSelective(checkin record);
    
    long insertCheckin(String id);

    checkin selectByPrimaryKey(checkinKey key);

    int updateByPrimaryKeySelective(checkin record);

    int updateByPrimaryKey(checkin record);
    
    Date selectCheckinTime(checkinKey key);
}