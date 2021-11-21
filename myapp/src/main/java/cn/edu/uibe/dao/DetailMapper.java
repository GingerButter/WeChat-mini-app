package cn.edu.uibe.dao;

import java.util.List;

import cn.edu.uibe.domain.Detail;

public interface DetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Detail record);

    int insertSelective(Detail record);

    Detail selectByPrimaryKey(Long id);
    
    List<Detail> selectByMemberId(Long memberId);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKey(Detail record);
}