package cn.edu.uibe.service;

import java.util.Date;

import cn.edu.uibe.domain.checkout;
import cn.edu.uibe.domain.checkoutKey;

public interface checkoutService {
	
	int insertCheckout(checkout c);
	
	Date retCheckoutTime(checkoutKey k);
	
	String timeToString(Date d);
	
	boolean isLate(Date d);

}
