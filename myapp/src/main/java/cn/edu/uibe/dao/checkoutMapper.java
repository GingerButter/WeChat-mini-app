package cn.edu.uibe.dao;

import java.util.Date;

import cn.edu.uibe.domain.checkout;
import cn.edu.uibe.domain.checkoutKey;

public interface checkoutMapper {
    int deleteByPrimaryKey(checkoutKey key);

    int insert(checkout record);

    int insertSelective(checkout record);

    checkout selectByPrimaryKey(checkoutKey key);

    int updateByPrimaryKeySelective(checkout record);

    int updateByPrimaryKey(checkout record);
    
    Date selectCheckoutTime(checkoutKey k);
}