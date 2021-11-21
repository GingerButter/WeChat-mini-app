package cn.edu.uibe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.uibe.dao.DetailMapper;
import cn.edu.uibe.dao.MemberMapper;
import cn.edu.uibe.domain.Detail;
import cn.edu.uibe.domain.Member;
import cn.edu.uibe.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	DetailMapper detailMapper;

	@Override
	public Member selectMemberById(String id) {
		long userId = Long.parseLong(StringUtils.trimToEmpty(id));
		return memberMapper.selectByPrimaryKey(userId);
	}
	
	@Override
	public Member getMemberByPhone(String phone) {
		return memberMapper.selectByPhone(StringUtils.trimToEmpty(phone));
	}
	
	@Override
	@Transactional
	public boolean charge(String id, String amount, String comment) {
		long userId = Long.parseLong(StringUtils.trimToEmpty(id));
		Member member = memberMapper.selectByPrimaryKey(userId);
		if(member==null) {
			return false;
		}
		double money = Double.parseDouble(StringUtils.trimToEmpty(amount));
		if(money<0) {
			return false;
		}
		member.setCredits(member.getCredits()+money);
		int count = memberMapper.updateByPrimaryKeySelective(member);
		
		Detail detail = new Detail();
		detail.setMemberid(member.getId());//外键，会员ID
		detail.setAmount(money);
		detail.setComment(StringUtils.trimToNull(comment));
		detail.setFinishtime(new Date());
	    int dcount = detailMapper.insert(detail);
		
	    return count == 1 && dcount==1;
	}
	
	@Override
	@Transactional
	public String consume(String id,String amount,String comment) {
		long userId = Long.parseLong(StringUtils.trimToEmpty(id));
		Member member = memberMapper.selectByPrimaryKey(userId);
		if(member==null) {
			return "无效的会员ID";
		}
		double money = Double.parseDouble(StringUtils.trimToEmpty(amount));
		if(money<0) {
			return "无效的消费金额: "+amount;
		}
		if(member.getCredits() < money) {//余额小于消费金额
			return "余额不足，请先充值!";
		}
		member.setCredits(member.getCredits()-money);
		int count = memberMapper.updateByPrimaryKeySelective(member);
		
		Detail detail = new Detail();
		detail.setMemberid(member.getId());//外键，会员ID
		detail.setAmount(-money);
		detail.setComment(StringUtils.trimToNull(comment));
		detail.setFinishtime(new Date());
	    int dcount = detailMapper.insert(detail);
		
		if(count==1 && dcount==1) {
			return "success";		
		}else {
			return "交易失败!";
		}
	}

	@Override
	public List<Detail> getDetailsByMemberId(String memberId) {
		long mid = Long.parseLong(StringUtils.trimToEmpty(memberId));
		List<Detail> detailList = detailMapper.selectByMemberId(mid);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(Detail detail: detailList) {
			String time = df.format(detail.getFinishtime());
			detail.setTransactionTime(time);
		}
		return detailList;
	}

}
