package cn.edu.uibe.service;

import java.util.List;

import cn.edu.uibe.domain.Detail;
import cn.edu.uibe.domain.Member;

public interface MemberService {
	
	Member selectMemberById(String id);
	
	Member getMemberByPhone(String phone);
	
	boolean charge(String id,String amount,String comment);
	
	String consume(String id,String amount,String comment);
	
	List<Detail> getDetailsByMemberId(String memberId);

}
