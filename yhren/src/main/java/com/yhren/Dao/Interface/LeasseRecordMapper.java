package com.yhren.Dao.Interface;

import com.yhren.Dao.Bean.LeasseRecord;

public interface LeasseRecordMapper {
    int deleteByPrimaryKey(Integer leaseId);

    int insert(LeasseRecord record);

    int insertSelective(LeasseRecord record);

    LeasseRecord selectByPrimaryKey(Integer leaseId);

    int updateByPrimaryKeySelective(LeasseRecord record);

    int updateByPrimaryKey(LeasseRecord record);
}