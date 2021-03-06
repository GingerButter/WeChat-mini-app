package cn.edu.uibe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.uibe.dao.checkoutMapper;
import cn.edu.uibe.domain.checkout;
import cn.edu.uibe.domain.checkoutKey;
import cn.edu.uibe.service.checkoutService;

@Service
@Transactional

public class checkoutServiceImpl implements checkoutService{

	@Autowired
	checkoutMapper checkoutMapper;
	
	@Override
	public int insertCheckout(checkout c) {
		return checkoutMapper.insert(c);
	}

	@Override
	public Date retCheckoutTime(checkoutKey k) {
		// TODO Auto-generated method stub
		return checkoutMapper.selectCheckoutTime(k);
	}

	@Override
	public String timeToString(Date d) {
		SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dd.format(d);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isLate(Date d) {
		if (d.getHours()>18) return true;
		else return false;
	}
}
