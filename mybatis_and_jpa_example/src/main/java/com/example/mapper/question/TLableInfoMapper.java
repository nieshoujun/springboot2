package com.example.mapper.question;

import com.example.bean.question.TLableInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TLableInfoMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(TLableInfo record);

    int insertSelective(TLableInfo record);

    TLableInfo selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(TLableInfo record);

    int updateByPrimaryKey(TLableInfo record);

    List<TLableInfo> findAllByPid(Map map);
}